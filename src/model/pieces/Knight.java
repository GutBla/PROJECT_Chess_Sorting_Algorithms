package model.pieces;

import enums.PieceColor;
import model.ChessPiece;

public class Knight extends ChessPiece {
    public Knight(PieceColor color, int instance) {
        super(color, instance == 1 ? 7 : 8, instance == 1 ? "g" : "h", "♘", "♞");
    }
}
