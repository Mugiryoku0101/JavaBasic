package basic.q01;

public class SubtractLoop {

public static void main(String[] args) {
	
int num = 100;
while (num >= 0) {
	if (num > 97) {
		System.out.println(num);
	}
	else if (num == 96) {
		System.out.println("≀");

	}
	else if (num <= 2) {
		System.out.println(num);
	}
	
	num--;
}

}
}
