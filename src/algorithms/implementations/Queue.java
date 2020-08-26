package algorithms.implementations;

import java.util.LinkedList;
import java.util.NoSuchElementException;

public class Queue<T> {
	LinkedList<T> list = new LinkedList<T>();
	
	public Queue() {};
	
	public Queue(T item) {
		list.addLast(item);
	}
	
	public boolean add(T item) {
		list.addLast(item);
		return true;
	}
	
	public boolean contains(T item) {
		return list.contains(item);
	}
	
	public T element() {
		if(isEmpty()) throw new NoSuchElementException();
		return list.getFirst();
	}
	
	public void offer(T item) {
		list.addLast(item);
	}
	
	public T peek() {
		if(isEmpty()) {
			return null;
		} else {
			return list.getFirst();
		}
	}
	
	public T poll() {
		if(isEmpty()) {
			return null;
		} else {
			return list.removeFirst();
		}
	}
	
	public T remove() {
		if(isEmpty()) throw new NoSuchElementException();
		return list.removeFirst();
	}
	
	public int size() {
		return list.size();
	}
	
	private boolean isEmpty() {
		return list.size() == 0;
	}

}
