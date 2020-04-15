package q_2020.junior;

import java.util.Scanner;

public class Epidemiology {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int p = scanner.nextInt();
		int n = scanner.nextInt();
		int r = scanner.nextInt();
		
		int total_number = n;
		int days = 0;
		int new_number = n;
		while(total_number <= p) {
			new_number = new_number * r;
			total_number += new_number;
			days++;
		}
        System.out.println(days);
	}

}
