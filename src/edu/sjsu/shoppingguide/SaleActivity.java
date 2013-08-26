package edu.sjsu.shoppingguide;

import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;

public class SaleActivity extends Activity {

	private List<Product> mProductList;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.catalogselected);
		
		// Obtain a reference to the product catalog
		mProductList = SaleHelper.getCatalog(getResources());
		
		// Create the list
		ListView listViewCatalog = (ListView) findViewById(R.id.ListViewCatalogSelected);
		listViewCatalog.setAdapter(new SaleAdapter(mProductList, getLayoutInflater(), true));
		
		listViewCatalog.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position,
					long id) {
				Intent productDetailsIntent = new Intent(getBaseContext(),SaleDetailsActivity.class);
				productDetailsIntent.putExtra(SaleHelper.PRODUCT_INDEX, position);
				startActivity(productDetailsIntent);
			}
		});
		

	}
}