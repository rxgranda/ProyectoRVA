package com.example.proyectorva;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;

public class MenuActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
		setContentView(R.layout.activity_menu);
		ImageButton btnSalir = (ImageButton) findViewById(R.id.btnDesarrolladores);		
		btnSalir.setOnClickListener(new OnClickListener() {
	        @Override
	        public void onClick(View v) {	           
	        	Intent mainIntent = new Intent(MenuActivity.this, DesarrolladoresActivity.class);
                startActivity(mainIntent);
               
	        }
	    });
		
		ImageButton btnIstrucciones = (ImageButton) findViewById(R.id.btnInstrucciones);		
		btnIstrucciones.setOnClickListener(new OnClickListener() {
	        @Override
	        public void onClick(View v) {	           
	        	Intent mainIntent = new Intent(MenuActivity.this, InstruccionActivity.class);
               startActivity(mainIntent);
               
	        }
	    });
		
		ImageButton btnJugar = (ImageButton) findViewById(R.id.btnJugar);		
		btnJugar.setOnClickListener(new OnClickListener() {
	        @Override
	        public void onClick(View v) {	           
	        	Intent mainIntent = new Intent(MenuActivity.this, ModoJuegoActivity.class);
                startActivity(mainIntent);
                finish();//Destruimos esta activity para prevenit que el usuario retorne aqui presionando el boton Atras.
         
	        }
	    });
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.menu, menu);
		return true;
	}

}
