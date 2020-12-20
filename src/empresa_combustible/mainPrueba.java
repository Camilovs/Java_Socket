/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package empresa_combustible;

/**
 *
 * @author Camilo
 */
public class mainPrueba {
    
    public static void main(String[] args) throws InterruptedException {
//        Carga_Reportes carga = new Carga_Reportes();
//        Thread t = new Thread(carga);
//        t.start();
//        int count=1;
//        while(true){
//            Thread.sleep(1500);
//            System.out.println("Creando Reporte...");
//            Report_File report_File = new Report_File();
//            report_File.setIdSurtidor(Integer.toString(count));
//            carga.addReporte(report_File);
//            count++;
//        }

           Integer contador=0;
           Aumentador.aumentar();
           Aumentador.aumentar();
           Aumentador.aumentar();
    }
    
    static class Aumentador {
        
        private static Integer contador=0;
        public Aumentador(Integer c) {
           
        }  
        public static void aumentar(){
            contador++;
            System.out.println("dentro: "+contador);
        }
    }
}
