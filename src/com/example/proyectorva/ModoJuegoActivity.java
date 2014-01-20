package com.example.proyectorva;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class ModoJuegoActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_modo_juego);
		setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
		Button btnDetective = (Button) findViewById(R.id.btnDetective);		
		btnDetective.setOnClickListener(new OnClickListener() {
	        @Override
	        public void onClick(View v) {	           
	        	Intent mainIntent = new Intent().setClass(ModoJuegoActivity.this, EsperandoActivity.class);
                startActivity(mainIntent);
                //finish();//Destruimos esta activity para prevenit que el usuario retorne aqui presionando el boton Atras.
         
	        }
	    });
		
		Button btnEspia = (Button) findViewById(R.id.btnEspia);		
		btnEspia.setOnClickListener(new OnClickListener() {
	        @Override
	        public void onClick(View v) {	           
	        	Intent mainIntent = new Intent().setClass(ModoJuegoActivity.this, TrackerActivity.class);
                startActivity(mainIntent);
                //finish();//Destruimos esta activity para prevenit que el usuario retorne aqui presionando el boton Atras.
         
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
