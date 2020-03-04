import java.io.File;

import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class KirbyDiugh {
	public static void main(String[] args) {
		// keep input file in the parent folder for the project
		// not in the src folder
		String i;
		File file = new File("map1"); // point to file

		try {

			Scanner sc = new Scanner(file); // setup scanner
			
			String a = sc.next();
			String b = sc.next();
			String c = sc.next();
			
			int x = Integer.parseInt(a);
			System.out.print(x);
			
			int y = Integer.parseInt(b);
			System.out.print(" "+y);
			
			int r = Integer.parseInt(c);
			System.out.println(" "+r);
			
			String[][][] arr = new String[x][y][r];
			for (int k = 0; k < r; k++) {
//				int cntr = 0;
				// check a line exists in the input file
				while (sc.hasNextLine()) {
					// NOTE format of input file is expected
					for (int cntr = 0; cntr < x; cntr++) {
//						i = sc.next();
						String val = sc.next();
						for (int d = 0; d < y; d++) {
//							System.out.println(i);
							String temp = val.substring(d, d+1);
							arr[cntr][d][k] = temp;
						}
					}
					// call nextInt()
				}
			}
			sc.close(); // done with scanner
//			for (int ew = 0; ew < arr[0][0].length; ew++) {
//				for (int qw = 0; qw < arr.length; qw++) {
//					for (int wq = 0; wq < arr[0].length; wq++) {
//						System.out.println(arr[qw][wq][ew]);
//					}
//				}
//			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}
}