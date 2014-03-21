package com.example.firstapp;

import java.util.ArrayList;

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
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;

public class IncorrectPane extends Activity {
	GridView gridView;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
	
		super.onCreate(savedInstanceState);
		setContentView(R.layout.incorrect_answer);
		
		final ImageButton checkButton = (ImageButton) findViewById(R.id.imageButton2);
		checkButton.setOnClickListener(
		new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// This needs to be where we send to a page that will check the results and show a correct or incorrect view.
				
				Intent userCreationIntent = new Intent(v.getContext(),MainActivity.class);
				startActivityForResult(userCreationIntent, 0);
			}
		});
	}
	
}

