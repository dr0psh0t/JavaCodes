package com.daryll.ds.stack;

public class StackList
{
	Node top;
	int count;
	
	public StackList()
	{
		top = null;
		count = 0;
	}
	
	public boolean isEmpty(){
		return count == 0;
	}
	
	public void push(int val)
	{
		Node newNode = new Node(val);
		if(isEmpty())
			top = newNode;
		else
		{
			newNode.link = top;
			top = newNode;
		}
		++count;
	}
	
	public void pop()
	{
		if(isEmpty())
			System.out.println("Stack is already empty");
		else
		{
			top = top.link;
			--count;
		}
	}
	
	public int top()
	{
		int info = top.info;
		return info;
	}
	
	public void print()
	{
		Node current = top;
		while(current != null)
		{
			System.out.println(current.info);
			current = current.link;
		}
		System.out.println();
	}
}