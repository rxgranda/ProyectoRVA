package com.example.proyectorva;

import java.util.LinkedList;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

public class GameBoard extends View {
	private static  LinkedList <Player> playerList;
	 int  p1X=0,p1Y=0;
	 static int clt=0;
	 private static Paint p;
	 Bitmap fondo;
	 Bitmap jugador1;
	 Rect rect;
	 BitmapDrawable mDrawable;
	public GameBoard(Context context, AttributeSet attrs) {
		super(context, attrs);
		p = new Paint();
		fondo= BitmapFactory.decodeResource(getResources(), R.drawable.lienzo2);
		
		jugador1=BitmapFactory.decodeResource(getResources(), R.drawable.ic_launcher);
		
		 mDrawable = new BitmapDrawable(context.getResources(), jugador1);
			rect = new Rect(0, 0, 50, 50);
			mDrawable.setBounds(rect);
		// TODO Auto-generated constructor stub
	}
	
	
	@Override
	protected void onSizeChanged(int w, int h, int oldw, int oldh) {
	  super.onSizeChanged(w, h, oldw, oldh);
	  fondo = Bitmap.createScaledBitmap(fondo, w, h, false);
	}
	
	
	
    @Override

    public  void onDraw(Canvas canvas) {
    	 super.onDraw(canvas);
        // p=new Paint();         
        // p.setColor(Color.RED);
    	 canvas.drawBitmap(fondo, 0, 0, p);
         synchronized (this) {
        	 int k=0;
        	 for(Player jugador:playerList){
        		 if(jugador.isEnabled()){
        			 //if(k!=0)        			         			        			 
        			 canvas.drawBitmap(jugador1, jugador.getPosX(),jugador.getPosY(), p);
        			 //else
        				// rect.set(jugador.getPosX(), jugador.getPosY(), jugador.getPosX()+50,  jugador.getPosY()+50);
        		 	k++;
        		 	}
        		 }        	
		}
         mDrawable.draw(canvas);
         for(Player jugador:playerList){
        	// Log.d("POSICIONES", "x="+jugador.getPosX()+"Y="+ jugador.getPosY());
    			// canvas.drawBitmap(jugador1, jugador.getPosX(), jugador.getPosY(), p);
    	 } 
        
    }
    public  void update(LinkedList<Player> jugadores) {  
    	if(clt==0)
    		this.playerList=jugadores;
    	this.invalidate();
    	 Log.d("QUERIENDO INICIAR", "LLLLLLLLLLLLLLLLLLLLLLL");
    	/* código de reescalamiento
    	synchronized (this) {
	    	p1X++;
	    	p1Y++;
	    	p1X=p1X%200;
	    	p1Y=p1Y%200;    
    	}*/
    }

    
    
    
 
}
