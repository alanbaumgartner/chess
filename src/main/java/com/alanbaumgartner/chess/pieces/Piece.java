package com.alanbaumgartner.chess.pieces;

import com.alanbaumgartner.chess.Board;
import com.alanbaumgartner.chess.Tile;

public abstract class Piece {

    private final boolean white;
    private boolean killed;

    public Piece(boolean white) {
        this.white = white;
    }

    public abstract boolean canMove(Board board, Tile startPos, Tile destPos);

    public abstract String getIcon();

    public abstract String getNotation();

    public boolean isWhite() {
        return white;
    }

    public boolean isKilled() {
        return killed;
    }

    public void setKilled(boolean killed) {
        this.killed = killed;
    }

    @Override
    public String toString() {
        return getIcon();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Piece piece = (Piece) o;

        if (isWhite() != piece.isWhite()) return false;
        return isKilled() == piece.isKilled();
    }

    @Override
    public int hashCode() {
        int result = (isWhite() ? 1 : 0);
        result = 31 * result + (isKilled() ? 1 : 0);
        return result;
    }
}
