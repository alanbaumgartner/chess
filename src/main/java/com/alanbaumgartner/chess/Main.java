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

        Tile blackQueenTile = board.getTiles()[3][7];
        Tile blackQueenMoveTile = board.getTiles()[1][5];

        Tile whiteQueenTile = board.getTiles()[3][0];
        Piece whiteQueen = whiteQueenTile.getPiece();
        Tile whiteQueenMoveTile = board.getTiles()[1][2];
        Tile whiteQueenMoveTile2 = board.getTiles()[1][5];

        Move move = new Move(whitePawn.getPiece(), whitePawn, whitePawnMove);
        Move move2 = new Move(blackPawnTile.getPiece(), blackPawnTile, blackPawnMoveTile);
        Move move3 = new Move(whiteQueen, whiteQueenTile, whiteQueenMoveTile);
        Move move4 = new Move(blackQueenTile.getPiece(), blackQueenTile, blackQueenMoveTile);
        Move move5 = new Move(whiteQueen, whiteQueenMoveTile, whiteQueenMoveTile2);
        game.doMove(move);
        game.doMove(move2);
        game.doMove(move3);
        game.doMove(move4);
        game.doMove(move5);
        System.out.println(game);
    }

}






