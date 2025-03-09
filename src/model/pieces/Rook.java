package model.pieces;
import enums.PieceColor;
import model.ChessPiece;

public class Rook extends ChessPiece {
    public Rook(PieceColor color, int instance) {
        super(color, instance == 1 ? 3 : 4, instance == 1 ? "c" : "d", "♖", "♜");
    }
}
