
package empresa_combustible;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class SucursalServidor implements Runnable {
    private ArrayList<Socket> surtidores;
    private int puerto;
    private DataInputStream in;
    private DataOutputStream out; 
    private ServerSocket servidor;
    private Socket cliente;

    public SucursalServidor(int puerto) {
        this.puerto = puerto;
        this.surtidores = new ArrayList<>();
    }

    @Override
    public void run() {
        try {
            servidor = new ServerSocket(puerto);
            System.out.println("Servidor Sucursal iniciado");
            
            while(true){
                cliente = servidor.accept();
                System.out.println("Surtidor Conectado");
                surtidores.add(cliente);
            }
        } catch (Exception e) {
            System.err.println("Error en despliegue de Sucursal Server"+ 
                    e.getMessage());
        }
    }
    public void enviarInfo(String[] nombres, double[] valores) {
        System.out.println("Enviando informacion a surtidores..");
        for (Socket sur : surtidores) {
            try {
                out = new DataOutputStream(sur.getOutputStream());
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
