package utils;
import model.ChessBoard;
import model.ChessPiece;
import enums.ListType;
import metrics.MetricsManager;
import java.util.List;
public class GameUtils {
    public static void updateBoardAndPause(ChessBoard board, List<ChessPiece> chessPieces, int pauseDuration) throws InterruptedException {
        board.updateLayout(chessPieces);
        System.out.println(chessPiecesToString(chessPieces, board.getListType()));
        Renderer.displayBoard(board);
        MetricsManager.getInstance().getStepCounter().increment();
        Thread.sleep(pauseDuration);
    }
    public static void swapChessPieces(List<ChessPiece> chessPieces, int indexA, int indexB) {
        ChessPiece temp = chessPieces.get(indexA);
        chessPieces.set(indexA, chessPieces.get(indexB));
        chessPieces.set(indexB, temp);
    }
    public static String chessPiecesToString(List<ChessPiece> chessPieces, ListType listType) {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < chessPieces.size(); i++) {
            if (i > 0) sb.append(",");
            sb.append(chessPieces.get(i).getDisplayValue(listType == ListType.NUMERIC));
        }
        sb.append("]");
        return sb.toString();
    }
}