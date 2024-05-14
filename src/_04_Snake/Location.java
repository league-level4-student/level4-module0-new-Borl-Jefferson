package _04_Snake;

public class Location{
	private int x;
	private int y;

	public Location(int x, int y){
		this.x=x;
		this.y=y;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}
public void setX(int nx) {
	x=nx;
}
public void setY(int ny) {
	y=ny;
}
	public boolean equals(int cx, int cy) {
		if (cx == x && cy == y) {
			return true;
		} else {
			return false;
		}
	}
}
