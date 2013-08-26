package edu.sjsu.shoppingguide;




import android.app.TabActivity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.widget.TabHost;

public class AndroidShoppingGuideActivity extends TabActivity {
    /** Called when the activity is first created. */
	public static int static_tab;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        Resources res = getResources(); // Resource object to get Drawables
	    TabHost tabHost = getTabHost();  // The activity TabHost
	    TabHost.TabSpec spec;  // Resusable TabSpec for each tab
	    Intent intent;  // Reusable Intent for each tab

	    intent = new Intent().setClass(this, CatalogActivity.class);
	    spec = tabHost.newTabSpec("browse").setIndicator("",
	                      res.getDrawable(R.drawable.ic_tab_browse))
	                  .setContent(intent);
	    tabHost.addTab(spec);
 
	    // Create an Intent to launch an Activity for the tab (to be reused)
	    intent = new Intent().setClass(this, SaleActivity.class);
	    //intent = new Intent().setClass(this, CatalogActivity.class);

	    // Initialize a TabSpec for each tab and add it to the TabHost
	    spec = tabHost.newTabSpec("sale").setIndicator("",
	                      res.getDrawable(R.drawable.ic_tab_sale))
	                  .setContent(intent);
	    tabHost.addTab(spec);
	    
	    intent = new Intent().setClass(this, LoginActivity.class);
	    spec = tabHost.newTabSpec("user").setIndicator("",
	                      res.getDrawable(R.drawable.ic_tab_user))
	                  .setContent(intent);
	    tabHost.addTab(spec);
	    
	    intent = new Intent().setClass(getBaseContext(), ShoppingCartActivity.class);
	    spec = tabHost.newTabSpec("cart").setIndicator("",
	                      res.getDrawable(R.drawable.ic_tab_cart))
	                  .setContent(intent);
	    tabHost.addTab(spec);
	    
	    intent = new Intent().setClass(this, StoreLocator.class);
	    spec = tabHost.newTabSpec("stores").setIndicator("",
	                      res.getDrawable(R.drawable.ic_tab_store))
	                  .setContent(intent);
	    tabHost.addTab(spec);


	    tabHost.setCurrentTab(static_tab);
	    static_tab = 3;
    }
}
