package problem4;
import pr2.Student;
import java.util.ArrayList;

public class GradeBook {
	private Course course;
	private ArrayList<Student> students;
	private ArrayList<Double> grades;
	
	
	public void addStudent(Student s, double grade) {
		if (s == null) {
			System.out.println("Error");
			return;
		}
		if (grade < 0 || grade > 100) {
			System.out.println("Error");
			return;
		}
	    students.add(s);
	    grades.add(grade);
	}
	
	public GradeBook(Course course) {
		if (course == null) {
			System.out.println("Error");
			return;
		}
	    this.course = course;
	    students = new ArrayList<>();
	    grades = new ArrayList<>();
	}
	
	public Course getCourse() {
		return course;
	}
	
	public int getStudentCount() {
		return students.size();
	}
	
	public Student getStudent(int index) {
		if (index >= 0 && index < students.size()) {
			return students.get(index);
		}
		return null;
	}
	
	public Double getGrade(int index) {
		if (index >= 0 && index < grades.size()) {
			return grades.get(index);
		}
		return null;
	}

	public ArrayList<Student> getAllStudents() {
		return new ArrayList<>(students);
	}
	
	public ArrayList<Double> getAllGrades() {
		return new ArrayList<>(grades);
	}
	
	public void displayMessage() {
		
		System.out.println("Welcome to the grade book for " + course.getName() + "!");
	}
	
	public double displayAvgClass() {
		if (grades.isEmpty()) return 0;
		double count =0;
		for(int i=0; i<grades.size();i++) {
			count+=grades.get(i);
		}
		
		return count / grades.size();
	}
	
	
	
	public void maxGrade() {
		if (grades.isEmpty()) {
			System.out.println("No grades available");
			return;
		}
		double m = -100000;
		int id=0;
		for(int i=0; i<grades.size();++i) {
			if(m<grades.get(i)) {
				m=grades.get(i);
				id = i;
			}
		}
		
		System.out.print("Highest grade is " + m +"( Student " + students.get(id).getName()+"," + "id: "+ students.get(id).getId()+").");
		
	}
	public void minGrade() {
		if (grades.isEmpty()) {
			System.out.println("No grades available");
			return;
		}
		double m = 100000;
		int id =0;
		for(int i=0; i<grades.size();++i) {
			if(m>grades.get(i)) {
				m=grades.get(i);
				id = i;
			}
			
		}
		System.out.print("Lowest grade is "+ m +" (Student " + students.get(id).getName()+", " + "id: "+ students.get(id).getId()+").");
		}
	
	private void stars(int count) {
	    for (int i = 0; i < count; i++) {
	        System.out.print("*");
	    }
	    System.out.println();
	}
	
	public void outputBarChart() {
	    int a = 0, b = 0, c = 0, d = 0, e = 0, f = 0, g = 0, h = 0, i = 0,  j= 0, k =0;
	    
 
	    for (int index = 0; index < grades.size(); index++) {
	        double currentGrade = grades.get(index);
	        
	        if (currentGrade >= 90 && currentGrade <= 99) a++;
	        else if (currentGrade >= 80 && currentGrade <= 89) b++;
	        else if (currentGrade >= 70 && currentGrade <= 79) c++;
	        else if (currentGrade >= 60 && currentGrade <= 69) d++;
	        else if (currentGrade >= 50 && currentGrade <= 59) e++;
	        else if (currentGrade >= 40 && currentGrade <= 49) f++;
	        else if (currentGrade >= 30 && currentGrade <= 39) g++;
	        else if (currentGrade >= 20 && currentGrade <= 29) h++;
	        else if (currentGrade >= 10 && currentGrade <= 19) i++;
	        else if (currentGrade >= 0 && currentGrade <= 9) j++;
	        else k++;
	    }

	    System.out.print("00-09: "); stars(j);
	    System.out.print("10-19: "); stars(i);
	    System.out.print("20-29: "); stars(h);
	    System.out.print("30-39: "); stars(g);
	    System.out.print("40-49: "); stars(f);
	    System.out.print("50-59: "); stars(e);
	    System.out.print("60-69: "); stars(d);
	    System.out.print("70-79: "); stars(c);
	    System.out.print("80-89: "); stars(b);
	    System.out.print("90-99: "); stars(a);
	    System.out.print("100: "); stars(k);
	}
	
	public void displayReport() {
		System.out.print("Class avarage is " +  displayAvgClass()+".");
		System.out.println();
	    minGrade();
	    System.out.println();
	    maxGrade();
	    
	    System.out.println();
	    System.out.println("Grades distribution: ");
	    outputBarChart();
	}
	
	
	public String toString() {
	    return "GradeBook for course: " + course.getName() +", students count: " + students.size();
	}
	

}