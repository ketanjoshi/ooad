package com.sample.sampleworld;

import android.support.v7.app.ActionBarActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class UserLogin extends ActionBarActivity implements OnClickListener{

	private EditText emailText;
	private EditText passText;
	private Button loginButton;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_user_login);
		this.emailText = (EditText) super.findViewById(R.id.email_edittext);
		this.passText = (EditText) super.findViewById(R.id.pass_edittext);
		this.loginButton = (Button) super.findViewById(R.id.logging_button);
		this.loginButton.setOnClickListener(this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.user_login, menu);
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
		// TODO Auto-generated method stub
		if (v == this.loginButton)
		{
			//TODO : Credentials check here....
			
			Toast.makeText(super.getApplicationContext(), "Opening profile for " + emailText.getText().toString(), 
					Toast.LENGTH_LONG).show();
			Intent profileIntent = new Intent(this, UserProfile.class);
			startActivity(profileIntent);
		}
	}
}
