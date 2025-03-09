package model.pieces;
import enums.PieceColor;
import model.ChessPiece;

public class Queen extends ChessPiece {
    public Queen(PieceColor color) {
        super(color, 2, "b", "♕", "♛");
    }
}
