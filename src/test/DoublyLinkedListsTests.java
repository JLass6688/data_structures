package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.HashSet;
import java.util.LinkedHashSet;

import org.junit.Test;

import algorithms.implementations.DoublyLinkedList;

public class DoublyLinkedListsTests {

	@Test
	public void test_add() {
		String item = "test_string";
		int listSize = 5;

		DoublyLinkedList<String> testList = getPopulatedTestList(listSize);
		
		testList.add(item);
		
		assertEquals(listSize + 1, testList.size());
	}
	
	@Test
	public void test_insert() {
		String expected = "test_string";
		String expected2 = "item_2";
		String expected3 = "item_3";

		DoublyLinkedList<String> testList = getPopulatedTestList(5);
		
		testList.add(3, expected);
		
		assertEquals(expected, testList.get(3));
		assertEquals(expected2, testList.get(2));
		assertEquals(expected3, testList.get(4));
	}
	
	@Test
	public void test_addAll() {
		int expected = 8;
		HashSet<String> testSet = getPopulatedCollection(3);
		DoublyLinkedList<String> testList = getPopulatedTestList(5);
		
		testList.addAll(testSet);
		
		assertEquals(expected, testList.size());
	}
	
	@Test
	public void test_insertAll() {
		int expected = 8;
		String expected2 = "set_0";
		String expected3 = "item_4";

		HashSet<String> testSet = getPopulatedCollection(3);
		DoublyLinkedList<String> testList = getPopulatedTestList(5);
		
		testList.addAll(3, testSet);
		
		assertEquals(expected, testList.size());
		assertEquals(expected2, testList.get(3));
		assertEquals(expected3, testList.getLast());
	}
	
	@Test
	public void test_addFirst() {
		String expected = "new_item";
		
		DoublyLinkedList<String> testList = getPopulatedTestList(5);
		
		testList.addFirst(expected);
		
		assertEquals(expected, testList.getFirst());
	}
	
	@Test
	public void test_addLast() {
		String expected = "new_item";
		
		DoublyLinkedList<String> testList = getPopulatedTestList(5);
		
		testList.addLast(expected);
		
		assertEquals(expected, testList.getLast());
	}
	
	@Test
	public void test_contains() {
		String test_string = "item_2";
		String test_string2 = "item_9000";
		
		DoublyLinkedList<String> testList = getPopulatedTestList(5);
		
		assertTrue(testList.contains(test_string));
		assertFalse(testList.contains(test_string2));
	}
	
	@Test
	public void test_get() {
		String expected = "item_2";
		String expected2 = "item_4";
		
		DoublyLinkedList<String> testList = getPopulatedTestList(5);
		
		assertEquals(expected, testList.get(2));
		assertEquals(expected2, testList.get(4));
	}
	
	@Test
	public void test_getFirst() {
		String expected = "item_0";

		DoublyLinkedList<String> testList = getPopulatedTestList(5);
		
		assertEquals(expected, testList.getFirst());
	}
	
	@Test
	public void test_getTail() {
		String expected = "item_4";

		DoublyLinkedList<String> testList = getPopulatedTestList(5);
		
		assertEquals(expected, testList.getLast());
	}
	
	@Test
	public void test_indexOf() {
		int expected = 3;

		DoublyLinkedList<String> testList = getPopulatedTestList(5);
		
		assertEquals(expected, testList.indexOf("item_3"));
	}
	
	@Test
	public void test_remove() {
		String expected = "item_0";
		String expected2 = "item_1";

		DoublyLinkedList<String> testList = getPopulatedTestList(5);
		
		String actual = testList.remove();
		
		assertEquals(expected, actual);
		assertEquals(expected2, testList.getFirst());
	}
	
	@Test
	public void test_removeAtIndex() {
		String expected = "item_3";
		String expected2 = "item_4";

		DoublyLinkedList<String> testList = getPopulatedTestList(5);
		
		String actual = testList.remove(3);
		
		assertEquals(expected, actual);
		assertEquals(expected2, testList.get(3));
	}
	
	@Test
	public void test_removeAtItem() {
		String expected = "item_4";

		DoublyLinkedList<String> testList = getPopulatedTestList(5);
		
		assertTrue(testList.remove("item_3"));
		assertEquals(expected, testList.get(3));
	}
	
	@Test
	public void test_removeLast() {
		String expected = "item_4";
		String expected2 = "item_3";

		DoublyLinkedList<String> testList = getPopulatedTestList(5);
		
		String actual = testList.removeLast();
		
		assertEquals(expected, actual);
		assertEquals(expected2, testList.getLast());
	}
	
	@Test
	public void test_set() {
		String expected = "item_900";

		DoublyLinkedList<String> testList = getPopulatedTestList(5);
		
		testList.set(3, expected);
		
		assertEquals(expected, testList.get(3));
	}
	
	@Test
	public void test_toArray() {
		Object expected = "item_0";

		DoublyLinkedList<String> testList = getPopulatedTestList(5);
		
		Object[] arr = testList.toArray();
		
		assertEquals(expected, arr[0]);
		assertEquals(testList.size(), arr.length);
	}

	@Test(expected = RuntimeException.class)
	public void should_throw_exception_when_index_exceeds_size() {
		DoublyLinkedList<String> testList = getPopulatedTestList(2);
		testList.add(8, "test_string");
	}

	
	private DoublyLinkedList<String> getPopulatedTestList(int size) {
		String test_string_base = "item";
		DoublyLinkedList<String> list = new DoublyLinkedList<String>();
		
		for(int i = 0; i < size; i++) {
			String test_string_iteration = test_string_base + "_" + i;
			list.add(test_string_iteration);
		}
		
		return list;
	}
	
	private LinkedHashSet<String> getPopulatedCollection(int size) {
		LinkedHashSet<String> testSet = new LinkedHashSet<String>();
		String test_base_string = "set";
		
		for(int i = 0; i < size; i++) {
			String test_string_iteration = test_base_string + "_" + i;
			testSet.add(test_string_iteration);
		}
		
		return testSet;
	}
}
