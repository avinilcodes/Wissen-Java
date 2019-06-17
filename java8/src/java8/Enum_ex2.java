package java8;

enum Direction{
	NORTH(10){
		public void move() {
			
		}
	}, SOUTH(20){
		public void move() {
			
		}
	},EAST(30){
		public void move() {
			
		}
	},WEST(40){
		public void move() {
			
		}
	};


	int value;
	Direction(int value){
		this.value=value;
	}
	public abstract void move();
}

public class Enum_ex2 {
	public static void main(String[] args) {
		System.out.println(Direction.NORTH.value);
//		System.out.println(Direction.NORTH.ordinal());
//		System.out.println(Direction.SOUTH.ordinal());
//		System.out.println(Direction.EAST.ordinal());
//		System.out.println(Direction.WEST.ordinal());
//		Direction[] directions= Direction.values();
//		for(Direction direction : directions) {
//			System.out.println(direction.name());
		}
}
