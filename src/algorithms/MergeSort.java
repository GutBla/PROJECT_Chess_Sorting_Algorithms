package algorithms;

import model.ChessBoard;
import model.ChessPiece;
import utils.GameUtils;
import java.util.List;
import java.util.ArrayList;

public class MergeSort implements SortingAlgorithm {
    @Override
    public void sort(List<ChessPiece> chessPieces, int pauseDuration, ChessBoard board) throws InterruptedException {
        mergeSort(chessPieces, 0, chessPieces.size() - 1, pauseDuration, board);
    }
    private void mergeSort(List<ChessPiece> chessPieces, int left, int right, int pauseDuration, ChessBoard board) throws InterruptedException {
        if (left < right) {
            int middle = left + (right - left) / 2;
            mergeSort(chessPieces, left, middle, pauseDuration, board);
            mergeSort(chessPieces, middle + 1, right, pauseDuration, board);
            merge(chessPieces, left, middle, right, pauseDuration, board);
        }
    }
    private void merge(List<ChessPiece> chessPieces, int left, int middle, int right, int pauseDuration, ChessBoard board) throws InterruptedException {
        ArrayList<ChessPiece> leftList = new ArrayList<>(chessPieces.subList(left, middle + 1));
        ArrayList<ChessPiece> rightList = new ArrayList<>(chessPieces.subList(middle + 1, right + 1));
        int i = 0, j = 0, k = left;
        while (i < leftList.size() && j < rightList.size()) {
            if (leftList.get(i).compareTo(rightList.get(j)) <= 0) chessPieces.set(k++, leftList.get(i++));
            else chessPieces.set(k++, rightList.get(j++));
            GameUtils.updateBoardAndPause(board, chessPieces, pauseDuration);
        }
        while (i < leftList.size()) {
            chessPieces.set(k++, leftList.get(i++));
            GameUtils.updateBoardAndPause(board, chessPieces, pauseDuration);
        }
        while (j < rightList.size()) {
            chessPieces.set(k++, rightList.get(j++));
            GameUtils.updateBoardAndPause(board, chessPieces, pauseDuration);
        }
    }
    @Override
    public String getName() {
        return "Merge Sort";
    }
}