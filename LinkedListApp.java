package com.company;

public class LinkedListApp {

    public static void main(String[] args) {
        MyLinkedList<String> myLinkedList = new MyLinkedList<>();
        myLinkedList.add("Hi!");
        myLinkedList.add("World!");
        myLinkedList.add("I'am Sasha", 1);
        myLinkedList.add("You are beautiful!");
        myLinkedList.add("I love you!");
        myLinkedList.set("Beautiful World!", 1);
        System.out.println(myLinkedList.get(2));
        System.out.println(myLinkedList.isEmpty());
        System.out.println(myLinkedList.remove("Hi!"));
        System.out.println(myLinkedList.remove(0));
    }
}
