package utils;

import enums.ListType;
import enums.PieceColor;
import model.ChessBoard;
import model.ChessPiece;
import model.ChessCell;

public class Renderer {


    public static void printErrorConfig(String algorithm, String listType, String color, String pieces, String speed) {
        printTitle();
        System.out.println("==========================================================");
        System.out.println("|                INFORMACION PRINCIPAL                   |");
        System.out.println("==========================================================");
        System.out.println("Algoritmo: [" + algorithm + "]");
        System.out.println("Tipo de lista: [" + listType + "]");
        System.out.println("Color de piezas: [" + color + "]");
        System.out.println("Número de piezas: [" + pieces + "]");
        System.out.println("Velocidad: [" + speed + "]");
        System.out.println("==========================================================");
    }


    public static void printConfig(String algorithm, ListType listType, PieceColor color, int pieces, int speed) {
        printTitle();
        System.out.println("==========================================================");
        System.out.println(ConsoleColor.colorText(ConsoleColor.MORADO, "|                INFORMACION PRINCIPAL                   |"));
        System.out.println("==========================================================");

        String listTypeText = listType == ListType.NUMERIC ? "Numérico" : "Caracter";
        String colorText = color == PieceColor.WHITE ? "Blancas" : "Negras";

        System.out.println("Algoritmo: [" + ConsoleColor.colorText(ConsoleColor.VERDE, algorithm) + "]");
        System.out.println("Tipo de lista: [" + ConsoleColor.colorText(ConsoleColor.AMARILLO, listTypeText) + "]");
        System.out.println("Color de piezas: [" + ConsoleColor.colorText(ConsoleColor.AZUL, colorText) + "]");
        System.out.println("Número de piezas: [" + ConsoleColor.colorText(ConsoleColor.ROJO, String.valueOf(pieces)) + "]");
        System.out.println("Velocidad: [" + ConsoleColor.colorText(ConsoleColor.NARANJA, String.valueOf(speed)) + "] ms");
        System.out.println("==========================================================");
    }

    public static void printTitle() {
        System.out.println(ConsoleColor.colorText(ConsoleColor.MORADO, "             _____ _    _ ______  _____ _____ "));
        System.out.println(ConsoleColor.colorText(ConsoleColor.MORADO, "            / ____| |  | |  ____|/ ____/ ____|"));
        System.out.println(ConsoleColor.colorText(ConsoleColor.MORADO, "           | |    | |__| | |__  | (___| (___  "));
        System.out.println(ConsoleColor.colorText(ConsoleColor.MORADO, "           | |    |  __  |  __|  \\___ \\\\___ \\ "));
        System.out.println(ConsoleColor.colorText(ConsoleColor.MORADO, "           | |____| |  | | |____ ____) |___) |"));
        System.out.println(ConsoleColor.colorText(ConsoleColor.MORADO, "            \\_____|_|  |_|______|_____/_____/ "));
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
                sb.append(piece != null ? ConsoleColor.colorText(ConsoleColor.MORADO, " " + piece.getSymbol() + " ") : "    ").append("|");
            }
            sb.append("\n  +----+----+----+----+----+----+----+----+\n");
        }

        sb.append("    A    B    C    D    E    F    G    H\n");
        return sb.toString();
    }
}
