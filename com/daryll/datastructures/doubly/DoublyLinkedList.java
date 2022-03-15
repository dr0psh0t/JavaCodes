package com.daryll.datastructures.doubly;

public class DoublyLinkedList
{
	int count;
	Node first;
	Node last;

	public DoublyLinkedList()
	{
		count = 0;
		first = last = null;
	}
	
	public boolean isEmpty(){
		return (count == 0);
	}
	
	public void insertToFirst(int val)
	{
		Node newNode = new Node(val);
		
		if(isEmpty())
			first = last = newNode;
		else
		{
			newNode.next = first;
			first.back = newNode;
			first = newNode;
		}
		count++;
	}
	
	public void insertToLast(int val)
	{
		Node newNode = new Node(val);
		
		if(isEmpty())
			first = last = newNode;
		else
		{
			last.next = newNode;
			newNode.back = last;
			last = newNode;
		}
		count++;
	}
	
	public void printReverse()
	{
		Node current = last;
		System.out.print("First: "+first.info+" Last: "+last.info+"\n");
		
		while(current != null)
		{
			System.out.print(current.info+" ");
			current = current.back;
		}
		System.out.println();
	}
	
	public void printForward()
	{
		Node current = first;
		System.out.print("First: "+first.info+" Last: "+last.info+"\n");
		
		while(current != null)
		{
			System.out.print(current.info+" ");
			current = current.next;
		}
		System.out.println();
	}
}
