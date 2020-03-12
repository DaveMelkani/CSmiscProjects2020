import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class KirbyPP {
	File file;
	Scanner sc;
	Scanner s;
	String[][][] arr;
	// int davedab;
	int height;
	int width;
	int numRooms;

	public KirbyPP(String mapName) throws FileNotFoundException {
		file = new File(mapName); // point to file
		sc = new Scanner(file);
		height = sc.nextInt();
		width = sc.nextInt();
		numRooms = sc.nextInt();
		System.out.print(height + " ");
		System.out.print(width + " ");
		System.out.print(numRooms);
		System.out.println();
		sc.next();

		arr = new String[height][width][numRooms];

		if (sc.hasNextInt()) {
			sc.close();
			sc = new Scanner(file);
			createMapFromCoords();
		} else {
			sc.close();
			sc = new Scanner(file);
			createMapFromText();
		}
	}

	public void createMapFromText() {
		sc.nextInt();
		sc.nextInt();
		sc.nextInt();
		System.out.println("text");

		// TODO Auto-generated method stub
		// keep input file in the parent folder for the project
		// not in the src folder

		// NO TRAILING SPACES OR TRAILING EMPTY LINES
		// LAST LINE NEEDS TO BE AN ELEMENT
		int row = 0;
		int roomNum = 0;
		while (sc.hasNextLine()) { // check a line exists in the input file
			if (row > height - 1) {
				row = 0;
				roomNum++;
			}
			String str = sc.next(); // NOTE format of input file is expected
			System.out.println(str);

			for (int j = 0; j < str.length(); j++) {
				arr[row][j][roomNum] = str.substring(j, j + 1);
			}
			row++;

		}
		System.out.println(Arrays.deepToString(arr));

		sc.close(); // done with scanner
	}

	// try{
	public void createMapFromCoords() {
		sc.nextInt();
		sc.nextInt();
		sc.nextInt();
		System.out.println("coords");
		boolean canIncrementRoom = false;
		int row = 0;
		int roomNum = 0;
		int j = 0;
		// int[][] davedab = new int[5][4];
		while (sc.hasNextLine()) {
			String s = sc.next();
			row = sc.nextInt();
			j = sc.nextInt();

			if (row == 1) {
				canIncrementRoom = true;

			}
			if (canIncrementRoom && row == 0) {

				roomNum++;

				canIncrementRoom = false;

			}

			arr[row][j][roomNum] = s;

		}

		for (int w = 0; w < numRooms; w++) {
			for (int i = 0; i < height; i++) {
				for (int c = 0; c < width; c++) {

					if (arr[i][c][w] == null) {
						arr[i][c][w] = ".";
					}
				}
			}
		}
		System.out.println(Arrays.deepToString(arr));
		
	}

	// } catch()
	public void QueueMethod() {
		ArrayDeque<int[]> queue = new ArrayDeque<int[]>();
		ArrayDeque<int[]> dequeue = new ArrayDeque<int[]>();
		int[] kirbyLocation = findSymbol("K", 1);
		queue.add(kirbyLocation);

		int[] dequeued = queue.remove();
		dequeue.add(dequeued);
		queue.add(checkNorth(dequeued));
		queue.add(checkSouth(dequeued));
		queue.add(checkEast(dequeued));
		queue.add(checkWest(dequeued));

	}

	public int[] checkNorth(int[] arr) {
		arr[1] = arr[1] - 1;
		if (this.arr[arr[0]][arr[1]][0].equals("C")) {
			System.out.println("Cake has been found");
		}
		return arr;
	}

	public int[] checkSouth(int[] arr) {
		arr[1] = arr[1] + 1;
		return arr;
	}

	public int[] checkEast(int[] arr) {
		arr[0] = arr[0] + 1;
		return arr;
	}

	public int[] checkWest(int[] arr) {
		arr[0] = arr[0] - 1;
		return arr;
	}

	public int[] findSymbol(String s, int n) {
		int[] coords = new int[2];
		for (int i = 0; i < height; i++) {
			for (int c = 0; c < width; c++) {
				if (arr[i][c][n].equals(s)) {
					coords[0] = i;
					coords[1] = c;
					break;
				}
			}

		}
		return coords;

	}
}