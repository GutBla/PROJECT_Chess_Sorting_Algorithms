package utils;

import enums.ListType;
import enums.PieceColor;
import model.ChessBoard;
import model.ChessCell;
import model.ChessPiece;

public class Renderer {
    public static void printConfig(String algorithm, ListType listType, PieceColor color, int pieces, int speed) {
        printTitle();
        System.out.println("==========================================================");
        System.out.println("|                INFORMACION PRINCIPAL                   |");
        System.out.println("==========================================================");
        String listTypeText = listType == ListType.NUMERIC ? ConsoleColor.AMARILLO + "Numérico" + ConsoleColor.RESET : ConsoleColor.AMARILLO + "Caracter" + ConsoleColor.RESET;
        String colorText = color == PieceColor.WHITE ? ConsoleColor.AZUL + "Blancas" + ConsoleColor.RESET : ConsoleColor.AZUL + "Negras" + ConsoleColor.RESET;
        System.out.println("Algoritmo: [" + ConsoleColor.VERDE + algorithm + ConsoleColor.RESET + "]");
        System.out.println("Tipo de lista: [" + listTypeText + "]");
        System.out.println("Color de piezas: [" + colorText + "]");
        System.out.println("Número de piezas: [" + ConsoleColor.ROJO + pieces + ConsoleColor.RESET + "]");
        System.out.println("Velocidad: [" + ConsoleColor.CYAN + speed + ConsoleColor.RESET + "] ms");
        System.out.println("==========================================================");
    }

    public static void printErrorConfig(String algorithm, String listType, String color, String pieceCount, String speed) {
        printTitle();
        System.out.println("==========================================================");
        System.out.println("|                INFORMACION PRINCIPAL                   |");
        System.out.println("==========================================================");
        System.out.println("Algoritmo: " + ConsoleColor.ROJO + algorithm + ConsoleColor.RESET);
        System.out.println("Tipo de lista: " + ConsoleColor.ROJO + listType + ConsoleColor.RESET);
        System.out.println("Color de piezas: " + ConsoleColor.ROJO + color + ConsoleColor.RESET);
        System.out.println("Número de piezas: " + ConsoleColor.ROJO + pieceCount + ConsoleColor.RESET);
        System.out.println("Velocidad: " + ConsoleColor.ROJO + speed + ConsoleColor.RESET);
        System.out.println("==========================================================");
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
        sb.append("\n  +----+----+----+----+----+----+----+----+\n");
        for (int row = 7; row >= 0; row--) {
            sb.append(row + 1).append(" |");
            for (int col = 0; col < 8; col++) {
                ChessPiece piece = grid[row][col].getPiece();
                if (piece != null) {
                    String pieceColor = piece.getColor() == PieceColor.WHITE ? ConsoleColor.WHITE : ConsoleColor.BLACK;
                    sb.append(" " + pieceColor + piece.getSymbol() + ConsoleColor.RESET + " ");
                } else {
                    sb.append("    ");
                }
                sb.append("|");
            }
            sb.append("\n  +----+----+----+----+----+----+----+----+\n");
        }
        sb.append("    A    B    C    D    E    F    G    H\n");
        return sb.toString();
    }
}
