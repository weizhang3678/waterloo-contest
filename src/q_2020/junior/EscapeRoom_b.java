package q_2020.junior;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class EscapeRoom_b {

	static boolean[][] searched = new boolean[1000][1000];// record cells are searched or not
	static Map<Integer, List<Cell>> cellMap = new HashMap<Integer, List<Cell>>(); // record all cells, by the values in																					// the cells
	static List<Cell> queue = new LinkedList<Cell>();// record all neighbor backward

	public static String isPossible(Cell last) {
		queue.add(last);
		while (!queue.isEmpty()) {
			Cell cell = queue.remove(0);
			List<Cell> neighbors = cellMap.get(cell.column * cell.row);
			for (Cell neighbor : neighbors) {
				if (neighbor.row == 1 && neighbor.column == 1) {
					return "yes";
				} else if (!searched[neighbor.row][neighbor.column]) {
					searched[neighbor.row][neighbor.column] = true;
                    queue.add(neighbor);
				}
			}
		}

		return "no";
	}

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int row = input.nextInt();
		int column = input.nextInt();
		input = new Scanner(System.in);
		Cell last = new Cell();
		last.row = row;
		last.column = column;
		for (int i = 1; i <= row; i++) {
			String input_value = input.nextLine();
			String[] values = input_value.split(" ");
			for (int j = 1; j <= values.length; j++) {
				int key = Integer.parseInt(values[j-1]);
				Cell cell = new Cell();
				cell.row = i;
				cell.column = j;
				if (cellMap.containsKey(key)) {
					cellMap.get(key).add(cell);
				}else {
					List<Cell> list = new LinkedList<Cell>();
					list.add(cell);
					cellMap.put(key, list);
				}
			}
		}
		System.out.println(isPossible(last));
		
	}

}

class Cell {
	int row;
	int column;
}