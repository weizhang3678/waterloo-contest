package q_2020.junior;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class EscapeRoom_f {

	/**
	 * get all the possible 2-factors multiplication expressions for example: value
	 * = 8, row = 5, col = 2, we can get 8 = 2 * 4
	 * 
	 * @param number
	 * @param row:    first number limitation
	 * @param column: second number limitation
	 * @return
	 */
	private static List<List<Integer>> getNextPoints(int number, int row, int column) {
		List<List<Integer>> pointslist = new ArrayList<List<Integer>>();
		for (int i = 1; i <= Math.sqrt(number); i++) {
			if (number % i == 0) {
				int n1 = i;
				int n2 = number / n1;
				if (n1 <= row && n2 <= column) {
					List<Integer> list = new ArrayList<Integer>();
					list.add(n1);
					list.add(n2);
					pointslist.add(list);
				}

				if (n2 <= row && n1 <= column &&(n1!=n2)) {
					List<Integer> list = new ArrayList<Integer>();
					list.add(n2);
					list.add(n1);
					pointslist.add(list);
				}

			}
		}
		return pointslist;
	}

	// There is a bug here
	public static String method1(int[][] values) {
		int first = values[0][0];
		return getNext(first, values);
	}

	public static String getNext(int value, int[][] values) {
		List<List<Integer>> list = getNextPoints(value, values.length, values[0].length);
		System.out.println(list);
		List<Integer> last = new ArrayList<Integer>();
		last.add(values.length);
		last.add(values[0].length);
		if (list.contains(last)) {
			return "yes";
		}
		for (int i = 0; i < list.size(); i++) {
			List<Integer> subList = list.get(i);
			return getNext(values[subList.get(0) - 1][subList.get(1) - 1], values);
		}

		return "no";
	}

	public static void parse(Point point, Point[][] points, List<Point> path) {
		List<List<Integer>> list = getNextPoints(point.value, points.length, points[0].length);
		System.out.println(list);
		if (list.isEmpty()) {
			return;
		}
		if(path == null) {
			path = new ArrayList<Point>();
		}

		for (int i = 0; i < list.size(); i++) {
			List<Integer> subList = list.get(i);
			Point nextPoint = points[subList.get(0) - 1][subList.get(1) - 1];
			if (path.contains(nextPoint) || nextPoint.equals(points[points.length-1][points[0].length-1])) {
				path.add(nextPoint);
				return;
			}
			if (i > 0) {
				List<Point> newpath = clone(path);
				point.paths.add(newpath);
				parse(nextPoint, points, newpath);
			} else {
				path.add(nextPoint);
				parse(nextPoint, points, path);
			}
		}

	}
	
	private static List<Point> clone(List<Point> path){
		List<Point> newPath = new ArrayList<Point>();
		for(Point point: path) {
			newPath.add(point);
		}
		return newPath;
	}


	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int row = input.nextInt();
		int column = input.nextInt();
		Point[][] all_points = new Point[row][column];
		input = new Scanner(System.in);
		for (int i = 0; i < row; i++) {
			String input_value = input.nextLine();
			String[] values = input_value.split(" ");
			for (int j = 0; j < values.length; j++) {
				all_points[i][j] = new Point(i, j, Integer.valueOf(values[j]));
			}
		}

		parse(all_points[0][0],all_points,null );
		
		String result = "no";
		for(List<Point> path:all_points[0][0].paths ) {
			if(path.contains(all_points[all_points.length-1][all_points[0].length-1])) {
				result = "yes";
				break;
			}
		}
		System.out.println(result);
	}
}

class Point {
	int x;
	int y;
	int value;
	List<List<Point>> paths = new ArrayList<List<Point>>();

	public Point(int x, int y, int value) {
		this.x = x;
		this.y = y;
		this.value = value;
		paths.clear();
	}

	
}
