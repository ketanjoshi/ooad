package com.sample.sampleworld;

import javax.security.auth.login.LoginException;

import com.sample.sampleworld.NetworkController.ObjectTypes;

import android.content.Intent;
import android.os.Bundle;
import android.renderscript.Sampler.Value;
import android.support.v7.app.ActionBarActivity;
import android.telephony.TelephonyManager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends ActionBarActivity implements
		android.view.View.OnClickListener {

	private TextView titleTextView;
	private Button registrationButton;
	private Button loginButton;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		this.titleTextView = (TextView) super.findViewById(R.id.title_textview);
		//this.mTextView.setText("ketan");

		this.registrationButton = (Button) super.findViewById(R.id.reg_button);
		this.registrationButton.setOnClickListener(this);
		
		this.loginButton = (Button) super.findViewById(R.id.login_button);
		this.loginButton.setOnClickListener(this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	@Override
	public void onClick(View v) {
		if (v == this.registrationButton)
		{
			Toast.makeText(super.getApplicationContext(), "Proceed to registration",
					Toast.LENGTH_LONG).show();
			Intent registrationIntent = new Intent(this, UserRegistration.class);
			startActivity(registrationIntent);
		}
		else if (v == this.loginButton)
		{
			TelephonyManager tm = (TelephonyManager)getSystemService(TELEPHONY_SERVICE);
			NetworkController nc = new NetworkController(tm.getLine1Number(), ObjectTypes.LOGIN);
			
			Toast.makeText(super.getApplicationContext(), "Proceed to login", Toast.LENGTH_LONG).show();
			Intent loginIntent = new Intent(this, UserLogin.class);
			startActivity(loginIntent);
		}

	}
}
