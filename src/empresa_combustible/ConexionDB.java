
package empresa_combustible;

import com.mysql.jdbc.PreparedStatement;

import java.sql.Connection;          //Aqui obtenemos el metodo conectar
import java.sql.DriverManager;       //Aqui obtenemos el manejo del driver de java a mysql
import java.sql.ResultSet;
import java.sql.SQLException;        //Aqui obtenemos los metodo para manejo de excepciones
import java.sql.Statement;

public class ConexionDB {
    private static Connection conexion; //Variable que sera la conexion con la bd
    private static final String usuario = "distribuidos"; //Usuario de MySQL
    private static final String password = "gato espacial"; //Contraseña
    private static final String urlCentral = "jdbc:mysql://179.56.164.139:3341/Central"; //Base de datos de la central
    private static final String urlSucursal1 = "jdbc:mysql://179.56.164.139:3342/Sucursal01"; //Base de datos de la Sucursal 1
    private static final String urlSucursal2 = "jdbc:mysql://179.56.164.139:3343/Sucursal02"; //Base de datos de la Sucursal 2
    private static final String urlSucursal3 = "jdbc:mysql://179.56.164.139:3344/Sucursal03"; //Base de datos de la Sucursal 3
    
    
    //Metodos para realizar la conexion a la base de datos por parte del programa
    public Connection abrirConexionCentral() throws SQLException{
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conexion = DriverManager.getConnection(urlCentral, usuario, password);
        }catch(SQLException | ClassNotFoundException ex){
        }
        return conexion;
    }
    
    public Connection abrirConexionSucursal1() throws SQLException{
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conexion = DriverManager.getConnection(urlSucursal1, usuario, password);
        }catch(SQLException | ClassNotFoundException ex){
        }
        return conexion;
    }
    public Connection abrirConexionSucursal2() throws SQLException{
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conexion = DriverManager.getConnection(urlSucursal2, usuario, password);
        }catch(SQLException | ClassNotFoundException ex){
        }
        return conexion;
    }
    public Connection abrirConexionSucursal3() throws SQLException{
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conexion = DriverManager.getConnection(urlSucursal3, usuario, password);
        }catch(SQLException | ClassNotFoundException ex){
        }
        return conexion;
    }

    /**
     * Metodo que guarda en la base de datos de la central, los nuevos valores de los combustibles
     * @param precio93 precio de la bencina de 93 octanos
     * @param precio95 precio de la bencina de 95 octanos
     * @param precio97 precio de la bencina de 97 octanos
     * @param precioDies precio del Diesel
     * @param precioKero precio del Kerosene
     * @throws SQLException 
     */
    public void actualizarPreciosCentral(double precio93, double precio95, double precio97, double precioDies, double precioKero) throws SQLException {
        abrirConexionCentral(); //Se establece la conexion con la bd de la central
        Statement s = conexion.createStatement(); //Se crea la instancia para empezar a enviar las consultas
        //Consultas
        s.executeQuery ("UPDATE combustible SET precio ="+ precio93+ "WHERE id_combustible = '93';");
        s.executeQuery ("UPDATE combustible SET precio ="+ precio95 +"WHERE id_combustible = '95';");
        s.executeQuery ("UPDATE combustible SET precio ="+ precio97 +"WHERE id_combustible = '97';");
        s.executeQuery ("UPDATE combustible SET precio ="+ precioDies +"WHERE id_combustible = 'Diesel';");
        s.executeQuery ("UPDATE combustible SET precio ="+ precioKero +"WHERE id_combustible = 'Kerosene';");
        conexion.close(); //Se cierra la conexion
    }
    
    /**
     * Metodo que actualiza los precios del combustible en una sucursal especifica
     * @param sucursal Indica cual de las 3 sucursales se esta trabajando para iniciar su conexion a la bd respectiva
     * @param precio93 precio de la bencina de 93 octanos
     * @param precio95 precio de la bencina de 95 octanos
     * @param precio97 precio de la bencina de 97 octanos
     * @param precioDies precio del Diesel
     * @param precioKero precio del Kerosene
     * @throws SQLException 
     */
    public void actualizarPreciosSucursal(int sucursal, double precio93, double precio95, double precio97, double precioDies, double precioKero) throws SQLException {
        //Condiciones para determinar que sucursal se esta trabajando
        if (sucursal == 1) abrirConexionSucursal1();
        if (sucursal == 2) abrirConexionSucursal2();
        if (sucursal == 3) abrirConexionSucursal3();
        Statement s = conexion.createStatement(); //Se crea la instancia para empezar a enviar las consultas
        //Consultas
        s.executeQuery ("UPDATE combustible SET precio ="+ precio93+ "WHERE id_combustible = '93';");
        s.executeQuery ("UPDATE combustible SET precio ="+ precio95 +"WHERE id_combustible = '95';");
        s.executeQuery ("UPDATE combustible SET precio ="+ precio97 +"WHERE id_combustible = '97';");
        s.executeQuery ("UPDATE combustible SET precio ="+ precioDies +"WHERE id_combustible = 'Diesel';");
        s.executeQuery ("UPDATE combustible SET precio ="+ precioKero +"WHERE id_combustible = 'Kerosene';");
        conexion.close(); //Cierre de la conexion
    }
     
    public void enviarReporteSucursal(Report_File reporte) throws SQLException{
        System.out.println("Enviando información a base de datos SUCURSAL");
        //Condiciones para determinar que sucursal se esta trabajando
        if (reporte.getIdSucursal().equals("SSAL001"))
            abrirConexionSucursal1();
        if (reporte.getIdSucursal().equals("SSAL002"))
            abrirConexionSucursal2();
        if (reporte.getIdSucursal().equals("SSAL003"))
            abrirConexionSucursal3();

        enviarInformacionBD(reporte);
    }
    public void enviarReporteCentral(Report_File reporte) throws SQLException{
        System.out.println("Enviando información a base de datos CENTRAL");     
        abrirConexionCentral();
        enviarInformacionBD(reporte);
    }
    public void printReporte() throws SQLException {
        abrirConexionCentral();
        Statement s = conexion.createStatement();
        ResultSet rs = s.executeQuery ("select * from Surtidor");
        System.out.println("ID Sucursal | ID Surtidor | Combustible | Precio x Litro | Litros Solicitados | Litros Vendidos | Precio Venta | Estado de Carga");
        while (rs.next()) {
            System.out.println (rs.getString (1) + " " + rs.getString (2) + " " + rs.getString (3) + " " + rs.getString (4) + " " + rs.getString (5) + " " + rs.getString (6)+ " " + rs.getString (7)+ " " + rs.getString (8));
        }
    }
    
    private void enviarInformacionBD(Report_File reporte) throws SQLException{
        PreparedStatement declara =  (PreparedStatement) conexion.prepareStatement("INSERT INTO Surtidor VALUES (?,?,?,?,?,?,?,?)");
        //String idSucursal, String idSurtidor, String combustible, Double precioLitro, Double litrosSolicitados, Double litrosVendidos, Double precioVenta, String estadoCarga
        declara.setString(1, reporte.getIdSucursal());
        declara.setString(2, reporte.getIdSurtidor());
        declara.setString(3, reporte.getCombustible());
        declara.setDouble(4, reporte.getPrecioLitro());
        declara.setDouble(5, reporte.getLitrosSolicitados());
        declara.setDouble(6, reporte.getLitrosVendidos());
        declara.setDouble(7, reporte.getPrecioVenta());
        declara.setString(8, reporte.getEstadoCarga());
        declara.executeUpdate();
        conexion.close(); //Cierre de la conexion con la BD
    }
    
    public ResultSet getReporte(int idBD) throws SQLException {
        if (idBD==0)
            abrirConexionCentral();
        if (idBD==1)
            abrirConexionSucursal1();
        if (idBD==2)
            abrirConexionSucursal2();
        if (idBD==3)
            abrirConexionSucursal3();
        
        Statement s = conexion.createStatement();
        ResultSet rs = s.executeQuery ("select * from Surtidor");
        return rs;
    }
    
    public boolean probarConexionSucursal(String sucursal){
        Connection test=null;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            if(sucursal.equals("SSAL001")){
                test = DriverManager.getConnection(urlSucursal1, usuario, password);
            }
            else if(sucursal.equals("SSAL002")){
                test = DriverManager.getConnection(urlSucursal2, usuario, password);
            }
            else if(sucursal.equals("SSAL003")){
                test = DriverManager.getConnection(urlSucursal3, usuario, password);
            }
        }catch(SQLException | ClassNotFoundException ex){
            System.err.println("Error Conectando a BD sucursal "+sucursal);
        }
        return test != null;
        
    }
    
    public boolean probarConexionCentral(){
        Connection test=null;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            test = DriverManager.getConnection(urlCentral, usuario, password);
        }catch(SQLException | ClassNotFoundException ex){
            System.err.println("Error Conectando a BD Central");
        }
        return test != null;
    }
    /**
     * Metodo para registrar los ajustes que se le realizan a un precio en especifico
     * @param sucursal Sucursal en donde se realizara la compra
     * @param ajuste Porcentaje de ajuste de un combustible
     * @param id_surtidor Surtidor en el cual se realiza la carga de combustible
     * @throws SQLException 
     
    public void ajustesPrecios(int sucursal, int ajuste, char id_surtidor) throws SQLException {
        //Condiciones para determinar que sucursal se esta trabajando
        if (sucursal == 1) abrirConexionSucursal1();
        if (sucursal == 2) abrirConexionSucursal2();
        if (sucursal == 3) abrirConexionSucursal3();
        Statement s = conexion.createStatement(); //Se crea la instancia para empezar a enviar las consultas
        //Consultas para registrar los diversos reajustes que tiene el precio de los combustibles
        s.executeQuery("INSERT INTO Estacion VALUES ("+ajuste+", '93',"+id_surtidor+")");
        s.executeQuery("INSERT INTO Estacion VALUES ("+ajuste+", '95',"+id_surtidor+")");
        s.executeQuery("INSERT INTO Estacion VALUES ("+ajuste+", '97',"+id_surtidor+")");
        s.executeQuery("INSERT INTO Estacion VALUES ("+ajuste+", 'Diesel',"+id_surtidor+")");
        s.executeQuery("INSERT INTO Estacion VALUES ("+ajuste+", 'Kerosene',"+id_surtidor+")");
        conexion.close(); //Cierre de la conexion
    }
    */
}
