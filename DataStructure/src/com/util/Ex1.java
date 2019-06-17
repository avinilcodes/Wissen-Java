package com.util;

public class Ex1 {
	public static void main(String[] args) {
		LinkedList<String> linkedList = new LinkedList<>();
		
		linkedList.add("hello");
		linkedList.add("hi");
		linkedList.add(2,"ok");
		/*System.out.println(linkedList.get(3));
		System.out.println(linkedList.length());*/
		//linkedList.iterator();
		//linkedList.set(1, "ok");
		linkedList.remove(3);
		for(String e: linkedList) {
			System.out.println(e);
		}
		
	
	}
}
