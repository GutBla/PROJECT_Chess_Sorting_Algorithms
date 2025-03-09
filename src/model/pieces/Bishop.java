package model.pieces;

import enums.PieceColor;
import model.ChessPiece;

public class Bishop extends ChessPiece {
    public Bishop(PieceColor color, int instance) {
        super(color, instance == 1 ? 5 : 6, instance == 1 ? "e" : "f", "♗", "♝");
    }
}
