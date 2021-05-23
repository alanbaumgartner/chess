package com.alanbaumgartner.chess;

import com.alanbaumgartner.chess.pieces.King;
import com.alanbaumgartner.chess.pieces.Piece;
import com.alanbaumgartner.chess.pieces.Rook;
import com.alanbaumgartner.chess.util.NotationUtility;

import java.util.List;

public class Move {

    private final Piece piece;
    private final Board board;
    private final Tile startPos;
    private final Tile destPos;
    private boolean castling;
    private boolean queenSideCastle;
    private boolean capturing;
    private boolean checking;

    public Move(Tile startPos, Tile destPos, Board board) {
        this.startPos = startPos;
        this.destPos = destPos;
        this.piece = startPos.getPiece();
        this.board = board;
        this.castling = false;
        this.capturing = false;
        this.queenSideCastle = false;
        this.checking = false;
    }

    public Piece doMove() {
        Piece ret = destPos.getPiece();
        if (ret != null) {
            capturing = true;
        }
//        castling = isCastling(startPos, destPos);
        destPos.setPiece(startPos.getPiece());
        startPos.setPiece(null);

        Tile king;
        List<Tile> pieces;
        if (piece.isWhite()) {
            king = board.getBlackKing();
//            pieces = board.getWhitePieces();
        } else {
            king = board.getWhiteKing();
//            pieces = board.getBlackPieces();
        }
        if (piece.canMove(board, destPos, king)) {
            checking = true;
        }
//        for (Tile tile : pieces) {
//            if (tile.getPiece().canMove(board, tile, king)) {
//                checking = true;
//            }
//        }
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

    public Tile getStartPos() {
        return startPos;
    }

    public Tile getDestPos() {
        return destPos;
    }

    @Override
    public String toString() {
        String notation;
        if (castling) {
            notation = queenSideCastle ? "O-O-O" : "O-O";
        } else {
            notation = NotationUtility.getPieceNotation(piece.getClass()) +
                        (capturing ? "x" : "") +
                        NotationUtility.getRowMappingFromInt(destPos.getX()) +
                        (destPos.getY() + 1) + (checking ? "+" : "");
        }
        return notation;
    }
}
