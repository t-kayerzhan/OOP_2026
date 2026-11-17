package problem5;

import java.util.Objects;

public abstract class Person {
    private String name;
    private int age;
    private Animal pet;
    
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
        this.pet = null;
    }
    
    public String getName() {
        return name;
    }
    
    public int getAge() {
        return age;
    }
    
    public Animal getPet() {
        return pet;
    }
    
    public boolean hasPet() {
        return pet != null;
    }
    
    public void assignPet(Animal animal) {
        if (canHavePet(animal)) {
            this.pet = animal;
            System.out.println(name + " now owns " + animal.getName());
        } else {
            System.out.println(name + " cannot have this pet: " + 
                              animal.getClass().getSimpleName());
        }
    }
    
    public Animal removePet() {
        Animal oldPet = this.pet;
        this.pet = null;
        if (oldPet != null) {
            System.out.println(name + " no longer owns " + oldPet.getName());
        }
        return oldPet;
    }
    
    public abstract String getOccupation();
    
    public boolean canHavePet(Animal animal) {
        return true;
    }
    
    public void leavePetWith(Person caretaker) {
        if (!hasPet()) {
            System.out.println(name + " cannot leave a pet - they don't have them");
            return;
        }
        
        if (this == caretaker) {
            System.out.println("Cannot leave pet");
            return;
        }
        
        if (!caretaker.canHavePet(this.pet)) {
            System.out.println(caretaker.name + " cannot take " + 
                              pet.getClass().getSimpleName() + " " + pet.getName());
            return;
        }
        
        Animal petToTransfer = this.removePet();
        caretaker.assignPet(petToTransfer);
        
        System.out.println(name + " left " + petToTransfer.getName() + 
                          " with " + caretaker.name + " during vacation");
    }
    
    public void retrievePetFrom(Person caretaker) {
        if (!caretaker.hasPet()) {
            System.out.println(caretaker.name + " doesn't have a pet!");
            return;
        }
        
        Animal petToReturn = caretaker.removePet();
        this.assignPet(petToReturn);
        
        System.out.println(name + " took " + petToReturn.getName() + 
                          " back after vacation");
    }
    
    @Override
    public String toString() {
        String petInfo = (pet == null) ? "no pet" : "pet: " + pet;
        return getOccupation() + " " + name + " (" + age + " years), " + petInfo;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age && Objects.equals(name, person.name);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

	protected abstract Gender getGender();
}