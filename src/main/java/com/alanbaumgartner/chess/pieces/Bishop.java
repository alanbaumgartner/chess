package com.alanbaumgartner.chess.pieces;

import com.alanbaumgartner.chess.Board;
import com.alanbaumgartner.chess.Tile;

public class Bishop extends Piece {

    public Bishop(boolean white) {
        super(white);
    }

    @Override
    public boolean canMove(Board board, Tile startPos, Tile destPos) {
        int x = Math.abs(startPos.getX() - destPos.getX());
        int y = Math.abs(startPos.getY() - destPos.getY());
        if (destPos.getPiece() != null && destPos.getPiece().isWhite() == isWhite()) {
            return false;
        }
        if (x != y) {
            return false;
        }
        for (int i = startPos.getX(); i < x; i++) {
            if (board.getTiles()[i][i].getPiece() != null) {
                return false;
            }
        }
        return true;
    }

    @Override
    public String getIcon() {
        return isWhite() ? "♝" : "♗";
    }

    @Override
    public String getNotation() {
        return "B";
    }

}
