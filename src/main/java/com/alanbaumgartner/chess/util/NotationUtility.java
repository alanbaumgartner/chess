package com.alanbaumgartner.chess.util;

import com.alanbaumgartner.chess.pieces.*;
import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;

import java.util.Map;

public class NotationUtility {

    public static final String ICON_SPACE = " ";

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

}

