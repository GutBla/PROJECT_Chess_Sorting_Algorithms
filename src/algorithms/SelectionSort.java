package algorithms;

import model.ChessBoard;
import model.ChessPiece;
import utils.GameUtils;
import java.util.List;

public class SelectionSort implements SortingAlgorithm {
    @Override
    public void sort(List<ChessPiece> list, int speed, ChessBoard board) throws InterruptedException {
        for (int i = 0; i < list.size() - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < list.size(); j++) {
                if (list.get(j).compareTo(list.get(minIndex)) < 0) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                ChessPiece temp = list.get(i);
                list.set(i, list.get(minIndex));
                list.set(minIndex, temp);
                GameUtils.updateBoardAndSleep(board, list, speed);
            }
        }
    }

    @Override
    public String getName() {
        return "Selection Sort";
    }
}
