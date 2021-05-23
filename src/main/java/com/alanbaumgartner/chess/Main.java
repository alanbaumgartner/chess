package com.alanbaumgartner.chess;

import com.alanbaumgartner.chess.pieces.Piece;

public class Main {

    public static void main(String[] args) {
        Game game = new Game();
        Board board = game.getBoard();


        Tile whitePawn = board.getTiles()[2][1];
        Tile whitePawnMove = board.getTiles()[2][2];

        Tile blackPawnTile = board.getTiles()[2][6];
        Tile blackPawnMoveTile = board.getTiles()[2][5];
        Tile blackPawnMoveTile2 = board.getTiles()[2][4];

        Tile blackQueenTile = board.getTiles()[3][7];
        Tile blackQueenMoveTile = board.getTiles()[1][5];

        Tile whiteQueenTile = board.getTiles()[3][0];
        Tile whiteQueenMoveTile = board.getTiles()[1][2];
        Tile whiteQueenMoveTile2 = board.getTiles()[1][5];
        Tile whiteQueenMoveTile3 = board.getTiles()[3][7];

        Move move = new Move(whitePawn, whitePawnMove, board);
        game.doMove(move);
        Move move2 = new Move(blackPawnTile, blackPawnMoveTile, board);
        game.doMove(move2);
        Move move3 = new Move(whiteQueenTile, whiteQueenMoveTile, board);
        game.doMove(move3);
        Move move4 = new Move(blackQueenTile, blackQueenMoveTile, board);
        game.doMove(move4);
        Move move5 = new Move(whiteQueenMoveTile, whiteQueenMoveTile2, board);
        game.doMove(move5);
        Move move6 = new Move(blackPawnMoveTile, blackPawnMoveTile2, board);
        game.doMove(move6);
        Move move7 = new Move(whiteQueenMoveTile2, whiteQueenMoveTile3, board);
        game.doMove(move7);
        System.out.println(game);
    }

}






