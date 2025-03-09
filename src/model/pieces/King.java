package model.pieces;
import enums.PieceColor;
import model.ChessPiece;

public class King extends ChessPiece {
    public King(PieceColor color) {
        super(color, 1, "a", "♔", "♚");
    }
}
