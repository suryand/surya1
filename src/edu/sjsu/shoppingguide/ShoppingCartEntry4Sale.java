package edu.sjsu.shoppingguide;

public class ShoppingCartEntry4Sale {
 
 private Product mProduct;
 private int mQuantity;
 
 public ShoppingCartEntry4Sale(Product sale, int quantity) {
  mProduct = sale;
  mQuantity = quantity;
 }
 
 public Product getProduct() {
  return mProduct;
 }
 
 public int getQuantity() {
  return mQuantity;
 }
 
 public void setQuantity(int quantity) {
  mQuantity = quantity;
 }

}
