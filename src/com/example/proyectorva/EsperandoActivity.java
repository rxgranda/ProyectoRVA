package com.example.proyectorva;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ExecutionException;

import org.json.JSONException;
import org.json.JSONObject;

import com.example.proyectorva.util.TCPClient;
import com.example.proyectorva.util.TCPServer;

import android.os.AsyncTask;
import android.os.Bundle;
import android.os.StrictMode;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.util.Log;
import android.view.Menu;
import android.widget.Toast;

@SuppressLint("NewApi")
public class EsperandoActivity extends Activity {
	 private long splashDelay = 30000; //6 segundos
	 private final int MODO_DETECTIVE=0;
	 private final int MODO_ESPIA=1;
	@SuppressLint("NewApi")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);		
		setContentView(R.layout.activity_esperando);
		setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
		getIntent().setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
		
		Intent intent = getIntent();
	    String message = intent.getStringExtra(Player.MODO_JUEGO);
	    Integer modo=Integer.parseInt(message);
	    RemoteTask task = new RemoteTask();
	    task.execute(new Integer[] { modo });
	    
		/* TimerTask task = new TimerTask() {
             @Override
             public void run() {
               Intent mainIntent = new Intent().setClass(EsperandoActivity.this, MapTestActivity.class);
               startActivity(mainIntent);
               finish();//Destruimos esta activity para prevenit que el usuario retorne aqui presionando el boton Atras.
             }
           };

           Timer timer = new Timer();
           timer.schedule(task, splashDelay);*/
	   
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.esperando, menu);
		return true;
	}
	 private class RemoteTask extends AsyncTask<Integer, Void, Boolean> {
		 TCPServer servidor=null;
		 TCPClient cliente;
		void mensaje_error(){
			runOnUiThread(new Runnable() {
				public void run() {

				    Toast.makeText(EsperandoActivity.this, "Error de comunicación con el servidor", Toast.LENGTH_SHORT).show();
				    }
				});
		}
		void mensaje_error_detective(){
			runOnUiThread(new Runnable() {
				public void run() {

				    Toast.makeText(EsperandoActivity.this, "Ya existe un jugador Detective", Toast.LENGTH_SHORT).show();
				    }
				});
		}
		void mensaje_error_espera(){
			runOnUiThread(new Runnable() {
				public void run() {

				    Toast.makeText(EsperandoActivity.this, "El juego no se ha podido sincronizar con el servidor", Toast.LENGTH_SHORT).show();
				    }
				});
		}
		public void regresar_modo_juego(){
			///////REVISAR
			Intent mainIntent = new Intent().setClass(EsperandoActivity.this, ModoJuegoActivity.class);
			startActivity(mainIntent);
			///////REVISAR
			finish();
		}
		@Override
		protected Boolean doInBackground(Integer... params) {
			for(Integer modo:params){
				String id_jugador="";
				try {
					id_jugador = joinGame(modo);
				} catch (Exception e) {				
					mensaje_error();
					regresar_modo_juego();
					return false;
				}
				if(id_jugador.equals(Player.ERROR_SERVER)){
					mensaje_error();
					regresar_modo_juego();
					return false;
				}
				if(id_jugador.equals(Player.ESTADO_WRONG)){
					 Log.d("NOOOOO2", "ENTROOOOOOOOOOOO");
					mensaje_error_detective();
					regresar_modo_juego();
					return false;
				}
				
				boolean result= waitForStartGame();
				if(!result){
					mensaje_error_espera();
					regresar_modo_juego();
					return false;
				}else{
				
				Intent mainIntent = new Intent().setClass(EsperandoActivity.this, MapTestActivity.class);
	               startActivity(mainIntent);
	               finish();	}										
				
			}
			return false;
		}
		public String joinGame(int modo) throws Exception{
			try {
				cliente= new TCPClient();
	            JSONObject request = new JSONObject();            
	            request.put(Player.MODO_JUEGO, modo+"");
	            String responseString= cliente.sendRequest(request.toString(2));
	            Log.d("REQUEST", request.toString(2));
	            Log.d("RESPONSE", responseString);
	            JSONObject response = new JSONObject(responseString);  
	            String estado_juego=response.getString(Player.ESTADO_TAG);
	            if(estado_juego.equals(Player.ESTADO_OK)){
	            	String id_jugador=response.getString(Player.ID_JUGADOR_TAG);
	            	 Log.d("SIIIIIIIIIIIII", "SI ENTROOOOO");
	            	 return id_jugador;
	            }
	            Log.d("NOOOOO", "ENTROOOOOOOOOOOO");
	            return Player.ESTADO_WRONG;
	           
	        } catch (JSONException e) {
	            e.printStackTrace();
	            
	            return Player.ERROR_SERVER;
	        } catch (Exception e) {
	        	e.printStackTrace();
	        	throw new Exception();
	        	 //return Player.ERROR_SERVER;
	        }
		}
		public boolean waitForStartGame(){
			try {       				
				servidor=new TCPServer();
				 Log.d("NOOOOO", "KILLLLLL");
				   Log.d("Abriendo", "ABRIENDOOOOOOOOOOO");
				String responseString=servidor.openServer();
	            JSONObject response = new JSONObject(responseString);  
	            String estado_juego=response.getString(Player.INICIO_JUEGO_TAG);
	            servidor.killServer();
	            Log.d("Abriendo", "RESPUESTAAAAA");
	            if(estado_juego.equals(Player.ESTADO_OK)){	            	
	            	 return true;
	            }
	            return false;
	           
	        } catch (JSONException e) {
	            e.printStackTrace();
	            Log.d("EXCEPCIONNNN", "XXXXXXXXXXXXXXXXXXXX");
	            return false;
	        } catch (Exception e) {
	        	e.printStackTrace();	 
	        	   Log.d("EXCEPCIONNNN", "XXXXXXXXXXXXXXXXXXXX");
	        	 return false;
	        }
		}
		 
	 }
	
	

}
