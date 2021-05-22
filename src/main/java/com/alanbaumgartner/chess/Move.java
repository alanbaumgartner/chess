package com.alanbaumgartner.chess;

import com.alanbaumgartner.chess.pieces.King;
import com.alanbaumgartner.chess.pieces.Piece;
import com.alanbaumgartner.chess.pieces.Rook;
import com.alanbaumgartner.chess.util.NotationUtility;

public class Move {

    private Piece piece;
    private Tile startPos;
    private Tile destPos;
    private boolean castling;
    private boolean capturing;

    public Move(Piece piece, Tile startPos, Tile destPos) {
        this.piece = piece;
        this.startPos = startPos;
        this.destPos = destPos;
        castling = false;
        capturing = false;
    }

    public Piece doMove() {
        Piece ret = destPos.getPiece();
        if (ret != null) {
            capturing = true;
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
        return startPiece.isWhite() == destPiece.isWhite() && startPiece instanceof King && destPiece instanceof Rook;
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
        return NotationUtility.getPieceNotation(piece.getClass()) + (capturing ? "x" : "") + NotationUtility.getRowMappingFromInt(destPos.getX()) + (destPos.getY() + 1);
    }
}
