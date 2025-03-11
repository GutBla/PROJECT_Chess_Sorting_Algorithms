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
        System.out.println(ConsoleColor.BLACK + "‖" + ConsoleColor.MORADO + "     INFORMACIÓN PRINCIPAL       " + ConsoleColor.BLACK + "‖" + ConsoleColor.RESET);
        System.out.println(ConsoleColor.BLACK + "╠=================================╣" + ConsoleColor.RESET);
        System.out.println(ConsoleColor.BLACK + "‖   " + ConsoleColor.RESET + "Algoritmo: " + ConsoleColor.VERDE + algorithm + ConsoleColor.RESET);
        System.out.println(ConsoleColor.BLACK + "‖   " + ConsoleColor.RESET + "Tipo de lista: " + ConsoleColor.AMARILLO + listType + ConsoleColor.RESET);
        System.out.println(ConsoleColor.BLACK + "‖   " + ConsoleColor.RESET + "Color de piezas: " + ConsoleColor.AZUL + color + ConsoleColor.RESET);
        System.out.println(ConsoleColor.BLACK + "‖   " + ConsoleColor.RESET + "Número de piezas: " + ConsoleColor.ROJO + pieces + ConsoleColor.RESET);
        System.out.println(ConsoleColor.BLACK + "‖   " + ConsoleColor.RESET + "Velocidad: " + ConsoleColor.CYAN + speed + ConsoleColor.RESET + " ms");
        System.out.println(ConsoleColor.BLACK + "╚=================================╝" + ConsoleColor.RESET);
    }

    public static void printTitle() {
        System.out.println(ConsoleColor.MORADO + " \n" +
                "  ██████ ██   ██ ███████ ███████ ███████ \n" +
                " ██      ██   ██ ██      ██      ██      \n" +
                " ██      ███████ █████   ███████ ███████ \n" +
                " ██      ██   ██ ██           ██      ██ \n" +
                "  ██████ ██   ██ ███████ ███████ ███████ \n" + ConsoleColor.RESET);
        System.out.println(ConsoleColor.BG_BLACK + "             SORTING ALGORITMS            " + ConsoleColor.RESET);
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
                String bgColor = (row + col) % 2 == 0 ? ConsoleColor.BG_BEIGE : ConsoleColor.BG_MORADO;

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
        System.out.println(ConsoleColor.MORADO + "\n┌──────────────────────────────┐");
        System.out.println("│      " + title + "       │");
        System.out.println("└──────────────────────────────┘" + ConsoleColor.RESET);
    }

    public static void printListTitle() {
        System.out.println(ConsoleColor.CYAN + "Lista: " + ConsoleColor.RESET);
    }

    public static void printTypeAndBoard(ChessBoard board) {
        System.out.println("\nTipo: " + (board.getListType() == ListType.NUMERIC ? ConsoleColor.AMARILLO + "Numérico" + ConsoleColor.RESET : ConsoleColor.AMARILLO + "Caracter" + ConsoleColor.RESET));
    }

    public static void printSortingInfo(SortingAlgorithm sortingAlgorithm) {
        System.out.println("Algoritmo: " + ConsoleColor.VERDE + sortingAlgorithm.getName() + ConsoleColor.RESET);
    }

    public static void printMetrics() {
        System.out.println("Tiempo total: " + ConsoleColor.CYAN + MetricsManager.getInstance().getTimeCounter().getFormattedElapsedTime() + ConsoleColor.RESET);
        System.out.println("Total de pasos: " + ConsoleColor.CYAN + MetricsManager.getInstance().getStepCounter().getSteps() + ConsoleColor.RESET);
    }
}
