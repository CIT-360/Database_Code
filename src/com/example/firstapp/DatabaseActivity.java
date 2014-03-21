package com.example.firstapp;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

	    public class DatabaseActivity extends Activity {
	    	protected void onCreate(Bundle savedInstanceState) {
	    		
	    		super.onCreate(savedInstanceState);
	    		setContentView(R.layout.activity_main);
	    		DBAdapter db = new DBAdapter(this);
	    		
	    		// add 6 questions
	    		db.open();
	    		long id;
	    		id = db.insertTest("tf", "Did this work?", "true", "false", null, null);
	    		id = db.insertTest("rb", "Did this work?", "yes", "no", "maybe", "not really");
	    		id = db.insertTest("cb", "Did this work?", "true", "kinda", "partially", null);
	    		id = db.insertTest("tf", "Random Question", "true", "false", null, null);
	    		id = db.insertTest("rb", "Random Question?", "option 1", "option 2", "option 3", "option 4");
	    		id = db.insertTest("cb", "Something random", "yes", "no", "true", "false");
	    		db.close();
	    		
	    		/*Cursor c = db.getAllTests();
	    		if (c.moveToFirst()){
	    			do{
	    				DisplayTitle(c);
	    			} while (c.moveToNext));
	    		}
	    	db.close();
	    	public void DisplayTitle (Cursor c){
				Toast.makeText(this,  "id: " + c.getString(0) + "\n" +
		                "Type: " + c.getString(1) + "\n" +
		                "Question: " + c.getString(2) + "\n" +
		                "Answer 1:  " + c.getString(3) + 
		                 "Answer 2: " + c.getString(4) + "\n" +
	                "Answer 3: " + c.getString(5) + "\n" +
	                "Answer 4: " + c.getString(6) + "\n", Toast.LENGTH_LONG).show();
			};*/
	    	}
	    }