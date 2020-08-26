package test;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import algorithms.implementations.DynamicArray;

class DynamicArrayTests {

	@Test
	void test_add() {
		int expectedSize = 5;
		DynamicArray<Integer> da = new DynamicArray<Integer>(4);
		
		da.add(45);
		da.add(25);
		da.add(68);
		da.add(48);
		da.add(14);
		
		assertEquals(expectedSize, da.size());
		assertEquals(25, (int) da.get(1));
	}
	
	@Test
	void test_remove() {
		int expectedSize = 2;
		DynamicArray<Integer> da = new DynamicArray<Integer>();
		
		da.add(45);
		da.add(25);
		da.add(68);
		da.remove(45);
		
		assertEquals(expectedSize, da.size());
		assertEquals(68, (int) da.get(1));
	}
	
	@Test
	void throws_outofboundsexception_when_requesting_higher_than_index() {
		DynamicArray<Integer> da = new DynamicArray<Integer>();
		
		da.add(45);
		da.add(25);
		
		assertThrows(IndexOutOfBoundsException.class, () -> {
			da.get(2);
		});
	}
	
	@Test
	void should_return_true_if_array_contains_item() {
		DynamicArray<Integer> da = new DynamicArray<Integer>();
		
		da.add(45);
		
		assertTrue(da.contains(45));
	}
	
	@Test
	void should_return_false_if_array_contains_item() {
		DynamicArray<Integer> da = new DynamicArray<Integer>();
		
		da.add(45);
		
		assertFalse(da.contains(20));
	}
	
	@Test
	void should_clear_all_items_from_array() {
		DynamicArray<Integer> da = new DynamicArray<Integer>();
		
		da.add(45);
		
		da.clear();
		
		assertEquals(0, da.size());
	}
	
	@Test
	void should_return_true_if_array_is_empty() {
		DynamicArray<Integer> da = new DynamicArray<Integer>();
		
		assertTrue(da.isEmpty());
	}
	
	@Test
	void should_add_object_to_appropriate_index() {
		DynamicArray<Integer> da = new DynamicArray<Integer>();
		
		da.add(45);
		da.add(25);
		da.add(68);
		da.add(22, 1);
		
		assertEquals(22, (int) da.get(1));
		assertEquals(25, (int) da.get(2));
	}

}
