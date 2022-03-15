package com.daryll.datastructures.singlylinkedlist;

public class SinglyLinkedList {

    class Node {

        int info;
        Node nextLink;
        Node prevLink;

        public Node(int inf) {
            info = inf;
            nextLink = null;
            prevLink = null;
        }
    }

    Node head;
    Node tail;
    int size;

    public SinglyLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    public void insertNode(int data) {

        if (size == 0) {
            head = new Node(data);
            tail = head;

        } else {
            Node newNode = new Node(data);
            tail.nextLink = newNode;
            tail = newNode;
        }

        size++;
    }

    /*
    throw new node if no preceding node found to insert after
     */
    public void insertAfter(int data, int newData) {
        if (size == 0) {
            insertNode(newData);
        } else {
            Node temp = head;

            while (temp != null) {

                if (temp.info == data) {

                    //  if temp is the tail
                    if (temp.nextLink == null) {
                        addToTail(newData);

                    } else {

                        Node newNode = new Node(newData);
                        newNode.nextLink = temp.nextLink;
                        temp.nextLink = newNode;
                    }

                    size++;
                    break;
                }

                temp = temp.nextLink;
            }
        }
    }

    public void insertBefore(int data, int newData) {
        if (size == 0) {
            insertNode(newData);
        } else {
            Node temp = head;

            //  check head if its the "data"
            if (temp.info == data) {
                addToHead(newData);
            } else {

                while (temp != null) {

                    if (temp.nextLink.info == data) {

                        Node newNode = new Node(newData);

                        newNode.nextLink = temp.nextLink;
                        temp.nextLink = newNode;

                        size++;
                        break;
                    }

                    temp = temp.nextLink;
                }
            }
        }
    }

    public void addToTail(int data) {
        if (size == 0) {
            insertNode(data);
        } else {

            Node temp = tail;
            Node newTailNode = new Node(data);

            temp.nextLink = newTailNode;
            tail = newTailNode;

            size++;
        }
    }

    public void addToHead(int data) {
        if (size == 0) {
            insertNode(data);
        } else {

            Node temp = head;
            Node newHeadNode = new Node(data);

            newHeadNode.nextLink = temp;
            head = newHeadNode;

            size++;
        }
    }

    public void deleteNode(int data) {
        if (size > 0) {
            Node temp = head;

            if (temp.info == data) {
                temp = temp.nextLink;
                head = temp;
                temp = null;
                size--;
            }
        }
    }

    public void printNodes() {
        Node temp = head;

        while (temp != null) {
            System.out.print(temp.info + " ");
            temp = temp.nextLink;
        }

        System.out.println();
    }

    public void checkHeadTail() {
        System.out.println(head.info+" "+tail.info);
    }
}
