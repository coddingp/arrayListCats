package com.company;

public class Mouse extends Animal{
    Integer age;
    String name;

    public Mouse(String kind, int age, String name) {
        super(kind);
        this.age = age;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Mouse{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}
