package utils;

import algorithms.SortingAlgorithm;
import enums.ListType;
import enums.PieceColor;
import metrics.MetricsManager;
import model.ChessBoard;
import model.ChessCell;
import model.ChessPiece;

public class Renderer {
    public static void printConfig(String algorithm, String listType, String color, String pieces, String speed) {
        printTitle();
        System.out.println(ConsoleColor.BLACK + "╔=================================╗" + ConsoleColor.RESET);
        System.out.println(ConsoleColor.BLACK + "‖" + ConsoleColor.PURPLE + "      MAIN INFORMATION       " + ConsoleColor.BLACK + "‖" + ConsoleColor.RESET);
        System.out.println(ConsoleColor.BLACK + "╠=================================╣" + ConsoleColor.RESET);
        System.out.println(ConsoleColor.BLACK + "‖   " + ConsoleColor.RESET + "Algorithm: " + ConsoleColor.GREEN + algorithm + ConsoleColor.RESET);
        System.out.println(ConsoleColor.BLACK + "‖   " + ConsoleColor.RESET + "List type: " + ConsoleColor.YELLOW + listType + ConsoleColor.RESET);
        System.out.println(ConsoleColor.BLACK + "‖   " + ConsoleColor.RESET + "Piece color: " + ConsoleColor.BLUE + color + ConsoleColor.RESET);
        System.out.println(ConsoleColor.BLACK + "‖   " + ConsoleColor.RESET + "Number of pieces: " + ConsoleColor.RED + pieces + ConsoleColor.RESET);
        System.out.println(ConsoleColor.BLACK + "‖   " + ConsoleColor.RESET + "Speed: " + ConsoleColor.CYAN + speed + ConsoleColor.RESET + " ms");
        System.out.println(ConsoleColor.BLACK + "╚=================================╝" + ConsoleColor.RESET);
    }

    public static void printTitle() {
        System.out.println(ConsoleColor.PURPLE + " \n" +
                "  █▀▀█  █  █  █▀▀▀  █▀▀▀█  █▀▀▀█ \n" +
                "  █     █▀▀█  █▀▀▀  ▀▀▀▄▄  ▀▀▀▄▄  \n" +
                "  █▄▄█  █  █  █▄▄▄  █▄▄▄█  █▄▄▄█\n" + ConsoleColor.RESET);
        System.out.println(ConsoleColor.BG_BLACK + "         SORTING ALGORITHMS         " + ConsoleColor.RESET);
    }

    public static void displayBoard(ChessBoard board) {
        System.out.println(getBoardDesign(board));
    }
    private static String getBoardDesign(ChessBoard board) {
        ChessCell[][] grid = board.getGrid();
        StringBuilder sb = new StringBuilder();
        sb.append("\n");

        for (int row = 7; row >= 0; row--) {
            sb.append(row + 1).append(" ");
            for (int col = 0; col < 8; col++) {
                ChessPiece piece = grid[row][col].getPiece();
                String bgColor = (row + col) % 2 == 0 ? ConsoleColor.BG_PURPLE : ConsoleColor.BG_BEIGE;

                if (piece != null) {
                    String pieceColor = piece.getColor() == PieceColor.WHITE ? ConsoleColor.WHITE : ConsoleColor.BLACK;
                    sb.append(bgColor).append(" ").append(pieceColor).append(piece.getSymbol()).append(" ").append(ConsoleColor.RESET);
                } else {
                    sb.append(bgColor).append(" 　 ").append(ConsoleColor.RESET);
                }
            }
            sb.append("\n");
        }
        sb.append(" 　A 　B 　C 　D 　E 　F 　G 　H\n");
        return sb.toString();
    }

    public static void printBoardTitle(String title) {
        System.out.println(ConsoleColor.PURPLE + "\n┌──────────────────────────────┐");
        System.out.println("│      " + title + "       │");
        System.out.println("└──────────────────────────────┘" + ConsoleColor.RESET);
    }

    public static void printListTitle() {
        System.out.println(ConsoleColor.CYAN + "List: " + ConsoleColor.RESET);
    }

    public static void printTypeAndBoard(ChessBoard board) {
        System.out.println("\nType: " + (board.getListType() == ListType.NUMERIC ? ConsoleColor.YELLOW + "Numeric" + ConsoleColor.RESET : ConsoleColor.YELLOW + "Character" + ConsoleColor.RESET));
    }

    public static void printSortingInfo(SortingAlgorithm sortingAlgorithm) {
        System.out.println("Algorithm: " + ConsoleColor.GREEN + sortingAlgorithm.getName() + ConsoleColor.RESET);
    }

    public static void printMetrics() {
        System.out.println("Total time: " + ConsoleColor.CYAN + MetricsManager.getInstance().getTimeCounter().getFormattedElapsedTime() + ConsoleColor.RESET);
        System.out.println("Total steps: " + ConsoleColor.CYAN + MetricsManager.getInstance().getStepCounter().getSteps() + ConsoleColor.RESET);
    }
}
