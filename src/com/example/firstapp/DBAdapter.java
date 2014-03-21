package com.example.firstapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.util.Log;

	    public class DBAdapter 
	    {
	    	public static final String KEY_ROWID = "_id";
		    public static final String KEY_TYPE = "type";
		    public static final String KEY_QUESTION = "question";
		    public static final String KEY_ANSWER1 = "answer1";    
		    public static final String KEY_ANSWER2 = "answer2";
		    public static final String KEY_ANSWER3 = "answer3";
		    public static final String KEY_ANSWER4 = "answer4";
		    private static final String TAG = "DBAdapter";
		    
		    private static final String DATABASE_NAME = "tests";
		    private static final String DATABASE_TABLE = "quiz";
		    private static final int DATABASE_VERSION = 1;

		    private static final String DATABASE_CREATE =
		        "create tests (_id integer primary key autoincrement, "
		        + "question type not null, question text not null, "
		        + "answer1 text not null" 
		        + "answer2 text not null" 
		        + "answer3 text not null" 
		        + "answer4 text not null);";
	            
	        private final Context context; 
	        
	        private DatabaseHelper DBHelper;
	        private SQLiteDatabase db;

	        public DBAdapter(Context ctx) 
	        {
	            this.context = ctx;
	            DBHelper = new DatabaseHelper(context);
	        }
	            
	        private static class DatabaseHelper extends SQLiteOpenHelper 
	        {
	            DatabaseHelper(Context context) 
	            {
	                super(context, DATABASE_NAME, null, DATABASE_VERSION);
	            }

	            @Override
	            public void onCreate(SQLiteDatabase db) 
	            {
	                db.execSQL(DATABASE_CREATE);
	            }

	            @Override
	            public void onUpgrade(SQLiteDatabase db, int oldVersion, 
	            int newVersion) 
	            {
	                Log.w(TAG, "Upgrading database from version " + oldVersion 
	                        + " to "
	                        + newVersion + ", which will destroy all old data");
	                db.execSQL("DROP TABLE IF EXISTS titles");
	                onCreate(db);
	            }
	        }    
	        
	        //---opens the database---
	        public DBAdapter open() throws SQLException 
	        {
	            db = DBHelper.getWritableDatabase();
	            return this;
	        }

	        //---closes the database---    
	        public void close() 
	        {
	            DBHelper.close();
	        }
	        
	        //---insert a title into the database---
	        public long insertTest(String type, String question, String answer1, String answer2, String answer3, String answer4) 
	        {
	            ContentValues initialValues = new ContentValues();
	            initialValues.put(KEY_TYPE, type);
	            initialValues.put(KEY_QUESTION, question);
	            initialValues.put(KEY_ANSWER1, answer1);
	            initialValues.put(KEY_ANSWER2, answer2);
	            initialValues.put(KEY_ANSWER3, answer3);
	            initialValues.put(KEY_ANSWER4, answer4);
	            return db.insert(DATABASE_TABLE, null, initialValues);
	        }

	        //---deletes a particular title---
	        public boolean deleteTest(long rowId) 
	        {
	            return db.delete(DATABASE_TABLE, KEY_ROWID + 
	            		"=" + rowId, null) > 0;
	        }

	        //---retrieves all the titles---
	        public Cursor getAllTests() 
	        {
	            return db.query(DATABASE_TABLE, new String[] {
	            		KEY_ROWID, 
	            		KEY_TYPE,
	            		KEY_QUESTION,
	                    KEY_ANSWER1,
	                    KEY_ANSWER2,
	                    KEY_ANSWER3,
	                    KEY_ANSWER4}, 
	                    null, 
	                    null, 
	                    null, 
	                    null, 
	                    null,
	                    null);
	        }

	        //---retrieves a particular title---
	        public Cursor getTest(long rowId) throws SQLException 
	        {
	            Cursor mCursor =
	                    db.query(true, DATABASE_TABLE, new String[] {
	                    		KEY_ROWID,
	                    		KEY_TYPE, 
	                    		KEY_QUESTION,
	                    		KEY_ANSWER1,
	                    		KEY_ANSWER2,
	                    		KEY_ANSWER3,
	                    		KEY_ANSWER4,
	                    		}, 
	                    		KEY_ROWID + "=" + rowId, 
	                    		null,
	                    		null, 
	                    		null, 
	                    		null,
	                    		null, 
	                    		null);
	            if (mCursor != null) {
	                mCursor.moveToFirst();
	            }
	            return mCursor;
	        }

	        //---updates a title---
	        public boolean updateTest(long rowId, String type, String question, String answer1, String answer2, String answer3, String answer4) 
	        {
	            ContentValues args = new ContentValues();
	            args.put(KEY_TYPE, type);
	            args.put(KEY_QUESTION, question);
	            args.put(KEY_ANSWER1, answer1);
	            args.put(KEY_ANSWER2, answer2);
	            args.put(KEY_ANSWER3, answer3);
	            args.put(KEY_ANSWER4, answer4);
	            return db.update(DATABASE_TABLE, args, 
	                             KEY_ROWID + "=" + rowId, null) > 0;
	        }
}