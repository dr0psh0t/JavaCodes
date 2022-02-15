package com.daryll.ds.queue;

public class QueueTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		QueueList ref = new QueueList();
		
		ref.enqueue(1);
		ref.enqueue(2);
		ref.enqueue(3);
		ref.enqueue(4);
		
		ref.print();
		
		ref.dequeue();
		
		ref.print();
		
		ref.enqueue(5);
		
		ref.print();
	}

}
