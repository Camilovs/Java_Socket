
package empresa_combustible;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Observable;

public class Sucursal extends Observable implements Runnable{
    
    private ArrayList<Socket> distribuidores;
    private int puerto;
    private String HOST = "localhost";
    private DataInputStream in;
    private DataOutputStream out;   
    private Socket cliente;
    private String nombreTag;
    private double valor;


    public Sucursal(int puerto) {
        this.puerto = puerto;
        this.distribuidores = new ArrayList<>();       
    }
    
    @Override
    public void run(){
        try {
            cliente = new Socket(HOST,puerto);
            in = new DataInputStream(cliente.getInputStream());
            while (true) {                
                System.out.println("Escuchando datos..");
                nombreTag = in.readUTF();
                System.out.println("recibiendo nametag");
                this.setChanged();
                this.notifyObservers(nombreTag);
                this.clearChanged();
                
                valor = in.readDouble();
                System.out.println("recibiendo valor");
                this.setChanged();
                this.notifyObservers(valor);
                this.clearChanged();
            }
        } catch (Exception e) {
            System.err.println("Error en iniciar Sucursal: "+e.getMessage());
        }
    }
    
    public void enviarInfo(){
        System.out.println("Enviando info..");
        for (Socket dist : distribuidores) {
            try {
                out = new DataOutputStream(dist.getOutputStream());
                System.out.println("Escribiendo nametag");
                out.writeUTF("93");
                System.out.println("Escribiendo valor");
                out.writeDouble(200);                            
            } catch (Exception e) {
            }
        }
    }  
}
