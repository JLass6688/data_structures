package test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import algorithms.implementations.Graph;

public class GraphTests {
	@Test
	public void tests_min_spanning_tree_algorithm() {
		Graph g = new Graph(6, 10);
		
		g.addEdge(0, 4, 0);
		g.addEdge(4, 3, 4);
		g.addEdge(3, 2, 1);
		g.addEdge(2, 1, 4);
		g.addEdge(1, 0, 2);
		g.addEdge(0, 5, 2);
		g.addEdge(5, 4, 1);
		g.addEdge(5, 3, 2);
		g.addEdge(2, 5, 3);
		g.addEdge(1, 5, 3);
		
		assertEquals(6, g.minimumSpanningTree());
	}
}
