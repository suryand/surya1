package edu.sjsu.shoppingguide;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AutoCompleteTextView;

public class DBManagementActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup);
    }
    
    public void onAddClick(View botton) {
		AutoCompleteTextView username = (AutoCompleteTextView) findViewById(R.id.username);
		AutoCompleteTextView password = (AutoCompleteTextView) findViewById(R.id.password);
		AutoCompleteTextView secQuestion = (AutoCompleteTextView) findViewById(R.id.secQuestion);
		AutoCompleteTextView answer = (AutoCompleteTextView) findViewById(R.id.answer);
    	
		Intent intent = new Intent();
		intent.setClass(this,Result.class);

		intent.putExtra("Username", username.getText().toString());
		intent.putExtra("Password", password.getText().toString());
		intent.putExtra("Security Question", secQuestion.getText().toString());
		intent.putExtra("Answer", answer.getText().toString());
		startActivity(intent);
	}
    
    public void onCancelClick(View botton) {
		Intent intent = new Intent();
		intent.setComponent(new ComponentName(this,Result.class));
		intent.putExtra("Cancel", "Cancel");
		startActivity(intent);
	}

}