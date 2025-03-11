package utils;

import enums.PieceColor;
import model.ChessBoard;
import model.ChessCell;
import model.ChessPiece;

public class Renderer {
    public static void printConfig(String algorithm, String listType, String color, String pieces, String speed) {
        printTitle();
        System.out.println("==========================================================");
        System.out.println("|                INFORMACION PRINCIPAL                   |");
        System.out.println("==========================================================");
        System.out.println("Algoritmo: " + algorithm);
        System.out.println("Tipo de lista: " + listType);
        System.out.println("Color de piezas: " + color);
        System.out.println("Número de piezas: " + pieces);
        System.out.println("Velocidad: " + speed + " ms");
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
                    sb.append(" ").append(pieceColor).append(piece.getSymbol()).append(ConsoleColor.RESET).append(" ");
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
