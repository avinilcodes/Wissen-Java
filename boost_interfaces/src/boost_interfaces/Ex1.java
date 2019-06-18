package boost_interfaces;

interface I1{
	default void m1() {
		
	}
}
interface I2{
	default void m1() {
		
	}
}

class imple implements I1,I2{

	@Override
	public void m1() { 
		//..
	}
	
}

public class Ex1 {
	public static void main(String[] args) {
		
	}
}
