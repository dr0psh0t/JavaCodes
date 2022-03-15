package com.daryll.datastructures.doubly;

public class TestDoubly {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		DoublyLinkedList ref = new DoublyLinkedList();

		ref.insertToFirst(1);
		ref.insertToFirst(2);
		ref.insertToFirst(3);
		ref.insertToFirst(4);
		
		ref.printForward();
		
		ref.insertToLast(0);
		ref.printForward();
		
		ref.insertToFirst(5);
		ref.printForward();
		ref.printReverse();
	}

}
