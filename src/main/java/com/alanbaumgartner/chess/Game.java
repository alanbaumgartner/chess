package com.alanbaumgartner.chess;

import java.util.ArrayList;
import java.util.List;

public class Game {

    private List<Move> moves;
    private boolean whiteTurn;
    private Board board;

    public Game() {
        moves = new ArrayList<>();
        board = new Board();
        whiteTurn = true;
    }

    public boolean doMove(Move move) {
        if (move.getPiece().isWhite() != whiteTurn) {
            return false;
        }
        if (move.getPiece().canMove(board, move.getStartPos(), move.getDestPos())) {
            move.doMove();
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
