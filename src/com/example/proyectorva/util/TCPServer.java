package com.example.proyectorva.util;
import java.io.*;
import java.net.*; 

import android.os.SystemClock;

import com.example.proyectorva.Player;
public class TCPServer {    
	ServerSocket welcomeSocket=null;
	private String estadoJuego;
	private String accionJugador;
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
			outToClient.writeBytes(capitalizedSentence);
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
			setEstadoJuego( inFromClient.readLine());
			System.out.println("Received: " + getEstadoJuego());			
			outToClient.writeBytes(getAccionJugador());			
		}
	}
	public void killServer() throws IOException{
		welcomeSocket.close();
	}

	public String getEstadoJuego() {
		return estadoJuego;
	}

	public void setEstadoJuego(String estadoJuego) {
		this.estadoJuego = estadoJuego;
	}

	public synchronized String  getAccionJugador() {
		String tmp=accionJugador;
		accionJugador="";
		return tmp+"";
	}

	public synchronized void setAccionJugador(String accioneJugador) {
		this.accionJugador = accioneJugador;
	}
} 