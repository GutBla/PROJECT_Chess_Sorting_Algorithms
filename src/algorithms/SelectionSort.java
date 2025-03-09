package algorithms;

import model.ChessBoard;
import model.ChessPiece;
import utils.GameUtils;
import java.util.List;

public class SelectionSort implements SortingAlgorithm {
    @Override
    public void sort(List<ChessPiece> chessPieces, int pauseDuration, ChessBoard board) throws InterruptedException {
        int n = chessPieces.size();
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (chessPieces.get(j).compareTo(chessPieces.get(minIndex)) < 0) minIndex = j;
            }
            if (minIndex != i) {
                GameUtils.swapChessPieces(chessPieces, i, minIndex);
                GameUtils.updateBoardAndPause(board, chessPieces, pauseDuration);
            }
        }
    }
    @Override
    public String getName() {
        return "Selection Sort";
    }
}