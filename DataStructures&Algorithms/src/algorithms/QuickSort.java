package algorithms;

/*
 * Worst Case Runtime: O(n^2)
 * Average Case Runtime: O(nlogn)
 * Best Case Runtime: O(nlogn)
 */

public class QuickSort {
	
	public static void main(String[] args) {
		int[] testArray = MergeSort.createRandomArray(20, 0, 100);
		
		System.out.println("Unsorted Array: ");
		for(int i = 0; i < testArray.length; i++) {
			System.out.print(testArray[i] + " ");
		}
		
		quicksort(testArray, 0, testArray.length - 1);
		
		System.out.println("\nSorted Array: ");
		for(int i = 0; i < testArray.length; i++) {
			System.out.print(testArray[i] + " ");
		}
		
	}
	
	public static void quicksort(int[] nums, int low, int high) {
		if(low < high) {
			int partitionIndex = partition(nums, low, high);
			
			quicksort(nums, low, partitionIndex - 1);
			quicksort(nums, partitionIndex + 1, high);
		}
	}
	
	/* places pivot element in its correct position + places
	 * everything smaller than it to the left and everything
	 * larger to the right 
	 */
	public static int partition(int[] nums, int low, int high) {
		
		/* in this implementation we will pick the last element as the pivot point each time */
		int pivot = nums[high];
		
		/* index for smaller element */
		int i = low - 1;
		
		for(int j = low; j <= high; j++) {
			if(nums[j] < pivot) {
				i++;
				int temp = nums[i];
				nums[i] = nums[j];
				nums[j] = temp;
			}
		}
		
		int temp = nums[i + 1];
		nums[i + 1] = nums[high];
		nums[high] = temp;
		
		return i + 1;
	}
	
}
