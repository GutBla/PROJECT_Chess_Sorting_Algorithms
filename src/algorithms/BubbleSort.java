package algorithms;

import model.ChessBoard;
import model.ChessPiece;
import utils.GameUtils;
import java.util.List;

public class BubbleSort implements SortingAlgorithm {
    @Override
    public void sort(List<ChessPiece> chessPieces, int pauseDuration, ChessBoard board) throws InterruptedException {
        int n = chessPieces.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (chessPieces.get(j).compareTo(chessPieces.get(j + 1)) > 0) {
                    GameUtils.swapChessPieces(chessPieces, j, j + 1);
                    board.updateLayout(chessPieces);
                    GameUtils.updateBoardAndPause(board, chessPieces, pauseDuration);
                }
            }
        }
    }
    @Override
    public String getName() {
        return "Bubble Sort";
    }
}