package com.alanbaumgartner.chess.util;

import com.alanbaumgartner.chess.pieces.*;
import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;

import java.util.Map;

public class NotationUtility {

    public static final String ICON_SPACE = " ";

    private static final Map<Class<? extends Piece>, String[]> PIECE_TO_ICON = Map.of(
            Pawn.class, new String[]{"♟", "♙"},
            Knight.class, new String[]{"♞", "♘"},
            Bishop.class, new String[]{"♝", "♗"},
            Rook.class, new String[]{"♜", "♖"},
            Queen.class, new String[]{"♛", "♕"},
            King.class, new String[]{"♚", "♔"}
    );

    private static final Map<Class<? extends Piece>, String> PIECE_TO_NOTATION = Map.of(
            Pawn.class, "",
            Knight.class, "N",
            Bishop.class, "B",
            Rook.class, "R",
            Queen.class, "Q",
            King.class, "K"
    );

    private static final BiMap<Integer, String> ROW_MAPPING = HashBiMap.create(Map.of(
            0, "a",
            1, "b",
            2, "c",
            3, "d",
            4, "e",
            5, "f",
            6, "g",
            7, "h"
    ));

    public static String getRowMappingFromInt(Integer key) {
        return ROW_MAPPING.get(key);
    }

    public static Integer getRowMappingFromString(String key) {
        return ROW_MAPPING.inverse().get(key);
    }

    public static String getPieceIcon(Class<? extends Piece> piece, boolean white) {
        int index = white ? 0 : 1;
        return PIECE_TO_ICON.get(piece)[index];
    }

    public static String getPieceNotation(Class<? extends Piece> piece) {
        return PIECE_TO_NOTATION.get(piece);
    }

}
