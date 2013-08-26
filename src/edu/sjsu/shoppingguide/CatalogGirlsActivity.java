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

public class CatalogGirlsActivity extends Activity {

	private List<Product> mProductList;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.catalogselected);
		
		// Obtain a reference to the product catalog
	//	mProductList = ShoppingCartHelper.getCatalog(getResources(), 5);
		mProductList = new Vector<Product>();
		ShoppingCartHelper.getCatalog(getResources(), mProductList, 5);
		
		// Create the list
		ListView listViewCatalogSelected = (ListView) findViewById(R.id.ListViewCatalogSelected);
		listViewCatalogSelected.setAdapter(new ProductAdapter(mProductList, getLayoutInflater(), false));
		
		listViewCatalogSelected.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position,
					long id) {
				Intent productDetailsIntent = new Intent(getBaseContext(),ProductDetailsActivity.class);
				productDetailsIntent.putExtra(ShoppingCartHelper.PRODUCT_INDEX, position);
				productDetailsIntent.putExtra(ShoppingCartHelper.PRODUCT_DEPT, 5);
				startActivity(productDetailsIntent);
			}
		});
		


	}
}
