package com.daryll.ds.stack;

public class TestStack {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		StackList ref = new StackList();
		
		ref.push(1);
		ref.push(2);
		ref.push(3);
		ref.push(4);
		
		ref.print();
		
		ref.pop();
		
		ref.print();
		
		System.out.println("Top: "+ref.top());
	}

}
