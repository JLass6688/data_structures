package test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

import algorithms.implementations.UnionFind;

public class UnionFindTests {
	
	@Test
	public void test_find() {
		int expected = 3;
		int expected2 = 9;
		
		UnionFind uf = getPopulatedUnionFind();
		
		assertEquals(expected, uf.find(1));
		assertEquals(expected2, uf.find(5));
	}
	
	@Test
	public void test_componentSize() {
		int expected = 6;
		
		UnionFind uf = getPopulatedUnionFind();
		
		assertEquals(expected, uf.componentSize(5));
	}
	
	@Test
	public void test_numComponents() {
		int expected = 2;
		
		UnionFind uf = getPopulatedUnionFind();
		
		assertEquals(expected, uf.numComponents());
	}
	
	@Test
	public void test_connected() {
		UnionFind uf = getPopulatedUnionFind();
		
		assertTrue(uf.connected(4, 8));
		assertFalse(uf.connected(2, 7));
	}
	
	@Test
	public void test_union() {
		int expected = 1;
		int expected2 = 3;

		UnionFind uf = new UnionFind(4);
		
		uf.unify(0, 1);
		uf.unify(2, 3);
		
		assertEquals(expected, uf.find(0));
		assertEquals(expected2, uf.find(2));
	}
	
	@Test
	public void test_size() {
		int expected = 10;
		
		UnionFind uf = getPopulatedUnionFind();
		
		assertEquals(expected, uf.size());
	}
	
	public UnionFind getPopulatedUnionFind() {
		UnionFind uf = new UnionFind(10);
		
		uf.unify(0, 1);
		uf.unify(2, 3);
		uf.unify(4, 5);
		uf.unify(6, 7);
		uf.unify(8, 9);
		uf.unify(5, 9);
		uf.unify(6, 9);
		uf.unify(0, 3);
		
		return uf;
	}
}
