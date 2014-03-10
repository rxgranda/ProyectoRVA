package com.example.proyectorva;

import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;

public class Player {

	public final static String HOST="192.168.0.102";//"192.168.43.172";
	public final static int PLAYERS_NUMBER=4;
	public final static int PUERTO=7777;
	public final static int MODO_DETECTIVE=0;
	public final static int MODO_ESPIA=1;
	public final static String MODO_JUEGO="modo_juego";
	public final static String ERROR_SERVER="ERROR";
	//JSON
	public final static String ESTADO_TAG="estado";
	public final static String ID_JUGADOR_TAG="id_jugador";
	public final static String INICIO_JUEGO_TAG="inicio";
	public final static String JUGADORES_TAG="jugadores";
	public final static String X_TAG="x";
	public final static String Y_TAG="y";
	public final static String ROBOT_TAG="robot";
	//JSON
	public final static String ESTADO_OK="1";
	public final static String ESTADO_WRONG="-100";
	public final static String RESULTADO="resultado";
	public final static String RESULTADO_GANO="gano";
	public final static String RESULTADO_PERDIO="perdio";
	public final static String RESULTADO_ELIMINADO="eliminado";
	
	
	private int id;
	private int posX;
	private int posY;
	private int posXAnim;
	private int posYAnim;
	private int posXOld;
	private int posYOld;
	private  static String seleccionado="-1";
	private boolean enabled=false;
	Rect rectangulo;
	BitmapDrawable imagen;
	
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
public static synchronized String seleccionado(String idJugador){
	String tmp;	 
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

}
