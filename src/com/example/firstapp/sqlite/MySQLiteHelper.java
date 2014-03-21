package com.example.firstapp.sqlite;

import java.util.LinkedList;
import java.util.List;

import com.example.firstapp.model.Test;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class MySQLiteHelper extends SQLiteOpenHelper {

	// Database Version
	private static final int DATABASE_VERSION = 1;
	// Database Name
	private static final String DATABASE_NAME = "TestDB";

	public MySQLiteHelper(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		// statement to create test table
		String CREATE_TEST_TABLE = "CREATE TABLE tests( "
				+ "id INTEGER PRIMARY KEY AUTOINCREMENT, " + "type TEXT, "
				+ "question TEXT, " + "answer 1 TEXT, " + "answer 2 TEXT, "
				+ "answer 3 TEXT, " + "answer 4 TEXT )";

		// create test table
		db.execSQL(CREATE_TEST_TABLE);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// drop older test table if exists
		db.execSQL("DROP TABLE IF EXISTS test");

		// create new test table
		this.onCreate(db);
	}

	// table name
	private static final String TABLE_TEST = "test";
	// column names
	private static final String KEY_ID = "_id";
	private static final String KEY_TYPE = "type";
	private static final String KEY_QUESTION = "question";
	private static final String KEY_ANSWER1 = "answer1";
	private static final String KEY_ANSWER2 = "answer2";
	private static final String KEY_ANSWER3 = "answer3";
	private static final String KEY_ANSWER4 = "answer4";

	private static final String[] COLUMNS = { KEY_ID, KEY_TYPE, KEY_QUESTION,
			KEY_ANSWER1, KEY_ANSWER2, KEY_ANSWER3, KEY_ANSWER4 };

	public void addTest(Test test) {
		Log.d("addTest", test.toString());
		SQLiteDatabase db = this.getWritableDatabase();

		ContentValues values = new ContentValues();
		values.put(KEY_TYPE, test.getType());
		values.put(KEY_QUESTION, test.getQuestion());
		values.put(KEY_ANSWER1, test.getAnswer1());
		values.put(KEY_ANSWER2, test.getAnswer2());
		values.put(KEY_ANSWER3, test.getAnswer3());
		values.put(KEY_ANSWER4, test.getAnswer4());

		db.insert(TABLE_TEST, null, values);

		db.close();
	}

	public Test getTest(int id) {
		SQLiteDatabase db = this.getReadableDatabase();
		Cursor cursor = db.query(TABLE_TEST, COLUMNS, "id = ?",
				new String[] { String.valueOf(id) }, null, null, null, null);

		if (cursor != null)
			cursor.moveToFirst();

		Test test = new Test();
		test.setId(Integer.parseInt(cursor.getString(0)));
		test.setType(cursor.getString(1));
		test.setQuestion(cursor.getString(2));
		test.setAnswer1(cursor.getString(3));
		test.setAnswer2(cursor.getString(4));
		test.setAnswer3(cursor.getString(5));
		test.setAnswer4(cursor.getString(6));

		Log.d("getTest(" + id + ")", test.toString());

		return test;
	}

	public List<Test> getAllTest() {
		List<Test> tests = new LinkedList<Test>();

		String query = "Select * FROM " + TABLE_TEST;

		SQLiteDatabase db = this.getWritableDatabase();
		Cursor cursor = db.rawQuery(query, null);

		Test test = null;
		if (cursor.moveToFirst()) {
			do {
				test = new Test();
				test.setId(Integer.parseInt(cursor.getString(0)));
				test.setType(cursor.getString(1));
				test.setQuestion(cursor.getString(2));
				test.setAnswer1(cursor.getString(3));
				test.setAnswer2(cursor.getString(4));
				test.setAnswer3(cursor.getString(5));
				test.setAnswer4(cursor.getString(6));

				tests.add(test);
			} while (cursor.moveToNext());
		}

		Log.d("getAllTests()", tests.toString());

		return tests;
	}

	public int updateTest(Test test) {
		SQLiteDatabase db = this.getWritableDatabase();

		ContentValues values = new ContentValues();
		values.put("type", test.getType());
		values.put("question", test.getQuestion());
		values.put("answer1", test.getAnswer1());
		values.put("answer2", test.getAnswer2());
		values.put("answer3", test.getAnswer3());
		values.put("answer4", test.getAnswer4());

		int i = db.update(TABLE_TEST, values, KEY_ID + " = ?",
				new String[] { String.valueOf(test.getId())});

		db.close();

		return i;
	}
	
	public void deleteTest (Test test){
		SQLiteDatabase db = this.getWritableDatabase();
		
		db.delete(TABLE_TEST, KEY_ID + " = ?",
				new String[] { String.valueOf(test.getId())});
		
		db.close();
		
		Log.d("deleteTest", test.toString());
	}
}
