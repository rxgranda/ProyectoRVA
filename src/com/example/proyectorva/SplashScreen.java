package com.example.proyectorva;

import java.util.Timer;
import java.util.TimerTask;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.view.Menu;

public class SplashScreen extends Activity {
	 private long splashDelay = 1500; //6 segundos
static int i=0;
     @Override
     protected void onCreate(Bundle savedInstanceState) {
             super.onCreate(savedInstanceState);
             setContentView(R.layout.activity_splash_screen);
             setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE); 
             final Timer timer = new Timer();
             final Context context = this;
              TimerTask task = new TimerTask() {
                   @Override
                   public void run() {
                	   		

                       Intent mainIntent = new Intent(SplashScreen.this, MenuActivity.class);
                       i++;
                       if(i==1)
                       startActivity(mainIntent);                    
                       finish();
                    //Destruimos esta activity para prevenit que el usuario retorne aqui presionando el boton Atras.
                    
                   }
                 };
                                
                 timer.schedule(task, splashDelay);//Pasado los 6 segundos dispara la tarea
     }
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.splash_screen, menu);
		return true;
	}

}
