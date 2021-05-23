package com.alanbaumgartner.chess.pieces;

public enum Role {

    PAWN("" , "♟♙", 1),
    KNIGHT("N" , "♞♘", 3),
    BISHOP("B" , "♝♗", 3),
    ROOK("R" , "♜♖", 5),
    QUEEN("Q" , "♛♕", 9),
    KING("K" , "♚♔", 0);

    private final String notation;
    private final String icon;
    private final int value;

    Role(String notation, String icon, int value) {
        this.notation = notation;
        this.icon = icon;
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public String getNotation() {
        return notation;
    }

    public String getIcon(Color color) {
        return switch (color) {
            case WHITE -> icon.substring(0,1);
            case BLACK -> icon.substring(1,2);
        };
    }
}
