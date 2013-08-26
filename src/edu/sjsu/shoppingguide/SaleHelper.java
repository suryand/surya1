package edu.sjsu.shoppingguide;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import android.content.res.Resources;

public class SaleHelper {
 
 public static final String PRODUCT_INDEX = "PRODUCT_INDEX";
 
 private static List<Product> catalog;
 private static Map<Product, ShoppingCartEntry4Sale> cartMap = new HashMap<Product, ShoppingCartEntry4Sale>();
 public static void createCatalog(Resources res){
 }
 public static List<Product> getCatalog(Resources res){
  if(catalog == null) {
   catalog = new Vector<Product>();
   catalog.add(new Product("Nike Air Max 2011", res
		     .getDrawable(R.drawable.sale6),
		     "The Nike Air Max+ 2011 Men's Running Shoe improves upon its popular predecessor with an innovative, lightweight upper and a plusher fit and feel.\n\nBenefits" +
		     "\nHyperfuse upper for lightweight support, durability and ventilation\nMesh inner-sleeve for breathability and a plush fit and feel" +
		     "\nMax Air technology for maximum impact protection\nDesign" +
		     "\nThe upper of the Air Max+ 2011 Men's Running Shoe features Hyperfuse, which is made of multiple materials fused together for incredibly lightweight, \n" +
		     "\nbreathable durability and a seamless fit. Inside the shoe, a mesh inner-sleeve, or bootie, wraps around the entire foot for a plush feel and extra breathability." +
		     "\n\nCushioning\nFor smoother, more natural range of motion and maximum impact protection, the Air Max features a full-length Max Air unit. " +
		     "\nA full-length Cushlon midsole adds soft cushioning and springy resilience.\n\nAdditional Benefits" +
		     "\nReflectivity for enhanced visibility in low light\nMolded collar around the ankle to help reduce slippage" +
		     "\nColored Max Air unit with a translucent perimeter on the outsole for a unique look" +
		     "\nRubber outsole with Waffle pattern and lugs around the perimeter for durability and traction" +
		     "\nFlex grooves for enhanced flexibility and a smoother transition from heel to toe\nNike+ ready", 29.99));
		   catalog.add(new Product("Men's T-Shirt", res
				     .getDrawable(R.drawable.sale5),
				     "Logo T-Shirt: Broken in to perfection\n\nSoft to the touch and ultra-versatile, " +
				     "the Nike College Distressed Logo (Iowa) Men's T-Shirt has a worn-in look and feel with" +
				     " a proud team design.\n\nBenefits\n\n" +
				     "Rib crew-neck with interior taping for durability and comfort" +
				     "\nScreen-print at front Standard fit that's not too loose and not too tight" +
				     "\n\nAdditional Details" +
				     "\nFabric: 50% polyester/37% cotton/13% rayon " +
				     "\nMachine wash" +
				     "\nImported", 14.99));
		   catalog.add(new Product("NIKE COLLEGE TWILL", res
		     .getDrawable(R.drawable.sale4),
		     " Twill Football Jersey: Looks and feels like the real thing", 15.00));
		   catalog.add(new Product("Boys Sandals", res
				     .getDrawable(R.drawable.sale3),
				     "Ultimate comfort for less", 14.99));
		   catalog.add(new Product("Boys Jeans", res
				     .getDrawable(R.drawable.sale2),
				     "Great Jeans with smart grey patches", 14.99));
		   catalog.add(new Product("Boys Shirt", res
				     .getDrawable(R.drawable.sale1),
				     "Halfsleeves shirt made of thick jeans material", 14.99)); 
   
  }
  
  return catalog;
 }
 
 public static void setQuantity(Product sale, int quantity) {
  // Get the current cart entry
  ShoppingCartEntry4Sale curEntry = cartMap.get(sale);
  
  // If the quantity is zero or less, remove the products
  if(quantity <= 0) {
   if(curEntry != null)
    removeProduct(sale);
   return;
  }
  
  // If a current cart entry doesn't exist, create one
  if(curEntry == null) {
   curEntry = new ShoppingCartEntry4Sale(sale, quantity);
   cartMap.put(sale, curEntry);
   return;
  }
  
  // Update the quantity
  curEntry.setQuantity(quantity);
 }
 
 public static int getProductQuantity(Product sale) {
  // Get the current cart entry
  ShoppingCartEntry4Sale curEntry = cartMap.get(sale);
  
  if(curEntry != null)
   return curEntry.getQuantity();
  
  return 0;
 }
 
 public static void removeProduct(Product sale) {
  cartMap.remove(sale);
 }
 
 public static List<Product> getCartList() {
  List<Product> cartList = new Vector<Product>(cartMap.keySet().size());
  for(Product p : cartMap.keySet()) {
   cartList.add(p);
  }
  
  return cartList;
 }
}
