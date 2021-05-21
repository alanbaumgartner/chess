package com.alanbaumgartner.chess.pieces;

import com.alanbaumgartner.chess.Board;
import com.alanbaumgartner.chess.Tile;

public class Knight extends Piece {

    public Knight(boolean white) {
        super(white);
    }

    @Override
    public boolean canMove(Board board, Tile startPos, Tile destPos) {
        if (destPos.getPiece() != null && destPos.getPiece().isWhite() == isWhite()) {
            return false;
        }
        int x = Math.abs(startPos.getX() - destPos.getX());
        int y = Math.abs(startPos.getY() - destPos.getY());
        return x * y == 2;
    }

    @Override
    public String getIcon() {
        return isWhite() ? "♞" : "♘";
    }

    @Override
    public String getNotation() {
        return "N";
    }

}