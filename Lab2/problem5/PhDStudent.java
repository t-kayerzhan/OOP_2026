package problem5;

public class PhDStudent extends Student {
    private String researchTopic; 
    
    public PhDStudent(String name, int age, String major, String researchTopic) {
        super(name, age, major);
        this.researchTopic = researchTopic;
    }
    
    @Override
    public String getOccupation() {
        return "aspirant";
    }
    
    public String getResearchTopic() { return researchTopic; }
    
   
    @Override
    public boolean canHavePet(Animal animal) {
        return !(animal instanceof Dog);  
    }
    
    @Override
    public String toString() {
        return super.toString() + ", topic of reserach: " + researchTopic;
    }
}