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
public class Distribuidor extends Observable implements Runnable{
    
    private int puerto;
    private final String HOST = "localhost";
    private DataInputStream in;
    private DataOutputStream out;
    private String nombreTag;
    private double valor;

    public Distribuidor(int puerto) {
        this.puerto = puerto;
    }
    
    @Override
    public void run(){
        System.out.println("Iniciando dist..");
        try {
            Socket cliente = new Socket(HOST, puerto);           
            while(true){
               
            }
            
        } catch (IOException ex) {
            System.err.println("Error en iniciar Distribuidor "+ex.getMessage());
        }
    }
}
