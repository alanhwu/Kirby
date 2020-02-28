import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Reading {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File file = new File("map5"); // point to file

		try {

			Scanner sc = new Scanner(file); // setup scanner

			int rows = sc.nextInt();
			int cols = sc.nextInt();
			int levels = sc.nextInt();
			System.out.println(rows + " " + cols + " " + levels);
			int r = 0;
			int c = 0;
			char dot = '.';
			while (sc.hasNextLine()) { // check a line exists in the input file
				c = 0;
				String i = sc.next();
				while (c < cols) {
					i.charAt(c); // NOTE format of input file is expected

					if ((i.charAt(c) != dot)) {
						System.out.println(i.charAt(c) + " " + r + " " + c);
					}// call nextInt()

					c++;
				}

				r++;
			}

			sc.close(); // done with scanner

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}
