import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.Random;
import java.util.stream.IntStream;

import org.junit.Before;
import org.junit.Test;

/**
 * 
 * Test class for sorting algorithms
 * 
 * @author Mukul Dhariwal
 */
@SuppressWarnings("javadoc")
public class SolutionTest {

	private Solution solution = new Solution();
	private int[] sortedArray;
	private int[] unsortedArray;
	private int[] randomArray;

	@Before
	public void setUp() {
		int size = 10000;
		sortedArray = new int[size];
		for (int i = 0; i < size; i++) {
			sortedArray[i] = i;
		}

		unsortedArray = new int[size];
		for (int i = 0; i < size; i++) {
			unsortedArray[i] = size - i;
		}

		randomArray = randomGenrator(size, 0, size);
	}

	@Test
	public void testBubbleSort() {

		solution.bubbleSort(sortedArray, ArrayType.SORTED);
		assertThat(arrayIsSorted(sortedArray), is(true));

		solution.bubbleSort(unsortedArray, ArrayType.UNSORTED);
		assertThat(arrayIsSorted(unsortedArray), is(true));

		solution.bubbleSort(randomArray, ArrayType.RANDOM);
		assertThat(arrayIsSorted(randomArray), is(true));
	}

	@Test
	public void testSelectionSort() {

		solution.selectionSort(sortedArray, ArrayType.SORTED);
		assertThat(arrayIsSorted(sortedArray), is(true));

		solution.selectionSort(unsortedArray, ArrayType.UNSORTED);
		assertThat(arrayIsSorted(unsortedArray), is(true));

		solution.selectionSort(randomArray, ArrayType.RANDOM);
		assertThat(arrayIsSorted(randomArray), is(true));
	}

	@Test
	public void testInsertionSort() {

		solution.insertionSort(sortedArray, ArrayType.SORTED);
		assertThat(arrayIsSorted(sortedArray), is(true));

		solution.insertionSort(unsortedArray, ArrayType.UNSORTED);
		assertThat(arrayIsSorted(unsortedArray), is(true));

		solution.insertionSort(randomArray, ArrayType.RANDOM);
		assertThat(arrayIsSorted(randomArray), is(true));
	}

	private boolean arrayIsSorted(int[] sortedArray) {

		for (int i = 0; i < sortedArray.length - 1; i++) {
			if (sortedArray[i] > sortedArray[i + 1]) {
				return false;
			}
		}
		return true;
	}

	@SuppressWarnings("unused")
	private int[] randomGenrator(int size, int lowerBound, int upperBound) {
		Random random = new Random();
		IntStream ints = random.ints(size, lowerBound, upperBound);
		int[] list = new int[size + 1];
		int index = 0;
		return ints.toArray();
	}

	interface ArrayType {
		String SORTED = "sorted";
		String UNSORTED = "unsorted";
		String RANDOM = "random";
	}
}