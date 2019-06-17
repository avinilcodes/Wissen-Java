package lib;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import com.Product;

public class Lib {
	public static List<Product> filter(List<Product> inp,Predicate<Product> predicate){
	List<Product> products = new ArrayList<>();
	for(Product product: inp) {
		if(predicate.test(product))
			products.add(product);
	}
	return products;
	}
}
