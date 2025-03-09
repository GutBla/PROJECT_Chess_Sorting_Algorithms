package algorithms;

import model.ChessBoard;
import model.ChessPiece;
import utils.GameUtils;
import java.util.List;
import java.util.ArrayList;

public class RadixSort implements SortingAlgorithm {
    @Override
    public void sort(List<ChessPiece> list, int speed, ChessBoard board) throws InterruptedException {
        int max = list.stream().mapToInt(p -> p.getType().getValue()).max().orElse(0);
        for (int exp = 1; max / exp > 0; exp *= 10) {
            countSort(list, exp, speed, board);
        }
    }

    private void countSort(List<ChessPiece> list, int exp, int speed, ChessBoard board) throws InterruptedException {
        List<ChessPiece> output = new ArrayList<>(list);
        int[] count = new int[10];
        for (ChessPiece p : list) {
            count[(p.getType().getValue() / exp) % 10]++;
        }
        for (int i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }
        for (int i = list.size() - 1; i >= 0; i--) {
            ChessPiece p = list.get(i);
            output.set(count[(p.getType().getValue() / exp) % 10] - 1, p);
            count[(p.getType().getValue() / exp) % 10]--;
            GameUtils.updateBoardAndSleep(board, output, speed);
        }
        list.clear();
        list.addAll(output);
    }

    @Override
    public String getName() {
        return "Radix Sort";
    }
}

