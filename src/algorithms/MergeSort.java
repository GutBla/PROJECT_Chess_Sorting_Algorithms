package algorithms;

import model.ChessBoard;
import model.ChessPiece;
import utils.GameUtils;
import java.util.List;
import java.util.ArrayList;

public class MergeSort implements SortingAlgorithm {
    @Override
    public void sort(List<ChessPiece> list, int speed, ChessBoard board) throws InterruptedException {
        mergeSort(list, 0, list.size() - 1, speed, board);
    }

    private void mergeSort(List<ChessPiece> list, int l, int r, int speed, ChessBoard board) throws InterruptedException {
        if (l < r) {
            int m = l + (r - l) / 2;
            mergeSort(list, l, m, speed, board);
            mergeSort(list, m + 1, r, speed, board);
            merge(list, l, m, r, speed, board);
        }
    }

    private void merge(List<ChessPiece> list, int l, int m, int r, int speed, ChessBoard board) throws InterruptedException {
        List<ChessPiece> left = new ArrayList<>(list.subList(l, m + 1));
        List<ChessPiece> right = new ArrayList<>(list.subList(m + 1, r + 1));
        int i = 0, j = 0, k = l;
        while (i < left.size() && j < right.size()) {
            if (left.get(i).compareTo(right.get(j)) <= 0)
                list.set(k++, left.get(i++));
            else
                list.set(k++, right.get(j++));
            GameUtils.updateBoardAndSleep(board, list, speed);
        }
        while (i < left.size()) {
            list.set(k++, left.get(i++));
            GameUtils.updateBoardAndSleep(board, list, speed);
        }
        while (j < right.size()) {
            list.set(k++, right.get(j++));
            GameUtils.updateBoardAndSleep(board, list, speed);
        }
    }

    @Override
    public String getName() {
        return "Merge Sort";
    }
}
