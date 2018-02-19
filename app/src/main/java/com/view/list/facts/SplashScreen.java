package com.view.list.facts;

import java.util.Timer;
import java.util.TimerTask;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;


public class SplashScreen extends Activity
{
	protected int _splashTime = 4000;
	
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
			 setContentView(R.layout.splash);
        try
        {
        	TimerTask task=new TimerTask() 
        	{
    			
    			@Override
    			public void run()
    			{
    				// TODO Auto-generated method stub
    				Intent intent = new Intent(getApplicationContext(), FactsActivity.class);
    		        startActivity(intent);
    		        finish();
    			}
    		};
    		Timer timer=new Timer();
    		timer.schedule(task, _splashTime);
    		
		}
        catch (Exception e) 
        {
			// TODO: handle exception
		}
	}
	
	
	
	   
}
