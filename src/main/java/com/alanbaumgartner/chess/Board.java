package com.alanbaumgartner.chess;

import com.alanbaumgartner.chess.pieces.*;
//import com.alanbaumgartner.chess.util.NotationUtility;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Board {

    private final Position[][] positions;
    private final List<Move> moves;

    private boolean whiteChecked;
    private boolean blackChecked;

    public Board() {
        positions = new Position[8][8];
        moves = new ArrayList<>();

        Color white = Color.WHITE;
        Color black = Color.BLACK;

        Role pawn = Role.PAWN;
        Role knight = Role.KNIGHT;
        Role bishop = Role.BISHOP;
        Role rook = Role.ROOK;
        Role queen = Role.QUEEN;
        Role king = Role.KING;

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                positions[i][j] = new Position(this, null, i, j);
            }
        }

        positions[0][0] = new Position(this, new Piece(white, rook), 0, 0);
        positions[1][0] = new Position(this, new Piece(white, knight), 1, 0);
        positions[2][0] = new Position(this, new Piece(white, bishop), 2, 0);
        positions[3][0] = new Position(this, new Piece(white, queen), 3, 0);
        positions[4][0] = new Position(this, new Piece(white, king), 4, 0);
        positions[5][0] = new Position(this, new Piece(white, bishop), 5, 0);
        positions[6][0] = new Position(this, new Piece(white, knight), 6, 0);
        positions[7][0] = new Position(this, new Piece(white, rook), 7, 0);

        for (int i = 0; i < 8; i++) {
            positions[i][1] = new Position(this, new Piece(white, pawn), i, 1);
        }

        positions[0][7] = new Position(this, new Piece(black, rook), 0, 7);
        positions[1][7] = new Position(this, new Piece(black, knight), 1, 7);
        positions[2][7] = new Position(this, new Piece(black, bishop), 2, 7);
        positions[3][7] = new Position(this, new Piece(black, queen), 3, 7);
        positions[4][7] = new Position(this, new Piece(black, king), 4, 7);
        positions[5][7] = new Position(this, new Piece(black, bishop), 5, 7);
        positions[6][7] = new Position(this, new Piece(black, knight), 6, 7);
        positions[7][7] = new Position(this, new Piece(black, rook), 7, 7);

        for (int i = 0; i < 8; i++) {
            positions[i][6] = new Position(this, new Piece(black, pawn), i, 6);
        }
//        whiteKing = positions[4][0];
//        blackKing = positions[4][7];
//        whiteChecked = false;
//        blackChecked = false;
    }

    public boolean isWhiteChecked() {
        return whiteChecked;
    }

    public void setWhiteChecked(boolean whiteChecked) {
        this.whiteChecked = whiteChecked;
    }

    public boolean isBlackChecked() {
        return blackChecked;
    }

    public void setBlackChecked(boolean blackChecked) {
        this.blackChecked = blackChecked;
    }

    public Position[][] getTiles() {
        return positions;
    }

//    public List<Position> getWhitePieces() {
//        return Arrays.stream(positions).flatMap(Stream::of).filter(position -> position.getPiece() != null && position.getPiece().isWhite()).collect(Collectors.toList());
//    }
//
//    public List<Position> getBlackPieces() {
//        return Arrays.stream(positions).flatMap(Stream::of).filter(position -> position.getPiece() != null && !position.getPiece().isWhite()).collect(Collectors.toList());
//    }
//
//    public Position getWhiteKing() {
//        return Arrays.stream(positions).flatMap(Stream::of).filter(position -> position.getPiece() != null && position.getPiece().isWhite() && (position.getPiece() instanceof King)).findAny().orElse(null);
//    }
//
//    public Position getBlackKing() {
//        return Arrays.stream(positions).flatMap(Stream::of).filter(position -> position.getPiece() != null && !position.getPiece().isWhite() && (position.getPiece() instanceof King)).findAny().orElse(null);
//    }

//    public Position getTileByNotation(String position) {
//        int row = NotationUtility.getRowMappingFromString(String.valueOf(position.charAt(0)));
//        int column = Integer.parseInt(String.valueOf(position.charAt(1))) - 1;
//        return positions[row][column];
//    }

//    public Position getKing(boolean white) {
//        return white ? whiteKing : blackKing;
//    }

    public boolean doMove(Move move) {
        if (move.getPiece().canMove(this, move.getStartPos(), move.getDestPos())) {
            move.doMove();
            moves.add(move);
            return true;
        }
        return false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Board board = (Board) o;

        return Arrays.deepEquals(getTiles(), board.getTiles());
    }

    @Override
    public int hashCode() {
        return Arrays.deepHashCode(getTiles());
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 7; i >= 0; i--) {
            sb.append(i + 1).append(" ");
            for (int j = 0; j < 8; j++) {
                sb.append(positions[j][i].toString()).append(" ");
            }
            sb.append("\n");
        }
        sb.append("  ").append("a b c d e f g h");
        // moves in notation
        sb.append("\n");
        for (int i = 0; i < moves.size(); i++) {
            if (i % 2 == 0) {
                sb.append(((i / 2) + 1) + ") ").append(moves.get(i)).append(", ");
            } else {
                sb.append(moves.get(i)).append("\n");
            }
        }
        return sb.toString();
    }
}





