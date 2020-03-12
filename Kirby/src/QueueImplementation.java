import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;
import java.util.ArrayDeque;

public class QueueImplementation {
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
			Spot Cake = new Spot();
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

			ArrayDeque<Spot> queue = new ArrayDeque<Spot>();
			ArrayDeque<Spot> dequeue = new ArrayDeque<Spot>();

			for (int k = 0; k < levels; k++) { // GO THROUGH THE ARRAY AND
												// ENQUEUE THE OBJECT WITH K TO
												// GET STARTED
				for (int i = 0; i < rows; i++) {
					for (int j = 0; j < cols; j++) {
						if (map[i][j][k].getLetter() == 'K') {
							queue.push(map[i][j][k]);
							map[i][j][j].setVisited(true);
						}
					}
				}
			}
			
			
	
			for (int k = 0; k < levels; k++) {
				for (int i = 0; i < rows; i++) {
					for (int j = 0; j < cols; j++) {
						if(queue.size()>0){queue.peek().setVisited(true); //prepare to actually visit the first thing in the queue
						dequeue.push(queue.pop()); //move from queue to dequeue
						int x = dequeue.peek().getRow(); //check its attributes
						int y = dequeue.peek().getCol();
						int z = dequeue.peek().getFloor();
						if ((x - 1 >= 0) //CHECK NORTH
								&& (map[x - 1][y][z].isChecked() == false)
								&& (map[x - 1][y][z].getLetter() != '@')) {
							queue.push(map[x - 1][y][z]); // N O RT H
							map[x - 1][y][z].setChecked(true);
							if (map[x - 1][y][z].getLetter() == 'c') {
								Cake = new Spot('c', x - 1, y, z);
								break;
							}
						}

						if ((x + 1 < rows) //CHECK SOUTH
								&& (map[x + 1][y][z].isChecked() == false)
								&& (map[x + 1][y][z].getLetter() != '@')) {
							queue.push(map[x + 1][y][z]); // SO UT H
							map[x + 1][y][z].setChecked(true);
							if (map[x + 1][y][z].getLetter() == 'c') {
								Cake = new Spot('c', x + 1, y, z);
								break;
							}
						}

						if ((y + 1 < cols) //CHECK EAST
								&& (map[x][y + 1][z].isChecked() == false)
								&& (map[x][y + 1][z].getLetter() != '@')) {
							queue.push(map[x][y + 1][z]);
							map[x][y + 1][z].setChecked(true);
							if (map[x][y + 1][z].getLetter() == 'c') {
								Cake = new Spot('c', x, y + 1, z);
								break;
							}
						}
						
						if ((y - 1 >= 0) //CHECK WEST
								&& (map[x][y - 1][z].isChecked() == false)
								&& (map[x][y - 1][z].getLetter() != '@')) {
							queue.push(map[x][y - 1][z]);
							map[x][y - 1][z].setChecked(true);
							if (map[x][y - 1][z].getLetter() == 'c') {
								Cake = new Spot('c', x, y - 1, z);
								break;
							}
						}
						}
							//checker(queue);
							//checker(dequeue);	
					}
				}
			
			}
			
			System.out.println(Cake.getRow());
			System.out.println(Cake.getCol());
			System.out.println(Cake.getFloor());

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static void checker(Deque<Spot> queue){
		for(int i=0; i< queue.size(); i++){
			System.out.println(queue.peek());
			queue.pop();
		}
	}

}
