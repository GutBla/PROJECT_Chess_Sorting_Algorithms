package model.pieces;

import enums.PieceColor;
import model.ChessBoard;
import model.ChessCell;
import model.ChessPiece;

import java.util.Collections;
import java.util.List;

/**
 * Representa una pieza vacía / placeholder.
 * Símbolo: IDEOGRAPHIC SPACE (U+3000) -> "　"
 * Valor: 0 (para que aparezca antes en ordenamientos numéricos)
 */
public class Empty extends ChessPiece {

    public static final String SYMBOL = "　";

    public Empty() {
        super(PieceColor.WHITE, 0, " ", SYMBOL, SYMBOL);
    }

    // No necesita movimientos legales: devuelve lista vacía para compatibilidad.
    public List<ChessCell> getLegalMoves(ChessBoard board) {
        return Collections.emptyList();
    }
}
