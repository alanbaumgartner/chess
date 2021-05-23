package com.alanbaumgartner.chess;

public class Main {

    public static void main(String[] args) {
        Board board = new Board();

        Position whitePawn = board.getTiles()[2][1];
        Position whitePawnMove = board.getTiles()[2][2];

        Position blackPawnPosition = board.getTiles()[2][6];
        Position blackPawnMovePosition = board.getTiles()[2][5];
        Position blackPawnMovePosition2 = board.getTiles()[2][4];

        Position blackQueenPosition = board.getTiles()[3][7];
        Position blackQueenMovePosition = board.getTiles()[1][5];

        Position whiteQueenPosition = board.getTiles()[3][0];
        Position whiteQueenMovePosition = board.getTiles()[1][2];
        Position whiteQueenMovePosition2 = board.getTiles()[1][5];
        Position whiteQueenMovePosition3 = board.getTiles()[3][7];
//
        Move move = new Move(whitePawn, whitePawnMove, board);
        board.doMove(move);
        Move move2 = new Move(blackPawnPosition, blackPawnMovePosition, board);
        board.doMove(move2);
        Move move3 = new Move(whiteQueenPosition, whiteQueenMovePosition, board);
        board.doMove(move3);
        Move move4 = new Move(blackQueenPosition, blackQueenMovePosition, board);
        board.doMove(move4);
        Move move5 = new Move(whiteQueenMovePosition, whiteQueenMovePosition2, board);
        board.doMove(move5);
        Move move6 = new Move(blackPawnMovePosition, blackPawnMovePosition2, board);
        board.doMove(move6);
        Move move7 = new Move(whiteQueenMovePosition2, whiteQueenMovePosition3, board);
        board.doMove(move7);
        System.out.println(board);
//        System.out.println(board.getString());
    }

}






