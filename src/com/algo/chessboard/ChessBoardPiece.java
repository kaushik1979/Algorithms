package com.algo.chessboard;

/**
 * (1) 1 King - 1 move in any direction
 * (2) 1 Queen - Can move as many in one direction - be it sidewise, front, or the corners
 * (3) 2 Rooks - Can move as many forward, backward, or sideways only
 * (4) 2 Knight - 2 moves forward or sideways and one move to the 90 degree
 * (5) 2 Bishops - as many moves in the diagonal direction
 * (6) 8 Pawns - one step always in forward direction, except when attacking it goes diagonally one step to attack
 * @author priyankasharma
 *
 */
public class ChessBoardPiece {
	
	public static enum CHESS_PIECE {
		KING, QUEEN, ROOK, KNIGHT, BISHOP, PAWN;
		public String get_name() {
			return this.name().toLowerCase();
		}
	}
	
	public boolean can_move_fwd_only = true; // by default the piece can move forward only. set this to false to move backward also.
	
	public CHESS_PIECE chess_piece;
	
	public ChessBoardNode starting_position; // this is where the piece will be situated at the beginning of the game
	
	public ChessBoardNode current_position; // this is where the piece will be situated at any point in the game\
	
	public ChessBoardPiece(CHESS_PIECE cp) {
		this.chess_piece = cp;
	}
	
	public ChessBoardPiece(CHESS_PIECE cp, ChessBoardNode sp) {
		this.chess_piece = cp;
		this.starting_position = sp;
		this.current_position = sp;
	}
	
	/**
	 * move will work differently for every piece<br>
	 * simple case is 8 pawns, where it always moves forward and only one position, straight or diagonally <br>
	 * complex cases are every other piece
	 * @return
	 */
	public ChessBoardNode move() {
		// TODO
		
		switch(this.chess_piece) {
		case KING:
			return this.moveKing();
		case QUEEN:
			return this.moveQueen();
		case ROOK:
			return this.moveRook();
		case KNIGHT:
			return this.moveKnight();
		case BISHOP:
			return this.moveBishop();
		case PAWN:
			return this.movePawn();
			default: System.out.println("Unrecognized piece ... not moving");
		}
		
		return null;
	}
	
	/**
	 * one step always in forward direction, except when attacking it goes diagonally one step to attack <br>
	 * let us move the pawn in forward and diagonal directions only<br>
	 * @return
	 */
	public ChessBoardNode movePawn() {
		
		ChessBoardNode current_pos = this.current_position;
		
		return null;
	}
	
	/**
	 * 1 move in any direction
	 * @return
	 */
	public ChessBoardNode moveKing() {
		return null;
	}
	
	/**
	 * Can move as many in one direction - be it sidewise, front, or the corners
	 * @return
	 */
	public ChessBoardNode moveQueen() {
		return null;
	}
	
	/**
	 * Can move as many forward, backward, or sideways only
	 * @return
	 */
	public ChessBoardNode moveRook() {
		return null;
	}
	
	/**
	 * 2 Knight - 2 moves forward or sideways and one move to the 90 degree
	 * @return
	 */
	public ChessBoardNode moveKnight() {
		return null;
	}
	
	/**
	 * 2 Bishops - as many moves in the diagonal direction
	 * @return
	 */
	public ChessBoardNode moveBishop() {
		return null;
	}
}
