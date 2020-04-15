package q_2020.junior;

import java.util.Scanner;

public class Art {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		int number = input.nextInt();
		int top = 0;
		int right = 0;
		int left = 100;
		int bottom = 100;
		int i = 0; 
		input = new Scanner(System.in);
		while (i < number) {
			String str = input.nextLine();
			String[] strs = str.split(",");
			int x = Integer.parseInt(strs[0]);
			int y = Integer.parseInt(strs[1]);
			
			if(top <= y) {
				top = y+1;
			}
			if(bottom >=y ) {
				bottom = y -1;
			}
			if(left >= x) {
				left = x -1;
			}
			if(right <= x) {
				right = x+1;
			}
			i++;
		}
		System.out.println(left + "," + bottom);
        System.out.println(right + "," + top);
	}

}
