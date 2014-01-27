package com.example.proyectorva;

import java.util.LinkedList;

import org.json.JSONException;
import org.json.JSONObject;

import com.example.proyectorva.util.TCPServer;

import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.util.Log;
import android.view.Menu;
import android.widget.Toast;

public class MapTestActivity extends Activity {

	//private GameBoard game;
	private LinkedList <Player> playerList;
	private int PLAYERS_NUMBER=3;
	/////////////////////////
	int x1,x2,x3;
	int y1=50,y2=100,y3=150;
	/////////////////////////
	 
    public Handler updateHandler = new Handler(){
        /** Gets called on every message that is received */
        // @Override
        public void handleMessage(Message msg) {
        	Player a=playerList.get(0);
    		Player b=playerList.get(1);
    		Player c=playerList.get(2);
    		x1++;x2++;x3++;
    		x1=x1%600;x2=x2%600;x3=x3%600;
    		
    		a.setPosX(x1); a.setPosY(y1);
    		b.setPosX(600-x2); b.setPosY(y2);
    		c.setPosX(x3); c.setPosY(y3);    		
        	((GameBoard)findViewById(R.id.canvas)).update(playerList);
        	((GameBoard)findViewById(R.id.canvas)).invalidate();        	
            super.handleMessage(msg);
        }
    };
 
    public class UpdateThread implements Runnable {    	 
        @Override
        public void run() {
             while(true){
                 MapTestActivity.this.updateHandler.sendEmptyMessage(0);
                 try {
					Thread.sleep(20, 0);
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
		playerList=new LinkedList<Player>();
		for (int i=0;i<PLAYERS_NUMBER;i++){
			Player jugador=new Player(i+1);
			playerList.add(jugador);
		}
		//Player a=playerList.get(0);
		//Player b=playerList.get(1);
		//Player c=playerList.get(2);
		//a.setPosX(0); a.setPosY(50);
		//b.setPosX(400); b.setPosY(100);
		//c.setPosX(0); c.setPosY(150);
        Thread myThread = new Thread(new UpdateThread());        
        myThread.start();

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.map_test, menu);
		return true;
	}
	
	private class RemoteTask extends AsyncTask<Integer, Void, Boolean> {
		 TCPServer servidor=new TCPServer();
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
					servidor.openServer();		             
		            return true;		            			           		      
		        } catch (Exception e) {
		        	e.printStackTrace();	 
		        	   Log.d("EXCEPCIONNNN", "XXXXXXXXXXXXXXXXXXXX");
		        	 return false;
		        }
			}
	 }

}
