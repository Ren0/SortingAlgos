package sortingalgostest;
import static org.junit.Assert.fail;

import java.util.Arrays;
import java.util.Random;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;

import sortingalgos.BubbleSort;
import sortingalgos.InsertionSort;
import sortingalgos.MergeSort;
import sortingalgos.QuickSort;

public class SortTest {
	private static int[] numbers;
	private long start;
	private final static int SIZE = 50000;
	private final static int MAX = 100;
	private final static boolean DEBUG = false;
	@Rule public TestName testName = new TestName();

	@BeforeClass
	public static void setUp() throws Exception {
		numbers = new int[SIZE];
		Random generator = new Random();
		for (int i = 0; i < numbers.length; i++) {
			numbers[i] = generator.nextInt(MAX);
		}
		if(DEBUG) printResult(numbers);
	}
	
	@Before
	public void start() {
        start = System.currentTimeMillis();
    }

    @After
    public void end() {
        System.out.println(testName.getMethodName() + ":\t\t " + (System.currentTimeMillis() - start) + " ms");
        if (!validate(numbers)) {
			fail("Should not happen");
		}
        if(DEBUG) printResult(numbers);
    }

	@Test
	public void quickSort() {
		QuickSort sorter = new QuickSort(numbers);
		sorter.sort();
	}

	@Test
	public void bubbleSort() {
		BubbleSort sorter = new BubbleSort(numbers);
		sorter.sort();
	}
	
	@Test
	public void mergeSort() {
		MergeSort sorter = new MergeSort(numbers);
		sorter.sort();
	}
	
	@Test
	public void insertionSort() {
		InsertionSort sorter = new InsertionSort(numbers);
		sorter.sort();
	}

	@Test
	public void javaSort() {
		Arrays.sort(numbers);
	}

	private boolean validate(int[] numbers) {
		for (int i = 0; i < numbers.length - 1; i++) {
			if (numbers[i] > numbers[i + 1]) {
				return false;
			}
		}
		return true;
	}

	private static void printResult(int[] numbers) {
		for (int i = 0; i < numbers.length; i++) {
			System.out.print(numbers[i] + " ");
		}
		System.out.println();
	}
}