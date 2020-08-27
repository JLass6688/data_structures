package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import algorithms.implementations.PriorityQueue;

public class PriorityQueueTests {
	
	@Test
	public void test_add() {
		Integer expected = 0;
		PriorityQueue<Integer> testQueue = getPopulatedQueue(5);
		
		testQueue.add(expected);
		
		assertEquals(6, testQueue.size());
		assertEquals(expected, testQueue.peek());
	}
	
	@Test
	public void test_clear() {
		PriorityQueue<Integer> testQueue = getPopulatedQueue(5);
		
		testQueue.clear();
		
		assertEquals(0, testQueue.size());
	}
	
	@Test
	public void test_remove() {
		Integer expected = 2;
		PriorityQueue<Integer> testQueue = getPopulatedQueue(5);
		
		testQueue.remove(1);
		
		assertEquals(4, testQueue.size());
		assertEquals(expected, testQueue.peek());
	}
	
	@Test
	public void test_remove_when_empty() {
		PriorityQueue<Integer> testQueue = new PriorityQueue<Integer>();

		assertFalse(testQueue.remove(5));
	}
	
	@Test
	public void test_remove_when_val_not_present_in_queue() {
		PriorityQueue<Integer> testQueue = getPopulatedQueue(5);

		assertFalse(testQueue.remove(900));
	}

	@Test
	public void test_poll() {
		Integer expected = 1;
		Integer expected2 = 2;

		PriorityQueue<Integer> testQueue = getPopulatedQueue(5);
		
		Integer val = testQueue.poll();
		
		assertEquals(4, testQueue.size());
		assertEquals(expected, val);
		assertEquals(expected2, testQueue.peek());
	}

	@Test
	public void test_poll_when_queue_is_empty() {
		Integer expected = null;

		PriorityQueue<Integer> testQueue = new PriorityQueue<Integer>();
		
		Integer val = testQueue.poll();
		
		assertEquals(expected, val);
	}
	
	@Test
	public void test_size() {
		int expectedSize = 5;
		PriorityQueue<Integer> testQueue = getPopulatedQueue(expectedSize);
		
		assertEquals(expectedSize, testQueue.size());
	}
	
	@Test
	public void test_contains() {
		PriorityQueue<Integer> testQueue = getPopulatedQueue(5);
		
		assertTrue(testQueue.contains(1));
	}
	
	@Test
	public void test_contains_when_value_not_present() {
		PriorityQueue<Integer> testQueue = getPopulatedQueue(5);
		
		assertFalse(testQueue.contains(8));
	}
	
	@Test
	public void test_peek() {
		int expected = 1;
		PriorityQueue<Integer> testQueue = getPopulatedQueue(5);
		
		assertEquals(expected, (int) testQueue.peek());
	}
	
	@Test
	public void test_peek_when_queue_is_empty() {
		Integer expected = null;
		PriorityQueue<Integer> testQueue = new PriorityQueue<Integer>();
		
		assertEquals(expected, testQueue.peek());
	}
	
	private PriorityQueue<Integer> getPopulatedQueue(int size) {
		PriorityQueue<Integer> q = new PriorityQueue<Integer>(size);
		
		for(int i = 1; i <= size; i++) {
			q.add(i);
		}
		
		return q;
	}
	
}
