package _01_Encapsulate_the_Data;

public class EncapsulateTheData {

	// 1. Encapsulate all the members.

	// 2. Implement the setter restrictions described above each member variable.

	// 3. Pass all the JUnit tests.

	/* 
	 * All negative arguments should set itemsReceived to 0.
	 */

	private int itemsReceived;
public int getItemsReceived() {
	return itemsReceived;
}

public void setItemsReceived(int in) {
	if(in<0) {
		in=0;
	}
	itemsReceived = in;
}
	/*
	 * degreesTurned must be locked between 0.0 and 360.0 inclusive.
	 * 
	 * All parameters outside this range should set degreesTurned to the nearest
	 * bound.
	 */

	private double degreesTurned;
	public double getDegreesTurned() {
		return degreesTurned;
	}

	public void setDegreesTurned(double in) {
		if(in<0) {
			in=0;
		}
		if(in>360) {
			in=360;
		}
		degreesTurned = in;
	}
	/*
	 * nomenclature must not contain an empty String.
	 * 
	 * An empty String parameter should set nomenclature to a String with a single
	 * space.
	 */

	private String nomenclature;
	public String getNomenclature() {
		return nomenclature;
	}

	public void setNomenclature(String in) {
		if(in.isEmpty()) {
			in=" ";
		}
		nomenclature = in;
	}
	/*
	 * memberObj must not be a String.
	 * 
	 * A String parameter should set memberObj to a new Object();
	 * 
	 * Hint: Use the instanceof operator.
	 * 
	 * Example:
	 * 
	 * Robot rob = new Robot();
	 * 
	 * System.out.println(rob instanceof Robot); // prints true
	 * 
	 * System.out.println(rob instanceof Random); //prints false
	 */

	private Object memberObj;
	
	public Object getMemberObj() {
		return memberObj;
	}

	public void setMemberObj(Object in) {
		if(in instanceof String) {
		//can't use ! to flip the if statement
		}
		else {
			memberObj = in;
		}
		
	}
	
}
