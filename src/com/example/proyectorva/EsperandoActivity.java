package com.example.proyectorva;

import java.util.Timer;
import java.util.TimerTask;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.view.Menu;

public class EsperandoActivity extends Activity {
	 private long splashDelay = 3000; //6 segundos

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_esperando);
		setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
		 TimerTask task = new TimerTask() {
             @Override
             public void run() {
               Intent mainIntent = new Intent().setClass(EsperandoActivity.this, MapaActivity.class);
               startActivity(mainIntent);
               finish();//Destruimos esta activity para prevenit que el usuario retorne aqui presionando el boton Atras.
             }
           };

           Timer timer = new Timer();
           timer.schedule(task, splashDelay);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.esperando, menu);
		return true;
	}

}
