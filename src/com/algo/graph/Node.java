package com.algo.graph;

import java.util.Collection;
import java.util.LinkedList;

import com.algo.Pair;

/**
 * Represents each element in the graph
 * @author priyankasharma
 *
 * @param <V>
 */
@SuppressWarnings("rawtypes")
public class Node<V extends Comparable> implements Comparable<Node<V>> {
	V vertex;
	Boolean visited = false;
	
	boolean maze_val;
	
	Integer distance; // used to store distance of the node from source
	
	Collection<Pair<Pair<Node<V>, Node<V>>, Integer>> side_length = new LinkedList<>();
	
	// a list of vertex which are adjacent to the current vertex. these are also the edges from the current vertex
	// the pair represents whether the node is visited or not in the current graph traversal
	LinkedList<Node<V>> adjcacency_list = new LinkedList<>();
	
	public Node(V vertex) {
		this.vertex = vertex;
		this.maze_val = true;
		
		/**if(vertex instanceof Integer) this.distance = (Integer) vertex;
		else this.distance = 1;**/
	}
	
	public void addChild(Node<V> child) {
		this.adjcacency_list.add(child);
	}
	
	public void setMaze_val(boolean maze_val) {
		this.maze_val = maze_val;
	}

	public V getVertex() {
		return vertex;
	}

	public void setVertex(V vertex) {
		this.vertex = vertex;
	}

	public Boolean getVisited() {
		return visited;
	}

	public void setVisited(Boolean visited) {
		this.visited = visited;
	}

	public LinkedList<Node<V>> getAdjcacency_list() {
		return adjcacency_list;
	}

	public void setAdjcacency_list(LinkedList<Node<V>> adjcacency_list) {
		this.adjcacency_list = adjcacency_list;
	}

	@SuppressWarnings("unchecked")
	@Override
	public int compareTo(Node<V> o) {
		// TODO Auto-generated method stub
		return this.vertex.compareTo(o.getVertex()) ;
	}

	@Override
	public String toString() {
		return "Node [vertex=" + this.vertex + ", distance="+ this.distance +"]";
	}
	
	@Override
	public boolean equals(Object other) {
		if(!(other instanceof Node)) return false;
		
		Node other_1 = (Node) other;
		
		return this.vertex == other_1.vertex;
		
	}
}
