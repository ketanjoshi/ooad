package com.sample.sampleworld;

import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.nio.ByteBuffer;

import android.os.AsyncTask;

public class NetworkController extends AsyncTask<Void, Void, Void> {
	
	public enum ObjectTypes
	{
		LOGIN(0),
		PROFILE(1),
		SEARCH(2);
		
		private int objectType;
	    //Constructor which will initialize the enum
		ObjectTypes(int objtype)
	    {
			objectType = objtype;
	    }
	    
	    //method to return the direction set by the user which initializing the enum
	    public int GetType()
	    {
	      return objectType;
	    }
	    
	    public void SetType(int objType)
	    {
	    	objectType = objType;
	    }
	}

	//private Socket connectionSocket;
	private String dataString;
	private ObjectTypes objectTypes;

	public NetworkController(String data, ObjectTypes obj) {
				dataString = data;
	}
	
	public String SendObject() {
		try {
			//Socket socket = new Socket("10.204.40.158", 5338);
			Socket socket = new Socket("10.204.40.158", 5338);
			BufferedOutputStream bo = new BufferedOutputStream(socket.getOutputStream()); 
			//PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
			//out.println(dataString.length());
			//out.print
			bo.write(dataString.length());
			ByteBuffer bytebuff = ByteBuffer.allocate(4);
			bytebuff.putInt(dataString.length());
			byte[] result = bytebuff.array();
			byte[] buffer = new byte[dataString.length() + 4];
			System.arraycopy(dataString.getBytes("UTF-8"), 0, buffer, 4, dataString.length());
			System.arraycopy(result, 0, buffer, 0, 4);
			bo.write(buffer);
			//out.print(dataString.length());
			//out.close();
			bo.close();
			socket.close();
			return "Data serialized and sent.";
		} catch (Exception ex) {
			// TODO: handle exception
			return ex.getMessage();
		}
	}

	@Override
	protected Void doInBackground(Void... params) {
		// TODO Auto-generated method stub
		SendObject();
		return null;
	}

}