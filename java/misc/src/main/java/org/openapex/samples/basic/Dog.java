package org.openapex.samples.basic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Dog implements Comparable<Dog>{
    private String name;
    private String color;
    private int age;

    public Dog(String name, String color, int age){
        this.name = name;
        this.color = color;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", color='" + color + '\'' +
                ", age=" + age +
                '}';
    }

    public static void main(String[] args) {
        List<Dog> dogs = new ArrayList<>();
        dogs.add(new Dog("Kalu", "Black", 8));
        dogs.add(new Dog("Bhulu", "Yellow", 6));
        dogs.add(new Dog("Tommy", "Yellow-White", 10));
        // This is printing all the dogs the way In have added to the list. Let's say I have to sort the dogs by their age in descending (big to small) order
        Collections.sort(dogs);
        System.out.println(dogs);
    }
    // Herte we are overriding the abstract method
    @Override
    public int compareTo(Dog o) {
        //return o.age - this.age;
        return this.age - o.age;
    }
}
