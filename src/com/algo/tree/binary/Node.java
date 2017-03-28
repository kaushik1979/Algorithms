package com.algo.tree.binary;

public class Node<V extends Comparable<V>> {
	
	V value;
	
	boolean is_root = false;
	
	Node<V> left_child;
	Node<V> right_child;
	
	Node<V> parent;
	
	Integer height;
	Integer depth;
	
	public boolean isIs_root() {
		return is_root;
	}
	public void setIs_root(boolean is_root) {
		this.is_root = is_root;
	}
	public Node<V> getLeft_child() {
		return left_child;
	}
	public void setLeft_child(Node<V> left_child) {
		this.left_child = left_child;
	}
	public Node<V> getRight_child() {
		return right_child;
	}
	public void setRight_child(Node<V> right_child) {
		this.right_child = right_child;
	}
	public Integer getHeight() {
		return height;
	}
	public void setHeight(Integer height) {
		this.height = height;
	}
	public Integer getDepth() {
		return depth;
	}
	public void setDepth(Integer depth) {
		this.depth = depth;
	}
	public V getValue() {
		return value;
	}
	public void setValue(V value) {
		this.value = value;
	}
	public Node<V> getParent() {
		return parent;
	}
	public void setParent(Node<V> parent) {
		this.parent = parent;
	}
	@Override
	public String toString() {
		return "Node [value=" + value + ", is_root=" + is_root
				+ ", left_child=" + left_child.getValue() + ", right_child=" + right_child.getValue()
				+ ", height=" + height + ", depth=" + depth + "]";
	}
	
}
