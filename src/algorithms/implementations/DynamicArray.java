package algorithms.implementations;

import java.util.Collection;

/*
 * A dynamic array structure built upon a static array
 */

public class DynamicArray<T> {
	private final int DEFAULT_SIZE = 4;
	private T[] array;
	private int index = 0;
	private int size;

	public DynamicArray(T[] array) {
		this.array = array;
		this.size = array.length;
		this.index = array.length;
	}
	
	public DynamicArray(int size) {
		this.array = (T[]) new Object[size];
		this.size = size;
		this.index = -1;
	}
	
	public DynamicArray() {
		this.array = (T[]) new Object[DEFAULT_SIZE];
		this.size = DEFAULT_SIZE;
		this.index = -1;
	}
	
	// Adds the given element to the end of the array
	public void add(T element) {
		if(expansionNeeded()) expandArray();
		array[index+1] = element;
		index++;
	}
	
	// Adds the given element to the array at the given index
	public void add(T element, int index) {
		if(expansionNeeded()) expandArray();
		if(index > this.index) {
			add(element);
		} else {
			shiftRight(index);
			array[index] = element;
			index++;
		}
	}
	
	// Adds all elements of collection to array
	public void addAll(Collection<T> collection) {
		
	}
	
	// Returns the element at the given index
	public T get(int index) {
		if(index > this.index) throw new java.lang.IndexOutOfBoundsException(index);
		return array[index];
	}
	
	// Gets the index of the given element
	public int getIndexOf(T element) {
		for(int i = 0; i <= index; i++) {
			if(array[i].equals(element)) return i;
		}
		
		return -1;
	}
	
	// Returns the size of the array
	public int size() {
		return index + 1;
	}
	
	// Removes the given element from the array
	public void remove(T element) {
		int index = getIndexOf(element);
		shiftLeft(index);
		this.index--;
	}
	
	// Checks whether the array contains the given element
	public boolean contains(T element) {
		return getIndexOf(element) >= 0;
	}
	
	// Returns array as string representation
	public String toString() {
		return array.toString();
	}
	
	// Clears all elements from the array
	public void clear() {
		this.array = (T[]) new Object[size];
		this.index = -1;
	}
	
	// Returns true if array is empty
	public boolean isEmpty() {
		return index < 0;
	}
	
	// Returns the underlying array
	public T[] toArray() {
		return this.toArray();
	}

	
	
	
	private void shiftLeft(int index) {
		for(int i = index; i <= this.index; i++) {
			if(i+1 >= size) return;
			array[i] = array[i+1];
		}
	}
	
	private void shiftRight(int index) {
		for(int i = (this.index + 1); i > index; i--) {
			array[i] = array[i-1];
		}
	}
	
	private boolean expansionNeeded() {
		return index >= (size - 1);
	}
	
	private void expandArray() {
		T[] expandedArray = (T[]) new Object[size * 2];
		System.arraycopy(array, 0, expandedArray, 0, array.length );
		this.array = expandedArray;
		this.size = expandedArray.length;
	}
}
