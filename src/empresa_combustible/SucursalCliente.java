
package empresa_combustible;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Observable;

public class SucursalCliente extends Observable implements Runnable{
    
    private int puerto;
    private final String HOST = "localhost";
    private DataInputStream in;
    private DataOutputStream out;   
    private Socket cliente;
    private String nombreTag;
    private double valor;


    public SucursalCliente(int puerto) {
        this.puerto = puerto;       
    }
    
    @Override
    public void run(){
        try {
            cliente = new Socket(HOST,puerto);
            System.out.println("sucursal conectandose a: "+HOST+":"+puerto);
            in = new DataInputStream(cliente.getInputStream());
            while (true) {                
                System.out.println("Esperando datos..");
                nombreTag = in.readUTF();
                System.out.println("recibiendo nametag: "+nombreTag);
                this.setChanged();
                this.notifyObservers(nombreTag);
                this.clearChanged();
                
                valor = in.readDouble();
                System.out.println("recibiendo valor: "+valor);
                this.setChanged();
                this.notifyObservers(valor);
                this.clearChanged();
            }
        } catch (Exception e) {
            System.err.println("Error en iniciar Sucursal: "+e.getMessage());
        }
    } 
}
