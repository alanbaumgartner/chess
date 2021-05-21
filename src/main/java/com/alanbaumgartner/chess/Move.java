package com.alanbaumgartner.chess;

import com.alanbaumgartner.chess.pieces.King;
import com.alanbaumgartner.chess.pieces.Piece;
import com.alanbaumgartner.chess.pieces.Rook;

import java.util.Map;

public class Move {

    private static final Map<Integer, String> xPosMap = Map.of(
        0, "a",
        1, "b",
        2, "c",
        3, "d",
        4, "e",
        5, "f",
        6, "g",
        7, "h"
    );

    private Piece piece;
    private Tile startPos;
    private Tile destPos;
    private boolean castling = false;

    public Move(Piece piece, Tile startPos, Tile destPos) {
        this.piece = piece;
        this.startPos = startPos;
        this.destPos = destPos;
    }

    public Piece doMove() {
        Piece ret = destPos.getPiece();
        if (ret != null) {
            ret.setKilled(true);
        }
//        castling = isCastling(startPos, destPos);
        destPos.setPiece(startPos.getPiece());
        startPos.setPiece(null);
        return ret;
    }

    private boolean isCastling(Tile startPos, Tile destPos) {
        if (startPos.getPiece() == null || destPos.getPiece() != null) {
            return false;
        }
        Piece startPiece = startPos.getPiece();
        Piece destPiece = destPos.getPiece();
        if (startPiece.isWhite() == destPiece.isWhite() && startPiece instanceof King && destPiece instanceof Rook) {
            return true;
        }
        return false;
    }

    public Piece getPiece() {
        return piece;
    }

    public void setPiece(Piece piece) {
        this.piece = piece;
    }

    public Tile getStartPos() {
        return startPos;
    }

    public void setStartPos(Tile startPos) {
        this.startPos = startPos;
    }

    public Tile getDestPos() {
        return destPos;
    }

    public void setDestPos(Tile destPos) {
        this.destPos = destPos;
    }

    @Override
    public String toString() {
        return piece.getNotation() + xPosMap.get(destPos.getX()) + (destPos.getY() + 1);
    }
}
