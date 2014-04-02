package com.example.coopizza;

import java.util.Calendar;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {

	private final String TAG = "CooPizza";
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
				
		
		// Restore any saved state 
		super.onCreate(savedInstanceState);
		
		// Set content view
		setContentView(R.layout.activity_main);
		
		// Initialize UI elements
		final Button listBtn = (Button) findViewById(R.id.buttonList);
		final Button routeBtn = (Button) findViewById(R.id.buttonRoute);
		
		// Link UI elements to actions in code	
		listBtn.setOnClickListener(new Button.OnClickListener() {			
			@Override
			public void onClick(View v) {				
				startListActivity();				
			}		
			
		});
		
		routeBtn.setOnClickListener(new Button.OnClickListener() {
			@Override
			public void onClick(View v) {
				startRouteActivity();
			}
		});
		
		Log.e(TAG, "Antes do Servi�o");
		// Starting Location Service with AlarmManager
		Calendar cal = Calendar.getInstance();

		Intent intent = new Intent(this, LocationService.class);
		PendingIntent pintent = PendingIntent.getService(this, 0, intent, 0);

		AlarmManager alarm = (AlarmManager)getSystemService(Context.ALARM_SERVICE);
				// Start every 10 seconds
		alarm.setRepeating(AlarmManager.RTC_WAKEUP, cal.getTimeInMillis(), 10*1000, pintent);
		Log.e(TAG, "Depois do Sservi�o");
		
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	//Start the ListActivity
	
	private void startListActivity() {
		try {
			Intent listIntent = new Intent(this, ListActivity.class);
			startActivity(listIntent);
			
		} catch (Exception e) {
			Log.e(TAG, e.toString());
		}
	}
	
	//Start the RouteActivity
	
	private void startRouteActivity() {
		try {
			Intent routeIntent = new Intent(this, RouteActivity.class);
			startActivity(routeIntent);
			
		} catch (Exception e) {
			Log.e(TAG, e.toString());
		}
	}
	
	
	
	
	
}
