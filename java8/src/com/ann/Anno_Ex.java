package com.ann;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlRootElement;

class Super{
	public void abc() {
		System.out.println("Super :: abc()");
	}
}
class Sub extends Super{

	@Override
	public void abc() {
		
	}
	
}

class Lib{
	@Deprecated
	public static void v1() {
		
	}
	public static void v2() {
		
	}
}
//JAXB Tool(JDK 1.6)
@XmlRootElement
class Product{
	private int id;
	private String name;
}
public class Anno_Ex {
public static void main(String[] args) {
	@SuppressWarnings({"rawtypes","unused"})
	ArrayList arrayList = new ArrayList();
	
}
}
