package com.example.proyectorva.util;
import java.io.*;
import java.net.*; 

import android.os.SystemClock;
import android.util.Log;

import com.example.proyectorva.Player;
public class TCPServer {    
	ServerSocket welcomeSocket=null;
	private String estadoJuego="";
	private String accionJugador="Hola";
	public  String  openServer() throws Exception       {
		String clientSentence;
		String capitalizedSentence;
		welcomeSocket = new ServerSocket(Player.PUERTO);
		while(true)          {
			Socket connectionSocket = welcomeSocket.accept();
			BufferedReader inFromClient =
					new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));
			DataOutputStream outToClient = new DataOutputStream(connectionSocket.getOutputStream());
			clientSentence = inFromClient.readLine();
			System.out.println("Received: " + clientSentence);
			capitalizedSentence = clientSentence+'\n';
			outToClient.writeBytes(capitalizedSentence+"\0");
			return clientSentence;
		}
	}
	
	public  void  openServer2() throws Exception {		
		String clientSentence;
		String capitalizedSentence;
		welcomeSocket = new ServerSocket(Player.PUERTO);
		while(true)          {
			Socket connectionSocket = welcomeSocket.accept();
			BufferedReader inFromClient =
					new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));
			DataOutputStream outToClient = new DataOutputStream(connectionSocket.getOutputStream());
			clientSentence=inFromClient.readLine();
			setEstadoJuego(clientSentence );
			//System.out.println("Received: " + getEstadoJuego())
			//Log.d("Recibiendo", clientSentence);		
			outToClient.writeBytes(clientSentence.toUpperCase()+"\0");
			//Log.d("Enviaando", clientSentence);	
		}
	}
	public void killServer() throws IOException{
		welcomeSocket.close();
	}

	public String getEstadoJuego() {
		synchronized (this.estadoJuego) {
			String tmp=estadoJuego;
			estadoJuego="";
			return tmp+"";			
		}
		
	}

	public void setEstadoJuego(String estadoJuego) {
		synchronized (this.estadoJuego) {
			this.estadoJuego = estadoJuego;
		}
	}

	public  String  getAccionJugador() {
		synchronized (this.accionJugador) {
			String tmp=accionJugador;
			accionJugador="";
			return tmp+"";
		}
	}

	public synchronized void setAccionJugador(String accioneJugador) {
		synchronized (this.accionJugador) {
			this.accionJugador = accioneJugador;
		}
	}
} 