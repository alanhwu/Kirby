import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;


public class TakeInput {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File file = new File("map5"); // point to file

		try {

			Scanner sc = new Scanner(file); // setup scanner

			int rows = sc.nextInt();
			int cols = sc.nextInt();
			int levels = sc.nextInt();
			char[][][] map = new char[rows][cols][levels];
			int r = 0;
			int c = 0;
			int l = levels-1;
			char dot = '.';
			while (sc.hasNextLine()) { // check a line exists in the input file
				c = 0;
				String i = sc.next();
				while (c < cols) {
						map[r][c][l] = (i.charAt(c));
					c++;
				}
				if(r<rows-1){
				r++;}
				if(r%rows == 0 && r>0){
					l++;
				}
			}
 
			
			sc.close(); // done with scanner
			System.out.println(Arrays.deepToString(map));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}
