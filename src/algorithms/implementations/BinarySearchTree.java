package algorithms.implementations;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class BinarySearchTree<T extends Comparable<T>> {
	Node rootNode = null;
	private int size = 0;
	
	private class Node {
		public T val;
		public Node left;
		public Node right;
		
		public Node(T val, Node left, Node right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
		
		public Node(T val) {
			this(val, null, null);
		}
		
		public int compareTo(Node n) {
			return val.compareTo(n.val);
		}
	}
	
	public BinarySearchTree() {}
	
	public BinarySearchTree(T val) {
		rootNode = new Node(val, null, null);
		size = 1;
	}
	
	public int size() {
		return size;
	}
	
	public boolean add(T item) {
		if(isEmpty()) {
			rootNode = new Node(item);
			size++;
			return true;
		}
		
		Node itemNode = new Node(item);
		Node trav = rootNode;
		
		return add(itemNode, trav);
	}
	
	public boolean remove(T item) {
		if(! contains(item)) {
			return false;
		}

		rootNode = remove(item, rootNode);
		size--;
		return true;
	}
	
	public boolean contains(T item) {
		Node trav = rootNode;
		
		return contains(item, trav);
	}
	
	public Iterator<T> iterator(TreeTraversalOrder traversal) {
		switch(traversal) {
			case PRE_ORDER:
				return getPreorder();
			case IN_ORDER:
				return getInorder();
			case POST_ORDER:
				return getPostorder();
			case LEVEL_ORDER:
				return getLevelorder();
			default:
				return null;
		}
	}
	
	public boolean isEmpty() {
		return size == 0;
	}
	
	private Iterator<T> getPreorder() {
		Stack<Node> stack = new Stack<Node>();
		stack.push(rootNode);
		
		return new Iterator<T>() {
			@Override
			public boolean hasNext() {
				return rootNode != null && ! stack.empty();
			}
			
			@Override
			public T next() {
				Node next = stack.pop();
				
				if(next.right != null) stack.push(next.right);
				if(next.left != null) stack.push(next.left);
				
				return next.val;
			}
		};
	}
	
	private Iterator<T> getInorder() {
		Stack<Node> stack = new Stack<Node>();
		stack.push(rootNode);
		
		return new Iterator<T>() {
			Node trav = rootNode;

			@Override
			public boolean hasNext() {
				return rootNode != null && ! stack.empty();
			}
			
			@Override
			public T next() {
				while(trav.left != null) {
					stack.push(trav.left);
					trav = trav.left;
				}
				
				Node next = stack.pop();
				
				if(next.right != null) {
					stack.push(next.right);
					trav = next.right;
				}
				
				return next.val;
			}
		};
	}
	
	private Iterator<T> getPostorder() {
		Stack<Node> stack1 = new Stack<Node>();
		Stack<Node> stack2 = new Stack<Node>();
		stack1.push(rootNode);
		
		while(!stack1.empty()) {
			Node next = stack1.pop();
			stack2.push(next);
			if(next.left != null) stack1.push(next.left);
			if(next.right != null) stack1.push(next.right);
		}
		
		return new Iterator<T>() {
			@Override
			public boolean hasNext() {
				return rootNode != null && !stack2.empty();
			}
			
			@Override
			public T next() {
				return stack2.pop().val;
			}
		};
	}
	
	private Iterator<T> getLevelorder() {
		Queue<Node> queue = new LinkedList<Node>();
		queue.add(rootNode);
		
		return new Iterator<T>() {
			@Override
			public boolean hasNext() {
				return rootNode != null && !queue.isEmpty();
			}
			
			@Override
			public T next() {
				Node next = queue.poll();
				
				if(next.left != null) queue.add(next.left);
				if(next.right != null) queue.add(next.right);
				
				return next.val;
			}
		};
	}
	
	
	// {12, 7, 19, 6, 9, 1, 14, 13, 8, 44, 102, 11, 4}
	private boolean add(Node itemNode, Node trav) {
		int comp = itemNode.compareTo(trav);
		
		if(comp < 0) {
			if(trav.left == null) {
				trav.left = itemNode;
			} else {
				return add(itemNode, trav.left);
			}
		} else if(comp > 0) {
			if(trav.right == null) {
				trav.right = itemNode;
			} else {
				return add(itemNode, trav.right);
			}
		} else {
			// Avoid duplicate values
			return false;
		}
		
		size++;
		return true;
	}
	
	private Node remove(T item, Node trav) {
		int comp = item.compareTo(trav.val);
		
		if(comp > 0) {
			trav.right = remove(item, trav.right);
		} else if(comp < 0) {
			trav.left = remove(item, trav.left);
		} else {
			if(trav.right == null) {
				Node replacement = trav.left;
				trav.val = null;
				trav = null;
				return replacement;
			} else if(trav.left == null) {
				Node replacement = trav.right;
				trav.val = null;
				trav = null;
				return replacement;
			} else {
				Node max = findMax(trav.left);
				
				trav.val = max.val;
				
				trav.left = remove(max.val, trav.left);
			}
		}
		
		return trav;
	}
	
	private Node findMax(Node trav) {
		while(trav.right != null) {
			trav = trav.right;
		}
		
		return trav;
	}
	
	private boolean contains(T item, Node trav) {
		if(trav == null) return false;

		int comp = item.compareTo(trav.val);
		
		if(comp < 0) {
			return contains(item, trav.left);
		} else if(comp > 0) {
			return contains(item, trav.right);
		} else {
			return true;
		}
	}

}
