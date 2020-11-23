
package empresa_combustible;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Observable;

public class Sucursal extends Observable implements Runnable{
    
    private int puerto;
    private String HOST;
    private DataInputStream in;
    private DataOutputStream out;   
    private Socket cliente;
    private String nombreTag;
    private double valor;

    public Sucursal(int puerto, String host) {
        this.puerto = puerto;   
        this.HOST = host;
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

    public int getPuerto() {
        return puerto;
    }

    public void setPuerto(int puerto) {
        this.puerto = puerto;
    }

    public String getHOST() {
        return HOST;
    }

    public void setHOST(String HOST) {
        this.HOST = HOST;
    }
    
}
