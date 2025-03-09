package algorithms;

import model.ChessBoard;
import model.ChessPiece;
import utils.GameUtils;
import java.util.List;

public class QuickSort implements SortingAlgorithm {
    @Override
    public void sort(List<ChessPiece> list, int speed, ChessBoard board) throws InterruptedException {
        quickSort(list, 0, list.size() - 1, speed, board);
    }

    private void quickSort(List<ChessPiece> list, int low, int high, int speed, ChessBoard board) throws InterruptedException {
        if (low < high) {
            int pi = partition(list, low, high, speed, board);
            quickSort(list, low, pi - 1, speed, board);
            quickSort(list, pi + 1, high, speed, board);
        }
    }

    private int partition(List<ChessPiece> list, int low, int high, int speed, ChessBoard board) throws InterruptedException {
        ChessPiece pivot = list.get(high);
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (list.get(j).compareTo(pivot) < 0) {
                i++;
                ChessPiece temp = list.get(i);
                list.set(i, list.get(j));
                list.set(j, temp);
                GameUtils.updateBoardAndSleep(board, list, speed);
            }
        }
        ChessPiece temp = list.get(i + 1);
        list.set(i + 1, list.get(high));
        list.set(high, temp);
        GameUtils.updateBoardAndSleep(board, list, speed);
        return i + 1;
    }

    @Override
    public String getName() {
        return "Quick Sort";
    }
}
