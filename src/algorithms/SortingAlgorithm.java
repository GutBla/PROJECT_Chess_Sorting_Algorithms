package algorithms;

import model.ChessBoard;
import model.ChessPiece;
import java.util.List;

public interface SortingAlgorithm {
    void sort(List<ChessPiece> chessPieces, int pauseDuration, ChessBoard board) throws InterruptedException;
    String getName();
}
