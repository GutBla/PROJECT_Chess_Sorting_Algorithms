package algorithms;

import model.ChessBoard;
import model.ChessPiece;
import utils.GameUtils;
import java.util.List;

public class BubbleSort implements SortingAlgorithm {
    @Override
    public void sort(List<ChessPiece> pieces, int speed, ChessBoard board) throws InterruptedException {
        int n = pieces.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (pieces.get(j).compareTo(pieces.get(j + 1)) > 0) {
                    ChessPiece temp = pieces.get(j);
                    pieces.set(j, pieces.get(j + 1));
                    pieces.set(j + 1, temp);
                    board.updateLayout(pieces);
                    GameUtils.updateBoardAndSleep(board, pieces, speed);
                }
            }
        }
    }

    @Override
    public String getName() {
        return "Bubble Sort";
    }
}
