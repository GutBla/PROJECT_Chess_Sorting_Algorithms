package utils;

import model.ChessBoard;
import model.ChessPiece;
import enums.ListType;
import java.util.List;

public class GameUtils {

    private static int stepCounter = 0;

    public static void resetStepCounter() {
        stepCounter = 0;
    }

    public static void incrementStepCounter() {
        stepCounter++;
    }

    public static int getStepCounter() {
        return stepCounter;
    }

    public static void updateBoardAndPause(ChessBoard board, List<ChessPiece> chessPieces, int pauseDuration) throws InterruptedException {
        board.updateLayout(chessPieces);
        System.out.println(chessPiecesToString(chessPieces, board.getListType()));
        Renderer.displayBoard(board);
        incrementStepCounter();
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
            if (listType == ListType.NUMERIC) {
                sb.append(chessPieces.get(i).getType().getValue());
            } else {
                sb.append("'").append(chessPieces.get(i).getType().getCharValue()).append("'");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
