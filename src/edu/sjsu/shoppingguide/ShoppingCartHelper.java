package edu.sjsu.shoppingguide;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;


import android.content.res.Resources;

public class ShoppingCartHelper {
 
 public static final String PRODUCT_INDEX = "PRODUCT_INDEX";
 public static final String PRODUCT_DEPT = "PRODUCT_DEPT";
 
// private static List<Product> catalog;
 private static Map<Product, ShoppingCartEntry> cartMap = new HashMap<Product, ShoppingCartEntry>();
 
 public static void getCatalog(Resources res, List<Product> catalog, int type){
//  if(catalog == null) {
//   catalog = new Vector<Product>();
//  }
  catalog.clear();
   if (type == 1) {
	   catalog.add(new Product("Men", res
			     .getDrawable(R.drawable.men),
			     "junk", 14.99)); 
	   catalog.add(new Product("Women", res
			     .getDrawable(R.drawable.women),
			     "junk", 14.99)); 
	   catalog.add(new Product("Boys", res
			     .getDrawable(R.drawable.boys),
			     "junk", 14.99)); 
	   catalog.add(new Product("Girl", res
			     .getDrawable(R.drawable.girls),
			     "junk", 14.99)); 
   } else if (type == 2) {
	   catalog.add(new Product("Mens Formal Shirt", res
			     .getDrawable(R.drawable.man1),
			     "Logo Shirt: Stiched in to perfection", 94.99)); 
	   catalog.add(new Product("Mens Suit Black", res
			     .getDrawable(R.drawable.man2),
			     "Gives an elegant look. Smart Choice !!", 599.99));
	   catalog.add(new Product("Mens Suit White", res
			     .getDrawable(R.drawable.man3),
			     "Gives a bright appearance to suit you", 599.99));
	   catalog.add(new Product("Mens Suit Black", res
			     .getDrawable(R.drawable.man4),
			     "Lovely Finish, topclass stitching", 499.99));
	   catalog.add(new Product("Mens Casuals FullSleeves", res
			     .getDrawable(R.drawable.man5),
			     "Roundneck fullsleeves that gives a handsome look", 49.99));
   } else if (type == 3) {
	   catalog.add(new Product("Women's T-Shirt", res
			     .getDrawable(R.drawable.woman1),
			     "Halfsleeves Casuals", 59.99)); 
	   catalog.add(new Product("Women's T-Shirt", res
			     .getDrawable(R.drawable.woman2),
			     "Sleeveless Casuals", 44.99)); 
	   catalog.add(new Product("Women's T-Shirt", res
			     .getDrawable(R.drawable.woman3),
			     "Fullsleeves Casuals", 59.99)); 
	   catalog.add(new Product("Women's T-Shirt", res
			     .getDrawable(R.drawable.woman4),
			     "Fullsleeves Semitransparant", 44.99)); 
	   catalog.add(new Product("Women's T-Shirt", res
			     .getDrawable(R.drawable.woman5),
			     "Formal Wear", 99.99)); 
   } else if (type == 4) {
	   catalog.add(new Product("Boys Suit Black", res
			     .getDrawable(R.drawable.boy1),
			     "Black elegant suite", 94.99)); 
	   catalog.add(new Product("Boys Suit Grey", res
			     .getDrawable(R.drawable.boy2),
			     "Smart looking suit. Grey makes you look bright", 74.99));
	   catalog.add(new Product("Boys T-Shirt", res
			     .getDrawable(R.drawable.boy3),
			     "Fully Cotton", 44.99));
	   catalog.add(new Product("Boys T-Shirt", res
			     .getDrawable(R.drawable.boy4),
			     "Fullsleeves V-Neck", 24.99));
	   catalog.add(new Product("Boys T-Shirt", res
			     .getDrawable(R.drawable.boy5),
			     "Fullsleeves with hoodie", 24.99));
   } else if (type == 5) {
	   catalog.add(new Product("Girls Frock", res
			     .getDrawable(R.drawable.girl1),
			     "Fullsleeves top with a mini skirt", 14.99)); 
	   catalog.add(new Product("Girls Frock", res
			     .getDrawable(R.drawable.girl2),
			     "Pretty frock for pretty princess", 14.99)); 
	   catalog.add(new Product("Girls T-Shirt", res
			     .getDrawable(R.drawable.girl3),
			     "Dashing fullsleeves T-shirt", 14.99)); 
	   catalog.add(new Product("Girls Frock", res
			     .getDrawable(R.drawable.girl4),
			     "Pretty frock, gives a pleasant look", 14.99)); 
	   catalog.add(new Product("Girls Frock", res
			     .getDrawable(R.drawable.girl5),
			     "Nice frock for a naughty little girl !!", 14.99)); 
   } 
   
  
  
  //return catalog;
 }
 
 
 
 
 public static void setQuantity(Product product, int quantity) {
  // Get the current cart entry
  ShoppingCartEntry curEntry = cartMap.get(product);
  
  // If the quantity is zero or less, remove the products
  if(quantity <= 0) {
   if(curEntry != null)
    removeProduct(product);
   return;
  }
  
  // If a current cart entry doesn't exist, create one
  if(curEntry == null) {
   curEntry = new ShoppingCartEntry(product, quantity);
   cartMap.put(product, curEntry);
   return;
  }
  
  // Update the quantity
  curEntry.setQuantity(quantity);
 }
 
 public static int getProductQuantity(Product product) {
  // Get the current cart entry
  ShoppingCartEntry curEntry = cartMap.get(product);
  
  if(curEntry != null)
   return curEntry.getQuantity();
  
  return 0;
 }
 
 public static void removeProduct(Product product) {
  cartMap.remove(product);
 }
 
 public static List<Product> getCartList() {
  List<Product> cartList = new Vector<Product>(cartMap.keySet().size());
  for(Product p : cartMap.keySet()) {
   cartList.add(p);
  }
  
  return cartList;
 }
}
