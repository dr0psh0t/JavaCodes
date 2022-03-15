package com.daryll.datastructures.singly;

public class SinglyLinkedList
{
	int count;
	Node head, tail;
	
	public SinglyLinkedList()
	{
		count = 0;
		head = null; 
		tail = null;
	}
	
	public boolean isEmpty(){
		return count == 0;
	}
	
	public void insertToHead(int val)
	{
		Node newNode = new Node(val);
		if(isEmpty())
		{
			head = newNode;
			tail = newNode;
		}
		else
		{
			newNode.link = head;
			head = newNode;
		}
		++count;
	}
	
	public void insertToTail(int val)
	{
		Node newNode = new Node(val);
		if(isEmpty())
		{
			head = null;
			tail = null;
		}
		else
		{
			tail.link = newNode;
			tail = newNode;
		}
		++count;
	}
	
	public void print()
	{
		Node current = head;
		//System.out.println("Head: "+current.info+" Tail: "+tail.info);
		
		while(current != null)
		{
			System.out.print(current.info+" ");
			current = current.link;
		}
		System.out.println();
	}
}