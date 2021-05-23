package com.alanbaumgartner.chess.pieces;

import com.alanbaumgartner.chess.Board;
import com.alanbaumgartner.chess.Position;

public class Piece {

    private final Color color;
    private Role role;

    public Piece(final Color color, final Role role) {
        this.color = color;
        this.role = role;
    }

    public boolean canMove(Board board, Position start, Position dest) {
        return switch (this.role) {
            case PAWN ->  start.isPathOpen(dest);
            case KNIGHT -> start.isL(dest) && start.isPathOpen(dest);
            case BISHOP -> start.onSameDiagonal(dest) && start.isPathOpen(dest);
            case ROOK -> start.onSameLine(dest) && start.isPathOpen(dest);
            case QUEEN -> (start.onSameDiagonal(dest) || start.onSameLine(dest)) && start.isPathOpen(dest);
            case KING -> start.isAdjacent(dest) && start.isPathOpen(dest);
        };
    }

    public Color getColor() {
        return color;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return this.role.getIcon(this.color);
    }

    public String getNotation() {
        return this.role.getNotation();
    }
}
