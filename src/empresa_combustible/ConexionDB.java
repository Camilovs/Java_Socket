
package empresa_combustible;

import com.mysql.jdbc.PreparedStatement;
import java.sql.Connection;          //Aqui obtenemos el metodo conectar
import java.sql.DriverManager;       //Aqui obtenemos el manejo del driver de java a mysql
import java.sql.SQLException;        //Aqui obtenemos los metodo para manejo de excepciones
import java.sql.Statement;

import java.sql.Connection;          //Aqui obtenemos el metodo conectar
import java.sql.DriverManager;       //Aqui obtenemos el manejo del driver de java a mysql
import java.sql.ResultSet;
import java.sql.SQLException;        //Aqui obtenemos los metodo para manejo de excepciones
import java.sql.Statement;
import java.sql.Types;

public class ConexionDB {
    private static Connection conexion; //Variable que sera la conexion con la bd
    private static final String usuario = "distribuidos"; //Usuario de MySQL
    private static final String password = "gato espacial"; //Contraseña
    private static final String urlCentral = "jdbc:mysql://179.56.164.139:3306/Central"; //Base de datos de la central
    private static final String urlSucursal1 = "jdbc:mysql://179.56.164.139:3307/Sucursal"; //Base de datos de la Sucursal 1
    private static final String urlSucursal2 = "jdbc:mysql://179.56.164.139:3308/Sucursal"; //Base de datos de la Sucursal 2
    private static final String urlSucursal3 = "jdbc:mysql://179.56.164.139:3309/Sucursal"; //Base de datos de la Sucursal 3
    
    
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
    
    /**
     * Metodo para registrar las cargas de combustibles
     * @param sucursal Sucursal en donde se realizara la compra
     * @param precioLitro Precio por litro de un determinado combustible (ajuste aplicado)
     * @param litrosCarga Cantidad de litros que se cargan
     * @param totalPagar Total que se debe cancelar
     * @param id_surtidor Surtidor en el cual se realizo la carga de combustible
     * @throws SQLException 
     */
    public void cargaCombustible(int sucursal, double precioLitro, double litrosCarga, double totalPagar, String id_surtidor, String id_combustible) throws SQLException {
        String id_sucursal = "";
        System.out.println("La sucursalita es:");
        System.out.println(sucursal);
        
        //Condiciones para determinar que sucursal se esta trabajando
        if (sucursal == 1) {abrirConexionSucursal1(); id_sucursal = "Su01";}
        if (sucursal == 2) {abrirConexionSucursal2(); id_sucursal = "Su02";}
        if (sucursal == 3) {abrirConexionSucursal3(); id_sucursal = "Su03";}

        //Statement s = conexion.createStatement(); //Se crea la instancia para empezar a enviar las consultas
        //String test = precioLitro+","+litrosCarga+","+totalPagar;//+","+id_surtidor;
        //System.out.println(test);
        
        PreparedStatement declara =  (PreparedStatement) conexion.prepareStatement("INSERT INTO Surtidor VALUES (?,?,?,?,?)");
        declara.setDouble(1, precioLitro);
        declara.setDouble(2, litrosCarga);
        declara.setDouble(3, totalPagar);
        declara.setString(4, id_surtidor);
        declara.setString(5, id_combustible);
        declara.executeUpdate();
        //s.executeUpdate("INSERT INTO Surtidor VALUES ("+precioLitro+","+litrosCarga+","+totalPagar+","+id_surtidor+")"); //Consulta que registra la compra
        //s.executeUpdate("INSERT INTO Surtidor VALUES ("+test+")"); //Consulta que registra la compra
        conexion.close(); //Cierre de la conexion con la sucursal
        //Inicio de conexion con la central para informar de la compra en el surtidor X de la sucursal Y
        abrirConexionCentral();
        PreparedStatement declara1 =  (PreparedStatement) conexion.prepareStatement("INSERT INTO Surtidor VALUES (?,?,?,?,?,?)");
        declara1.setDouble(1, precioLitro);
        declara1.setDouble(2, litrosCarga);
        declara1.setDouble(3, totalPagar);
        declara1.setString(4, id_surtidor);
        declara1.setString(5, id_sucursal);
        declara1.setString(6, id_combustible);
        declara1.executeUpdate();
        //s = conexion.createStatement(); //Se crea la instancia para empezar a enviar las consultas
        //s.executeUpdate("INSERT INTO Surtidor VALUES ("+precioLitro+","+litrosCarga+","+totalPagar+","+id_surtidor+","+id_sucursal+")"); //Consulta que registra la compra
        conexion.close(); //Cierre de la conexion*/
    }
    
    public void printReporte() throws SQLException {
        abrirConexionCentral();
        Statement s = conexion.createStatement();
        ResultSet rs = s.executeQuery ("select * from Surtidor");
        System.out.println("precioLitro | litrosCarga | totalPagar | surtidor | sucursal | combustible");
        while (rs.next()) {
            System.out.println (rs.getString (1) + " " + rs.getString (2) + " " + rs.getString (3) + " " + rs.getString (4) + " " + rs.getString (5) + " " + rs.getString (6));
        }
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
