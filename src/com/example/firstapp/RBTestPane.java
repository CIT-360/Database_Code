package com.example.firstapp;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;
import android.app.Activity;
import android.content.Intent;

public class RBTestPane extends Activity {
	RadioButton rbutton, rbutton1, rbutton2, rbutton3, rbutton4, rbutton5,
			rbutton6;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
 
		super.onCreate(savedInstanceState);
		setContentView(R.layout.rbquiz);

		// TextView textView = new TextView(this);

		final OnClickListener radio_listener = new OnClickListener() {

			@Override
			public void onClick(View v) {
				rbutton = (RadioButton) v;
				Toast.makeText(RBTestPane.this, rbutton.getText(),
						Toast.LENGTH_LONG).show();

			}
		};

		rbutton1 = (RadioButton) findViewById(R.id.radioButton1);
		rbutton1.setOnClickListener(radio_listener);
		rbutton2 = (RadioButton) findViewById(R.id.radioButton2);
		rbutton2.setOnClickListener(radio_listener);
		rbutton3 = (RadioButton) findViewById(R.id.radioButton3);
		rbutton3.setOnClickListener(radio_listener);
		rbutton4 = (RadioButton) findViewById(R.id.radioButton4);
		rbutton4.setOnClickListener(radio_listener);

		final Button caButton = (Button) findViewById(R.id.buttonrb);
		caButton.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// This needs to be where we send to a page that will check the
				// results and show a correct or incorrect view.

				Intent userCreationIntent = new Intent(v.getContext(),
						IncorrectPane.class);
				startActivityForResult(userCreationIntent, 0);
			}
		});
	};
}
