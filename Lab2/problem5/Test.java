package problem5;

public class Test {
    public static void main(String[] args) {
        Person john = new Employee("John", 30, "Engineer");
        Person alice = new PhDStudent("Alice", 26, "Computer Science", "AI");
        Person bob = new Student("Bob", 22, "Biology");
        
        Animal murka = new Cat("Murka", 5);
        Animal rex = new Dog("Rex", 3);
        Animal kesha = new Bird("Kesha", 2);
        Animal goldie = new Fish("Goldie", 1);
        
        PersonRegistry registry = new PersonRegistry();
        registry.addPerson(john);
        registry.addPerson(alice);
        registry.addPerson(bob);
        
        System.out.println("\n--- Assigning pets ---");
        john.assignPet(rex);
        alice.assignPet(murka);
        bob.assignPet(kesha);
        
        System.out.println("\n--- PhD student tries to take a dog ---");
        alice.assignPet(rex);
        
        System.out.println("\n--- Registry state ---");
        System.out.println(registry);
        
        System.out.println("\n--- John goes on vacation ---");
        john.leavePetWith(alice);
        
        System.out.println("\n--- Registry after transfer ---");
        System.out.println(registry);
        
        System.out.println("\n--- John returns ---");
        john.retrievePetFrom(alice);
        
        System.out.println("\n--- Final registry state ---");
        System.out.println(registry);
        
        System.out.println("\n--- People with pets ---");
        for (Person p : registry.findPeopleWithPets()) {
            System.out.println("  " + p.getName());
        }
        
        System.out.println("\n--- PhD students ---");
        for (PhDStudent phd : registry.getPhDStudents()) {
            System.out.println("  " + phd.getName() + " studies: " + phd.getResearchTopic());
        }
    }
}