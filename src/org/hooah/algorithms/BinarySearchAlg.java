package org.hooah.algorithms;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;


/**
 * Binary Search
 * O(log n)
 *
 * Real World Usage:
 * Let’s say we’re in the wine-selling business and millions of buyers are visiting our application every day.
 *
 * Through our app, a customer can filter out items which have a price below n dollars, select a bottle from the search results, and add them to his cart. We have millions of users seeking wines with a price limit every second. The results need to be fast.
 *
 * On the backend, our algorithm runs a linear search through the entire list of wines comparing the price limit entered by the customer with the price of every wine bottle in the list.
 *
 * Then, it returns items which have a price less than or equal to the price limit. This linear search has a time complexity of O(n).
 *
 * This means the bigger the number of wine bottles in our system, the more time it will take. The search time increases proportionately to the number of new items introduced.
 *
 * If we start saving items in sorted order and search for items using the binary search, we can achieve a complexity of O(log n).
 *
 * With binary search, the time taken by the search results naturally increases with the size of the dataset, but not proportionately.
 *
 *
 *
 *
 * Simply put, the algorithm compares the key value with the middle element of the array; if they are unequal, the half in which the key cannot be part of is eliminated, and the search continues for the remaining half until it succeeds.
 *
 * Remember – the key aspect here is that the array is already sorted.
 *
 * If the search ends with the remaining half being empty, the key is not in the array.
 *
 *
 *
 *
 *
 *
 *  Performance
 * Whether to use a recursive or an iterative approach for writing the algorithm is mostly a matter of personal preference. But still here are a few points we should be aware of:
 *
 * 1. Recursion can be slower due to the overhead of maintaining a stack and usually takes up more memory
 * 2. Recursion is not stack-friendly. It may cause StackOverflowException when processing big data sets
 * 3. Recursion adds clarity to the code as it makes it shorter in comparison to the iterative approach
 *
 * Ideally, a binary search will perform less number of comparisons in contrast to a linear search for large values of n. For smaller values of n, the linear search could perform better than a binary search.
 *
 * One should know that this analysis is theoretical and might vary depending on the context.
 *
 * Also, the binary search algorithm needs a sorted data set which has its costs too. If we use a merge sort algorithm for sorting the data, an additional complexity of n log n is added to our code.
 *
 * So first we need to analyze our requirements well and then take a decision on which search algorithm would suit our requirements best.
 */
public class BinarySearchAlg {

    
    public static void main(String[] args) {
    
        int[] sortedArray = { 0, 1, 2, 3, 4, 5, 5, 6, 7, 8, 9, 9 };
        List<Integer> sortedList = Arrays.asList(0, 1, 2, 3, 4, 5, 5, 6, 7, 8, 9, 9);
        int expectedIndexForSearchKey = 7;
        
        int key = 6;
        int low = 0;
        int high = sortedArray.length - 1;
        
        int resultIndex;
        
        resultIndex = binarySearchRecursively(sortedArray, key, low, high);
        System.out.println("RECURSION: "+resultIndex);
        assert expectedIndexForSearchKey==resultIndex;
    
    
        resultIndex = binarySearchIteratively(sortedArray, key, low, high);
        System.out.println("ITERATIVE: "+resultIndex);
        assert expectedIndexForSearchKey==resultIndex;
    
        resultIndex = binarySearchUsingJavaArrays(sortedArray, key);
        System.out.println("JAVA_ARRAYS: "+resultIndex);
        assert expectedIndexForSearchKey==resultIndex;
    
        resultIndex = binarySearchUsingJavaCollections(sortedList, key);
        System.out.println("JAVA_COLLECTIONS: "+resultIndex);
        assert expectedIndexForSearchKey==resultIndex;
    
    }
    
    /**
     * accepts a sortedArray, key, the low and high indexes of the sortedArray.
     *
     */
    private static int binarySearchRecursively(
            int[] sortedArray, int key, int low, int high) {
        int middle = (low + high) / 2;
        
        if (high < low) {
            return -1;
        }
        
        if (key == sortedArray[middle]) {
            return middle;
        } else if (key < sortedArray[middle]) {
            return binarySearchRecursively(
                    sortedArray, key, low, middle - 1);
        } else {
            return binarySearchRecursively(
                    sortedArray, key, middle + 1, high);
        }
    }
    
    /**
     * takes a sortedArray, key & the low & high indexes of the sortedArray as arguments. When the method runs for the first time the low, the first index of the sortedArray, is 0, while the high, the last index of the sortedArray, is equal to its length – 1.
     *
     * The middle is the middle index of the sortedArray. Now the algorithm runs a while loop comparing the key with the array value of the middle index of the sortedArray.
     */
    private static int binarySearchIteratively(int[] sortedArray, int key, int low, int high) {
        
        int index = Integer.MAX_VALUE;
        
        while (low <= high) {
            
            int mid = (low + high) / 2;
            
            if (sortedArray[mid] < key) {
                low = mid + 1;
            } else if (sortedArray[mid] > key) {
                high = mid - 1;
            } else if (sortedArray[mid] == key) {
                index = mid;
                break;
            }
        }
        return index;
    }
    
    /**
     *
     * A sortedArray and an int key, which is to be searched in the array of integers, are passed as arguments to the binarySearch method of the Java Arrays class.
     */
    private static int binarySearchUsingJavaArrays(int[] sortedArray, Integer key) {
        return Arrays.binarySearch(sortedArray, key);
    }
    
    /**
     *
     * A sortedList & an Integer key, which is to be searched in the list of Integer objects, are passed as arguments to the binarySearch method of the Java Collections class.
     *
     */
    private static int binarySearchUsingJavaCollections(List<Integer> sortedList, Integer key) {
        return Collections.binarySearch(sortedList, key);
    }
}
