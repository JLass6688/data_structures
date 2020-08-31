package algorithms.implementations;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
pipes = {
    'plant': {'A': 1, 'B': 5, 'C': 20},
    'A': {'C': 15},
    'B': {'C': 10},
    'C': {}
}
 */

public class Graph {
	private class Edge implements Comparable<Edge> {
		public int source;
		public int dest;
		public Integer weight;
		
		public Edge(int source, int dest, int weight) {
			this.source = source;
			this.dest = dest;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge edge) {
			return weight.compareTo(edge.weight);
		}
	}
	
	int V;
	int E;
	List<Edge> edges;

	public Graph(int V, int E) {
		this.V = V;
		this.E = E;
		edges = new ArrayList<Edge>(E);
	};
	
	public boolean addEdge(int source, int dest, int weight) {
		Edge edge = new Edge(source, dest, weight);
	
		edges.add(edge);

		return true;
	}
	
	public int minimumSpanningTree() {
		Collections.sort(edges);
		
		UnionFind uf = new UnionFind(V);
		
		int edgeTotal = 0;
		
		for(Edge edge : edges) {
			int v1 = edge.source;
			int v2 = edge.dest;
			
			if(! uf.connected(v1, v2)) {
				edgeTotal += edge.weight;
				uf.unify(v1, v2);
			}
		}
		
		return edgeTotal;
		
	}
	
	public int getVerticeCount() {
		return V;
	}
	
	public int getEdgeCount() {
		return E;
	}
}
