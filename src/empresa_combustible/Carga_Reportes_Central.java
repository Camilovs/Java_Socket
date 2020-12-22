package empresa_combustible;

import java.sql.SQLException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Carga_Reportes_Central implements Runnable{
    
    private static Queue<Report_File> cola_reportes;
    private boolean conexion = true;
    private ConexionDB conexionDB;
    
    public Carga_Reportes_Central() {
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
                    System.err.println("Error en sleep por reporte");
                }
            }
            //Si la cola tiene un reporte, se envia.
            else{   
                
                if(conexionDB.probarConexionCentral()){
                    
                    //Enviar Reportes SQL
                    
                    Report_File reporte = getReporte();
                    try {
                        conexionDB.enviarReporteCentral(reporte);
                    } catch (SQLException ex) {
                        Logger.getLogger(Carga_Reportes_Central.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    System.out.println("Reporte "+ reporte.getIdSurtidor()+ " enviado!");
                }
                else{
                    try {
                        //System.err.println("Conexion con Central no establecida.");
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
