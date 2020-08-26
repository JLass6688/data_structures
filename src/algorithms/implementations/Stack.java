package algorithms.implementations;

import java.util.EmptyStackException;
import java.util.LinkedList;

public class Stack<T> {
	LinkedList<T> list = new LinkedList<T>();
	
	public Stack(){}
	
	public Stack(T item) {
		push(item);
	}
	
	public boolean empty() {
		return (size() == 0);
	}
	
	public T peek() {
		if(empty()) throw new EmptyStackException();

		return list.getLast();
	}
	
	public T pop() {
		if(empty()) throw new EmptyStackException();
		
		return list.removeLast();
	}
	
	public void push(T item) {
		list.addLast(item);
	}
	
	public int search(T item) {
		if(empty()) throw new EmptyStackException();
		
		// Stack returns 1-based index, list returns 0-based index
		return (list.indexOf(item) + 1);
	}
	
	public int size() {
		return list.size();
	}
}
