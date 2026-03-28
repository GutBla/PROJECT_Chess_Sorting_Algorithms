package model.pieces;

import enums.PieceColor;
import model.ChessBoard;
import model.ChessCell;
import model.ChessPiece;

import java.util.Collections;
import java.util.List;

public class Empty extends ChessPiece {

    public static final String SYMBOL = "　";

    public Empty() {
        super(PieceColor.WHITE, 0, " ", SYMBOL, SYMBOL);
    }

    public List<ChessCell> getLegalMoves(ChessBoard board) {
        return Collections.emptyList();
    }
}
