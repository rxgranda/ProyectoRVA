package com.example.proyectorva;

import org.json.JSONException;
import org.json.JSONObject;

import com.example.proyectorva.util.TCPClient;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;

public class ModoJuegoActivity extends Activity {
 
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_modo_juego);
		setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
		ImageButton btnDetective = (ImageButton) findViewById(R.id.btnDetective);		
		btnDetective.setOnClickListener(new OnClickListener() {
	        @Override
	        public void onClick(View v) {		            	            	          
	        	Intent mainIntent = new Intent(ModoJuegoActivity.this, EsperandoActivity.class);
	        	mainIntent.putExtra(Player.MODO_JUEGO, Player.MODO_DETECTIVE +"");
	        	startActivity(mainIntent);
                finish();//Destruimos esta activity para prevenit que el usuario retorne aqui presionando el boton Atras.
         
	        }
	    });
		
		ImageButton btnEspia = (ImageButton) findViewById(R.id.btnEspia);		
		btnEspia.setOnClickListener(new OnClickListener() {
	        @Override
	        public void onClick(View v) {	
	        //	joinGame(MODO_ESPIA);
	        	Intent mainIntent = new Intent(ModoJuegoActivity.this, TrackerActivity.class);
	        	mainIntent.putExtra(Player.MODO_JUEGO, Player.MODO_ESPIA+"");
	        	startActivity(mainIntent);
                finish();//Destruimos esta activity para prevenit que el usuario retorne aqui presionando el boton Atras.
         
	        }
	    });
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.modo_juego, menu);
		return true;
	}
	

}
