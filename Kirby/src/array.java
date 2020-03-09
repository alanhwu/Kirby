import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;
import java.util.ArrayDeque;
public class array {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File file = new File("tester"); // point to file

		try {

			Scanner sc = new Scanner(file); // setup scanner

			int rows = sc.nextInt();
			int cols = sc.nextInt();
			int levels = sc.nextInt();
			Spot map[][][] = new Spot[rows][cols][levels];
			// System.out.println(rows + " " + cols + " " + levels);
			int r = 0;
			int c = 0;
			int l = 0;
			char dot = '.';
			while (sc.hasNextLine()) { // check a line exists in the input file
				c = 0;
				String i = sc.next();
				while (c < cols) {
					i.charAt(c); // NOTE format of input file is expected
					map[r][c][l] = new Spot(i.charAt(c), r, c, l);
					c++;
				}
				r++;
				if (r % rows == 0 && r > 0) {
					l++;
					r = 0;
				}
			}
			sc.close(); // done with scanner
			
			
			 Deque<Spot> queue = new ArrayDeque<Spot>(); 
			  
			 for (int k = 0; k < levels; k++) {
				for (int i = 0; i < rows; i++) {
					for (int j = 0; j < cols; j++) {
						System.out.print(map[i][j][k].getLetter());
						if (j == cols - 1) {
							System.out.println();
						}
					}
				}
			}
			// System.out.println(Arrays.deepToString(map));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}
