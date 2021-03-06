package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Iterator;

import org.junit.Test;

import algorithms.implementations.BinarySearchTree;
import algorithms.implementations.TreeTraversalOrder;

public class BinarySearchTreeTests {
	private int[] testVals = {12, 7, 19, 6, 9, 1, 14, 13, 8, 44, 102, 11, 4};

	@Test
	public void test_size() {
		int expected = testVals.length;
		BinarySearchTree<Integer> tree = getPopulatedTree();
		
		assertEquals(expected, tree.size());
	}

	@Test
	public void test_add() {
		int expected = 2;

		BinarySearchTree<Integer> tree = new BinarySearchTree<Integer>(12);
		tree.add(5);
		
		assertEquals(expected, tree.size());
		assertTrue(tree.contains(5));
	}

	@Test
	public void test_remove() {
		int expected = 1;

		BinarySearchTree<Integer> tree = new BinarySearchTree<Integer>(12);
		tree.add(5);
		tree.remove(12);
		
		assertTrue(tree.contains(5));
		assertFalse(tree.contains(12));
		assertEquals(expected, tree.size());
	}

	@Test
	public void test_contains() {
		BinarySearchTree<Integer> tree = getPopulatedTree();

		assertTrue(tree.contains(testVals[0]));
		assertTrue(tree.contains(testVals[1]));
		assertTrue(tree.contains(testVals[7]));
	}

	@Test
	public void test_isEmpty_true_when_empty() {
		BinarySearchTree<Integer> tree = new BinarySearchTree<Integer>();
		
		assertTrue(tree.isEmpty());
	}
	
	@Test
	public void test_isEmpty_false_when_not_empty() {
		BinarySearchTree<Integer> tree = getPopulatedTree();
		
		assertFalse(tree.isEmpty());
	}
	
	@Test
	public void test_preorder_travseral() {
		BinarySearchTree<Integer> tree = getPopulatedTree();
		Iterator<Integer> it = tree.iterator(TreeTraversalOrder.PRE_ORDER);
		
		assertEquals(12, (int) it.next());
		assertEquals(7, (int) it.next());
		assertEquals(6, (int) it.next());
		assertEquals(1, (int) it.next());
		assertEquals(4, (int) it.next());
		assertEquals(9, (int) it.next());
		assertEquals(8, (int) it.next());
		assertEquals(11, (int) it.next());
		assertEquals(19, (int) it.next());
		assertEquals(14, (int) it.next());
		assertEquals(13, (int) it.next());
		assertEquals(44, (int) it.next());
	}
	
	@Test
	public void test_inorder_traversal() {
		BinarySearchTree<Integer> tree = getPopulatedTree();
		Iterator<Integer> it = tree.iterator(TreeTraversalOrder.IN_ORDER);
		
		assertEquals(1 , (int) it.next());
		assertEquals(4, (int) it.next());
		assertEquals(6, (int) it.next());
		assertEquals(7, (int) it.next());
		assertEquals(8, (int) it.next());
		assertEquals(9, (int) it.next());
		assertEquals(11, (int) it.next());
		assertEquals(12, (int) it.next());
		assertEquals(13, (int) it.next());
		assertEquals(14, (int) it.next());
		assertEquals(19, (int) it.next());
		assertEquals(44, (int) it.next());
	}
	
	@Test
	public void test_postorder_traversal() {
		BinarySearchTree<Integer> tree = getPopulatedTree();
		Iterator<Integer> it = tree.iterator(TreeTraversalOrder.POST_ORDER);
		
		assertEquals(4, (int) it.next());
		assertEquals(1, (int) it.next());
		assertEquals(6, (int) it.next());
		assertEquals(8, (int) it.next());
		assertEquals(11, (int) it.next());
		assertEquals(9, (int) it.next());
		assertEquals(7, (int) it.next());
		assertEquals(13, (int) it.next());
		assertEquals(14, (int) it.next());
		assertEquals(102, (int) it.next());
		assertEquals(44, (int) it.next());
		assertEquals(19, (int) it.next());
	}
	
	@Test
	public void test_levelorder_traversal() {
		BinarySearchTree<Integer> tree = getPopulatedTree();
		Iterator<Integer> it = tree.iterator(TreeTraversalOrder.LEVEL_ORDER);
		
		assertEquals(12, (int) it.next());
		assertEquals(7, (int) it.next());
		assertEquals(19, (int) it.next());
		assertEquals(6, (int) it.next());
		assertEquals(9, (int) it.next());
		assertEquals(14, (int) it.next());
		assertEquals(44, (int) it.next());
		assertEquals(1, (int) it.next());
		assertEquals(8, (int) it.next());
		assertEquals(11, (int) it.next());
		assertEquals(13, (int) it.next());
		assertEquals(102, (int) it.next());
	}
	
	private BinarySearchTree<Integer> getPopulatedTree() {
		BinarySearchTree<Integer> tree = new BinarySearchTree<Integer>();
		
		for(int i = 0; i < testVals.length; i++) {
			tree.add(testVals[i]);
		}
		
		return tree;
	}
}
