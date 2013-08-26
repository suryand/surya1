package edu.sjsu.shoppingguide;

import java.util.List;
import java.util.Vector;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;

public class CatalogActivity extends Activity {

	private List<Product> mProductList;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.catalog);
		
		// Obtain a reference to the product catalog
	//	mProductList = ShoppingCartHelper.getCatalog(getResources(), 1);
		
		mProductList = new Vector<Product>();
		ShoppingCartHelper.getCatalog(getResources(), mProductList, 1);
		
		// Create the list
		ListView listViewCatalog = (ListView) findViewById(R.id.ListViewCatalog);
		listViewCatalog.setAdapter(new ProductAdapter(mProductList, getLayoutInflater(), false));
		
		listViewCatalog.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position,
					long id) {
				if (position == 0) {
				    Intent catalogSelectedIntent = new Intent(getBaseContext(),CatalogMensActivity.class);
				    startActivity(catalogSelectedIntent);
				} else if (position == 1) {
				    Intent catalogSelectedIntent = new Intent(getBaseContext(),CatalogWomensActivity.class);
				    startActivity(catalogSelectedIntent);
				} else if (position == 2) {
				    Intent catalogSelectedIntent = new Intent(getBaseContext(),CatalogBoysActivity.class);
				    startActivity(catalogSelectedIntent);
				} else if (position == 3) {
				    Intent catalogSelectedIntent = new Intent(getBaseContext(),CatalogGirlsActivity.class);
				    startActivity(catalogSelectedIntent);
				}
			}
		});
		
	}
}