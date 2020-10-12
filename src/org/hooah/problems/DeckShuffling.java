package org.hooah.problems;

/**
 *  * Shuffle deck of cards randomly
 */
public class DeckShuffling {
	
	public void shuffleDeck(int[] arr){
		for(int i=arr.length-1; i>=0; i--){
			int random = (int)(Math.random()*(i+1)) ;
			//
			swap(arr,random,i);
		}
	}
	
	//swaps values of arr[a] and arr[b]
	private void swap(int[] arr,int a,int b){
		int temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}
	
	public static void main(String[] args){
		int[] arr = {1,2,3,4,5,6,7,8};
		DeckShuffling sa = new DeckShuffling();
		sa.shuffleDeck(arr);
		System.out.println();
		for(int j : arr) {
			System.out.print(j + " ");
		}
	}
	
}
