package algorithms.implementations;

public class UnionFind {
	private int size;
	private int numComponents;
	private int[] ids;
	private int[] componentSize;
	
	public UnionFind(int size) {
		this.size = numComponents = size;
		
		this.ids = new int[size];
		this.componentSize = new int[size];
		
		for(int i = 0; i < size; i++) {
			ids[i] = i;
			componentSize[i] = 1;
		}
	}
	
	public int find(int k) {
		int root = k;
		
		while(root != ids[root]) {
			root = ids[root];
		}
		
		while(k != root) {
			int parent = ids[k];
			ids[k] = root;
			k = parent;
		}
		
		return root;
	}
	
	public boolean connected(int k, int l) {
		return find(l) == find(k);
	}
	
	public int componentSize(int k) {
		return componentSize[find(k)];
	}
	
	public int numComponents() {
		return numComponents;
	}
	
	public void unify(int k, int l) {
		int rootK = find(k);
		int rootL = find(l);
		
		if(rootK == rootL) return;
		
		ids[rootK] = rootL;
		componentSize[rootL] += componentSize[rootK];
		
		numComponents--;
	}
	
	public int size() {
		return size;
	}
}
