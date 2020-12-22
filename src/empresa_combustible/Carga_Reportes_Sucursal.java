package empresa_combustible;

import java.sql.SQLException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Carga_Reportes_Sucursal implements Runnable{
    
    private static Queue<Report_File> cola_reportes;
    private boolean conexion = true;
    private ConexionDB conexionDB;

    public Carga_Reportes_Sucursal() {
        cola_reportes = new LinkedList<>();
        conexionDB = new ConexionDB();
    }
    
    
    @Override
    public void run() {
        
        //Permanentemente buscando reportes para enviar
        while(true){     
            
            //Si la cola esta vacia esperamos un segundo.
            if(cola_reportes.isEmpty()){               
                try {                 
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {
                    System.err.println("Error en esperar por reporte");
                }
            }
            //Si la cola tiene un reporte, se envia.
            else{  
                Report_File reporte = cola_reportes.peek();          
                if(conexionDB.probarConexionSucursal(reporte.getIdSucursal())){
                    reporte = getReporte();
                    try {
                        conexionDB.enviarReporteSucursal(reporte);
                    } catch (SQLException ex) {
                        Logger.getLogger(Carga_Reportes_Sucursal.class.getName()).log(Level.SEVERE, null, ex);
                    }
                
                    System.out.println("Reporte "+ reporte.getIdSurtidor()+ " enviado!");
                }
                else{
                    try {
                        Thread.sleep(5000);
                    } catch (InterruptedException ex) {                   
                    }
                }
            }
        }
    }
    
    public static void addReporte(Report_File reporte){
        System.out.println("Reporte añadido a la cola!");
        cola_reportes.add(reporte);
    }
    
    public Report_File getReporte(){
        
        if(!cola_reportes.isEmpty()){
            return cola_reportes.poll();
        }
        else{
            return null;
        }
    }
    
    
    
}
