package problem4;

public class Course {
	private String name; 
	private String description;
	private int numberOfcredits;
	private String prereq;
	
	
	public Course(String name, String description, int numberOfcredits, String prereq) {
		this.name = name;
		this.description = description;
		this.numberOfcredits = numberOfcredits;
		this.prereq = prereq;
		}
	
	public String getName() {
		return this.name;
	}
	
	public String getDesc() {
		return this.description;
	}
	
	public String getPrereq() {
		return this.prereq;
	}
	public int getCred() {
		return this.numberOfcredits;
		
	}
	
	public String toString() {
		return name + " - " + description + " (" + numberOfcredits + ")";
	    	
	}
	
}
