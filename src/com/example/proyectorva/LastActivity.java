package com.example.proyectorva;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.drawable.Drawable;
import android.view.Menu;
import android.widget.ImageView;

public class LastActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE); 
		setContentView(R.layout.activity_last);
		
		Intent intent = getIntent();
	    String message = intent.getStringExtra(Player.RESULTADO);
	    ImageView fondo=(ImageView)(findViewById(R.id.resultado));
	    
	    Drawable image ;
	    if(message.equals(Player.RESULTADO_GANO))
	    	image= getResources().getDrawable(R.drawable.gano);	    	
	    else if(message.equals(Player.RESULTADO_ELIMINADO))
	    	image= getResources().getDrawable(R.drawable.perdio);
	    else 
	    	image= getResources().getDrawable(R.drawable.eliminado);
	    		    	
	    	fondo.setBackground(image);
	    	
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.last, menu);
		return true;
	}

}
