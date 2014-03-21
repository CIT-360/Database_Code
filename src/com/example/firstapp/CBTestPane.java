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
import android.widget.CheckBox;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;

public class CBTestPane extends Activity {
	// GridView gridView;
	CheckBox checkbox;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
	
		super.onCreate(savedInstanceState);
		setContentView(R.layout.cbquiz);
		
		TextView textView = new TextView(this);
		textView.setTextSize(40);

		checkbox = (CheckBox) findViewById(R.id.checkBox1);
		checkbox.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				if (((CheckBox) v).isChecked()){
					Toast.makeText(CBTestPane.this, "Selected", Toast.LENGTH_LONG).show();
		} else{
			Toast.makeText(CBTestPane.this, "Not selected", Toast.LENGTH_LONG).show();
		}
				
			}
		});
		
		final Button caButton = (Button) findViewById(R.id.buttonca);
		caButton.setOnClickListener(
		new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// This needs to be where we send to a page that will check the results and show a correct or incorrect view.
				
				Intent userCreationIntent = new Intent(v.getContext(),CorrectPane.class);
				startActivityForResult(userCreationIntent, 0);
			}
		});
	};
}
