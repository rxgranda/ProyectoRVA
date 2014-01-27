package com.example.proyectorva;

import java.util.LinkedList;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

public class GameBoard extends View {
	private LinkedList <Player> playerList;
	 int  p1X=0,p1Y=0, clt;
	 private Paint p;
	 Bitmap jugador1;
	public GameBoard(Context context, AttributeSet attrs) {
		super(context, attrs);
		p = new Paint();
		jugador1=BitmapFactory.decodeResource(getResources(), R.drawable.ic_launcher);
		// TODO Auto-generated constructor stub
	}
	
    @Override

    public  void onDraw(Canvas canvas) {
    	 super.onDraw(canvas);
         p=new Paint();         
         p.setColor(Color.RED);
         synchronized (this) {
        	 for(Player jugador:playerList){
        		 if(jugador.isEnabled())
        			 canvas.drawBitmap(jugador1, jugador.getPosX(), jugador.getPosY(), p);
        	 }        	
		}
        
    }
    public  void update(LinkedList<Player> jugadores) {  
    	if(clt==0)
    		this.playerList=jugadores;
    	/* código de reescalamiento
    	synchronized (this) {
	    	p1X++;
	    	p1Y++;
	    	p1X=p1X%200;
	    	p1Y=p1Y%200;    
    	}*/
    }

}
