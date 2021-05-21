package com.alanbaumgartner.chess;

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
        Tile whiteQueenMoveTile = board.getTiles()[1][2];

        Move move = new Move(whitePawn.getPiece(), whitePawn, whitePawnMove);
        Move move2 = new Move(blackPawnTile.getPiece(), blackPawnTile, blackPawnMoveTile);
        Move move3 = new Move(whiteQueenTile.getPiece(), whiteQueenTile, whiteQueenMoveTile);
        Move move4 = new Move(blackQueenTile.getPiece(), blackQueenTile, blackQueenMoveTile);
        game.doMove(move);
        game.doMove(move2);
        game.doMove(move3);
        game.doMove(move4);
        System.out.println(board);
        System.out.println(game);
    }

}






