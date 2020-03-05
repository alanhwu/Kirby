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
				while (sc.hasNextLine()) { // check a line exists in the input file
					c = 0;
					String i = sc.next();
					while (c < cols) {
						i.charAt(c); // NOTE format of input file is expected
						map[r][c][l] = new Spot(i.charAt(c), r, c);
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
				 Deque<Spot> dequeue = new ArrayDeque<Spot>(); 
				 
				 for (int k = 0; k < levels; k++) { //GO THROUGH THE ARRAY AND ENQUEUE THE OBJECT WITH K TO GET STARTED
					for (int i = 0; i < rows; i++) {
						for (int j = 0; j < cols; j++) {
							if(map[i][j][k].getLetter() == 'K'){
								queue.add(map[i][j][k]);
								map[i][j][j].setVisited(true);
							}
						}
					}
				}
				 
				 for (int k = 0; k < levels; k++) {
						for (int i = 0; i < rows; i++) {
							for (int j = 0; j < cols; j++) {
								dequeue.add(queue.remove());
								
								if((dequeue.peek().getRow()-1 >=0) && (map[i-1][j][j].isVisited() == false) && (map[i-1][j][j].getLetter() != '@')){
									queue.add(map[i-1][j][j]); //N O RT H
									map[i-1][j][j].setVisited(true);
								}
								
								if((dequeue.peek().getRow()+1 >=rows) && (map[i+1][j][j].isVisited() == false) && (map[i+1][j][j].getLetter() != '@')){
									queue.add(map[i+1][j][j]); // SO UT H 
									map[i-1][j][j].setVisited(true);
								}
								
								if((dequeue.peek().getCol()-1 >=0) && (map[i][j-1][j].isVisited() == false) && (map[i][j-1][j].getLetter() != '@')){
									queue.add(map[i][j-1][j]); 
									map[i][j-1][j].setVisited(true);
								}
								
								if((dequeue.peek().getRow()+1 <=cols) && (map[i][j+1][j].isVisited() == false) && (map[i][j+1][j].getLetter() != '@')){
									queue.add(map[i][j+1][j]);
									map[i][j+1][j].setVisited(true);
								}
								
								
								
								
								}
							}
						}
					
				 

			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		}
	}


