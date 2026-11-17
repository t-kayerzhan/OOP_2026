package problem4;
import java.util.Scanner;

import pr2.Student;

public class GradeBookTest {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		
		Course course = new Course("Object - oriented and design", "Introduction to Object-Oriented Programming using Java", 5, "Java bsics");
		GradeBook s = new GradeBook(course);
		s.displayMessage();
	
		System.out.print("Enter number of students: ");
		int n = scanner.nextInt();

		System.out.println("Plz, input grades for students: ");
		for(int i=0; i<n; i++) {
			
			System.out.print("Id: ");
			int id=scanner.nextInt(); 
			scanner.nextLine();
			
			System.out.print("Name: ");
			String st = scanner.nextLine();
			
			System.out.print("Student " + st + " points " + ": ");
			
			double g = scanner.nextDouble();
			scanner.nextLine();
			Student newStudent = new Student(st, id);  
			s.addStudent(newStudent, g);                
			
			}
		s.displayReport();
		}
	

}
