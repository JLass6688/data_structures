package test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import algorithms.implementations.Sort;

public class SortTests {
	@Test
	public void test_bubbleSort() {
		int[] test = getPopulatedArrayWithIntegers();
		Sort.bubbleSort(test);
		
		assertEquals(1 , test[0]);
		assertEquals(2 , test[1]);
		assertEquals(3 , test[2]);
		assertEquals(9 , test[3]);
		assertEquals(12 , test[4]);
		assertEquals(15 , test[5]);
		assertEquals(16 , test[6]);
		assertEquals(18 , test[7]);
	}
	
	@Test
	public void test_selectionSort() {
		int[] test = getPopulatedArrayWithIntegers();
		Sort.selectionSort(test);
		
		assertEquals(1 , test[0]);
		assertEquals(2 , test[1]);
		assertEquals(3 , test[2]);
		assertEquals(9 , test[3]);
		assertEquals(12 , test[4]);
		assertEquals(15 , test[5]);
		assertEquals(16 , test[6]);
		assertEquals(18 , test[7]);
	}
	
	@Test
	public void test_insertionSort() {
		int[] test = getPopulatedArrayWithIntegers();
		Sort.insertionSort(test);
		
		assertEquals(1 , test[0]);
		assertEquals(2 , test[1]);
		assertEquals(3 , test[2]);
		assertEquals(9 , test[3]);
		assertEquals(12 , test[4]);
		assertEquals(15 , test[5]);
		assertEquals(16 , test[6]);
		assertEquals(18 , test[7]);
	}
	
	@Test
	public void test_quickSort() {
		int[] test = getPopulatedArrayWithIntegers();
		Sort.quickSort(test);
		
		assertEquals(1 , test[0]);
		assertEquals(2 , test[1]);
		assertEquals(3 , test[2]);
		assertEquals(9 , test[3]);
		assertEquals(12 , test[4]);
		assertEquals(15 , test[5]);
		assertEquals(16 , test[6]);
		assertEquals(18 , test[7]);
	}
	
	@Test
	public void test_mergeSort() {
		int[] test = getPopulatedArrayWithIntegers();
		int[] result = Sort.mergeSort(test);
		
		assertEquals(1 , result[0]);
		assertEquals(2 , result[1]);
		assertEquals(3 , result[2]);
		assertEquals(9 , result[3]);
		assertEquals(12 , result[4]);
		assertEquals(15 , result[5]);
		assertEquals(16 , result[6]);
		assertEquals(18 , result[7]);
	}
	
	private int[] getPopulatedArrayWithIntegers() {
		return new int[] {3,9,15,2,12,18,16,1};
	}
}
