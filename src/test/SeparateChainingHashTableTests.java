package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

import java.util.Set;

import org.junit.Test;

import algorithms.implementations.Entry;
import algorithms.implementations.SeparateChainingHashTable;

public class SeparateChainingHashTableTests {

	@Test
	public void test_clear() {
		int expectedSize = 0;

		SeparateChainingHashTable<String,String> table = getPopulatedTable(5);
		table.clear();

		assertEquals(expectedSize, table.size());
	}
	
	@Test
	public void test_containsKey_when_key_is_present() {
		SeparateChainingHashTable<String,String> table = getPopulatedTable(5);
		
		assertTrue(table.containsKey("Key_0"));
		assertTrue(table.containsKey("Key_1"));
		assertTrue(table.containsKey("Key_2"));
		assertTrue(table.containsKey("Key_3"));
		assertTrue(table.containsKey("Key_4"));
	}
	
	@Test
	public void test_containsKey_when_key_is_not_present() {
		SeparateChainingHashTable<String,String> table = getPopulatedTable(5);
		
		assertFalse(table.containsKey("Key_99"));
	}
	
	@Test
	public void test_entrySet() {
		int expectedSize = 5;
		
		SeparateChainingHashTable<String,String> table = getPopulatedTable(expectedSize);
		Set<Entry<String,String>> es = table.entrySet();

		assertEquals(expectedSize, es.size());
	}
	
	@Test
	public void test_get_when_key_is_present() {
		String expected = "Value_2";
		
		SeparateChainingHashTable<String,String> table = getPopulatedTable(5);

		assertEquals(expected, table.get("Key_2"));
	}
	
	@Test
	public void test_get_when_key_is_not_present() {
		String expected = null;
		
		SeparateChainingHashTable<String,String> table = getPopulatedTable(5);

		assertEquals(expected, table.get("Key_99"));
	}
	
	@Test
	public void test_isEmpty() {
		SeparateChainingHashTable<String,String> table = new SeparateChainingHashTable<String,String>();
		
		assertTrue(table.isEmpty());
	}
	
	@Test
	public void test_put_new_entry() {
		String expected = null;
		int expectedSize = 6;
		
		SeparateChainingHashTable<String,String> table = getPopulatedTable(5);
		
		assertEquals(expected, table.put("Key_99", "Value_99"));
		assertEquals(expectedSize, table.size());
		assertTrue(table.containsKey("Key_99"));
	}
	
	@Test
	public void test_put_existing_key_different_value() {
		String expected1 = "Value_2";
		String expected2 = "Value_99";
		int expectedSize = 5;
		
		SeparateChainingHashTable<String,String> table = getPopulatedTable(5);
		
		assertEquals(expected1, table.put("Key_2", "Value_99"));
		assertEquals(expectedSize, table.size());
		assertEquals(expected2, table.get("Key_2"));
	}
	
	@Test
	public void test_remove() {
		String expected1 = "Value_2";
		String expected2 = null;
		int expectedSize = 4;
		
		SeparateChainingHashTable<String,String> table = getPopulatedTable(5);
		
		assertEquals(expected1, table.remove("Key_2"));
		assertEquals(expectedSize, table.size());
		assertEquals(expected2, table.get("Key_2"));
	}
	
	@Test
	public void test_remove_when_key_doesnt_exist() {
		String expected = null;
		
		SeparateChainingHashTable<String,String> table = getPopulatedTable(5);
		
		assertEquals(expected, table.remove("Key_99"));
	}
	
	@Test
	public void test_size() {
		int expectedSize = 5;
		
		SeparateChainingHashTable<String,String> table = getPopulatedTable(expectedSize);

		assertEquals(expectedSize, table.size());
	}
	
	private SeparateChainingHashTable<String,String> getPopulatedTable(int size) {
		SeparateChainingHashTable<String,String> table = new SeparateChainingHashTable<String,String>(5);
		
		String base_key = "Key_";
		String base_val = "Value_";
		
		for(int i = 0; i < size; i++) {
			String key = base_key + i;
			String val = base_val + i;
			
			table.put(key, val);
		}
		
		return table;
	}
}
