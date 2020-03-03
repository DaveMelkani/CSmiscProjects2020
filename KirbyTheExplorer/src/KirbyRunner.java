import java.io.File;

import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class KirbyRunner {
	public static void main(String[] args) {
		// keep input file in the parent folder for the project
		// not in the src folder
		String i;
		File file = new File("map2"); // point to file

		try {

			Scanner sc = new Scanner(file); // setup scanner
			String j = sc.next();
			int x = Integer.parseInt(j);
			System.out.print(x);
			String l = sc.next();
			int y = Integer.parseInt(l);
			System.out.print(" "+y);
			String k = sc.next();
			int z = Integer.parseInt(k);
			System.out.println(" "+z);
			String[][][] arr = new String[x][y][z];
			for (int r = 0; r < z; r++) {
				int cntr = 0;
				// check a line exists in the input file
				while (sc.hasNextLine()) {
					// NOTE format of input file is expected
					for (int c = 0; cntr < x; cntr++) {
						i = sc.next();
						for (int d = 0; d < y; d++) {
							System.out.println(i);
							arr[cntr][d][r] = i.substring(d, d + 1);
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