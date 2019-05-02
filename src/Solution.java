class Solution {
	private long startTime;
	private long endTime;

	public static void main(String[] args) {
	}

	/*
	 * Performs an optimized bubble sort alogrithm. Bubble sort algorithm bubbles
	 * the largest element to the end of the array by comparing it with the rest of
	 * the array.
	 * 
	 * Steps : 1) start with the first element of the array
	 * 
	 * 2) compare it with it's neighbor
	 * 
	 * 3) if it is greater swap the elements
	 * 
	 * 4) continue
	 * 
	 * 5) when the loop ends we would get the largest element bubbled to the end
	 * 
	 * Best case : O(N) sorted array
	 * 
	 * Worst case : O(N2) unsorted array
	 * 
	 * Average case : O(N2) random array.
	 *
	 * Note : Even though we can see that the time to execute the random array might
	 * be better than the unsorted array it is due to the nature of the array. If
	 * the swaps required are lesser it would take longer time.
	 * 
	 * Some results :
	 * 
	 * Bubble sort of sorted array took 54 milliseconds by doing 0 swaps.
	 * 
	 * Bubble sort of unsorted array took 153 milliseconds by doing 49995000 swaps.
	 * 
	 * Bubble sort of random array took 268 milliseconds by doing 24935963 swaps.
	 */
	public void bubbleSort(int[] array, String typeOfArray) {
		startTimer();

		int swaps = 0;
		boolean swapped = true;
		for (int i = 0; i < array.length; i++) {
			if (!swapped)
				break;
			for (int j = 0; j < array.length - i - 1; j++) {
				if (array[j] > array[j + 1]) {
					// swapping logic
					swapped = true;
					swaps++;
					array[j] = array[j] + array[j + 1];
					array[j + 1] = array[j] - array[j + 1];
					array[j] = array[j] - array[j + 1];
				}
			}

			swapped = true;
		}

		endTimer("Bubble sort of " + typeOfArray + " array took", swaps);
	}

	/*
	 * Performs the selection sort. Its a selecting algorithm. The basic idea is the
	 * keep getting the minimum element of the array and move it to the ith position
	 * and repeat the process.
	 * 
	 * a) start from the i = 0; b) find the minimum element in range [i,length). c)
	 * swap with A[i] and A[min]. d) increment i. e) repeat till i == length.
	 * 
	 * In case of a selection sort the complexity will always be O(N2) because under
	 * any cases we would need to search for the minimum element. The efficiency is
	 * added in terms of the swaps and that can be reduced in case the minimum is
	 * the current element being checked and we can avoid the swap adding some time
	 * saving operation.
	 * 
	 * 
	 * Best case : O(N2) because no matter what we need to go through the entire
	 * array.
	 * 
	 * Worst case : O(N2)
	 * 
	 * Average case : O(N2)
	 * 
	 * Some results for 10,000 elements
	 * 
	 * Selection sort of sorted array took 29 milliseconds by doing 0 swaps
	 * Selection sort of unsorted array took 84 milliseconds by doing 5000 swaps
	 * Selection sort of random array took 190 milliseconds by doing 9993 swaps
	 */
	public void selectionSort(int[] array, String typeOfArray) {
		int min = 0;
		int swaps = 0;
		startTimer();
		for (int i = 0; i < array.length; i++) {
			min = i;
			for (int j = i; j < array.length; j++) {
				if (array[j] < array[min]) {
					min = j;
				}
			}
			// swapping logic adding an optimization to not swap the element if the minimum
			// is the element itself
			if (i != min) {
				swaps++;
				array[i] = array[i] + array[min];
				array[min] = array[i] - array[min];
				array[i] = array[i] - array[min];
			}
		}

		endTimer("Selection sort of " + typeOfArray + " array took", swaps);
	}

	/*
	 * Performs the insertion sort. It's an inserting sorting algorithm. The basic
	 * idea is that the array gets divided into two halves and the left half is
	 * sorted and right half is unsorted. We take and element from the right half
	 * and find the right position for it.
	 * 
	 * a) start from i = 1
	 * 
	 * b) set the value as A[i]. and the value of where the hole is to i.
	 * 
	 * c) while( hole > 0 && A[hole-1] > value) , while the previous element is
	 * greater than the current element move the previous element to the current
	 * position. copying it.
	 * 
	 * d) once the right position is found A[hole] = A[hole+1]
	 * 
	 * e) put the value A[hole] = value.
	 * 
	 * In case of an insertion sort the inner loop decides the complexity.
	 * 
	 * 
	 * Best case : O(N) because no swapping required.
	 * 
	 * Worst case : O(N2)
	 * 
	 * Average case : O(N2)
	 * 
	 * Some results for 10,000 elements
	 * 
	 * insertion sort of sorted array took 0 milliseconds by doing 0 swaps insertion
	 * sort of unsorted array took 88 milliseconds by doing 49995000 swaps insertion
	 * sort of random array took 123 milliseconds by doing 24872824 swaps
	 */
	public void insertionSort(int[] array, String typeOfArray) {
		int swaps = 0;
		startTimer();
		for (int i = 1; i < array.length; i++) {
			int hole = i;
			int value = array[i];
			while (hole > 0 && array[hole - 1] > value) {
				swaps++;
				array[hole] = array[hole - 1];
				hole--;
			}
			array[hole] = value;
		}
		endTimer("insertion sort of " + typeOfArray + " array took", swaps);
	}

	public void quickSort(int[] array, String typeOfArray) {

	}

	private void startTimer() {
		startTime = System.nanoTime();
	}

	private void endTimer(String message, int swaps) {
		endTime = System.nanoTime();
		System.out.println(
				message + " " + (endTime - startTime) / 1000000 + "  milliseconds" + " by doing " + swaps + " swaps");
	}
}