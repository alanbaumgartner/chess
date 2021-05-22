package com.alanbaumgartner.chess;

import com.alanbaumgartner.chess.pieces.Piece;
import com.alanbaumgartner.chess.util.NotationUtility;

public class Tile {
    private Piece piece;
    private final int x;
    private final int y;

    public Tile(Piece piece, int x, int y) {
        this.piece = piece;
        this.x = x;
        this.y = y;
    }

    public Piece getPiece() {
        return piece;
    }

    public void setPiece(Piece piece) {
        this.piece = piece;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Tile tile = (Tile) o;

        if (getX() != tile.getX()) return false;
        if (getY() != tile.getY()) return false;
        return getPiece() != null ? getPiece().equals(tile.getPiece()) : tile.getPiece() == null;
    }

    @Override
    public int hashCode() {
        int result = getPiece() != null ? getPiece().hashCode() : 0;
        result = 31 * result + getX();
        result = 31 * result + getY();
        return result;
    }

    @Override
    public String toString() {
        return piece != null ? piece.toString() : NotationUtility.ICON_SPACE;
    }
}
