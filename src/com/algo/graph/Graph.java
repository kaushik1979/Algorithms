package com.algo.graph;

import java.util.Collection;
import java.util.LinkedList;
import java.util.Queue;

import com.algo.Pair;


/**
 * A Graph is a data-structure containing vertices and edges to reach to the adjacent vertex<br>
 * Every Graph element will contain the vertex and edges to other vertex that can be reached from current vertex
 * 
 * <V, E>
 * @author priyankasharma
 *
 */
public class Graph<V extends Comparable<?>> {
	// field to indicate the vertex itself
	Node<V> source;
	
	public Graph(){}
	
	public void setSource(Node<V> source) {
		if(this.source == null) this.source = source;
	}
	
	public void addEdge(Node<V> parent, Node<V> edge) throws Throwable {
		if(this.source == null) throw new Throwable("Vertex is not set. Can not assign Edge to non existing graph vertex.");
		
		parent.adjcacency_list.add(edge);
	}
	
	public Node<V> BFS(Node<V> target) {
		Node<V> found_target = null;
		
		// mark the visited nodes as visited so that you dont revisit
		source.setVisited(true);
		
		// dequeue the head and enqueue the child of visited nodes
		Queue<Node<V>> queue = new LinkedList<>();
		queue.add(source);
		
		// now iterate until queue is empty
		while(!queue.isEmpty()) {
			
			// dequeue the head
			Node<V> current = queue.poll();
			current.setVisited(true);
			System.out.println(current.getVertex());
			
			if(current.compareTo(target) == 0) {
				found_target = target;
				System.out.println("Found through BFS - " + found_target);
				break;
			}
			
			// enqueue the children/adjcacency_list
			queue.addAll(current.getAdjcacency_list());
		}
		
		return found_target;
	}
	
	public boolean isMazeExit(Node<V> target) {
		Node<V> found_target = null;
		
		// mark the visited nodes as visited so that you dont revisit
		source.setVisited(true);
		
		// dequeue the head and enqueue the child of visited nodes
		Queue<Node<V>> queue = new LinkedList<>();
		queue.add(source);
		
		// now iterate until queue is empty
		while(!queue.isEmpty()) {
			// dequeue the head
			Node<V> current = queue.poll();
			current.setVisited(true);
			System.out.println(current.getVertex());
			
			if(current.compareTo(target) == 0) {
				found_target = current;
				System.out.println("Found through BFS - " + found_target);
				break;
			}
			
			// enqueue the children/adjcacency_list
			queue.addAll(current.getAdjcacency_list());
		}
		
		System.out.println(found_target != null && found_target.maze_val? "Found exit through - " + found_target : "No exit through - " + target);
				
		return found_target != null && found_target.maze_val;
	}
	
	
	/**
	 * Dijkta's Algorithm
	 * Mark all the nodes except the source and target with infinity distance
	 * assign source and target 0 distance
	 * now perform BFS and sum-up distances through every possible neighbour for every node
	 * update the distance of the node if you fond a shorter one else continue
	 * @param target
	 * @return
	 */
	public Integer shortestPath(Node<V> target) {
		// set the distance for source and target 0
		// target.distance = 0;
		this.source.distance = 0;
		
		// starting from adjacent nodes of source, set all distances -1 now
		Queue<Node<V>> queue = new LinkedList<>();
		queue.addAll(this.source.adjcacency_list);
		
		while(!queue.isEmpty()) {
			Node<V> node = queue.poll();
			queue.addAll(node.adjcacency_list);
			
			node.distance = -1;
		}
		
		// let us perform BFS again and set the distances to minimum for all possible paths
		queue.addAll(source.adjcacency_list);
		while(!queue.isEmpty()) {
			Node<V> node = queue.poll();
			queue.addAll(node.adjcacency_list);
			
			// update target reference so that we get it in the result
			if(target.equals(node)) {
				target = node;
			}
			
			// <<node_1, node_2>, 1>
			// <<node_6, node_10>, 4>, <<node_7, node_10>, 5>
			Collection<Pair<Pair<Node<V>, Node<V>>, Integer>> side_pairs = node.side_length;
			for(Pair<Pair<Node<V>, Node<V>>, Integer> side_pair : side_pairs) {
				Pair<Node<V>, Node<V>> nodes = side_pair.getV1();
				Integer side_length = side_pair.getV2();
				Integer distance_tmp = nodes.getV1().distance + side_length;
				
				if(nodes.getV2().distance == -1) nodes.getV2().distance = distance_tmp;
				else {
					if(nodes.getV2().distance > distance_tmp) nodes.getV2().distance = distance_tmp;
				}
			}
		}
		
		return target.distance;
	}
}
