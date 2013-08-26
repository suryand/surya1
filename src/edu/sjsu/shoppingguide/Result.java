package edu.sjsu.shoppingguide;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class Result extends Activity {
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.result);

		TextView resultText = (TextView) findViewById(R.id.resultText);
		Bundle bundle = getIntent().getExtras();

		if (bundle.getString("Cancel") != null) {
			//resultText.setText(getString(R.string.cancelOp));
		    Intent catalogSelectedIntent = new Intent(getBaseContext(),AndroidShoppingGuideActivity.class);
		    AndroidShoppingGuideActivity.static_tab = 0;
		    startActivity(catalogSelectedIntent);
		} else {
			String username = bundle.getString("Username");
			String password = bundle.getString("Password");
			String secQuestion = bundle.getString("Security Question");
			String answer = bundle.getString("Answer");
			insertUser(username, password ,secQuestion, answer);
			//resultText.setText(getString(R.string.resultOk));
			Toast.makeText(Result.this,"Registration Successful", Toast.LENGTH_LONG).show();
		    Intent LoginIntent = new Intent(getBaseContext(),LoginActivity.class);
		    startActivity(LoginIntent);
		}
	}
	
	private void insertUser(String username, String password, String secQuestion, String answer) {
		DatabaseHelper databaseHelper = new DatabaseHelper(this);
		SQLiteDatabase db = databaseHelper.getWritableDatabase();
		
		ContentValues cv = new ContentValues();
		cv.put(DatabaseHelper.USERNAME, username);
		cv.put(DatabaseHelper.PASSWORD, password);
		cv.put(DatabaseHelper.SECQUESTION, secQuestion);
		cv.put(DatabaseHelper.ANSWER, answer);
		
		db.insert("users", DatabaseHelper.USERNAME, cv);
		db.close();
	}


	
	
}