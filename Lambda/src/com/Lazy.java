package com;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

// lazy evaluation using messageSupplier SAM Interface

public class Lazy {
	public static void main(String[] args) {
		String s1 = null;
		Objects.requireNonNull(s1, () -> "s1 should not be null" + getMessage());
		System.out.println("All is well");
	}

	private static String getMessage() {
		try {
			TimeUnit.SECONDS.sleep(5);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return LocalDateTime.now().toString();
	}

}
