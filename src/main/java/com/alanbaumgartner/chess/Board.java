package com.alanbaumgartner.chess;

import com.alanbaumgartner.chess.pieces.*;
import com.alanbaumgartner.chess.util.NotationUtility;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Board {

    private final Tile[][] tiles;
    private final Tile whiteKing;
    private final Tile blackKing;

    private boolean whiteChecked;
    private boolean blackChecked;

    public Board() {
        tiles = new Tile[8][8];

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                tiles[i][j] = new Tile(null, i, j);
            }
        }

        tiles[0][0] = new Tile(new Rook(true), 0, 0);
        tiles[1][0] = new Tile(new Knight(true), 1, 0);
        tiles[2][0] = new Tile(new Bishop(true), 2, 0);
        tiles[3][0] = new Tile(new Queen(true), 3, 0);
        tiles[4][0] = new Tile(new King(true), 4, 0);
        tiles[5][0] = new Tile(new Bishop(true), 5, 0);
        tiles[6][0] = new Tile(new Knight(true), 6, 0);
        tiles[7][0] = new Tile(new Rook(true), 7, 0);

        for (int i = 0; i < 8; i++) {
            tiles[i][1] = new Tile(new Pawn(true), i, 1);
        }

        tiles[0][7] = new Tile(new Rook(false), 0, 7);
        tiles[1][7] = new Tile(new Knight(false), 1, 7);
        tiles[2][7] = new Tile(new Bishop(false), 2, 7);
        tiles[3][7] = new Tile(new Queen(false), 3, 7);
        tiles[4][7] = new Tile(new King(false), 4, 7);
        tiles[5][7] = new Tile(new Bishop(false), 5, 7);
        tiles[6][7] = new Tile(new Knight(false), 6, 7);
        tiles[7][7] = new Tile(new Rook(false), 7, 7);

        for (int i = 0; i < 8; i++) {
            tiles[i][6] = new Tile(new Pawn(false), i, 6);
        }
        whiteKing = tiles[4][0];
        blackKing = tiles[4][7];
        whiteChecked = false;
        blackChecked = false;
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

    public Tile[][] getTiles() {
        return tiles;
    }

    public List<Tile> getWhitePieces() {
        return Arrays.stream(tiles).flatMap(Stream::of).filter(tile -> tile.getPiece() != null && tile.getPiece().isWhite()).collect(Collectors.toList());
    }

    public List<Tile> getBlackPieces() {
        return Arrays.stream(tiles).flatMap(Stream::of).filter(tile -> tile.getPiece() != null && !tile.getPiece().isWhite()).collect(Collectors.toList());
    }

    public Tile getWhiteKing() {
        return Arrays.stream(tiles).flatMap(Stream::of).filter(tile -> tile.getPiece() != null && tile.getPiece().isWhite() && (tile.getPiece() instanceof King)).findAny().orElse(null);
    }

    public Tile getBlackKing() {
        return Arrays.stream(tiles).flatMap(Stream::of).filter(tile -> tile.getPiece() != null && !tile.getPiece().isWhite() && (tile.getPiece() instanceof King)).findAny().orElse(null);
    }

    public Tile getTileByNotation(String tile) {
        int row = NotationUtility.getRowMappingFromString(String.valueOf(tile.charAt(0)));
        int column = Integer.parseInt(String.valueOf(tile.charAt(1))) - 1;
        return tiles[row][column];
    }

    public Tile getKing(boolean white) {
        return white ? whiteKing : blackKing;
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
                sb.append(tiles[j][i].toString()).append(" ");
            }
            sb.append("\n");
        }
        sb.append("  ").append("a b c d e f g h");
        return sb.toString();
    }

    public String getString(List<Piece> whitePieces, List<Piece> blackPieces) {
        StringBuilder sb = new StringBuilder();
        for (int i = 7; i >= 0; i--) {
            sb.append(i + 1).append(" ");
            for (int j = 0; j < 8; j++) {
                sb.append(tiles[j][i].toString()).append(" ");
                if (i == 0 && j == 7 && blackPieces.size() > 0) {
                    sb.append(" | ");
                    for (Piece piece : blackPieces) {
                        sb.append(NotationUtility.getPieceIcon(piece.getClass(), piece.isWhite())).append(" ");
                    }
                }
                if (i == 7 && j == 7 && whitePieces.size() > 0) {
                    sb.append(" | ");
                    for (Piece piece : whitePieces) {
                        sb.append(NotationUtility.getPieceIcon(piece.getClass(), piece.isWhite())).append(" ");
                    }
                }
            }
            sb.append("\n");
        }
        sb.append("  a b c d e f g h");
        return sb.toString();
    }
}





