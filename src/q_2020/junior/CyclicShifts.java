package q_2020.junior;

import java.util.Scanner;

public class CyclicShifts {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String str1 = input.nextLine();
		String str2 = input.nextLine();
		String result = "no";
		for(int i = 0; i< str2.length(); i++) {
			str2 = str2.substring(1) + str2.charAt(0);
			if(str1.indexOf(str2) != -1) {
				result = "yes";
			}
		}
		System.out.println(result);
	}

}
