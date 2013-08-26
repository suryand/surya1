package edu.sjsu.shoppingguide;

import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class SaleDetailsActivity extends Activity {

 @Override
 protected void onCreate(Bundle savedInstanceState) {

  super.onCreate(savedInstanceState);
  setContentView(R.layout.saledetails);

  List<Product> catalog = SaleHelper.getCatalog(getResources());

  int productIndex = getIntent().getExtras().getInt(
    SaleHelper.PRODUCT_INDEX);
  final Product saleprod = catalog.get(productIndex);

  // Set the proper image and text
  ImageView productImageView = (ImageView) findViewById(R.id.ImageViewProduct);
  productImageView.setImageDrawable(saleprod.productImage);
  TextView productTitleTextView = (TextView) findViewById(R.id.TextViewProductTitle);
  productTitleTextView.setText(saleprod.title);
  TextView priceDetailsTextView = (TextView) findViewById(R.id.TextViewPrice);
  Double db=saleprod.price;
  String str=db.toString();
  priceDetailsTextView.setTextSize(40);
   priceDetailsTextView.setText("Sale: "+str);
  TextView productDetailsTextView = (TextView) findViewById(R.id.TextViewProductDetails);
  productDetailsTextView.setText(saleprod.description);

  
  // Update the current quantity in the cart
  TextView textViewCurrentQuantity = (TextView) findViewById(R.id.textViewCurrentlyInCart);
  textViewCurrentQuantity.setText("Currently in Cart: "
    + SaleHelper.getProductQuantity(saleprod));

  // Save a reference to the quantity edit text
  final EditText editTextQuantity = (EditText) findViewById(R.id.editTextQuantity);

  Button addToCartButton = (Button) findViewById(R.id.ButtonAddToCart);
  addToCartButton.setOnClickListener(new OnClickListener() {

   @Override
   public void onClick(View v) {

    // Check to see that a valid quantity was entered
    int quantity = 0;
    try {
     quantity = Integer.parseInt(editTextQuantity.getText()
       .toString());

     if (quantity < 0) {
      Toast.makeText(getBaseContext(),
        "Please enter a quantity of 0 or higher",
        Toast.LENGTH_SHORT).show();
      return;
     }

    } catch (Exception e) {
     Toast.makeText(getBaseContext(),
       "Please enter a numeric quantity",
       Toast.LENGTH_SHORT).show();

     return;
    }
    Toast.makeText(getBaseContext(),
           quantity+" items added to cart",
            Toast.LENGTH_SHORT).show();
    // If we make it here, a valid quantity was entered
    SaleHelper.setQuantity(saleprod, quantity);

    // Close the activity
    //finish();
	Intent viewShoppingCartIntent = new Intent(getBaseContext(), AndroidShoppingGuideActivity.class);
	startActivity(viewShoppingCartIntent);
   }
  });

 }

}
