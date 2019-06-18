package com;

import java.util.function.Function;

public class Ex1 {
	public static void main(String[] args) {

		Function<String, Integer> function1 = s -> s.length();
		Function<String, Integer> function2 = s -> Integer.parseInt(s);

		Function<Function<String, Integer>, Function<String, Integer>> logWrapper = (InpFunc) -> {
			return s -> {
				System.out.println("before :: LOG");
				int r = InpFunc.apply(s);
				System.out.println("After :: LOG");
				return r;
			};
		};
		Function<String, Integer> Function1WithLog = logWrapper.apply(function1);
		Function<String, Integer> Function2WithLog = logWrapper.apply(function2);
		
	}
}
