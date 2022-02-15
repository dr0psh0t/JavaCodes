package com.daryll.ds.queue;

public class QueueList
{
	Node head, tail;
	int count;
	
	public QueueList()
	{
		head = null;
		tail = null;
		count = 0;
	}
	
	public boolean isEmpty(){
		return count == 0;
	}
	
	public void enqueue(int val)
	{
		Node newNode = new Node(val);
		if(isEmpty())
		{
			head = newNode;
			tail = newNode;
		}
		else
		{
			tail.link = newNode;
			tail = newNode;
		}
		++count;
	}
	
	public void dequeue()
	{
		if(isEmpty())
			System.out.println("Queue is already empty");
		else
		{
			head = head.link;
			--count;
		}
	}
	
	public void print()
	{
		Node current = head;
		while(current != null)
		{
			System.out.println(current.info+" ");
			current = current.link;
		}
		System.out.println();
	}
}