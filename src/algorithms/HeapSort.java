package algorithms;

import model.ChessBoard;
import model.ChessPiece;
import utils.GameUtils;
import java.util.List;

public class HeapSort implements SortingAlgorithm {

    @Override
    public void sort(List<ChessPiece> chessPieces, int pauseDuration, ChessBoard board) throws InterruptedException {
        int n = chessPieces.size();
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(chessPieces, n, i, pauseDuration, board);
        }
        for (int i = n - 1; i > 0; i--) {
            GameUtils.swapChessPieces(chessPieces, 0, i);
            GameUtils.updateBoardAndPause(board, chessPieces, pauseDuration);
            heapify(chessPieces, i, 0, pauseDuration, board);
        }
    }

    private void heapify(List<ChessPiece> chessPieces, int n, int i, int pauseDuration, ChessBoard board) throws InterruptedException {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < n && chessPieces.get(left).compareTo(chessPieces.get(largest)) > 0) {
            largest = left;
        }
        if (right < n && chessPieces.get(right).compareTo(chessPieces.get(largest)) > 0) {
            largest = right;
        }
        if (largest != i) {
            GameUtils.swapChessPieces(chessPieces, i, largest);
            GameUtils.updateBoardAndPause(board, chessPieces, pauseDuration);
            heapify(chessPieces, n, largest, pauseDuration, board);
        }
    }

    @Override
    public String getName() {
        return "Heap Sort";
    }
}
