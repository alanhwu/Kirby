public class Spot {
	int row;
	int col;
	int floor;
	char letter;
	boolean visited;
	public Spot(){
		
	}
	public Spot(char l, int r,int c, int f){
		visited = false;
		letter = l;
		row = r;
		col = c;
		floor = f;
	}
	public int getRow() {
		return row;
	}
	public int getFloor() {
		return floor;
	}
	public int getCol() {
		return col;
	}
	public char getLetter() {
		return letter;
	}
	public boolean isVisited() {
		return visited;
	}
	public void setVisited(boolean visited) {
		this.visited = visited;
	}
}
