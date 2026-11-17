package problem5;


public class Employee extends Person {
    private String occupation;
    
    public Employee(String name, int age, String occupation) {
        super(name, age);  
        this.occupation = occupation;
    }
    
    @Override  
    public String getOccupation() {
        return occupation;
    }
    
    @Override
    public String toString() {
        
        return super.toString();
    }
}