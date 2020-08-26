package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import algorithms.implementations.Stack;

public class StackTests {

	@Test
	public void tests_empty() {
		Stack<String> testStack = new Stack<String>();
		
		assertTrue(testStack.empty());
	}
	
	@Test
	public void tests_peek() {
		String expected = "item_4";

		Stack<String> testStack = getPopulatedStack(5);
		
		assertEquals(expected, testStack.peek());
	}
	
	@Test
	public void tests_pop() {
		String expected = "item_4";
		int expectedSize = 4;

		Stack<String> testStack = getPopulatedStack(5);
		
		assertEquals(expected, testStack.pop());
		assertEquals(expectedSize, testStack.size());
	}
	
	@Test
	public void tests_push() {
		String expected = "test_string";
		int expectedSize = 1;
		
		Stack<String> testStack = new Stack<String>();
		
		testStack.push(expected);
		
		assertEquals(expected, testStack.peek());
		assertEquals(expectedSize, testStack.size());
	}
	
	@Test
	public void tests_search() {
		int expected = 3;
		
		Stack<String> testStack = getPopulatedStack(5);
		
		assertEquals(expected, testStack.search("item_2"));
	}
	
	@Test
	public void tests_size() {
		int expected = 5;
		
		Stack<String> testStack = getPopulatedStack(5);
		
		assertEquals(expected, testStack.size());
	}
	
	private Stack<String> getPopulatedStack(int size) {
		Stack<String> stack = new Stack<String>();
		String base_string = "item";
		
		for(int i = 0; i < size; i++) {
			String indexed_item = base_string + "_" + i;
			stack.push(indexed_item);
		}
		
		return stack;
	}
}
