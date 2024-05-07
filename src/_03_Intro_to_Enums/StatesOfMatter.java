package _03_Intro_to_Enums;


public enum StatesOfMatter {
	SOLID(0), LIQUID(25.55), GAS(100);
	private double ct;
	StatesOfMatter(double i) {
		// TODO Auto-generated constructor stub
	}
public double getCT() {
	return ct;
}
public void setCT(double in) {
	ct=in;
}
	public double ctf(double in) {
		return ((in * 9/5) + 32);
	}
	
	
	
}
