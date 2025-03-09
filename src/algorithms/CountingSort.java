package algorithms;

import model.ChessBoard;
import model.ChessPiece;
import utils.GameUtils;
import java.util.List;
import java.util.ArrayList;

public class CountingSort implements SortingAlgorithm {

    @Override
    public void sort(List<ChessPiece> chessPieces, int pauseDuration, ChessBoard board) throws InterruptedException {
        int max = chessPieces.stream().mapToInt(p -> p.getType().getValue()).max().orElse(0);
        int[] count = new int[max + 1];
        ArrayList<ChessPiece> output = new ArrayList<>(chessPieces);

        for (ChessPiece p : chessPieces) {
            count[p.getType().getValue()]++;
        }
        for (int i = 1; i <= max; i++) {
            count[i] += count[i - 1];
        }
        for (int i = chessPieces.size() - 1; i >= 0; i--) {
            ChessPiece p = chessPieces.get(i);
            output.set(count[p.getType().getValue()] - 1, p);
            count[p.getType().getValue()]--;
            GameUtils.updateBoardAndPause(board, output, pauseDuration);
        }
        chessPieces.clear();
        chessPieces.addAll(output);
    }

    @Override
    public String getName() {
        return "Counting Sort";
    }
}
