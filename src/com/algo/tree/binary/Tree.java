package com.algo.tree.binary;

/**
 * This tree is 
 * <p>(1) Simple binary tree as well as
 * <br><tab> As new elements are inserted, simply follows the comparison model, and inserts the new node in the tree
 * <br><tab> Worst case Algorithm can be O(N), just like a linked-list
 * <p>(2) Balancing binary tree
 * <br><tab> Difference depth of farthest element on left and right subtree can not be more than 1
 * <br><tab> This tree does auto-balancing as the new elements/nodes are inserted in the tree
 * @author priyankasharma
 *
 * @param <V>
 */
public class Tree<V extends Comparable<V>> {
	
	Node<V> root;
	
	boolean is_balancing = false;
	
	public Tree(Node<V> root) {
		this.root = root;
		root.height = 0; // increases by one on adding additional element to either side of the tree (revisit for balanced tree)
		root.depth = 0; // remains the same since root will be highest level node always
	}
	
	public Tree(Node<V> root, boolean is_balancing) {
		this.is_balancing = is_balancing;
		this.root = root;
		root.height = 0; // increases by one on adding additional element to either side of the tree (revisit for balanced tree)
		root.depth = 0; // remains the same since root will be highest level node always
	}
	
	public String addChild(Node<V> node) {
		node.height = 0;
		node.depth = 0;
		this.addChild(root, node);
		
		return "";
	}
	
	public void addChild(Node<V> node_1, Node<V> node) {
		if(node.getValue().compareTo(node_1.getValue()) < 0) {
			if(node_1.getLeft_child() !=null) {
				// REVISIT
				// with every call to addChild on the left-node, root elements goes one level higher, and this node goes one down
				root.height += 1;
				node_1.left_child.height += 1;
				node.depth += 1;
				addChild(node_1.getLeft_child(), node);
			} else {
				node_1.left_child = node;
				
				if(this.is_balancing) node.parent = node_1;
			}
		} else {
			if(node_1.getRight_child() !=null) {
				// REVISIT
				// with every call to addChild on the right-node, root elements goes one level higher, and this node goes one down
				root.height += 1;
				node_1.left_child.height += 1;
				node.depth += 1;
				addChild(node_1.getRight_child(), node);
			} else {
				node_1.right_child = node;
				
				if(this.is_balancing) node.parent = node_1;
			}
		}
		
		return;
	}
	
	/**
	 * mode = in, pre, post
	 * @param mode
	 */
	public void printTree(String mode) {
		switch(mode) {
		case "in" : this.inOrderTraversal(this.root); break;
		case "pre" : this.preOrderTraversal(this.root); break;
		case "post" : this.postOrderTraversal(this.root); break;
			default: break;
		}
	}
	
	public void inOrderTraversal(Node<V> root) {
		if(root == null) return;
		
		// print root, print left-tree, print right-tree
		System.out.println(root.toString());
		inOrderTraversal(root.left_child);
		inOrderTraversal(root.right_child);
		return;
	}
	
	public void preOrderTraversal(Node<V> root) {
		if(root == null) return;
		
		// print left-tree, print root, print right-tree
		preOrderTraversal(root.left_child);
		System.out.println(root.toString());
		preOrderTraversal(root.right_child);
		return;
	}
	
	public void postOrderTraversal(Node<V> root) {
		if(root == null) return;
		
		// print left-tree, print right-tree, print root 
		postOrderTraversal(root.left_child);
		postOrderTraversal(root.right_child);
		System.out.println(root.toString());
		return;
	}
	
	/**
	 * The tree can be rotated on it's node in the clock-wise or anti-clock-wide directions. <br> This can be achieved by 
	 * <br> clock-wise rotation:
	 * <br> (1) left-node of the root gets assigned to the root
	 * <br> (2) right-node of the root gets assigned to the root
	 * <p> To be able to rotate, the child node needs to know the parent-node's reference
	 * @param root
	 */
	public void rotateTheNode(Node<V> node, String clock_or_anti) {
		if(! this.is_balancing) return; // Rotation is not enabled
		
		switch(clock_or_anti) {
		case "clock":
			if(node.left_child == null) return;
			Node<V> parent = node.parent;
			Node<V> left_node = node.left_child;
			Node<V> right_node = node.right_child;
			
			Node<V> parent_left = parent.left_child;
			Node<V> parent_right = parent.right_child;
			
			if(parent_left != null && parent_left.equals(node)) {
				parent.left_child = left_node;
				node.parent = left_node;
			} else if(parent_right != null && parent_right.equals(node)) {
				parent.right_child = left_node;
				node.parent = left_node;
			}
		case "anti":
			if(node.right_child == null) return;
			default: return;
		}
	}

}
