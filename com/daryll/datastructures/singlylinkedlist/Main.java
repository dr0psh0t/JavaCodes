package com.daryll.datastructures.singlylinkedlist;

public class Main {

    public static void main(String[] args) {

        SinglyLinkedList single = new SinglyLinkedList();

        single.addToTail(3);
        single.addToTail(4);
        single.addToTail(5);
        single.addToTail(6);

        single.addToHead(2);
        single.addToHead(1);
        single.addToHead(0);

        single.insertAfter(6, 7);
        single.insertBefore(3, -99);
        single.insertBefore(1, -88);
        single.insertBefore(7, -77);
        single.insertAfter(-77, 65);

        single.insertNode(8);

        //single.addToTail(8);

        single.printNodes();
        single.checkHeadTail();

        single.deleteNode(0);
        single.printNodes();
    }
}
