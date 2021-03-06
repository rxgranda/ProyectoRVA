package com.example.proyectorva;

import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;

public class Player {
	
	public final static String HOST="192.168.65.126";//"192.168.43.172";
	public final static int PLAYERS_NUMBER=5;
	public final static int PUERTO=7777;
	public final static int MODO_DETECTIVE=0;
	public final static int MODO_ESPIA=1;

	public final static String TRACKER1="Ojos";
	public final static String TRACKER2="Ojos1";
	public final static String TRACKER3="Ojos2";
	public final static String MODO_JUEGO="modo_juego";
	public final static String TRACKER_ID="nombre_tracker";
	public final static String ERROR_SERVER="ERROR";
	//JSON
	public final static String ESTADO_TAG="estado";
	public final static String ID_JUGADOR_TAG="id_jugador";
	public final static String INICIO_JUEGO_TAG="inicio";
	public final static String JUGADORES_TAG="jugadores";
	public final static String X_TAG="x";
	public final static String Y_TAG="y";
	public final static String ROBOT_TAG="robot";
	public final static String TIPO_MENSAJE_TAG="tipo_mensaje";
	//JSON
	public final static String ESTADO_OK="1";
	public final static int  ESTADO_ELIMINADO=-1;
	public final static String ESTADO_WRONG="-100";
	public final static String RESULTADO="resultado";
	public final static String RESULTADO_GANO="gano";
	public final static String RESULTADO_PERDIO="perdio";
	public final static String RESULTADO_ELIMINADO="eliminado";
	
	private static int idPlayer;
	private static int puntaje=1000;
	private static int espias=0;
	private static boolean esDetective=false;
	private int id;
	private int posX;
	private int posY;
	private int posXAnim;
	private int posYAnim;
	private int posXOld;
	private int posYOld;
	private  static int seleccionado=-1;
	private boolean enabled=false;
	Rect rectangulo;
	BitmapDrawable imagen;
	private boolean robot=false;
	
	public Player(int id,Rect rectangulo,BitmapDrawable imagen){
		this.id=id;
		enabled=true;
		this.rectangulo=rectangulo;
		this.imagen=imagen;
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

	public Rect getRectangulo() {
		return rectangulo;
	}

	public void setRectangulo(Rect rectangulo) {
		this.rectangulo = rectangulo;
	}

	public BitmapDrawable getImagen() {
		return imagen;
	}

	public void setImagen(BitmapDrawable imagen) {
		this.imagen = imagen;
	}
public static synchronized int seleccionado(int idJugador){
	int tmp;	 
	tmp=seleccionado;
	seleccionado=idJugador;
	return tmp;
}

public int getPosXOld() {
	return posXOld;
}

public void setPosXOld(int posXOld) {
	this.posXOld = posXOld;
}

public int getPosYOld() {
	return posYOld;
}

public void setPosYOld(int posYOld) {
	this.posYOld = posYOld;
}

public int getPosXAnim() {
	return posXAnim;
}

public void setPosXAnim(int posXAnim) {
	this.posXAnim = posXAnim;
}

public int getPosYAnim() {
	return posYAnim;
}

public void setPosYAnim(int posYAnim) {
	this.posYAnim = posYAnim;
}

public static int getIdPlayer() {
	return idPlayer;
}

public static void setIdPlayer(int idPlayer) {
	Player.idPlayer = idPlayer;
}



public static void modificarPuntaje(){
	puntaje=puntaje-100;
}

public static void setEspias(int a){
	espias=a;
}

public static int  getEspias(){
	return espias;
}
public static boolean isEsDetective() {
	return esDetective;
}

public static void setEsDetective(boolean esDetective) {
	Player.esDetective = esDetective;
}

public boolean isRobot() {
	return robot;
}

public void setRobot(boolean robot) {
	this.robot = robot;
}

}