package com.daryll.tests;

public class QueueNode<T> {

    Node rear, front;
    int size;

    public QueueNode() {
        rear = front = null;
        size = 0;
    }

    public void add(T info) {
        Node node = new Node(info);

        if (size < 1) {
            rear = front = node;
        } else {
            rear.link = node;
            rear = node;
        }

        ++size;
    }

    public void remove() {
        if (size > 0) {
            front = front.link;
            --size;
        }
    }

    public void peek() {
        Node current = front;

        while (current != null) {
            System.out.print(current.info+" ");
            current = current.link;
        }
    }

    class Node {
        Node link;
        T info;

        public Node(T info) {
            this.info = info;
            link = null;
        }
    }

    public static void main(String[] args) {
        QueueNode<String> queueNode = new QueueNode<>();

        queueNode.add("a");
        queueNode.add("b");
        queueNode.add("c");
        queueNode.add("d");
        queueNode.add("e");

        queueNode.peek();

        System.out.println();

        queueNode.remove();
        queueNode.remove();
        queueNode.remove();
        queueNode.remove();
        queueNode.remove();
        queueNode.peek();

        System.out.println();

        queueNode.add("f");
        queueNode.add("g");
        queueNode.add("h");
        queueNode.add("i");
        queueNode.peek();
    }
}
