package com.example.proyectorva;

import java.util.LinkedList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


import com.example.proyectorva.util.SocketSingleton;
import com.example.proyectorva.util.TCPServer;

import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Rect;
import android.util.Log;
import android.view.Menu;
import android.widget.Toast;

public class MapTestActivity extends Activity {
	
	 SocketSingleton servidor;
	
	private static LinkedList <Player> playerList;

	/////////////////////////
	int x1,x2,x3;
	int y1=50,y2=100,y3=150;
	/////////////////////////
	 static int i=0;
    public Handler updateHandler = new Handler(){
        /** Gets called on every message that is received */
        // @Override
        public void handleMessage(Message msg) {
        	//Player a=playerList.get(0);
    		//Player b=playerList.get(1);
    		//Player c=playerList.get(2);
    		//x1++;x2++;x3++;
    		//x1=x1%600;x2=x2%600;x3=x3%600;
    		
    		//a.setPosX(x1); a.setPosY(y1);
    		//b.setPosX(600-x2); b.setPosY(y2);
    		//c.setPosX(x3); c.setPosY(y3);    		
        
        	//((GameBoard)findViewById(R.id.canvas)).update(playerList);  
        	 ((GameBoard)findViewById(R.id.canvas)).invalidate(); 
            super.handleMessage(msg);
        }
    };
 
    public class UpdateThread implements Runnable {  
    	 SocketSingleton socket;
        @Override
        public void run() {
             while(true){
            	 try {
            		
            		 socket=servidor.getInstance();
            		 JSONObject request = new JSONObject();            
     	            request.put("tipo_mensaje", "2");
     	           request.put("seleccionado", 1);
     	          Log.d("PIDIENDO", "PIDIENDO");
            	 String estado=socket.enviarMensaje(request.toString(2));
            	   Log.d("RECIBIENDO", estado);
            	 if(!estado.equals("")){
            		 JSONObject response;
            		
						response = new JSONObject(estado);
						JSONArray estado_juego=response.getJSONArray(Player.JUGADORES_TAG);
						//for(int i=0 ;i<estado_juego.length();i++){
						for(int i=0 ;i<Player.PLAYERS_NUMBER;i++){
							JSONObject jugador=estado_juego.getJSONObject(i);
							int x,y; double xD,yD;
							Player jugadorP=playerList.get(i);
							//if(i==1)
								//jugadorP.setPosX(600-x); 
							//else
							 if (jugador.getInt(Player.ROBOT_TAG)==0)
		        			 {
								 xD=jugador.getDouble(Player.X_TAG);
								 yD=jugador.getDouble(Player.Y_TAG);
								 x = (int)(xD*120 + 450);
		        			 	 y = (int)(yD*175 + 100 );
		        			 }
		        			 else{
		        				 x=jugador.getInt(Player.X_TAG);
							     y=jugador.getInt(Player.Y_TAG);
		        				
		        			 }
								jugadorP.setPosX(x); 
							jugadorP.setPosY(y);
							//Log.d("pos X= Y=", x+" "+y);	
						}
						
						
            	 }
            	 } catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}  
            	
                 MapTestActivity.this.updateHandler.sendEmptyMessage(0);
                 try {
					Thread.sleep(10, 0);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            }
        } 
    }

	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
	
		super.onCreate(savedInstanceState);
		 
		setContentView(R.layout.activity_map_test);
		setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
		 //game = new GameBoard(this);	
		playerList=playerList=new LinkedList<Player>();
		for (int i=0;i<Player.PLAYERS_NUMBER;i++){
			Player jugador=new Player(i+1);
			playerList.add(jugador);
		}
		((GameBoard)findViewById(R.id.canvas)).update(playerList);
		//Player a=playerList.get(0);
		//Player b=playerList.get(1);
		//Player c=playerList.get(2);
		//a.setPosX(0); a.setPosY(50);
		//b.setPosX(400); b.setPosY(100);
		//c.setPosX(0); c.setPosY(150);
		/*RemoteTask task = new RemoteTask();
	    task.execute(new Integer[] { 0 });*/
        Thread myThread = new Thread(new UpdateThread());  
       
        	
        		
        		myThread.start();
			
        
        
	
        

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.map_test, menu);
		return true;
	}
	
	public void terminarJuego(String resultado){
		Intent mainIntent = new Intent(MapTestActivity.this, LastActivity.class);
		mainIntent.putExtra(Player.RESULTADO, resultado +"");
		startActivity(mainIntent);
		
	}
	
	
	
	
	
	
	
	
	/*
	private class RemoteTask extends AsyncTask<Integer, Void, Boolean> {
		
		 void mensaje_error_servidor(){
				runOnUiThread(new Runnable() {
					public void run() {

					    Toast.makeText(MapTestActivity.this, "El juego no se ha podido sincronizar con el servidor", Toast.LENGTH_SHORT).show();
					    }
					});
			}
			@Override
			protected Boolean doInBackground(Integer... arg0) {
				boolean server=openSocketComunicationWithServer();
				if(!server){
					mensaje_error_servidor();
					return false;
				}
				return null;
			}
			public boolean openSocketComunicationWithServer(){
				try {       				
										
					Log.d("Abriendo", "ABRIENDOOOOOOOOOOO");
					servidor.openServer2();
					//Log.d("Abriendo", "ABIERTOOOO-CERRADO");
					//servidor.killServer();
		            return true;		            			           		      
		        } catch (Exception e) {
		        	e.printStackTrace();	 
		        	   Log.d("EXCEPCIONNNN", "XXXXXXXXXXXXXXXXXXXX");
		        	 return false;
		        }
			}
	 }
*/
}
