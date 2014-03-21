package com.example.firstapp;

import java.util.ArrayList;
import java.util.List;

import com.example.firstapp.model.Test;
import com.example.firstapp.sqlite.MySQLiteHelper;

import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.database.Cursor;

public class MainActivity extends Activity {
	GridView gridView;

	static final String[] COURSE_NAMES = new String[] { "FDCNC 350", "CIT 495",
			"SOC 330", "ENG 350 R", "SOC 355", "FDCA 201" };

	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		MySQLiteHelper db = new MySQLiteHelper(this);

		db.addTest(new Test("tf", "Did this work?", "true", "false", null, null));
		db.addTest(new Test("rb", "Did this work?", "yes", "no", "maybe",
				"not really"));
		db.addTest(new Test("cb", "Did this work?", "true", "kinda",
				"partially", null));
		db.addTest(new Test("tf", "Random Question", "true", "false", null,
				null));
		db.addTest(new Test("rb", "Random Question?", "option 1", "option 2",
				"option 3", "option 4"));
		db.addTest(new Test("cb", "Something random", "yes", "no", "true",
				"false"));
		db.addTest(new Test("tf", "Something weird", "true", "false", null,
				null));

		List<Test> test = db.getAllTest();

		db.deleteTest(test.get(6));

		db.getAllTest();

		
		  gridView = (GridView) findViewById(R.id.gridView);
		  
		  gridView.setAdapter(new ImageAdapter(this, COURSE_NAMES));
		  
		  gridView.setOnItemClickListener(new AdapterView.OnItemClickListener()
		  {
		  
		  @Override public void onItemClick(AdapterView<?> parent, View view,
		  int position, long id) { // Class targetActivity =
		  /*getTargetActivityForPosition(position); //
		  view.this.startActivity(new Intent(OpenTestActivity.this,
		  OpenTestPane.class)); */
			  Context context = view.getContext(); Intent
		  intent = new Intent(context ,
		  OpenTestPane.class).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		  context.startActivity(intent); }
		  
		  });
		  
		  /*public void DisplayTitle (Cursor c){ Toast.makeText(this, "id: " +
		  c.getString(0) + "\n" + "Type: " + c.getString(1) + "\n" +
		  "Question: " + c.getString(2) + "\n" + "Answer 1:  " + c.getString(3)
		  + "Answer 2: " + c.getString(4) + "\n" + "Answer 3: " +
		  c.getString(5) + "\n" + "Answer 4: " + c.getString(6) + "\n",
		  Toast.LENGTH_LONG).show(); };*/
		  
		  
		  final Button testButton = (Button) findViewById(R.id.button1);
		  testButton.setOnClickListener( new View.OnClickListener() {
		  
		  @Override public void onClick(View v) { Intent userCreationIntent =
		  new Intent(v.getContext(),OpenTestPane.class);
		  startActivityForResult(userCreationIntent, 0); } });
		  
		  final Button cbquizButton = (Button) findViewById(R.id.button2);
		  cbquizButton.setOnClickListener( new View.OnClickListener() {
		  
		  @Override public void onClick(View v) { Intent userCreationIntent =
		  new Intent(v.getContext(),CBTestPane.class);
		  startActivityForResult(userCreationIntent, 0); } });
		  
		  final Button loginButton = (Button) findViewById(R.id.button3);
		  loginButton.setOnClickListener( new View.OnClickListener() {
		  
		  @Override public void onClick(View v) { Intent userCreationIntent =
		  new Intent(v.getContext(),LoginActivity.class);
		  startActivityForResult(userCreationIntent, 0); } });
		  
		  final Button answer1Button = (Button) findViewById(R.id.button4);
		  answer1Button.setOnClickListener( new OnClickListener() {
		  
		  @Override public void onClick(View v) { Intent userCreationIntent =
		  new Intent(v.getContext(),CorrectPane.class);
		  startActivityForResult(userCreationIntent, 0); } });
		  
		  final Button answer2Button = (Button) findViewById(R.id.button5);
		  answer2Button.setOnClickListener( new View.OnClickListener() {
		  
		  @Override public void onClick(View v) { Intent userCreationIntent =
		  new Intent(v.getContext(),IncorrectPane.class);
		  startActivityForResult(userCreationIntent, 0); } });
		  
		  final Button tfquizButton = (Button) findViewById(R.id.buttontf);
		  tfquizButton.setOnClickListener( new View.OnClickListener() {
		  
		  @Override public void onClick(View v) { Intent userCreationIntent =
		  new Intent(v.getContext(),TFTestPane.class);
		  startActivityForResult(userCreationIntent, 0); } });
		  
		  final Button rbquizButton = (Button) findViewById(R.id.buttonrb);
		  rbquizButton.setOnClickListener( new View.OnClickListener() {
		  
		  @Override public void onClick(View v) { Intent userCreationIntent =
		  new Intent(v.getContext(),RBTestPane.class);
		  startActivityForResult(userCreationIntent, 0); } });
		 
	}
}