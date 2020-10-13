package org.hooah.problems;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * You should design and implement a data structure which will collect statistics.
 * More precisely it should perform two operations:
 * Add operation. Add element E. E is a string, for example, it can be a user query or something else.
 * GetCount operation for element Q… Q is a string.  In other words, how many Q did we add before.
 *
 * part 2
 * If you were to add a most popular method to find the most popular string and the number of times it occurs.
 * What would you do differently.
 */
public class FavoritesList<E> {
	
	// ---------------- nested Item class ----------------
	protected static class Item<E> {
		
		private final E value;
		private int count = 0;
		
		/** Constructs new item with initial count of zero. */
		public Item(E val) {
			this.value = val;
		}
		
		public int getCount() { return count; }
		
		public E getValue() { return value; }
		
		public void increment() { count++; }
	} //----------- end of nested Item class -----------
	
	List<Item<E>> list = new ArrayList<Item<E>>();
	
	public FavoritesList(){
	
	}
	// nonpublic utilities
	
	/** Provides shorthand notation to retrieve count of item stored at Position p. */
	protected int getCount(Item<E> e) {
		return findPosition(e.value).getCount();
	}
	
	// public methods
	
	/** Returns the number of items in the favorites list. */
	public int size() { return list.size(); }
	
	/** Returns true if the favorites list is empty. */
	public boolean isEmpty() { return list.isEmpty(); }
	
	/** Accesses element e (possibly new), increasing its access count. */
	public void add(E e) {
		Item<E> p = findPosition(e); // try to locate existing element
		if(p == null) {
			p = new Item<E>(e);
		}
		p.increment(); // always increment count
		list.add(p);// if new, place at end
	}
	
	/** Returns Position having element equal to e (or null if not found). */
	protected Item<E> findPosition(E e) {
		Item<E> walk=null;
		if(!list.isEmpty()) {
			for(Item<E> eItem : list) {
				if(e.equals(eItem.getValue())) {
					walk = eItem;
					break;
				}
			}
		}
		return walk;
	}
	
	/** Returns an iterable collection of the k most frequently accessed elements. */
	public Iterable<E> getFavorites(int k) throws IllegalArgumentException {
		if(k < 0 || k > size()) {
			throw new IllegalArgumentException("Invalid k");
		}
		List<E> result = new ArrayList<E>();
		Iterator<Item<E>> iter = list.iterator();
		for(int j = 0; j < k; j++) {
			result.add(iter.next().getValue());
		}
		return result;
	}
	
	public static void main(String[] args) {
		FavoritesList<String> favoritesList = new FavoritesList<String>();
		Item<String> hello = new Item<String>("hello");
		favoritesList.add(hello.value);
		favoritesList.add("yes");
		favoritesList.add("34");
		favoritesList.add(hello.value);
		favoritesList.add("yes");
		System.out.println(favoritesList.getCount(hello));
		
	}
}