package algorithms;

import model.ChessBoard;
import model.ChessPiece;
import utils.GameUtils;
import java.util.List;

public class InsertionSort implements SortingAlgorithm {
    @Override
    public void sort(List<ChessPiece> list, int speed, ChessBoard board) throws InterruptedException {
        for (int i = 1; i < list.size(); i++) {
            ChessPiece key = list.get(i);
            int j = i - 1;
            while (j >= 0 && list.get(j).compareTo(key) > 0) {
                list.set(j + 1, list.get(j));
                j--;
                GameUtils.updateBoardAndSleep(board, list, speed);
            }
            list.set(j + 1, key);
            GameUtils.updateBoardAndSleep(board, list, speed);
        }
    }

    @Override
    public String getName() {
        return "Insertion Sort";
    }
}
