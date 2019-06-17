package com;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import lib.Lib;

public class Q2 {
	static List<Product> products = new ArrayList<>();

	static {
		products.add(new Product(123, "item1", 100.0));
		products.add(new Product(124, "item2", 1000.0));
		products.add(new Product(125, "item3", 900.0));
		products.add(new Product(126, "item5", 10000.0));
	}
	// => imperative paradigm
	// private static List<Product> getProducts(double price){
	// List<Product> pro= new ArrayList<>();
	// for(Product p: products) {
	// if(p.getPrice()==price) {
	// pro.add(p);
	// }
	// }
	// return pro;
	// }
	// private static List<Product> getProductsInRange(double minPrice,double
	// maxPrice){
	// List<Product> pro= new ArrayList<>();
	// for(Product p: products) {
	// if(p.getPrice()>=minPrice && p.getPrice()<=maxPrice) {
	// pro.add(p);
	// }
	// }
	// return pro;
	// }

	// Declarative paradigm ==> using local inner class

	// private static List<Product> getProducts(double price){
	// class ByPrice implements Predicate<Product>{
	// @Override
	// public boolean test(Product t) {
	// return t.getPrice()==price;
	// }
	// };
	// Predicate<Product> byPrice = new ByPrice();
	// return Lib.filter(products,byPrice);
	// }

	// Declarative paradigm ==> using anonymous
	// private static List<Product> getProducts(double price){
	// Predicate<Product> byPrice = new Predicate<Product>(){
	// @Override
	// public boolean test(Product t) {
	// return t.getPrice()==price;
	// }
	// };
	// return Lib.filter(products,byPrice);
	// }

	// Declarative style : function
	private static List<Product> getProducts(double price) {
		return Lib.filter(products, t -> t.getPrice() == price);
	}

	private static List<Product> getProductsInRange(double minPrice, double maxPrice) {
		return Lib.filter(products, t -> t.getPrice() >= minPrice && t.getPrice() <= maxPrice);
	}

	private static void display(List<Product> products) {
		for (Product p : products)
			System.out.println(p);
	}

	public static void main(String[] args) {
		List<Product> products;
		products = getProductsInRange(100.00,90000.00);
		display(products);

	}

}
