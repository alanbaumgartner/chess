package com.alanbaumgartner.chess;

import com.alanbaumgartner.chess.pieces.Piece;

import java.util.ArrayList;
import java.util.List;

public class Game {

    private final Board board;
    private boolean whiteTurn;
    private final List<Move> moves;

    private final List<Piece> whitePieces;
    private final List<Piece> blackPieces;

    public Game() {
        moves = new ArrayList<>();
        board = new Board();
        whiteTurn = true;

        whitePieces = new ArrayList<>();
        blackPieces = new ArrayList<>();
    }

    public boolean doMove(Move move) {
        if (move.getPiece().isWhite() != whiteTurn) {
            return false;
        }
        if (move.getPiece().canMove(board, move.getStartPos(), move.getDestPos())) {
            Piece piece = move.doMove();
            if (piece != null) {
                if (whiteTurn) {
                    blackPieces.add(piece);
                } else {
                    whitePieces.add(piece);
                }
            }
            moves.add(move);
            whiteTurn = !whiteTurn;
            return true;
        }
        return false;
    }

//    public void doMove(String move) {
//        String piece = move.substring(0, 0);
//        String destPost = move.substring(1, 2);
//    }

    public List<Move> getMoves() {
        return moves;
    }

    public Board getBoard() {
        return board;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(board.getString(whitePieces, blackPieces)).append("\n\n");
        for (int i = 0; i < moves.size(); i++) {
            if (i % 2 == 0) {
                sb.append(((i / 2) + 1) + ") ").append(moves.get(i)).append(", ");
            } else {
                sb.append(moves.get(i)).append("\n");
            }
        }
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Game game = (Game) o;

        if (getMoves() != null ? !getMoves().equals(game.getMoves()) : game.getMoves() != null) return false;
        return getBoard() != null ? getBoard().equals(game.getBoard()) : game.getBoard() == null;
    }

    @Override
    public int hashCode() {
        int result = getMoves() != null ? getMoves().hashCode() : 0;
        result = 31 * result + (getBoard() != null ? getBoard().hashCode() : 0);
        return result;
    }
}
