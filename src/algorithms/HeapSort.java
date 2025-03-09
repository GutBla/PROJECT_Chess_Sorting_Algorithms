package algorithms;

import model.ChessBoard;
import model.ChessPiece;
import utils.GameUtils;
import java.util.List;

public class HeapSort implements SortingAlgorithm {
    @Override
    public void sort(List<ChessPiece> list, int speed, ChessBoard board) throws InterruptedException {
        int n = list.size();
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(list, n, i, speed, board);
        }
        for (int i = n - 1; i > 0; i--) {
            ChessPiece temp = list.get(0);
            list.set(0, list.get(i));
            list.set(i, temp);
            GameUtils.updateBoardAndSleep(board, list, speed);
            heapify(list, i, 0, speed, board);
        }
    }

    private void heapify(List<ChessPiece> list, int n, int i, int speed, ChessBoard board) throws InterruptedException {
        int largest = i, l = 2 * i + 1, r = 2 * i + 2;
        if (l < n && list.get(l).compareTo(list.get(largest)) > 0)
            largest = l;
        if (r < n && list.get(r).compareTo(list.get(largest)) > 0)
            largest = r;
        if (largest != i) {
            ChessPiece temp = list.get(i);
            list.set(i, list.get(largest));
            list.set(largest, temp);
            GameUtils.updateBoardAndSleep(board, list, speed);
            heapify(list, n, largest, speed, board);
        }
    }

    @Override
    public String getName() {
        return "Heap Sort";
    }
}
