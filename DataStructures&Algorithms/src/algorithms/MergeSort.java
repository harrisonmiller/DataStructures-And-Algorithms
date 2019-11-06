package algorithms;

import java.util.Random;

/* 
 * Recursive Merge Sort Implementation
 * Runtime: O(nlogn)
 */
public class MergeSort {

	public static void main(String[] args) {
		
		int testArray[] = createRandomArray(20, 1, 100);
		
		System.out.println("Unsorted Array: ");
		for(int i = 0; i < testArray.length; i++) {
			System.out.print(testArray[i] + " ");
		}
		
		int helper[] = new int[testArray.length];
		mergesort(testArray, helper, 0, testArray.length - 1);
		
		System.out.println("\nSorted Array: ");
		for(int i = 0; i < testArray.length; i++) {
			System.out.print(testArray[i] + " ");
		}
	}
	
	public static void merge(int[] nums, int[] helper, int low, int high) {
		int middle = (low + high) / 2;
		
		/* Copy the two halves into the helper array */
		for(int i = low; i <= high; i++) {
			helper[i] = nums[i];
		}
		
		/* Use these for iterating each half of the helper array */
		int helpLeft = low;
		int helpRight = middle + 1;
		int current = low;
		
		/* Compare the left and right, copy the smaller element from the two into the original array */
		while(helpLeft <= middle && helpRight <= high) {
			
			/* left element is less than the right element */
			if(helper[helpLeft] <= helper[helpRight]) {
				nums[current] = helper[helpLeft];
				helpLeft++;
			} 
			
			/* right element is less than the left element */
			else {
				nums[current] = helper[helpRight];
				helpRight++;
			}
			
			current++;
		}
		
		/* Copy whatever is remaining in the left side of the helper array into nums */
		int leftOvers = middle - helpLeft;
		for(int i = 0; i <= leftOvers; i++) {
			nums[current + i] = helper[helpLeft + i];
		}
		
	}
	
	
	public static void mergesort(int[] nums, int[] helper, int low, int high) {
		if(low < high) {
			int mid = (low + high) / 2;
			
			/* Sort left and right halves */
			mergesort(nums, helper, low, mid);
			mergesort(nums, helper, mid + 1, high);
			
			/* Merge the sorted halves */
			merge(nums, helper, low, high);
		}
	}
	
	/* Creates an int array of specified length filled with random values between min and max */
	public static int[] createRandomArray(int length, int min, int max) {
		int result[] = new int[length];
		Random random = new Random();
		
		for(int i = 0; i < length; i++)
			result[i] = random.nextInt(max - min) + min;
		
		return result;
	}

}
