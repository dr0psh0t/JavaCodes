package com.daryll.ds.doubly;

public class Node
{
	int info;
	Node next;
	Node back;
	
	public Node(int info)
	{
		this.info = info;
		next = back = null;
	}
}