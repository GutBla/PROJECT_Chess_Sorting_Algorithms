package algorithms;

import model.ChessBoard;
import model.ChessPiece;
import utils.GameUtils;
import java.util.List;
import java.util.ArrayList;

public class CountingSort implements SortingAlgorithm {
    @Override
    public void sort(List<ChessPiece> list, int speed, ChessBoard board) throws InterruptedException {
        int max = list.stream().mapToInt(p -> p.getType().getValue()).max().orElse(0);
        int[] count = new int[max + 1];
        List<ChessPiece> output = new ArrayList<>(list);
        for (ChessPiece p : list) {
            count[p.getType().getValue()]++;
        }
        for (int i = 1; i <= max; i++) {
            count[i] += count[i - 1];
        }
        for (int i = list.size() - 1; i >= 0; i--) {
            ChessPiece p = list.get(i);
            output.set(count[p.getType().getValue()] - 1, p);
            count[p.getType().getValue()]--;
            GameUtils.updateBoardAndSleep(board, output, speed);
        }
        list.clear();
        list.addAll(output);
    }

    @Override
    public String getName() {
        return "Counting Sort";
    }
}
