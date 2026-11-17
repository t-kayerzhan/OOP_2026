package problem5;
import java.util.Vector;

public class DragonLaunch {
    
    private Vector<Person> people = new Vector<>();
    
    public void kidnap(Person p) {
        people.add(p);
    }
    
    public boolean willDragonEatOrNot() {
        
        int boys = 0;
        int girls = 0;
        
        for (int i = 0; i < people.size(); i++) {
            
            Person current = people.get(i);
            
            if (current.getGender() == Gender.BOY) {
                boys++;
            } else {
                if (boys > 0) {
                    boys--;
                } else {
                    girls++;
                }
            }
        }
        
        if (boys + girls > 0) {
            return true;
        } else {
            return false;
        }
    }
    
    public String line() {
        
        String result = "";
        
        for (int i = 0; i < people.size(); i++) {
            
            Person p = people.get(i);
            
            if (p.getGender() == Gender.BOY) {
                result = result + "B";
            } else {
                result = result + "G";
            }
        }
        
        return result;
    }
    
    public static DragonLaunch fromString(String s) {
        
        DragonLaunch dl = new DragonLaunch();
        
        for (int i = 0; i < s.length(); i++) {
            
            char c = s.charAt(i);
            
            if (c == 'B') {
                Person boy = new Person(Gender.BOY);
                dl.kidnap(boy);
            }
            
            if (c == 'G') {
                Person girl = new Person(Gender.GIRL);
                dl.kidnap(girl);
            }
        }
        
        return dl;
    }
    
    public static void main(String[] args) {
        
        //test 1
        DragonLaunch test1 = DragonLaunch.fromString("BBGG");
        System.out.println("start with: BBGG");
        
        boolean result1 = test1.willDragonEatOrNot();
        
        if (result1 == true) {
            System.out.println("dragon will eat");
        } else {
            System.out.println("no one left");
        }
        
        System.out.println("line now: " + test1.line());
        System.out.println();
        
        //test 2
        DragonLaunch test2 = DragonLaunch.fromString("GBGB");
        System.out.println("start with: GBGB");
        
        boolean result2 = test2.willDragonEatOrNot();
        
        if (result2 == true) {
            System.out.println("dragon will eat");
        } else {
            System.out.println("no one left");
        }
        
        System.out.println("line now: " + test2.line());
        System.out.println();
        
        //test 3
        DragonLaunch test3 = DragonLaunch.fromString("BG");
        System.out.println("start with: BG");
        
        System.out.println("first time: " + test3.willDragonEatOrNot());
        System.out.println("second time: " + test3.willDragonEatOrNot());
        System.out.println("line: " + test3.line());
    }
}