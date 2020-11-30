
package empresa_combustible;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Servidor implements Runnable {
    
    private ArrayList<Socket> clientes;
    private int puerto;  
    private DataInputStream in;
    private DataOutputStream out; 
    private ServerSocket servidor;
    private Socket cliente;
    private String idServidor;

    public Servidor(int puerto) {
        this.puerto = puerto;
        this.clientes = new ArrayList<>();
    }
    
    @Override
    public void run() {
        try {
            servidor = new ServerSocket(puerto);
            System.out.println("Servidor iniciado");
            
            while (true) {                
                cliente = servidor.accept();
                out = new DataOutputStream(cliente.getOutputStream());
                //out.writeUTF(idServidor);          
                System.out.println("Cliente conectado");
                clientes.add(cliente);
            }
        } catch (Exception e) {
            System.err.println("Error en despliege server: "+e.getMessage());
        }
    }

    public String getIdServidor() {
        return idServidor;
    }

    public void setIdServidor(String idServidor) {
        this.idServidor = idServidor;
    }
    
    public void enviarInfo(String[] nombres, double[] valores) {
       
        for (Socket cliente : clientes) {
            try {
                out = new DataOutputStream(cliente.getOutputStream());              
                System.out.println("Id recibida: "+idServidor);
                for (int i = 0; i < nombres.length; i++) {
                    out.writeUTF(idServidor);
                    out.writeUTF(nombres[i]);
                    out.writeDouble(valores[i]);
                }
            } catch (IOException ex) {
                System.err.println("Error en enviar info: "+ex.getMessage());
            }

        }

    }
}   
