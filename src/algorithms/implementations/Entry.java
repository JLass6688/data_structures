package algorithms.implementations;

public class Entry<K, V> {
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
