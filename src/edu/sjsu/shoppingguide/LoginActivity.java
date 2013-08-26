
package edu.sjsu.shoppingguide;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends Activity {
	private Button createBtn;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.login);
		
		final EditText txtUserName = (EditText)findViewById(R.id.txtUsername);
		final EditText txtPassword = (EditText)findViewById(R.id.txtPassword);

		Button btnLogin = (Button)findViewById(R.id.btnLogin);
		btnLogin.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v) {
				String username = txtUserName.getText().toString();
				String password = txtPassword.getText().toString();
				try{
					if(username.length() > 0 && password.length() >0)
					{
						try {
				        	String destPath = "/data/data/" + getPackageName() + "/databases/usersdb";
				        	Log.w("Path: ", destPath);
				        	File f = new File(destPath);
				        	
				        	if (!f.exists()) {
					        	copyDB( getBaseContext().getAssets().open("userdb"), new FileOutputStream(destPath));
				        	}
				        } catch (FileNotFoundException e) {
				        		e.printStackTrace();
				        } catch (IOException e) {
				        	e.printStackTrace();
				        }
						
						DBUserAdapter dbUser = new DBUserAdapter(LoginActivity.this);
						dbUser.open();
						//dbUser.AddUser("mazed", "123");
						
						if(dbUser.Login(username, password))
						{
							Toast.makeText(LoginActivity.this,"Successfully Logged In", Toast.LENGTH_LONG).show();
							dbUser.close();
						    Intent catalogSelectedIntent = new Intent(getBaseContext(),AndroidShoppingGuideActivity.class);
						    AndroidShoppingGuideActivity.static_tab = 0;
						    startActivity(catalogSelectedIntent);
						}else{
							Toast.makeText(LoginActivity.this,"Invalid Username/Password", Toast.LENGTH_LONG).show();
							dbUser.close();
						}
						
					}
					
				}catch(Exception e)
				{
					Toast.makeText(LoginActivity.this,e.getMessage(), Toast.LENGTH_LONG).show();
				}
			}
			
		});
		
	    this.createBtn = (Button)this.findViewById(R.id.createAC);
	    this.createBtn.setOnClickListener(new OnClickListener() {
	        @Override
	        public void onClick(View v) {
	        	//initiating ImageActivity to perform operations on images
		        Intent i = new Intent(LoginActivity.this, DBManagementActivity.class);
		        startActivity(i);
	        }
	    });

	}
	
	public void copyDB(InputStream inputStream, OutputStream outputStream)
    		throws IOException {
    	
    		//---copy 1K bytes at a time---
    		byte[] buffer = new byte[1024];
    		int length;
    		
    		while ((length = inputStream.read(buffer)) > 0) {
    			outputStream.write(buffer, 0, length);
    		}
    		
    		inputStream.close();
    		outputStream.close();
    }
}

