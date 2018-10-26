package org.hooah.algorithms;

// A Dynamic Programming based solution for 0-1 Knapsack problem

/**
 Given a set of items, each with a weight and a value,
 we must determine the number of each item to include in a collection so that the total weight is less than or equal to a given limit and the total value must be maximized.
 */
import java.util.ArrayList;
import java.util.List;

public class Knapsack {
	
	// items of our problem
	private Item[] items;
	// capacity of the bag
	private int W;
	
	public Knapsack(Item[] items, int W) {
		this.items = items;
		this.W = W;
	}
	
	public void display() {
		if (items != null  &&  items.length > 0) {
			System.out.println("Knapsack problem");
			System.out.println("Capacity(W) : " + W);
			System.out.println("Items :");
			
			for (Item item : items) {
				System.out.println("- " + item.str());
			}
		}
	}
	
	// we write the solve algorithm
	public Bag solve() {
		int NB_ITEMS = items.length;
		
		// we use a matrix to store the max value at each n-th item
		int[][] matrix = new int[NB_ITEMS + 1][W + 1];
		
		//What if the knapsack's capacity is 0 - Set all columns at row 0 to be 0
		for (int col = 0; col <= W; col++) {
			matrix[0][col] = 0;
		}
		
		//What if there are no items at home.  Fill the first row with 0
		for (int row = 0; row <= NB_ITEMS; row++) {
			matrix[row][0] = 0;
		}
		
		// we iterate on items
		for (int i = 1; i <= NB_ITEMS; i++) {
			// we iterate on each capacity
			for (int j = 0; j <= W; j++) {
				if (items[i - 1].weight > j)
					//If the current item's weight is more than the running weight,
					// just carry forward the value without the current item
					matrix[i][j] = matrix[i-1][j];
				else
					// we maximize value at this rank in the matrix
					matrix[i][j] = max(matrix[i-1][j], matrix[i-1][j - items[i-1].weight]
							+ items[i-1].value);
			}
		}
		
		int res = matrix[NB_ITEMS][W];
		int w = W;
		List<Item> itemsSolution = new ArrayList<>();
		
		for (int i = NB_ITEMS; i > 0  &&  res > 0; i--) {
			if (res != matrix[i-1][w]) {
				itemsSolution.add(items[i-1]);
				// we remove items value and weight
				res -= items[i-1].value;
				w -= items[i-1].weight;
			}
		}
		
		return new Bag(itemsSolution, matrix[NB_ITEMS][W]);
	}
	
	static class Item {
		
		public String name;
		public int value;
		public int weight;
		
		public Item(String name, int value, int weight) {
			this.name = name;
			this.value = value;
			this.weight = weight;
		}
		
		public String str() {
			return name + " [value = " + value + ", weight = " + weight + "]";
		}
		
	}
	
	static class Bag {
		
		// list of items to put in the bag to have the maximal value
		public List<Item> items;
		// maximal value possible
		public int value;
		
		public Bag(List<Item> items, int value) {
			this.items = items;
			this.value = value;
		}
		
		public void display() {
			if (items != null  &&  !items.isEmpty()){
				System.out.println("\nKnapsack solution");
				System.out.println("Value = " + value);
				System.out.println("Items to pick :");
				
				for (Item item : items) {
					System.out.println("- " + item.str());
				}
			}
		}
		
	}
	
	
	
	public static void main(String[] args) {
		// we take the same instance of the problem displayed in the image
		Item[] items = {new Item("Elt1", 4, 12),
				new Item("Elt2", 2, 1),
				new Item("Elt3", 2, 2),
				new Item("Elt4", 1, 1),
				new Item("Elt5", 10, 4)};
		
		Knapsack knapsack = new Knapsack(items, 15);
		knapsack.display();
		
		
		
		
		Bag bag = knapsack.solve();
		bag.display();
	}
	
	/**
	 * Returns the greater of two {@code int} values. That is, the
	 * result is the argument closer to the value of
	 * {@link Integer#MAX_VALUE}. If the arguments have the same value,
	 * the result is that same value.
	 *
	 * @param   a   an argument.
	 * @param   b   another argument.
	 * @return  the larger of {@code a} and {@code b}.
	 */
	public static int max(int a, int b) {
		return (a >= b) ? a : b;
	}
}