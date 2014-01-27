package com.example.proyectorva;

public class Player {
	public final static String HOST="192.168.0.102";
	public final static int PUERTO=7777;
	public final static int MODO_DETECTIVE=0;
	public final static int MODO_ESPIA=1;
	public final static String MODO_JUEGO="modo_juego";
	public final static String ERROR_SERVER="ERROR";
	//JSON
	public final static String ESTADO_TAG="estado";
	public final static String ID_JUGADOR_TAG="id_jugador";
	public final static String INICIO_JUEGO_TAG="inicio";
	//JSON
	public final static String ESTADO_OK="1";
	public final static String ESTADO_WRONG="0";
	
	
	private int id;
	private int posX;
	private int posY;
	private boolean enabled=false;
	
	public Player(int id){
		this.id=id;
		enabled=true;
	}
	
	public int getPosX() {
		return posX;
	}
	public void setPosX(int posX) {
		this.posX = posX;
	}
	public int getPosY() {
		return posY;
	}
	public void setPosY(int posY) {
		this.posY = posY;
	}
	public boolean isEnabled() {
		return enabled;
	}
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

}
