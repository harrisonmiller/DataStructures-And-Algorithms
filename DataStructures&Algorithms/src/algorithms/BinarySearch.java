package algorithms;

/* 
 * Recursive Binary Search Implementation
 * Worst Case Runtime: O(logn)
 * Average Case Runtime: O(logn)
 * Best Case Runtime: O(1)
 */
public class BinarySearch {

	public static void main(String[] args) {
		
		int testArray[] = { -12, -4, 0, 1, 96, 108, 115 };
		int start = 0, end = testArray.length, target = 0;
		int targetIndex = search(testArray, target, start, end);

		for(int i = 0; i < testArray.length; i++) {
			System.out.print(testArray[i] + " ");
		}
		
		System.out.println("\nTarget: " + target + "\nTarget Index: " + targetIndex);
		
	}

	public static int search(int[] nums, int target, int start, int end) {
		if(end >= start) {
			
			/* Use this instead of (start + end) / 2 to handle overflow */
			int midPoint = start + (end - start) / 2;
			
			/* if the midpoint is the target number, return it */
			if(nums[midPoint] == target)
				return midPoint;
			
			/* if the midpoint > target, search the lower half of the array */
			else if(nums[midPoint] > target)
				return search(nums, target, start, midPoint - 1);
			
			/* if the midpoint < target, search the higher half of the array */
			else if(nums[midPoint] < target)
				return search(nums, target, midPoint + 1, end);
		}
		
		return -1;
	}
}