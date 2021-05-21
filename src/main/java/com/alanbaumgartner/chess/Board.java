package com.alanbaumgartner.chess;

import com.alanbaumgartner.chess.pieces.*;

import java.util.Arrays;

public class Board {

    private Tile[][] tiles;
    private Tile whiteKing;
    private Tile blackKing;

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

    public Tile[][] getTiles() {
        return tiles;
    }

    public void setTiles(Tile[][] tiles) {
        this.tiles = tiles;
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
        sb.append("  a b c d e f g h");
        return sb.toString();
    }
}





