package algorithms;

import model.ChessBoard;
import model.ChessPiece;
import utils.GameUtils;
import java.util.List;
import java.util.ArrayList;

public class RadixSort implements SortingAlgorithm {
    @Override
    public void sort(List<ChessPiece> chessPieces, int pauseDuration, ChessBoard board) throws InterruptedException {
        int max = chessPieces.stream().mapToInt(ChessPiece::getPieceValue).max().orElse(0);
        for (int exp = 1; max / exp > 0; exp *= 10) countSort(chessPieces, exp, pauseDuration, board);
    }
    private void countSort(List<ChessPiece> chessPieces, int exp, int pauseDuration, ChessBoard board) throws InterruptedException {
        ArrayList<ChessPiece> output = new ArrayList<>(chessPieces);
        int[] count = new int[10];
        for (ChessPiece p : chessPieces) count[(p.getPieceValue() / exp) % 10]++;
        for (int i = 1; i < 10; i++) count[i] += count[i - 1];
        for (int i = chessPieces.size() - 1; i >= 0; i--) {
            ChessPiece p = chessPieces.get(i);
            output.set(count[(p.getPieceValue() / exp) % 10] - 1, p);
            count[(p.getPieceValue() / exp) % 10]--;
            GameUtils.updateBoardAndPause(board, output, pauseDuration);
        }
        chessPieces.clear();
        chessPieces.addAll(output);
    }
    @Override
    public String getName() {
        return "Radix Sort";
    }
}

