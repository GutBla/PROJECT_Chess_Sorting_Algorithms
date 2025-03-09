package model.pieces;

import enums.PieceColor;
import model.ChessPiece;

public class Pawn extends ChessPiece {
    public Pawn(PieceColor color, int instance) {
        super(color, 8 + instance, String.valueOf((char)('i' + instance - 1)), "♙", "♟");
    }
}
