import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class KirbyRunner {
	public static void main(String[] args) {
		// keep input file in the parent folder for the project
		// not in the src folder
		String i;
		File file = new File("map1"); // point to file

		try {

			Scanner sc = new Scanner(file); // setup scanner
			String j = sc.next();
			int row = Integer.parseInt(j);
			System.out.println(row);
			String l = sc.next();
			int col = Integer.parseInt(l);
			System.out.println(col);
			String k = sc.next();
			int width = Integer.parseInt(k);
			System.out.println(width);
			String[][][] arr = new String[row][col][width];
			for (int y = 0; y < width; y++) {
				int counter = 0;
				// check a line exists in the input file
				while (sc.hasNextLine()) {
					// NOTE format of input file is expected
					for (int cat = 0; counter < row; counter++) {
						i = sc.next();
						for (int dog = 0; dog < col; dog++) {
							System.out.println(i);
							arr[counter][dog][y] = i.substring(dog, dog + 1);
						}
					}
					// call nextInt()
				}
			}
			sc.close(); // done with scanner
			for (int ew = 0; ew < arr[0][0].length; ew++) {
				for (int qw = 0; qw < arr.length; qw++) {
					for (int wq = 0; wq < arr[0].length; wq++) {
						System.out.println(arr[qw][wq][ew]);
					}
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}
}