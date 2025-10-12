package method.q09;

public class Even {
	public static void main(String[] args) {
		int number = 10;
		
		boolean isEven = checkEven(number);
		
		if (isEven) {
			System.out.println(number + "は偶数です。");
		} else {
			System.out.println(number + "は奇数です。");
		}
	}
	public static boolean checkEven(int num) {
		return num % 2 == 0;
		}
	}

