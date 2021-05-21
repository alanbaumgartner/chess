package com.alanbaumgartner.chess.pieces;

import com.alanbaumgartner.chess.Board;
import com.alanbaumgartner.chess.Tile;

public class King extends Piece {

    private boolean castled;

    public King(boolean white) {
        super(white);
        castled = false;
    }

    @Override
    public boolean canMove(Board board, Tile startPos, Tile destPos) {
        return false;
    }

    @Override
    public String getIcon() {
        return isWhite() ? "♚" : "♔";
    }
    @Override
    public String getNotation() {
        return "K";
    }
}
