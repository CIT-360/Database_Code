/*package com.example.firstapp;

import java.util.ArrayList;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;

public class mainactivity2 extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}
}


package com.example.firstapp;

import java.util.ArrayList;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;

public class MainActivity extends Activity {
	GridView myGrid;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		myGrid = (GridView) findViewById(R.id.gridView);
		// myGrid.setAdapter(new AppAdapter(this));
	}
}

class Course
{
	int imageId;
	String courseName;
	Course(int imageId, String courseName){
		this.imageId=imageId;
		this.courseName=courseName;
	}
}

class AppAdapter extends BaseAdapter{
	
	ArrayList<Course> list;
	String[] items;
	Context context;
	LayoutInflater inflater;
	
	AppAdapter(Context context) {
		this.context = context;
		list = new ArrayList<Course>();
		Resources res = context.getResources();
		String[] tempCourseName = res.getStringArray(R.array.courseName);
		int[] courseImages = {R.drawable.capestone, R.drawable.computer, R.drawable.crime, R.drawable.film, R.drawable.gavel, R.drawable.pakistan};
		for(int i=0;i<10;i++){
			Course tempCourse = new Course(courseImages[i],tempCourseName[i]);
			list.add(tempCourse);
		}
	}
	
	@Override
	public int getCount(){
		return items.length;
	}

	@Override
	public Object getItem(int i) {
		// return list.get(i);
		return items[i];
	}

	@Override
	public long getItemId(int i) {
		return i;
	}
	
	class ViewHolder{
		ImageView courseList;
		ViewHolder(View c){
			courseList=(ImageView) c.findViewById(R.id.imageView);
		}
	}
	
	@Override
	public View getView(int i, View view, ViewGroup viewGroup) {
		/*View row=view;
		ViewHolder holder=null;*/
		/*if(view==null){
			view = inflater.inflate(R.layout.single_item, null);
			/*LayoutInflater inflater=(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			row=inflater.inflate(R.layout.single_item, viewGroup, false);
			holder=new ViewHolder(row);
			row.setTag(holder);*/
		/*}
		else{
			holder=(ViewHolder) row.getTag();
		}
		Course temp = list.get(i);
		holder.courseList.setImageResource(temp.imageId);
		return view;
	}
}*/