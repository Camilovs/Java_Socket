
package empresa_combustible;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class ServidorCentral implements Runnable{
    
    private ArrayList<Socket> sucursales;
    private int puerto;  
    private DataInputStream in;
    private DataOutputStream out; 
    private ServerSocket servidor;
    private Socket cliente;

    public ServidorCentral(int puerto) {
        this.puerto = puerto;
        this.sucursales = new ArrayList<>();
    }
    
    @Override
    public void run() {
        try {
            servidor = new ServerSocket(puerto);
            System.out.println("Servidor iniciado");
            
            while (true) {                
                cliente = servidor.accept();
                System.out.println("Sucursal conectada");
                sucursales.add(cliente);
            }
        } catch (Exception e) {
            System.err.println("Error en despliege server: "+e.getMessage());
        }
    }
    public void enviarInfo(String[] nombres, double[] valores) {

        for (Socket suc : sucursales) {
            try {
                out = new DataOutputStream(suc.getOutputStream());
                for (int i = 0; i < nombres.length; i++) {
                    out.writeUTF(nombres[i]);
                    out.writeDouble(valores[i]);
                }
            } catch (IOException ex) {
                System.err.println("Error en enviar info: "+ex.getMessage());
            }

        }

    }
}
