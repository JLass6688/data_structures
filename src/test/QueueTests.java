package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.NoSuchElementException;

import org.junit.Test;

import algorithms.implementations.Queue;

public class QueueTests {
	
	@Test
	public void test_add() {
		String expected = "test_string";
		Queue<String> testQueue = new Queue<String>();
		
		testQueue.add(expected);
		
		assertEquals(1, testQueue.size());
	}
	
	@Test
	public void test_contains() {
		String expected = "test_string";
		Queue<String> testQueue = new Queue<String>(expected);
		
		assertTrue(testQueue.contains(expected));
	}
	
	@Test
	public void test_element() {
		String expected = "test_string";
		Queue<String> testQueue = new Queue<String>(expected);
		
		assertEquals(expected, testQueue.element());
	}
	
	@Test(expected = NoSuchElementException.class)
	public void should_throw_exception_when_calling_element_on_empty_list() {
		Queue<String> testQueue = new Queue<String>();
		testQueue.element();
	}
	
	@Test
	public void test_offer() {
		String expected = "test_string";
		Queue<String> testQueue = new Queue<String>();
		
		testQueue.offer(expected);
		
		assertEquals(1, testQueue.size());
	}
	
	@Test
	public void test_peek() {
		String expected = "test_string";
		Queue<String> testQueue = new Queue<String>(expected);

		assertEquals(expected, testQueue.peek());
		assertEquals(1, testQueue.size());
	}
	
	@Test
	public void test_peek_when_empty() {
		Queue<String> testQueue = new Queue<String>();

		assertEquals(null, testQueue.peek());
	}
	
	@Test
	public void test_poll() {
		String expected = "item_0";
		
		Queue<String> testQueue = getPopulatedQueue(5);
		
		assertEquals(expected, testQueue.poll());
	}
	
	@Test
	public void test_poll_when_empty() {
		Queue<String> testQueue = new Queue<String>();
		
		assertEquals(null, testQueue.poll());
	}
	
	@Test
	public void test_remove() {
		String expected = "item_0";
		
		Queue<String> testQueue = getPopulatedQueue(5);
		
		assertEquals(expected, testQueue.remove());
	}
	
	@Test(expected = NoSuchElementException.class)
	public void should_throw_exception_when_removing_from_empty_list() {
		Queue<String> testQueue = new Queue<String>();
		testQueue.remove();
	}
	
	@Test
	public void test_size() {
		int expected = 5;
		
		Queue<String> testQueue = getPopulatedQueue(5);
		
		assertEquals(expected, testQueue.size());
	}
	
	private Queue<String> getPopulatedQueue(int size) {
		Queue<String> q = new Queue<String>();
		String base_string = "item";
		
		for(int i = 0; i < size; i++) {
			String indexed_item = base_string + "_" + i;
			q.add(indexed_item);
		}
		
		return q;
	}
}
