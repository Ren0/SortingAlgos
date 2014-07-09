package sortingalgos;
/**
 * 
 * General idea:
 * Choose a pivot element
 * Every element less than the pivot is moved to the left of the pivot (the left partition)
 * Every element greater than the pivot is moved to the right of the pivot (the right partition)
 * Recursively quicksort the left and right partitions
 * 
 * Implementation:
 * Two cursors iterates through the array:
 * - i moving rightward, starting from zero. The i cursor stops whenever the value array[i] is greater than the pivot
 * - j moving leftward, starting from the end of the array. The j cursor stops whenever the value array[j] is smaller than the pivot
 * 
 *  At this points the two element array[i] and array[j] are swapped
 *  
 *  Then the leftward and rightward iterations resume where they left off and swapping happens again whenever necessary
 *  When the two cursors meet each other (i=j), then all elements smaller than the pivot are on the left side of the partition, and all elements greater than the pivot are on the right side of the partition.
 *  
 *  Then recursively apply the above quicksort logic to the left partition and the right partition  
 *
 */

public class QuickSort implements SortingAlgo {
	private final static String ALGO_NAME= "QuickSort";
	private int[] numbers;
	
	public String getAlgoName() {
		return ALGO_NAME;
	}
	
	public QuickSort(int[] numbers) {
		if(numbers == null || numbers.length == 0) throw new IllegalArgumentException("Empty array passed");
		this.numbers = numbers;
	};
	
	public int[] sort() {
		return quicksort(0, this.numbers.length - 1);
	}

	private int[] quicksort(int low, int high) {
		int i = low, j = high;
		// Get the pivot element from the middle of the list
		int pivot = numbers[low + (high - low) / 2];

		// Divide into two lists
		while (i <= j) {
			// If the current value from the left list is smaller then the pivot
			// element then get the next element from the left list
			while (numbers[i] < pivot) {
				i++;
			}
			// If the current value from the right list is larger then the pivot
			// element then get the next element from the right list
			while (numbers[j] > pivot) {
				j--;
			}

			// If we have found a values in the left list which is larger then
			// the pivot element and if we have found a value in the right list
			// which is smaller then the pivot element then we exchange the
			// values.
			// As we are done we can increase i and j
			if (i <= j) {
				swap(i, j);
				i++;
				j--;
			}
		}
		// Recursion
		if (low < j)
			quicksort(low, j);
		if (i < high)
			quicksort(i, high);
		
		return numbers;
	}

	private void swap(int i, int j) {
		int temp = numbers[i];
		numbers[i] = numbers[j];
		numbers[j] = temp;
	}

}



