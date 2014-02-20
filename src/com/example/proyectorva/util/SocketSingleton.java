package com.example.proyectorva.util;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

import android.util.Log;

import com.example.proyectorva.Player;

public class SocketSingleton {
    private static SocketSingleton mInstance = null;
 
    Socket clientSocket;	
    ServerSocket server;	
    PrintWriter  outToServer;
    BufferedReader inFromServer ;
 
    private SocketSingleton(){
    	try {
    	
			clientSocket = new Socket(Player.HOST, Player.PUERTO);
			server=  new ServerSocket( Player.PUERTO);
			  outToServer = new PrintWriter (clientSocket.getOutputStream(),true);
		         inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));	
		  
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
   
 
    public static SocketSingleton getInstance(){
        if(mInstance == null)
        {
            mInstance = new SocketSingleton();
        }
        return mInstance;
    }
 
    public String enviarMensaje(String json) throws Exception{
    	String respuesta;
    //	Log.d("Socket enviar","Antes");
    	
    	     // json = inFromUser.readLine();
	       // outToServer.writeBytes(json + '\n');
	      //  Log.d("Socket enviar",json);
	        
	        outToServer.println(json);
	       
	        respuesta = inFromServer.readLine();
	     //   outToServer.flush();
	       // outToServer.close();
	        //inFromServer.close();
	        //inFromServer.close();
	        //System.out.println(modifiedSentence);
	       // clientSocket.close();
	      //  Log.d("ESTAAAAAAA",respuesta);
	        //Log.d("Socket enviar","Despues");
	       
	        return respuesta;	
    }
    
    
    public String recibirMensaje(String json) throws Exception{
    	String clientSentence;
    	Log.d("Socket recibir2","Antes");
    	Socket connectionSocket = server.accept();
		BufferedReader inFromClient =
				new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));
		DataOutputStream outToClient = new DataOutputStream(connectionSocket.getOutputStream());
		clientSentence=inFromClient.readLine();		
		//System.out.println("Received: " + getEstadoJuego())
		//Log.d("Recibiendo", clientSentence);		
		outToClient.writeBytes(json+'\n');
		  Log.d("Socket recibir2","Despues");
    	return clientSentence;	
    }
 
    
}