package com.example.firstapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.TextView;

public class ImageAdapter extends BaseAdapter {
	private final String[] courses;
	
	private Context context;

	public ImageAdapter(Context context, String[] courses){
		this.context = context;
		this.courses = courses;
	}
	
	@Override
	public int getCount() {
		//number of pictures displayed 
		return courses.length;
	}

	@Override
	public Object getItem(int arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getItemId(int arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public View getView(int position, View view, ViewGroup group) {
		LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		View gridView;
		if(view == null){
			gridView = new View(context);
			gridView = inflater.inflate(R.layout.single_item, null);
			TextView textView = (TextView) gridView.findViewById(R.id.label);
			textView.setText(courses[position]);
			ImageView classes = (ImageView) gridView.findViewById(R.id.course);
			String mobile = courses[position];
	        if (mobile.equals("FDCNC 350")){
				classes.setImageResource(R.drawable.capestone);
			}else if (mobile.equals("CIT 495")){
				classes.setImageResource(R.drawable.computer);
			}else if (mobile.equals("SOC 330")){
				classes.setImageResource(R.drawable.crime);
			}else if (mobile.equals("ENG 350 R")){
				classes.setImageResource(R.drawable.film);
			}else if (mobile.equals("SOC 355")){
				classes.setImageResource(R.drawable.gavel);
			}else if (mobile.equals("FDCA 201")){
				classes.setImageResource(R.drawable.pakistan);
			}
		}
		else{
			gridView = (View)view;
			// gridView.setLayoutParams(new GridView.LayoutParams(200,200));
		}
		// gridView.setImageResource(images[position]);
		return gridView;
	}

}
