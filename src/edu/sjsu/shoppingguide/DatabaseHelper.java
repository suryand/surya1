package edu.sjsu.shoppingguide;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {
	private static final String DATABASE_NAME = "usersdb";
	public static final String USERNAME = "_uid";
	public static final String PASSWORD = "password";
	public static final String SECQUESTION = "question";
	public static final String ANSWER = "answer";

	public DatabaseHelper(Context context) {
		super(context, DATABASE_NAME, null, 1); 
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL(	"CREATE TABLE users (_uid TEXT, password TEXT, question TEXT, answer TEXT);");
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		android.util.Log.w("users",
				"Upgrading database, which will destroy all old data");
		db.execSQL("DROP TABLE IF EXISTS users");
		onCreate(db);
	}
}