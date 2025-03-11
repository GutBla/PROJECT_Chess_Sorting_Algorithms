package utils;

import enums.PieceColor;
import model.ChessBoard;
import model.ChessCell;
import model.ChessPiece;

public class Renderer {
    public static void printConfig(String algorithm, String listType, String color, String pieces, String speed) {
        printTitle();
        System.out.println(ConsoleColor.CYAN + "==========================================================" + ConsoleColor.RESET);
        System.out.println(ConsoleColor.MORADO + "|                INFORMACIÓN PRINCIPAL                   |" + ConsoleColor.RESET);
        System.out.println(ConsoleColor.CYAN + "==========================================================" + ConsoleColor.RESET);
        System.out.println("Algoritmo: " + ConsoleColor.VERDE + algorithm + ConsoleColor.RESET);
        System.out.println("Tipo de lista: " + ConsoleColor.AMARILLO + listType + ConsoleColor.RESET);
        System.out.println("Color de piezas: " + ConsoleColor.AZUL + color + ConsoleColor.RESET);
        System.out.println("Número de piezas: " + ConsoleColor.ROJO + pieces + ConsoleColor.RESET);
        System.out.println("Velocidad: " + ConsoleColor.CYAN + speed + ConsoleColor.RESET + " ms");
        System.out.println(ConsoleColor.CYAN + "==========================================================" + ConsoleColor.RESET);
    }

    public static void printTitle() {
        System.out.println(ConsoleColor.MORADO + "             _____ _    _ ______  _____ _____ ");
        System.out.println("            / ____| |  | |  ____|/ ____/ ____|");
        System.out.println("           | |    | |__| | |__  | (___| (___  ");
        System.out.println("           | |    |  __  |  __|  \\___ \\\\___ \\ ");
        System.out.println("           | |____| |  | | |____ ____) |___) |");
        System.out.println("            \\_____|_|  |_|______|_____/_____/ " + ConsoleColor.RESET);
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
}
