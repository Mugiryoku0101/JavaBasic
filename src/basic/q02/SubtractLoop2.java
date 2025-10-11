package basic.q02;

public class SubtractLoop2 {
	public static void main(String[] args) {
		int num = 100;
		
		do {
			
			System.out.println(num);
			
			num--;
		} while (num >= 98);
		
		System.out.println("≀");
		
		num = 2;
		do {
			
			System.out.println(num);
			
			num--;
		} while (num >= 0);
	}
}