package algorithms.implementations;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class PriorityQueue<T extends Comparable<T>> {
	private int heapSize = 0;
	private int heapCapacity;
	private List<T> heap = null;
	
	public PriorityQueue() {
		this(11);
	}
	
	public PriorityQueue(int size) {
		heap = new ArrayList<T>(size);
		heapCapacity = size;
	}
	
	public PriorityQueue(Collection<? extends T> collection) {
		this(collection.size());
		for(T item : collection) add(item);
	}
	
	public boolean add(T item) {
		if(item == null) throw new NullPointerException();
		
		if(heapSize < heapCapacity) {
			heap.add(item);
		} else {
			heap.add(item);
			heapCapacity++;
		}
		
		swim(heapSize);
		heapSize++;
		
		return true;
	}
	
	public void clear() {
		for(int i = 0; i < heapCapacity; i++) {
			heap.set(i, null);
		}
		
		heapSize = 0;
	}

	public Comparator<? super T> comparator() {
		return new Comparator<T>() {
			public int compare(T i, T j) {
				return compareItems(heap.indexOf(i), heap.indexOf(j));
			}
		};
	}

	public boolean contains(T item) {
		return heap.contains(item);
	}
	
	public Iterator<T> iterator() {
		return heap.iterator();
	}
	
	public boolean offer(T item) {
		add(item);
		return true;
	}
	
	public T peek() {
		if(isEmpty()) {
			return null;
		} else {
			return heap.get(0);
		}
	}
	
	public T poll() {
		if(isEmpty()) return null;
		
		T val = heap.get(0);
		remove(val);
		
		return val;
	}
	
	public boolean remove(T item) {
		if(isEmpty()) return false;

		int i = heap.indexOf(item);
		if(i < 0) return false;
		
		if(i == (heapSize - 1)) {
			heap.set(i, null);
			heapSize--;
		} else {
			swap(i, (heapSize - 1));
			T val = heap.get(i);
			heap.set((heapSize -1), null);
			heapSize--;

			sink(i);
			
			// If sink did not work, attempt to swim item
			if(heap.get(i) == val) swim(i);
		}
		
		return true;
	}
	
	public int size() {
		return heapSize;
	}
	
	private boolean isEmpty() {
		return heapSize <= 0;
	}
	
	private void sink(int i) {
		int childLeft = (2 * i) + 1;
		int childRight = (2 * i) + 2;
		
		int lesserChild = childLeft;
		
		if(lesserChild >= heapSize) return;
		
		if(childRight < heapSize && lessThan(childRight, childLeft)) {
			lesserChild = childRight;
		}
		
		if(lessThan(lesserChild, i)) {
			swap(lesserChild, i);
			sink(lesserChild);
		}
	}
	
	private void swim(int i) {
		int parentIdx = (i-1)/2;
		
		while(i > 0 && lessThan(i, parentIdx)) {
			swap(i, parentIdx);
			i = parentIdx;

			parentIdx = (i-1)/2;
		}
	}
	
	private boolean lessThan(int i, int j) {
		int comp = compareItems(i, j);
		
		return comp <= 0;
	}
	
	private int compareItems(int i, int j) {
		T valI = heap.get(i);
		T valJ = heap.get(j);
		
		return valI.compareTo(valJ);
	}
	
	private void swap(int i, int j) {
		T childVal = heap.get(i);
		T parentVal = heap.get(j);
		
		heap.set(j, childVal);
		heap.set(i, parentVal);
	}
}
