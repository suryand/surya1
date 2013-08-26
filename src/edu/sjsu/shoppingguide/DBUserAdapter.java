
package edu.sjsu.shoppingguide;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DBUserAdapter 
{ 
    //public static final String KEY_ROWID = "_uid";
    public static final String KEY_USERNAME= "_uid";
    public static final String KEY_PASSWORD = "password";    
    private static final String TAG = "DBAdapter";
    
    private static final String DATABASE_NAME = "usersdb";
    private static final String DATABASE_TABLE = "users";
    private static final int DATABASE_VERSION = 1;

    private static final String DATABASE_CREATE =
        "CREATE TABLE users (_uid TEXT, password TEXT, question TEXT, answer TEXT);";
        
    private Context context = null;  
    private DatabaseHelper DBHelper;
    private SQLiteDatabase db;

    public DBUserAdapter(Context ctx) 
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
        	try {
				db.execSQL(DATABASE_CREATE);
			} catch (SQLException e) {
				e.printStackTrace();
			}
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) 
        {
            Log.w(TAG, "Upgrading database from version " + oldVersion 
                    + " to "
                    + newVersion + ", which will destroy all old data");
            db.execSQL("DROP TABLE IF EXISTS users");
            onCreate(db);
        }
    }    
    
    
    public DBUserAdapter open() throws SQLException 
    {
        db = DBHelper.getWritableDatabase();
        return this;
    }

      
    public void close() 
    {
        DBHelper.close();
    }    
    
    public long AddUser(String username, String password)
    {
    	 ContentValues initialValues = new ContentValues();
         initialValues.put(KEY_USERNAME, username);
         initialValues.put(KEY_PASSWORD, password);       
         return db.insert(DATABASE_TABLE, null, initialValues);

    }

    public boolean Login(String username, String password) throws SQLException 
    {
    	String query = "SELECT * FROM " + DATABASE_TABLE + " WHERE _uid=? AND password=?";
    	Log.w("QUERY", query + username + password );
    	Cursor mCursor = db.rawQuery("SELECT * FROM " + DATABASE_TABLE + " WHERE _uid=? AND password=?", new String[]{username,password});
    	//Cursor mCursor = db.rawQuery("SELECT * FROM " + DATABASE_TABLE + " WHERE " + KEY_USERNAME + "=? AND " + KEY_PASSWORD + "=?", new String[]{username,password});
        if (mCursor != null) {           
            if(mCursor.getCount() > 0)
            {
            	return true;
            }
        }
     return false;
    }

}
