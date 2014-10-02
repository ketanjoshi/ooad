package com.sample.sampleworld;

import com.sample.sampleworld.NetworkController.ObjectTypes;

import android.support.v7.app.ActionBarActivity;
import android.telephony.TelephonyManager;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.EditText;

public class UserRegistration extends ActionBarActivity implements OnClickListener, OnFocusChangeListener {

	private EditText name;
	private EditText contact;
	private EditText address;
	private EditText blood;
	private EditText email;
	private EditText password;
	private EditText dob;
	private Button registerButton;
	private CalendarView dobCalView;
	//private Socket socket;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_user_registration);
		
		name = (EditText) super.findViewById(R.id.name_edittext);
		//contact = (EditText) super.findViewById(R.id.contact_edittext);
		address = (EditText) super.findViewById(R.id.address_edittext);
		blood = (EditText) super.findViewById(R.id.blood_edittext);
		email = (EditText) super.findViewById(R.id.mail_edittext);
		//password = (EditText) super.findViewById(R.id.password_edittext);
		dob = (EditText) super.findViewById(R.id.dob_edittext);
		registerButton = (Button) super.findViewById(R.id.submit_button);
		registerButton.setOnClickListener(this);
		//dobCalView = (CalendarView) super.findViewById(R.id.dob_calview);
		//dobCalView.setOnClickListener(this);
	/*	dob.setOnFocusChangeListener(this);
		try {
			socket = new Socket("192.168.0.3", 30000);
			Toast.makeText(super.getApplicationContext(), "Success", Toast.LENGTH_LONG).show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Toast.makeText(super.getApplicationContext(), "Exception : " + e.getMessage(), Toast.LENGTH_LONG).show();
		}*/
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.user_registration, menu);
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
		
		if (v == this.registerButton)
		{
			//TODO : Input check and registration part.... sending profile object to the server
			
			//Toast.makeText(super.getApplicationContext(), name.getText().toString(), Toast.LENGTH_LONG).show();
			
			/*Employee e = new Employee(name.getText().toString(), address.getText().toString(),
								123, 1111);
			NetworkController nc = new NetworkController();
			String msg = nc.SendObject(e);
			Toast.makeText(super.getApplicationContext(), msg, Toast.LENGTH_LONG).show();*/
			
			TelephonyManager tm = (TelephonyManager)getSystemService(TELEPHONY_SERVICE);
			String testdata="OOAD";
			String data = String.format("%s,%s,%s,%d,%d", name.getText().toString(), 
					address.getText().toString(), tm.getLine1Number(), 123, 1111);
			 NetworkController nc = new NetworkController(testdata, ObjectTypes.PROFILE);
			 nc.execute();
			//msg = tm.getLine1Number();
			
			//String msg = SendDataToServer(testdata);
			//Toast.makeText(super.getApplicationContext(), msg, Toast.LENGTH_LONG).show();
		}
		if (v == this.dobCalView)
		{
			
		}
	}
	
	/*@SuppressLint("NewApi")
	private String SendDataToServer(String data)
	{
		StringBuilder msgBuilder = new StringBuilder();
		
		try {
			msgBuilder.append("Inside try. ");
			StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
			StrictMode.setThreadPolicy(policy);
			Socket socket = new Socket("192.168.43.201", 33000);
			Toast.makeText(this, "Socket created", 5000).show();
			msgBuilder.append("Socket created..yo ");
			//InetAddress serverAddr = InetAddress.getByName("192.168.0.3");
			//Socket socket = new Socket(serverAddr, 30000);
			msgBuilder.append("Connection made. ");
			PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
			out.println(data);
			msgBuilder.append("Written on socket. ");
			out.close();
			socket.close();			
		} catch (Exception e) {
			// TODO: handle exception
			msgBuilder.append(e.getMessage());
		}
		finally {

			
			return msgBuilder.toString();
		}
	}*/

	@Override
	public void onFocusChange(View v, boolean hasFocus) {
		// TODO Auto-generated method stub
		//if(v == this.dob)
		{
			/*Date birthDate = new Date();
			SimpleDateFormat dateFormat = new SimpleDateFormat("YYYY-MM-DD");
			birthDate = dateFormat.parse(dob.getText().toString());
			Calendar calendar = Calendar.getInstance();
			Date currentDate = calendar.getTime();
			int years = (int) ( (currentDate.getTime() - birthDate.getTime()) / 86400);
			
			if(years < 17)
			{
				//Not eligible
			}*/

		}
		
	}
}
