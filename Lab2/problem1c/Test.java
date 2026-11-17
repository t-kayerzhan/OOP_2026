package problem1c;

import java.util.HashSet;

public class Test {
    public static void main(String[] args) {
        HashSet<Person> set = new HashSet<>();

        Person p1 = new Person("Alice", 30);
        Person p2 = new Person("Alice", 30); 
        Person p3 = new Person("Bob", 25);
        Employee e1 = new Employee("Alice", 30, "E123");
        Employee e2 = new Employee("Alice", 30, "E123"); 
        Employee e3 = new Employee("Alice", 30, "E456"); 

        set.add(p1);
        set.add(p2);  
        set.add(p3);
        set.add(e1);
        set.add(e2);  
        set.add(e3);

        System.out.println("Set size: " + set.size()); 
        for (Person person : set) {
            System.out.println(person);
        }
    }
}