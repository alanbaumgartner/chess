package com.alanbaumgartner.chess;

import com.alanbaumgartner.chess.pieces.Piece;

import java.util.ArrayList;
import java.util.List;

public class Game {

    private final Board board;
    private final List<Move> moves;

    public Game() {
        moves = new ArrayList<>();
        board = new Board();
    }

    public boolean doMove(Move move) {
        if (move.getPiece().canMove(move.getStartPos(), move.getDestPos())) {
            Piece capturedPiece = move.apply();
            if (capturedPiece != null) {
                switch (capturedPiece.getColor()) {
                    case WHITE -> board.getWhitePiecesCaptured().add(capturedPiece);
                    case BLACK -> board.getBlackPiecesCaptured().add(capturedPiece);
                }
            }
            moves.add(move);
            return true;
        }
        return false;
    }

    public List<Move> getMoves() {
        return moves;
    }

    public Board getBoard() {
        return board;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
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
