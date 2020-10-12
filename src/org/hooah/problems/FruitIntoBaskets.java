package org.hooah.problems;

/**
 * In a row of trees, the i-th tree produces fruit with type tree[i].
 *
 * You start at any tree of your choice, then repeatedly perform the following steps:
 *
 * Add one piece of fruit from this tree to your baskets.  If you cannot, stop.
 * Move to the next tree to the right of the current tree.  If there is no tree to the right, stop.
 * Note that you do not have any choice after the initial choice of starting tree: you must perform step 1, then step 2, then back to step 1, then step 2, and so on until you stop.
 *
 * You have two baskets, and each basket can carry any quantity of fruit, but you want each basket to only carry one type of fruit each.
 *
 * What is the total amount of fruit you can collect with this procedure?
 */
public class FruitIntoBaskets {
	
	public int totalFruit(int[] tree) {
		
		int l = 0;
		int firstType = -1, secondType = -1;
		
		int res = 0;
		for(int r = 0;r < tree.length;r++) {
			if(tree[r] == firstType || tree[r] == secondType) continue;
			
			if(firstType == -1) {
				firstType = tree[r];
				continue;
			}
			if(secondType == -1) {
				secondType = tree[r];
				continue;
			}
			
			res = Math.max(res, r - l);
			
			firstType = tree[r-1];
			secondType = tree[r];
			
			l = r-1;
			while( tree[l] == firstType) {
				--l;
			}
			++l;
		}
		
		res = Math.max(res, tree.length - l);
		return res;
	}
	public static void main(String[] args){
		FruitIntoBaskets fruitIntoBaskets = new FruitIntoBaskets();
		assert fruitIntoBaskets.totalFruit(new int[]{1,2,3,2,2})==4;
		assert fruitIntoBaskets.totalFruit(new int[]{3,3,3,1,2,1,1,2,3,3,4})==5;
		
	}
	
}
