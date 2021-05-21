package com.alanbaumgartner.chess.pieces;

import com.alanbaumgartner.chess.Board;
import com.alanbaumgartner.chess.Tile;

public class Pawn extends Piece {

    public Pawn(boolean white) {
        super(white);
    }

    @Override
    public boolean canMove(Board board, Tile startPos, Tile destPos) {
        int x = Math.abs(startPos.getX() - destPos.getX());
        int y = Math.abs(startPos.getY() - destPos.getY());
        if (destPos.getPiece() != null && destPos.getPiece().isWhite() == isWhite()) {
            return false;
        }
        if (x == 0 && y == 1 && destPos.getPiece() == null) {
            return true;
        } else {
            return x == 1 && y == 1 && destPos.getPiece() != null;
        }
    }

    @Override
    public String getIcon() {
        return isWhite() ? "♟" : "♙";
    }

    @Override
    public String getNotation() {
        return "P";
    }

}
