package com.alanbaumgartner.chess.pieces;

import com.alanbaumgartner.chess.Board;
import com.alanbaumgartner.chess.Tile;
import com.alanbaumgartner.chess.util.NotationUtility;

public abstract class Piece {

    private final boolean white;

    public Piece(boolean white) {
        this.white = white;
    }

    public abstract boolean canMove(Board board, Tile startPos, Tile destPos);

    public boolean isWhite() {
        return white;
    }

    @Override
    public String toString() {
        return NotationUtility.getPieceIcon(this.getClass(), isWhite());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Piece piece = (Piece) o;

        return isWhite() == piece.isWhite();
    }

    @Override
    public int hashCode() {
        return (isWhite() ? 1 : 0);
    }
}
