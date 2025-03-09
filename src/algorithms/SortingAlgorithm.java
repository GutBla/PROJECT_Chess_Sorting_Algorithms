package algorithms;

import model.ChessBoard;
import model.ChessPiece;
import java.util.List;

public interface SortingAlgorithm {
    void sort(List<ChessPiece> pieces, int speed, ChessBoard board) throws InterruptedException;
    String getName();
}
