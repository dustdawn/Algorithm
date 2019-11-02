package com.dustdawn.test;
import java.util.LinkedList;

public class Stack{
	private LinkedList list;
	public Stack() {
		this.list = new LinkedList();
	}
	public void add(Object obj) {
		this.list.addFirst(obj);
	}
	public Object get() {
		return this.list.getFirst();
	}
	public Object delete() {
		return this.list.removeFirst();
	}
	public static void main(String[] args) {
		   Stack st = new Stack();
		   st.add("1");
		   st.add("2");
		   st.add("3");
		   st.add("4");
		   
		   System.out.println(st.get());
		   st.delete();
		   System.out.println(st.get());
	}
}
