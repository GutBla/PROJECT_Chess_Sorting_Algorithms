package algorithms;

import model.ChessBoard;
import model.ChessPiece;
import utils.GameUtils;
import java.util.List;

public class QuickSort implements SortingAlgorithm {
    @Override
    public void sort(List<ChessPiece> chessPieces, int pauseDuration, ChessBoard board) throws InterruptedException {
        quickSort(chessPieces, 0, chessPieces.size() - 1, pauseDuration, board);
    }
    private void quickSort(List<ChessPiece> chessPieces, int low, int high, int pauseDuration, ChessBoard board) throws InterruptedException {
        if (low < high) {
            int partitionIndex = partition(chessPieces, low, high, pauseDuration, board);
            quickSort(chessPieces, low, partitionIndex - 1, pauseDuration, board);
            quickSort(chessPieces, partitionIndex + 1, high, pauseDuration, board);
        }
    }
    private int partition(List<ChessPiece> chessPieces, int low, int high, int pauseDuration, ChessBoard board) throws InterruptedException {
        ChessPiece pivot = chessPieces.get(high);
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (chessPieces.get(j).compareTo(pivot) < 0) {
                i++;
                GameUtils.swapChessPieces(chessPieces, i, j);
                GameUtils.updateBoardAndPause(board, chessPieces, pauseDuration);
            }
        }
        GameUtils.swapChessPieces(chessPieces, i + 1, high);
        GameUtils.updateBoardAndPause(board, chessPieces, pauseDuration);
        return i + 1;
    }
    @Override
    public String getName() {
        return "Quick Sort";
    }
}

