package utils;

import model.ChessBoard;
import model.ChessPiece;
import java.util.List;

public class GameUtils {
    public static void updateBoardAndSleep(ChessBoard board, List<ChessPiece> pieces, int speed) throws InterruptedException {
        board.updateLayout(pieces);
        System.out.println(listToString(pieces, board.getListType()));
        Renderer.displayBoard(board);
        Thread.sleep(speed);
    }

    public static String listToString(List<ChessPiece> pieces, enums.ListType type) {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < pieces.size(); i++) {
            if (i > 0) sb.append(",");
            if (type == enums.ListType.NUMERIC) {
                sb.append(pieces.get(i).getType().getValue());
            } else {
                sb.append("'").append(pieces.get(i).getType().getCharValue()).append("'");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
