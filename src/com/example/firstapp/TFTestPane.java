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

public class TFTestPane extends Activity {
	RadioButton rbutton, rbutton5, rbutton6;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
	
		super.onCreate(savedInstanceState);
		setContentView(R.layout.tfquiz);
		
		// TextView textView = new TextView(this);
		// textView.setTextSize(40);
	
		final OnClickListener radio_listener = new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				rbutton = (RadioButton) v;
				Toast.makeText(TFTestPane.this, rbutton.getText(), Toast.LENGTH_LONG).show();
					
				}			
		};
	
		rbutton5 = (RadioButton) findViewById(R.id.radioButton5);	
		rbutton5.setOnClickListener (radio_listener);
		rbutton6 = (RadioButton) findViewById(R.id.radioButton6);	
		rbutton6.setOnClickListener (radio_listener);
		
		final Button caButton = (Button) findViewById(R.id.buttontf);
		caButton.setOnClickListener(
			new View.OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// This needs to be where we send to a page that will check the results and show a correct or incorrect view.
					
					Intent userCreationIntent = new Intent(v.getContext(),IncorrectPane.class);
					startActivityForResult(userCreationIntent, 0);
				}
			}
		);
	};
}
