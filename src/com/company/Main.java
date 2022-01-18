package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        Random rnd = new Random();
        ArrayList<Animal> catArrayList = new ArrayList<>();
        ArrayList<Animal> dogArrayList = new ArrayList<>();
        Cat kitten = new Cat("Cat", 2, "Tyapa");
        Dog doggy = new Dog("Dog", 5, "Barboss");

        for (int i = 1; i < 51; i++) {
            if (i == 1) {
                catArrayList.add(kitten);
            } else {
                catArrayList.add(new Cat("Cat", kitten.age + rnd.nextInt((1 + 10) - 1) + 1, kitten.name + " " + i));
            }
        }

        for (int i = 1; i < 51; i++) {
            if (i == 1) {
                dogArrayList.add(doggy);
            } else {
                dogArrayList.add(new Dog("Dog", doggy.age + rnd.nextInt((1 + 10) - 1) + 1, doggy.name + " " + i));
            }
        }

        Cat[] cats = new Cat[catArrayList.size()];
        Dog[] dogs = new Dog[dogArrayList.size()];
        int countCats = 0;
        int countDogs = 0;
        int countMice = 1;
        for (int i = 0; i < catArrayList.size(); i++) {
            if (catArrayList.get(i) instanceof Cat && dogArrayList.get(i) instanceof Dog) {
                cats[countCats] = (Cat) catArrayList.get(i);
                countCats++;
                dogs[countDogs] = (Dog) dogArrayList.get(i);
                countDogs++;
            }
        }
        System.out.println(catArrayList);
        System.out.println(Arrays.toString(cats));

        System.out.println(dogArrayList);
        System.out.println(Arrays.toString(dogs));

        LinkedList<Animal> allAnimals = new LinkedList<>();
        allAnimals.addAll(catArrayList);
        allAnimals.addAll(dogArrayList);

        System.out.println(allAnimals);

        for (int i = 0; i < allAnimals.size(); i++) {
            if (i % 5 == 0 && i != 0 && allAnimals.get(i) instanceof Cat) {
                allAnimals.remove(i);
                System.out.println(i);
                System.out.println(allAnimals.size());

            }
            if (i != 0 && i % 3 == 0 && allAnimals.get(i) instanceof Dog) {
                allAnimals.add(i, new Mouse("Mouse",  + rnd.nextInt((1 + 10) - 1) + 1, "Mini " + (countMice)));
                countMice++;
            }
        }

        ArrayList<Animal> shortAnimals = new ArrayList<Animal>();

        System.out.println(allAnimals);
        int mouseAge = 0;
        int catAge = 0;
        int dogAge = 0;

        for (int i = 0; i < allAnimals.size(); i++) {
            if (allAnimals.get(i) instanceof Mouse) {
                mouseAge += ((Mouse) allAnimals.get(i)).age;
            }
            if (allAnimals.get(i) instanceof Dog) {
                dogAge += ((Dog) allAnimals.get(i)).age;
            }
            if (allAnimals.get(i) instanceof Cat) {
                catAge += ((Cat) allAnimals.get(i)).age;
            }
        }

        LinkedList<Animal> dogsCatsMice = new LinkedList<>();

        for (int i = 0; i < allAnimals.size(); i++) {
            if (allAnimals.get(i) instanceof Cat) {
                dogsCatsMice.addFirst(allAnimals.get(i));
            }
            if (allAnimals.get(i) instanceof Dog) {
                dogsCatsMice.addLast(allAnimals.get(i));
            }
        }

        for (int i = 0; i < allAnimals.size(); i++) {
            if (allAnimals.get(i) instanceof Mouse) {
                dogsCatsMice.addLast(allAnimals.get(i));
            }
        }


        System.out.println("\nCats' ages sum up: " + catAge + "\nDogs' ages sum up: " + dogAge + "\nMouse' ages sum up: " + mouseAge);
        System.out.println(dogsCatsMice);
    }
}