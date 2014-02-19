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

public class TrackerActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tracker);
		 setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
		 ImageButton btnTracker1 = (ImageButton) findViewById(R.id.btnTracker1);		
		 btnTracker1.setOnClickListener(new OnClickListener() {
		        @Override
		        public void onClick(View v) {	           
		        	Intent mainIntent = new Intent().setClass(TrackerActivity.this, EsperandoActivity.class);
	                startActivity(mainIntent);
	                //finish();//Destruimos esta activity para prevenit que el usuario retorne aqui presionando el boton Atras.
	         
		        }
		    });
		 ImageButton btnTracker2 = (ImageButton) findViewById(R.id.btnTracker2);		
		 btnTracker2.setOnClickListener(new OnClickListener() {
		        @Override
		        public void onClick(View v) {	           
		        	Intent mainIntent = new Intent().setClass(TrackerActivity.this, EsperandoActivity.class);
	                startActivity(mainIntent);
	                //finish();//Destruimos esta activity para prevenit que el usuario retorne aqui presionando el boton Atras.
	         
		        }
		    });
		 ImageButton btnTracker3 = (ImageButton) findViewById(R.id.btnTracker3);		
		 btnTracker3.setOnClickListener(new OnClickListener() {
		        @Override
		        public void onClick(View v) {	           
		        	Intent mainIntent = new Intent().setClass(TrackerActivity.this, EsperandoActivity.class);
	                startActivity(mainIntent);
	                //finish();//Destruimos esta activity para prevenit que el usuario retorne aqui presionando el boton Atras.
	         
		        }
		    });
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.tracker, menu);
		return true;
	}

}
