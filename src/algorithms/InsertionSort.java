package algorithms;
import model.ChessBoard;
import model.ChessPiece;
import utils.GameUtils;
import java.util.List;
public class InsertionSort implements SortingAlgorithm {
    @Override
    public void sort(List<ChessPiece> chessPieces, int pauseDuration, ChessBoard board) throws InterruptedException {
        for (int i = 1; i < chessPieces.size(); i++) {
            ChessPiece keyPiece = chessPieces.get(i);
            int j = i - 1;
            while (j >= 0 && chessPieces.get(j).compareTo(keyPiece) > 0) {
                chessPieces.set(j + 1, chessPieces.get(j));
                j--;
                GameUtils.updateBoardAndPause(board, chessPieces, pauseDuration);
            }
            chessPieces.set(j + 1, keyPiece);
            GameUtils.updateBoardAndPause(board, chessPieces, pauseDuration);
        }
    }
    @Override
    public String getName() {
        return "Insertion Sort";
    }
}

