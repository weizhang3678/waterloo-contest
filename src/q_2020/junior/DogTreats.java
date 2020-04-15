package q_2020.junior;

import java.util.Scanner;

public class DogTreats {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int small = scanner.nextInt();
		int medium = scanner.nextInt();
		int large = scanner.nextInt();

		int value = small + medium * 2 + large * 3;
		System.out.println(value >= 10 ? "happy" : "sad");

	}

}
