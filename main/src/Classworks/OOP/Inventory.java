package Classworks.OOP;

import java.util.ArrayList;

class Item {
    String name;
    int weight;
}

class Weapon extends Item {
    int damage;
    double durability = 50.0;

    public Weapon(String name, int damage, double durability, int weight) {
        this.name = name;
        this.damage = damage;
        this.durability = durability;
        this.weight = weight;
    }

    public void useItem() {
        durability -= 10;
        System.out.println("You use Weapon with damage: " + damage + " Your durability: " + durability);
    }
}

class Potion extends Item {
    int healAmount;

    public Potion(String name, int weight, int healAmount) {
        this.name = name;
        this.weight = weight;
        this.healAmount = healAmount;
    }

    public void useItem() {
        System.out.println("You use Heal Potion: " + healAmount);
    }
}

class Inventory {
    ArrayList<Item> items = new ArrayList<Item>();

    public void addItem(Item item) {
        items.add(item);
    }
    public void removeItem(Item item) {
        items.remove(item);
    }

    public static void main(String[] args) {
        Inventory inventory = new Inventory();
        Weapon knife = new Weapon("Knife", 50, 100.0, 1);
        inventory.addItem(knife);
        System.out.println("Name: " + inventory.items.getFirst().name);
        System.out.println("Weight: " + inventory.items.getFirst().weight);
    }

}

