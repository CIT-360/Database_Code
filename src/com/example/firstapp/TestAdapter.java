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

public class TestAdapter extends BaseAdapter {
	// private final String[] courses;
	
	int[] images = {
			R.drawable.one, R.drawable.two,
			R.drawable.three, R.drawable.four,
			R.drawable.five, R.drawable.six,
			R.drawable.seven, R.drawable.eight,
			R.drawable.nine, R.drawable.ten,
			R.drawable.eleven, R.drawable.twelve,
			R.drawable.thirteen, R.drawable.fourteen,
			R.drawable.fifteen
	};
	private Context context;

	public TestAdapter (Context applicationContext){
		context = applicationContext;
	}
	
	@Override
	public int getCount() {
		//number of pictures displayed 
		return images.length;
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
		ImageView iv;
		if(view!=null){
			iv = (ImageView) view;
		}
		else{
			iv = new ImageView(context);
			iv.setLayoutParams(new GridView.LayoutParams(200,200));
		}
		iv.setImageResource(images[position]);
		return iv;
	}

}
