package com;

import java.util.function.Predicate;

public class Fp_Principles {
	
	public static Predicate<Integer> and(Predicate<Integer> p1, Predicate<Integer> p2){
		return i->p1.test(i) && p2.test(i);
	}
	
	public static void main(String[] args) {
		Predicate<Integer> predicate1 = i->i>50;
		Predicate<Integer> predicate2 = i->i<100;
		
		Predicate<Integer> predicate = and(predicate1,predicate1);
		boolean b= predicate.test(60);
		System.out.println(b);
 	}
}
