package com.example.proyectorva.util;
import java.io.*;
import java.net.*;

import com.example.proyectorva.Player;

public class TCPClient {
	
	
    public  String sendRequest(String json) throws Exception {        
        String respuesta;
        //BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));

        Socket clientSocket;		
			clientSocket = new Socket(Player.HOST, Player.PUERTO);		
	        DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());
	        BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));	
	       // json = inFromUser.readLine();
	       // outToServer.writeBytes(json + '\n');
	        outToServer.writeBytes(json);
	        respuesta = inFromServer.readLine();
	        //System.out.println(modifiedSentence);
	        clientSocket.close();
	        return respuesta;		
			// TODO Auto-generated catch block
		
    }
}