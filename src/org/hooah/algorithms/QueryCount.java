package org.hooah.algorithms;

import java.util.Arrays;
import java.util.Map;
import java.util.Objects;

public class QueryCount {
	
	/**
	 * Default initial capacity.
	 */
	private static final int DEFAULT_CAPACITY = 16;

	/**
	 * The array buffer into which the elements of the ArrayList are stored.
	 * The capacity of the ArrayList is the length of this array buffer. Any
	 * empty ArrayList with elementData == EMPTY_DATA
	 * will be expanded to DEFAULT_CAPACITY when the first element is added.
	 */
	transient String[] data;
	
	/**
	 * The size of the ArrayList (the number of elements it contains).
	 *
	 * @serial
	 */
	private int size;
	
	static class Node<K,V> implements Map.Entry<K,V> {
		
		final int hash;
		final K key;
		V value;
		
		Node(int hash, K key, V value) {
			this.hash = hash;
			this.key = key;
			this.value = value;
		}
		
		public K getKey() {
			return key;
		}
		
		public V getValue() {
			return value;
		}
		
		public V setValue(V newValue) {
			V oldValue = value;
			value = newValue;
			return oldValue;
		}
		public final int hashCode() {
			return Objects.hashCode(key) ^ Objects.hashCode(value);
		}
		
		public final java.lang.String toString() { return key + "=" + value; }
		
	}
	
	/**
	 * The table, initialized on first use, and resized as
	 * necessary. When allocated, length is always a power of two.
	 * (We also tolerate length zero in some operations to allow
	 * bootstrapping mechanics that are currently not needed.)
	 */
	transient Node<String,Integer>[] table;
	
	/**
	 * Constructs an empty list with an initial capacity of ten.
	 */
	public QueryCount() {
	}
	
	public int add(final String userQuery){
		int val = 1;
		if (table != null) {
			for(Node<String, Integer> kvNode : table) {
				if(kvNode != null && kvNode.key.equals(userQuery)) {
					val = val + kvNode.value;
					kvNode.value = val;
					break;
				}
			}
		}
		size++;
		if(val>1){
			return val;
		}
		return put(userQuery, val);
	}
	
	public int put(String key, Integer value) {
		Node<String,Integer>[] oldTab = table;
		int newCap;
		int oldCap = oldTab==null?0:oldTab.length;
		if (oldTab == null || oldCap == 0){
			newCap=DEFAULT_CAPACITY;
		}else if(size>=DEFAULT_CAPACITY){
			newCap=oldCap<<1;//double capacity
		}else{
			//table.length>0 && table.length < DEFAULT_CAPACITY
			table[size+1] = new Node<>(hash(key),key, value);
			return value;
		}
		@SuppressWarnings({"unchecked"})
		Node<String,Integer>[] newTab = new Node[newCap];
		if(table!=null) {
			for(int i = 0; i < size; i++) {
				newTab[i] = table[i];
			}
		}
		newTab[size+1] = new Node<>(hash(key),key, value);
		table = newTab;
		return value;
	}
	
	static int hash(Object key) {
		int h;
		return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
	}
	
	public int getCount(final String userQuery){
		int count=0;
		if(table==null||table.length==0){
			return count;
		}
		for(Node<String,Integer> kvNode : table) {
			if(kvNode!=null&&kvNode.key.equals(userQuery)){
				count = kvNode.value;
				break;
			}
		}
		return count;
	}
	
	public static void main(String[] args) {
		QueryCount queryCount = new QueryCount();
		queryCount.add("hello");
		queryCount.add("hello");
		queryCount.add("a");
		queryCount.add("a");
		queryCount.add("hello");
		queryCount.add("yes");
		queryCount.add("cnn");
		queryCount.add("cnn");
		queryCount.add("cnn");
		queryCount.add("cnn");
		queryCount.add("fox");
		System.out.println("Table " + Arrays.toString(queryCount.table));
		System.out.println("Query 'fox' was added " + queryCount.getCount("fox") + " times");
		System.out.println("Query 'hello' was added " + queryCount.getCount("hello") + " times");
		
	}
	
}
