package com.algo.graph;

import com.algo.Pair;


/**
 * This class emulates and generates a simple graph structure storing Integers
 * @author priyankasharma
 * 
 * 0 --------> 1
 * ^ |        .
 * | |     .  
 * 9 |<--.----- 7----6        4
 * | |  .            |       |
 *   |.              |       |
 * | v               |       |
 * 2 -------->  3 --- 8       5
 *
 */
public class SimpleGraphContainer {
	
	private Graph<Integer> graph = new Graph<Integer>();
	
	/** public SimpleGraphContainer() {
		this.graph = Graph.getGraph();
	} **/
	
	
	public void runBFS(Node<Integer> target) {
		this.graph.BFS(target);
	}
	
	public void runMaze(Node<Integer> target) {
		this.graph.isMazeExit(target);
	}
	
	public Integer runShortestDistance(Node<Integer> target) {
		return this.graph.shortestPath(target);
	}
	
	
	public Node<Integer> addSample1() throws Throwable {
		/*
		 source = 1
		 child = 2,3
		 
		 vertex = 2
		 child = 4,5,6
		 
		 vertex = 3
		 child 7
		 
		 vertex = 4
		 child = 8
		 
		 vertex = 5
		 child = 9
		 
		 vertex = 6
		 child = 10
		 */
		
		Node<Integer> source = new Node<Integer>(1);
		this.graph.setSource(source);
		
		Node<Integer> node_2 = new Node<>(2);
		Node<Integer> node_3 = new Node<>(3);
		this.graph.addEdge(source, node_2);
		this.graph.addEdge(source, node_3);
		node_2.side_length.add(new Pair<>(new Pair<>(source, node_2), 1));
		node_3.side_length.add(new Pair<>(new Pair<>(source, node_3), 2));
		
		Node<Integer> node_4 = new Node<>(4);
		Node<Integer> node_5 = new Node<>(5);
		Node<Integer> node_6 = new Node<>(6);
		this.graph.addEdge(node_2, node_4);
		this.graph.addEdge(node_2, node_5);
		this.graph.addEdge(node_2, node_6);
		node_4.setMaze_val(false);
		node_4.side_length.add(new Pair<>(new Pair<>(node_2, node_4), 2));
		node_5.side_length.add(new Pair<>(new Pair<>(node_2, node_5), 3));
		node_6.side_length.add(new Pair<>(new Pair<>(node_2, node_6), 4));
		
		Node<Integer> node_8 = new Node<>(8);
		this.graph.addEdge(node_4, node_8);
		node_8.side_length.add(new Pair<>(new Pair<>(node_4, node_8), 4));
		
		Node<Integer> node_9 = new Node<>(9);
		this.graph.addEdge(node_5, node_9);
		node_9.setMaze_val(false);
		node_9.side_length.add(new Pair<>(new Pair<>(node_5, node_9), 4));
		
		Node<Integer> node_10 = new Node<>(10);
		this.graph.addEdge(node_6, node_10);
		node_10.setMaze_val(false);
		node_10.side_length.add(new Pair<>(new Pair<>(node_6, node_10), 4));
		
		Node<Integer> node_7 = new Node<>(7);
		Node<Integer> node_11 = new Node<>(11);
		this.graph.addEdge(node_3, node_7);
		this.graph.addEdge(node_3, node_11);
		node_11.setMaze_val(false);
		node_7.side_length.add(new Pair<>(new Pair<>(node_3, node_7), 4));
		
		this.graph.addEdge(node_7, node_10);
		node_10.side_length.add(new Pair<>(new Pair<>(node_7, node_10), 1));
		
		Node<Integer> node_12 = new Node<>(12);
		this.graph.addEdge(node_9, node_12);
		node_12.side_length.add(new Pair<>(new Pair<>(node_9, node_12), 3));
		
		return source;
	}
	
	
	public static void main(String... args) {
		try {
			
			SimpleGraphContainer sgc = new SimpleGraphContainer();
			Node<Integer> source = sgc.addSample1();
			Node<Integer> target = new Node<Integer>(2);
			/*sgc.runBFS(target);
			
			System.out.println("/n---------------------/n");
			
			sgc.runMaze(target);*/
			
			target = new Node<Integer>(10);
			System.out.println("Shortest distance is -----> "+sgc.runShortestDistance(target));
			
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}
	
	
}
