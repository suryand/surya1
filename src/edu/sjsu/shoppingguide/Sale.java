package edu.sjsu.shoppingguide;

import android.graphics.drawable.Drawable;

public class Sale extends Product {

	public String title;
	public Drawable productImage;
	public String description;
	public double price;
	public boolean selected;

	public Sale(String title, Drawable productImage, String description,
			double price) {
		super();
		this.title = title;
		this.productImage = productImage;
		this.description = description;
		this.price = price;
	}

}
