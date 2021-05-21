package com.alanbaumgartner.chess.pieces;

import com.alanbaumgartner.chess.Board;
import com.alanbaumgartner.chess.Tile;

public class Rook extends Piece {

    public Rook(boolean white) {
        super(white);
    }

    @Override
    public boolean canMove(Board board, Tile startPos, Tile destPos) {
        int x = Math.abs(startPos.getX() - destPos.getX());
        int y = Math.abs(startPos.getY() - destPos.getY());
        if (destPos.getPiece() != null && destPos.getPiece().isWhite() == isWhite()) {
            return false;
        }
        if (y == 0) {
            for (int i = startPos.getX(); i < destPos.getX(); i++) {
                if (board.getTiles()[i][startPos.getY()].getPiece() != null) {
                    return false;
                }
            }
            return true;
        } else if (x == 0) {
            for (int i = startPos.getY() + 1; i < destPos.getY(); i++) {
                if (board.getTiles()[startPos.getX()][i].getPiece() != null) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    @Override
    public String getIcon() {
        return isWhite() ? "♜" : "♖";
    }

    @Override
    public String getNotation() {
        return "R";
    }

}