package com;

import java.util.ArrayList;
import java.util.List;

public class Q1 {
	public static void main(String[] args) {
		List<String> menu = new ArrayList<>();
		menu.add("veg");
		menu.add("nveg");
		menu.add("veg");
		menu.add("nveg");
		menu.add("veg");
		menu.add("nveg");
		List<String> vegMenu =new ArrayList<>();
		for(String s: menu) {
			if(s=="veg") {
				vegMenu.add("veg");
			}
		}
		System.out.println(vegMenu);
	}
}
