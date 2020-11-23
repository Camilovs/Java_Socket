/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package empresa_combustible;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Observable;

/**
 *
 * @author Camilo
 */
public class Surtidor extends Observable implements Runnable{
    
    private int puerto;
    private String HOST = "localhost";
    private Socket cliente;
    private DataInputStream in;
    private DataOutputStream out;
    private String nombreTag;
    private double valor;

    public Surtidor(int puerto) {
        this.puerto = puerto;
    }
    public Surtidor(int puerto, String host) {
        this.puerto = puerto;
        this.HOST = host;
    }
    
    @Override
    public void run(){
        System.out.println("Iniciando dist..");
        try {
            cliente = new Socket(HOST, puerto);
            System.out.println("surtidor conectandose a: "+HOST+":"+puerto);
            in = new DataInputStream(cliente.getInputStream());
            while(true){
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
            
        } catch (IOException ex) {
            System.err.println("Error en iniciar Distribuidor "+ex.getMessage());
        }
    }
}
