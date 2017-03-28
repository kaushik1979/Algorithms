package com.algo.chessboard;

import java.util.Collection;
import java.util.LinkedList;

import com.algo.Pair;

/**
 * A ChessBoardNode identifies all the nodes which will have a 0 or 1 value depending on whether the piece can ever get to it.
 * All of these nodes can be initialized with 0 to start with or they can have the value set to 1 upfront.
 * 
 * (1) 1 King - 1 move in any direction
 * (2) 1 Queen - Can move as many in one direction - be it sidewise, front, or the corners
 * (3) 2 Rooks - Can move as many forward, backward, or sideways only
 * (4) 2 Knight - 2 moves forward or sideways and one move to the 90 degree
 * (5) 2 Bishops - as many moves in the diagonal direction
 * (6) 8 Pawns - one step always in forward direction, except when attacking it goes diagonally one step to attack<p>
 * 
 *  ________________________________________
 *  | 07 | 17 | 27 | 37 | 47 | 57 | 67 | 77 |
 *  ________________________________________
 *  | 06 | 16 | 26 | 36 | 46 | 56 | 66 | 76 |
 *  ________________________________________
 *  | 05 | 15 | 25 | 35 | 45 | 55 | 65 | 75 |
 *  ________________________________________
 *  | 04 | 14 | 24 | 34 | 44 | 54 | 64 | 74 |
 *  ________________________________________
 *  | 03 | 13 | 23 | 33 | 43 | 53 | 63 | 73 |
 *  ________________________________________
 *  | 02 | 12 | 22 | 32 | 42 | 52 | 62 | 72 |
 *  ________________________________________
 *  | 01 | 11 | 21 | 31 | 41 | 51 | 61 | 71 |
 *  ________________________________________
 *  | 00 | 10 | 20 | 30 | 40 | 50 | 60 | 70 |
 *  ________________________________________
 *  
 * @author priyankasharma
 *
 */
public class ChessBoardNode {
	
	boolean val = false;
	
	Integer distance;
	
	Pair<Integer, Integer> coordinates;
	
	Collection<Pair<Pair<ChessBoardNode, ChessBoardNode>, Integer>> side_length = new LinkedList<>();
	
	LinkedList<ChessBoardNode> adjcacency_list = new LinkedList<>();
	
	public ChessBoardNode(Pair<Integer, Integer> coordinates) {
		this.val = false;
		this.distance = -1;
		
		this.coordinates = coordinates;
		
		init();
	}
	
	public ChessBoardNode(Pair<Integer, Integer> coordinates, boolean val) {
		this.val = val;
		this.distance = -1;
		
		this.coordinates = coordinates;
		
		init();
	}
	
	
	/**
	 *  -------------
	 * |   |    |    |
	 *  -------------
	 * |   | XY  |   |
	 *  -------------
	 * |   |    |    |
	 *  -------------
	 *  <p> Based on where the XY coordinate is on the chessboard, we can determine the<br>
	 *  (1) 8 neighbors if it is in the middle of chessboard <br>
	 *  (2) 3 neighbors if it is at the corner of the chessboard<br>
	 *  (3) 5 neighbors if it is at the edges of the chessboard but not at the corners
	 */
	private void init() {
		// let us add the adjacency nodes here
		Integer x = coordinates.getV1();
		Integer y = coordinates.getV2();
		
		if( (y == 0 || y == 7) && (x == 0 || x == 7) ) { // these are the four corners
			// 3 adjacent nodes possible (three more sets write bellow(
			ChessBoardNode cbn_t = new ChessBoardNode(new Pair<>(1, 0));
			this.adjcacency_list.add(cbn_t);
			
			cbn_t = new ChessBoardNode(new Pair<>(0, 1));
			this.adjcacency_list.add(cbn_t);
			
			cbn_t = new ChessBoardNode(new Pair<>(1, 1));
			this.adjcacency_list.add(cbn_t);
			
		} else if( (y == 0 || y == 7) && 0 < x && x < 7 || (x == 0 || x == 7) && 0 < y && y < 7  ) { // these are the edges
			// 5 adjacent nodes possible
			if(y == 0) {
				// y can not go negative
				ChessBoardNode cbn_t = new ChessBoardNode(new Pair<>(x-1, y));
				this.adjcacency_list.add(cbn_t);
				
				cbn_t = new ChessBoardNode(new Pair<>(x+1, y));
				this.adjcacency_list.add(cbn_t);
				
				cbn_t = new ChessBoardNode(new Pair<>(x, y+1));
				this.adjcacency_list.add(cbn_t);
				
				cbn_t = new ChessBoardNode(new Pair<>(x-1, y+1));
				this.adjcacency_list.add(cbn_t);
				
				cbn_t = new ChessBoardNode(new Pair<>(x+1, y+1));
				this.adjcacency_list.add(cbn_t);
			} else if(x == 0) {
				// x can not go negative
				ChessBoardNode cbn_t = new ChessBoardNode(new Pair<>(x, y+1));
				this.adjcacency_list.add(cbn_t);
				
				cbn_t = new ChessBoardNode(new Pair<>(x, y-1));
				this.adjcacency_list.add(cbn_t);
				
				cbn_t = new ChessBoardNode(new Pair<>(x+1, y));
				this.adjcacency_list.add(cbn_t);
				
				cbn_t = new ChessBoardNode(new Pair<>(x+1, y+1));
				this.adjcacency_list.add(cbn_t);
				
				cbn_t = new ChessBoardNode(new Pair<>(x+1, y-1));
				this.adjcacency_list.add(cbn_t);
			} else if (x == 7) {
				// x can not be bigger than 7
				ChessBoardNode cbn_t = new ChessBoardNode(new Pair<>(x, y+1));
				this.adjcacency_list.add(cbn_t);
				
				cbn_t = new ChessBoardNode(new Pair<>(x, y-1));
				this.adjcacency_list.add(cbn_t);
				
				cbn_t = new ChessBoardNode(new Pair<>(x-1, y));
				this.adjcacency_list.add(cbn_t);
				
				cbn_t = new ChessBoardNode(new Pair<>(x-1, y+1));
				this.adjcacency_list.add(cbn_t);
				
				cbn_t = new ChessBoardNode(new Pair<>(x-1, y-1));
				this.adjcacency_list.add(cbn_t);
			} else if(y == 7) {
				// y can not be bigger than 7
				ChessBoardNode cbn_t = new ChessBoardNode(new Pair<>(x-1, y));
				this.adjcacency_list.add(cbn_t);
				
				cbn_t = new ChessBoardNode(new Pair<>(x+1, y));
				this.adjcacency_list.add(cbn_t);
				
				cbn_t = new ChessBoardNode(new Pair<>(x, y-1));
				this.adjcacency_list.add(cbn_t);
				
				cbn_t = new ChessBoardNode(new Pair<>(x+1, y-1));
				this.adjcacency_list.add(cbn_t);
				
				cbn_t = new ChessBoardNode(new Pair<>(x-1, y-1));
				this.adjcacency_list.add(cbn_t);
			}
		} else { // these are all the middle boxes on the chessboard
			// 8 adjacent nodes possible
			ChessBoardNode cbn_t = new ChessBoardNode(new Pair<>(1, 0));
			this.adjcacency_list.add(cbn_t);
			
			cbn_t = new ChessBoardNode(new Pair<>(x+1, y+1)); // upper right corner
			this.adjcacency_list.add(cbn_t);
			
			cbn_t = new ChessBoardNode(new Pair<>(x+1-1, y+1)); // walk one left from the upper right corner
			this.adjcacency_list.add(cbn_t);
			
			cbn_t = new ChessBoardNode(new Pair<>(x+1-2, y+1));// walk two left from the upper right corner
			this.adjcacency_list.add(cbn_t);
			
			cbn_t = new ChessBoardNode(new Pair<>(x+1, y+1-1)); // walk one down from the upper right corner
			this.adjcacency_list.add(cbn_t);
			
			cbn_t = new ChessBoardNode(new Pair<>(x+1, y+1-2)); // walk two down from the upper right corner
			this.adjcacency_list.add(cbn_t);
			
			cbn_t = new ChessBoardNode(new Pair<>(x-1, y-1)); // lower left corner
			this.adjcacency_list.add(cbn_t);
			
			cbn_t = new ChessBoardNode(new Pair<>(x-1+1, y-1)); // walk one right from the lower left corner
			this.adjcacency_list.add(cbn_t);
			
			cbn_t = new ChessBoardNode(new Pair<>(x-1, y-1+1)); // walk up from the lower left corner
			this.adjcacency_list.add(cbn_t);
		}
		
	}
	
	public void addChild(ChessBoardNode node) {
		this.adjcacency_list.add(node);
	}
	
}
