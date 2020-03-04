public class Spot {
	int row;
	int col;
	char letter;
	boolean visited;
	public Spot(char l, int r,int c){
		visited = false;
		letter = l;
		row = r;
		col = c;
	}
	public int getRow() {
		return row;
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
