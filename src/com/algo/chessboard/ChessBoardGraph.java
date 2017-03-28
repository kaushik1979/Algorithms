package com.algo.chessboard;

/**
 * Moves:
 * (1) 1 King - 1 move in any direction
 * (2) 1 Queen - Can move as many in one direction - be it sidewise, front, or the corners
 * (3) 2 Rooks - Can move as many forward, backward, or sideways only
 * (4) 2 Knight - 2 moves forward or sideways and one move to the 90 degree
 * (5) 2 Bishops - as many moves in the diagonal direction
 * (6) 8 Pawns - one step always in forward direction, except when attacking it goes diagonally one step to attack
 * 
 *  
 *  ________________________________________
 *  | 70 | 71 | 72 | 73 | 74 | 75 | 76 | 77 |
 *  ________________________________________
 *  | 60 | 61 | 62 | 63 | 64 | 65 | 66 | 67 |
 *  ________________________________________
 *  | 50 | 51 | 52 | 53 | 54 | 55 | 56 | 57 |
 *  ________________________________________
 *  | 40 | 41 | 42 | 43 | 44 | 45 | 46 | 47 |
 *  ________________________________________
 *  | 30 | 31 | 32 | 33 | 34 | 35 | 36 | 37 |
 *  ________________________________________
 *  | 20 | 21 | 22 | 23 | 24 | 25 | 26 | 27 |
 *  ________________________________________
 *  | 10 | 11 | 12 | 13 | 14 | 15 | 16 | 17 |
 *  ________________________________________
 *  | 00 | 01 | 02 | 03 | 04 | 05 | 06 | 07 |
 *  ________________________________________
 *  
 *  (1) Problem - Put the Bishop in 05, find all ways in which it can reach 74? Find shortest possible path?
 *  (2) Problem - Put the Knight in 06, find all ways in which it can reach 76? Find shortest possible path?
 * 
 * 
 * @author priyankasharma
 *
 */
public class ChessBoardGraph {
	// Two approaches -
	// (1) The source of the chess board depends on where the piece is set in the starting position (PREFERRED)
	// (2) Make box 00 as the source and then perform the algo
	ChessBoardNode source;
	
	public ChessBoardGraph(){}
	
	public void setSource(ChessBoardNode source) {
		this.source = source;
	}
}
