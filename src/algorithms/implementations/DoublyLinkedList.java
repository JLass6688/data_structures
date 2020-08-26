package algorithms.implementations;

import java.util.Collection;
import java.util.Iterator;

public class DoublyLinkedList <T> {
	private int size = 0;
	private Node<T> head = null;
	private Node<T> tail = null;
	
	private class Node<T> {
		public T data;
		public Node<T> next;
		public Node<T> previous;
		
		public Node(T data, Node<T> next, Node<T> previous) {
			this.data = data;
			this.next = next;
			this.previous = previous;
		}
		
		public T getData()  {
			return data;
		}
		
		@Override
		public String toString() {
			return data.toString();
		}
	}
	
	public void add(T item) {
		if(isEmpty()) {
			head = tail = new Node(item, null, null);
		} else {
			Node<T> currTail = tail;
			Node<T> newNode = new Node(item, null, currTail);
			currTail.next = newNode;
			tail = newNode;
		}

		size++;
	}
	
	public void add(int index, T item) {
		if(indexExceedsSize(index)) throw new RuntimeException("Specified index is out of bounds");
		
		Node<T> trav = head;
		
		Node<T> previous;
		Node<T> next;
		
		for(int i = 0; i < index; i++) {
			trav = trav.next;
		}
		
		next = trav;
		previous = trav.previous;
		
		Node<T> newNode = new Node(item, next, previous);
		next.previous = newNode;
		previous.next = newNode;
		
		size++;
	}
	
	public void addAll(Collection<? extends T> collection) {
		Node<T> trav = tail;
		Iterator<? extends T>  i = collection.iterator();
		
		while(i.hasNext()) {
			T item = i.next();
			Node<T> newNode = new Node<T>(item, null, trav);
			trav.next = newNode;
			trav = newNode;
			size++;
		}

		tail = trav;
 	}
	
	public void addAll(int index, Collection<? extends T> collection) {
		if(indexExceedsSize(index)) throw new RuntimeException("Specified index is out of bounds");

		Node<T> trav = head;
		
		for(int i = 1; i < index; i++) {
			trav = trav.next;
		}
		
		Node<T> next = trav.next;

		Iterator<? extends T>  i = collection.iterator();
		
		while(i.hasNext()) {
			T item = i.next();
			Node<T> newNode = new Node<T>(item, null, trav);
			trav.next = newNode;
			trav = newNode;

			if(! i.hasNext() && (next != null)) {
				newNode.next = next;
				next.previous = newNode;
			} else if(next == null) {
				tail = trav;
			}

			size++;
		}
 	}
	
	public void addFirst(T item) {
		Node<T> trav = head;
		
		Node<T> newNode = new Node(item, trav, null);
		trav.previous = newNode;
		
		head = newNode;
	}
	
	public void addLast(T item) {
		Node<T> trav = tail;
		
		Node<T> newNode = new Node(item, null, trav);
		trav.next = newNode;
		
		tail = newNode;
	}
	
	public void clear() {
		Node<T> trav = head;

		while(trav != null) {
			Node<T> next = trav.next;

			trav.previous = null;
			trav.next = null;
			trav.data = null;
			trav = next;
		}
		
		size = 0;
		head = tail = null;
	}
	
	public boolean contains(T item) {
		Node<T> trav = head;
		
		while(trav != null) {
			if(item != null && item.equals(trav.getData())) {
				return true;
			}
			
			trav = trav.next;
		}
		
		return false;
	}
	
	public T get(int index) {
		Node<T> trav = moveTravToIndex(index);
		
		return trav.getData();
	}
	
	public T getFirst() {
		return head.getData();
	}
	
	public T getLast() {
		return tail.getData();
	}
	
	public int indexOf(T item) {
		Node<T> trav = head;
		int counter = 0;
		
		while(trav != null) {
			if(item != null && item.equals(trav.getData())) {
				return counter;
			}
			
			trav = trav.next;
			counter++;
		}
		
		return -1;
	}
	
	public T remove() {
		if(isEmpty()) return null;
		
		Node<T> trav = head;
		T data = trav.getData();
		
		head = trav.next;
		trav.next.previous = null;
		trav.data = null;
		trav.next = null;
		
		return data;
	}
	
	public T remove(int index) {
		if(indexExceedsSize(index)) throw new RuntimeException("Specified index is out of bounds");

		if(index == 0) return remove();

		Node<T> trav = moveTravToIndex(index);

		T data = trav.getData();
		
		trav.next.previous = trav.previous;
		trav.previous.next = trav.next;
		trav.data = null;
		trav.next = null;
		trav.previous = null;
		
		return data;
	}
	
	public boolean remove(T item) {
		Node<T> trav = head;
		
		while(trav != null) {
			if(item != null && item.equals(trav.getData())) {
				trav.next.previous = trav.previous;
				trav.previous.next = trav.next;
				trav.data = null;
				trav.next = null;
				trav.previous = null;
				
				return true;
			}
			
			trav = trav.next;
		}
		
		return false;
	}
	
	public T removeFirst() {
		return remove();
	}
	
	public T removeLast() {
		Node<T> trav = tail;
		
		T data = trav.getData();
		trav.previous.next = null;
		tail = trav.previous;
		trav.data = null;
		trav.next = null;
		trav.previous = null;
		
		return data;
	}
	
	public void set(int index, T item) {
		if(indexExceedsSize(index)) throw new RuntimeException("Specified index is out of bounds");

		Node<T> trav = moveTravToIndex(index);
		
		trav.data = item;
	}
	
	public int size() {
		return size;
	}
	
	public Object[] toArray() {
		Object[] arr = new Object[size];
		Node<T> trav = head;
		
		for(int i = 0; i < size; i++) {
			arr[i] = trav.getData();
		}
		
		return arr;
	}

	private boolean isEmpty() {
		return size <= 0;
	}
	
	private boolean indexExceedsSize(int index) {
		return (size < index);
	}
	
	private Node<T> moveTravToIndex(int index) {
		Node<T> trav = head;
		
		for(int i = 0; i < index; i++) {
			trav = trav.next;
		}
		
		return trav;
	}
}
