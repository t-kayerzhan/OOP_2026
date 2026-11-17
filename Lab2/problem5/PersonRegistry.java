package problem5;

import java.util.*;

public class PersonRegistry {
    private List<Person> people;  
    
    public PersonRegistry() {
        people = new ArrayList<>();
    }
    

    public void addPerson(Person person) {
        if (!people.contains(person)) {
            people.add(person);
            System.out.println("Added: " + person.getName());
        } else {
            System.out.println("we already have such person");
        }
    }
    

    public void removePerson(Person person) {
        if (people.remove(person)) {
            System.out.println("Deleted: " + person.getName());
        } else {
            System.out.println("person not found");
        }
    }
    
   
    public List<Person> findPeopleWithPets() {
        List<Person> result = new ArrayList<>();
        for (Person p : people) {
            if (p.hasPet()) {
                result.add(p);
            }
        }
        return result;
    }
    
   
    public List<Person> findPeopleWithoutPets() {
        List<Person> result = new ArrayList<>();
        for (Person p : people) {
            if (!p.hasPet()) {
                result.add(p);
            }
        }
        return result;
    }
    

    public Person findByName(String name) {
        for (Person p : people) {
            if (p.getName().equals(name)) {
                return p;
            }
        }
        return null;
    }
    
 
    public List<PhDStudent> getPhDStudents() {
        List<PhDStudent> result = new ArrayList<>();
        for (Person p : people) {
            if (p instanceof PhDStudent) {
                result.add((PhDStudent) p);
            }
        }
        return result;
    }
    
    @Override
    public String toString() {
        if (people.isEmpty()) {
            return "Register empty";
        }
        
        String result = "\n=== REGISTER OF PERSON ===\n";
        for (int i = 0; i < people.size(); i++) {
            result = result + (i+1) + ". " + people.get(i) + "\n";
        }
        result = result + "====================\n";
        return result;
    }
}