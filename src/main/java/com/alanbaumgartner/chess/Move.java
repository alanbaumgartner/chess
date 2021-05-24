package com.alanbaumgartner.chess;

import com.alanbaumgartner.chess.pieces.Piece;
import com.alanbaumgartner.chess.util.NotationUtility;

import java.util.List;

public class Move {

    private final Piece piece;
    private final Board board;
    private final Position startPos;
    private final Position destPos;
    private boolean castling;
    private boolean queenSideCastle;
    private boolean capturing;
    private boolean checking;

    public Move(Position startPos, Position destPos, Board board) {
        this.startPos = startPos;
        this.destPos = destPos;
        this.piece = startPos.getPiece();
        this.board = board;
        this.castling = false;
        this.capturing = false;
        this.queenSideCastle = false;
        this.checking = false;
    }

    public Piece apply() {
        Piece ret = destPos.getPiece();
        if (ret != null) {
            capturing = true;
        }
//        castling = isCastling(startPos, destPos);
        destPos.setPiece(startPos.getPiece());
        startPos.setPiece(null);

        Position king;
        List<Position> pieces;
        if (piece.isWhite()) {
            king = board.getBlackKing();
            pieces = board.getWhitePieces();
        } else {
            king = board.getWhiteKing();
            pieces = board.getBlackPieces();
        }
        if (piece.canMove(destPos, king)) {
            checking = true;
        }
        for (Position position : pieces) {
            if (position.getPiece().canMove(position, king)) {
                checking = true;
            }
        }
        return ret;
    }

    //    private boolean isCastling(Position startPos, Position destPos) {
//        if (startPos.getPiece() == null || destPos.getPiece() != null) {
//            return false;
//        }
//        Piece startPiece = startPos.getPiece();
//        Piece destPiece = destPos.getPiece();
//        return startPiece.isWhite() == destPiece.isWhite() && startPiece instanceof King && destPiece instanceof Rook;
//    }
//
    public Piece getPiece() {
        return piece;
    }

    public Position getStartPos() {
        return startPos;
    }

    public Position getDestPos() {
        return destPos;
    }

    @Override
    public String toString() {
        String notation;
        if (castling) {
            notation = queenSideCastle ? "O-O-O" : "O-O";
        } else {
            notation = piece.getNotation() +
                    (capturing ? "x" : "") +
                    NotationUtility.getRowMappingFromInt(destPos.getFile()) +
                    (destPos.getRank() + 1) + (checking ? "+" : "");
        }
        return notation;
    }
}
