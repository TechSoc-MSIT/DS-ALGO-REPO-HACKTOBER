package Hashing;

import java.util.ArrayList;

//implementation of HashMap in Java
public class Map<K, V> {
	ArrayList<MapNode<K, V>> buckets;
	int size;
	int numBuckets;

	// Constructor Function
	public Map() {
		numBuckets = 20;
		buckets = new ArrayList<MapNode<K, V>>();
		for (int i = 0; i < numBuckets; i++) {
			buckets.add(null);
		}
		size = 0;

	}

	// returns size of HashMap
	public int size() {
		return size;
	}

	// to generate hashCompressed values
	private int getHashCode(K key) {
		int hashValue = key.hashCode();
		return hashValue % numBuckets;
	}

	public double loadFactor() {
		return (1.0 * size) / numBuckets;
	}

	// to insert given key in HashMap
	public void put(K key, V value) {
		int bucketIndex = getHashCode(key);
		MapNode<K, V> head = buckets.get(bucketIndex);
		while (head != null) {
			if (head.key.equals(key)) {
				head.value = value;
				return;
			}
			head = head.next;
		}
		head = buckets.get(bucketIndex);
		MapNode<K, V> newElementNode = new MapNode<K, V>(key, value);
		size++;
		newElementNode.next = head;
		buckets.set(bucketIndex, newElementNode);
		double loadFactor = (1.0 * size) / numBuckets;
		if (loadFactor > 0.7) {
			rehash();
		}
	}

	// to get value corresponding to a given key in HashMap
	public V get(K key) {
		int bucketIndex = getHashCode(key);
		MapNode<K, V> head = buckets.get(bucketIndex);
		while (head != null) {
			if (head.key.equals(key)) {
				return head.value;
			}

			head = head.next;
		}
		return null;
	}

	// to remove corresponding key from HashMap
	public V remove(K key) {
		int bucketIndex = getHashCode(key);
		MapNode<K, V> head = buckets.get(bucketIndex);
		MapNode<K, V> prev = null;
		while (head != null) {
			if (head.key.equals(key)) {
				if (prev == null) {
					buckets.set(bucketIndex, head.next);
				} else {
					prev.next = head.next;
				}
				size--;
				return head.value;
			}
			prev = head;
			head = head.next;
		}
		return null;
	}

	// to make rehashing function to maintain Load Factor
	private void rehash() {
		ArrayList<MapNode<K, V>> temp = buckets;
		buckets = new ArrayList<>();
		for (int i = 0; i < 2 * numBuckets; i++) {
			buckets.add(null);
		}
		size = 0;
		numBuckets *= 2;

		for (int i = 0; i < temp.size(); i++) {
			MapNode<K, V> head = temp.get(i);
			while (head != null) {
				K key = head.key;
				V value = head.value;
				put(key, value);
				head = head.next;
			}
		}
	}
}
