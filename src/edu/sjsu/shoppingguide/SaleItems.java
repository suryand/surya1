package edu.sjsu.shoppingguide;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class SaleItems extends Activity{
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        TextView textview = new TextView(this);
        textview.setText("Sale functionality is under construction...");
        setContentView(textview);
    }
}
