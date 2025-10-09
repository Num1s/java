class Animal {
    public String name;
    protected int age;
    private String sound;

    public Animal(String name, int age, String sound) {
        this.name = name;
        this.age = age;
        this.sound = sound;
    }

    public String getSound() {
        return sound;
    }

    public void setSound(String sound) {
        this.sound = sound;
    }

    public void makeSound() {
        System.out.println(name + " издает звук: " + sound);
    }
}

class Dog extends Animal {
    public Dog(String name, int age) {
        super(name, age, "Гав-гав");
    }

    @Override
    public void makeSound() {
        System.out.println(name + " лает: " + getSound());
    }
}

class Cat extends Animal {
    public Cat(String name, int age) {
        super(name, age, "Мяу");
    }

    @Override
    public void makeSound() {
        System.out.println(name + " мяукает: " + getSound());
    }
}

public class Activity {
    public static void main(String[] args) {
        Animal dog = new Dog("Барсик", 3);
        Animal cat = new Cat("Мурка", 2);

        dog.makeSound();
        cat.makeSound();
    }
}
