package com.alanbaumgartner.chess;

import com.alanbaumgartner.chess.pieces.Piece;
import com.alanbaumgartner.chess.util.NotationUtility;

public class Position {
    private final int file;
    private final int rank;
    private final Board board;
    private Piece piece;

    public Position(Board board, Piece piece, int file, int rank) {
        this.board = board;
        this.piece = piece;
        this.file = file;
        this.rank = rank;
    }

    public Piece getPiece() {
        return piece;
    }

    public void setPiece(Piece piece) {
        this.piece = piece;
    }

    public int getFile() {
        return file;
    }

    public int getRank() {
        return rank;
    }

    public boolean isPawnMove(Position other) {
        int dx = Math.abs(this.file - other.file);
        int dy = Math.abs(this.rank - other.rank);
        if (dy != 1 || dx > 1) {
            return false;
        }
        if (dx == 1) {
            if (other.getPiece() == null) {
                return false;
            } else {
                return other.getPiece().getColor() != piece.getColor();
            }
        }
        return true;
    }

    public boolean onSameDiagonal(Position other) {
        return (this.file - this.rank == other.file - other.rank) || (this.file + rank == other.file + other.rank);
    }

    public boolean isL(Position other) {
        int dx = Math.abs(this.file - other.file);
        int dy = Math.abs(this.rank - other.rank);
        return (dx == 2 && dy == 1) || (dx == 1 && dy == 2);
    }

    public boolean onSameLine(Position other) {
        return onSameFile(other) ^ onSameRank(other);
    }

    private boolean onSameFile(Position other) {
        return this.rank == other.rank;
    }

    private boolean onSameRank(Position other) {
        return this.file == other.file;
    }

    public boolean isAdjacent(Position other) {
        return (Math.abs(this.file - other.file) >= 1 && Math.abs(this.rank - other.rank) >= 1);
    }

    public boolean isPathOpen(Position other) {
        int dx = Math.abs(this.file - other.file);
        int dy = Math.abs(this.rank - other.rank);
        if (dx == 0) {
            for (int i = this.rank + 1; i < other.rank; i++) {
                if (board.getTiles()[this.file][i].getPiece() != null) {
                    System.out.println("here");
                    return false;
                }
            }
        }
        if (dy == 0) {
            for (int i = this.file + 1; i < other.file; i++) {
                if (board.getTiles()[i][this.rank].getPiece() != null) {
                    System.out.println("here");
                    return false;
                }
            }
        }
        if (dx == dy) {
            if (this.rank > other.rank) {
                for (int i = this.rank; i < dx; i++) {
                    if (board.getTiles()[i][i].getPiece() != null) {
                        return false;
                    }
                }
            } else {
                for (int i = this.rank; i > dx; i--) {
                    if (board.getTiles()[i][i].getPiece() != null) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Position position = (Position) o;

        if (getFile() != position.getFile()) return false;
        if (getRank() != position.getRank()) return false;
        return getPiece() != null ? getPiece().equals(position.getPiece()) : position.getPiece() == null;
    }

    @Override
    public int hashCode() {
        int result = getPiece() != null ? getPiece().hashCode() : 0;
        result = 31 * result + getFile();
        result = 31 * result + getRank();
        return result;
    }

    @Override
    public String toString() {
        return piece != null ? piece.toString() : NotationUtility.ICON_SPACE;
    }
}
