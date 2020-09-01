package algorithms.implementations;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

class Entry<K, V> {
	int hash;
	K key;
	V value;
	
	public Entry(K key, V value) {
		this.key = key;
		this.value = value;
		this.hash = key.hashCode();
	}
	
	public String toString() {
		return key + " -> " + value;
	}
}

public class SeparateChainingHashTable<K, V> {
	private int DEFAULT_SIZE = 10;
	private int DEFAULT_MAX_BUCKET_SIZE = 5;
	
	private int size;
	private int maxBucketSize;
	private int capacity;
	private LinkedList<Entry<K,V>>[] table;
	
	public SeparateChainingHashTable() {
		this.table = new LinkedList[DEFAULT_SIZE];
		this.capacity = DEFAULT_SIZE;
		this.maxBucketSize = DEFAULT_MAX_BUCKET_SIZE;
	}
	
	public SeparateChainingHashTable(int size) {
		this.table = new LinkedList[size];
		this.capacity = size;
		this.maxBucketSize = DEFAULT_MAX_BUCKET_SIZE;
	}
	
	public SeparateChainingHashTable(int size, int maxBucketSize) {
		this.table = new LinkedList[size];
		this.capacity = size;
		this.maxBucketSize = maxBucketSize;
	}

	public void clear() {
		for(int i = 0; i < table.length; i++) {
			table[i] = null;
		}

		size = 0;
	}
	
	public boolean containsKey(K key) {
		int bucketIndex = getTableIndex(key.hashCode());
		
		LinkedList<Entry<K,V>> bucket = table[bucketIndex];
		
		if(bucket == null) return false;
		
		for(Entry<K,V> entry : bucket) {
			if(entry.key.equals(key)) return true;
		}

		return false;
	}
	
	public Set<Entry<K,V>> entrySet() {
		Set<Entry<K,V>> set = new HashSet<Entry<K,V>>(size);

		for(int i = 0; i < table.length; i++) {
			LinkedList<Entry<K,V>> bucket = table[i];
			
			if(bucket != null) {
				for(Entry<K,V> entry : bucket) {
					set.add(entry);
				}
			}
		}

		return set;
	}
	
	public V get(K key) {
		if(containsKey(key)) {
			int bucketIndex = getTableIndex(key.hashCode());
			
			LinkedList<Entry<K,V>> bucket = table[bucketIndex];
			
			for(Entry<K,V> entry : bucket) {
				if(entry.key.equals(key)) return entry.value;
			}
		} 
	
		return null;
	}
	
	public boolean isEmpty() {
		return size == 0;
	}
	
	public V put(K key, V value) {
		if(key == null) throw new IllegalArgumentException("Null not a valid argument for operation put");
		
		Entry<K,V> entry = new Entry<K,V>(key, value);
		
		int bucketIndex = getTableIndex(entry.hash);
		
		if(table[bucketIndex] == null) {
			LinkedList<Entry<K,V>> bucket = new LinkedList<Entry<K,V>>();
			bucket.add(entry);
			table[bucketIndex] = bucket;
			size++;
			return null;
		} else {
			return addEntryToBucket(bucketIndex, entry);
		}
	}
	
	public V remove(K key) {
		if(containsKey(key)) {
			int bucketIndex = getTableIndex(key.hashCode());
			
			LinkedList<Entry<K,V>> bucket = table[bucketIndex];
			
			for(Entry<K,V> entry : bucket) {
				if(entry.key.equals(key)) {
					V val = entry.value;
					bucket.remove(entry);
				
					size--;
					return val;
				}
			}
		} 
	
		return null;
	}
	
	public int size() {
		return size;
	}

	

	private int getTableIndex(int hashCode) {
		return Math.abs(hashCode % capacity);
	}
	
	private V addEntryToBucket(int bucketIndex, Entry<K,V> entry) {
		LinkedList<Entry<K,V>> bucket = table[bucketIndex];

		Entry<K,V> existingEntry = bucketContains(bucket, entry);
		if(existingEntry != null) {
			V existingVal = existingEntry.value;
			existingEntry.value = entry.value;
			return existingVal;
		} else {
			bucket.add(entry);
			if(bucket.size() > maxBucketSize) expandTable();
			size++;
			return null;
		}
	}
	
	private Entry<K,V> bucketContains(LinkedList<Entry<K,V>> bucket, Entry<K,V> entry) {
		for(Entry<K,V> bucketEntry: bucket) {
			if(bucketEntry.key.equals(entry.key)) return bucketEntry;
		}
		
		return null;
	}
	
	private void expandTable() {
		capacity *= 2;
		LinkedList<Entry<K,V>>[] newTable = new LinkedList[capacity];
		
		for(int i = 0; i < table.length; i++) {
			LinkedList<Entry<K,V>> bucket = table[i];
			if(bucket != null && !bucket.isEmpty()) {
				for(Entry<K,V> bucketEntry : bucket) {
					int newBucketIndex = getTableIndex(bucketEntry.hash);
					LinkedList<Entry<K,V>> newBucket = newTable[newBucketIndex];
					
					if(newBucket ==  null) newTable[newBucketIndex] = newBucket = new LinkedList<Entry<K,V>>();
					newBucket.add(bucketEntry);
				}
			}
		}
		
		table = newTable;
	}
	
}
