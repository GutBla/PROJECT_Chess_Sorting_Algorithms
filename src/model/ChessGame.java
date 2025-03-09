package model;

import algorithms.SortingAlgorithm;
import enums.ListType;
import enums.PieceColor;
import enums.PieceType;
import utils.GameUtils;
import utils.Renderer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ChessGame {
    private final SortingAlgorithm sortingAlgorithm;
    private final ChessBoard board;
    private final int pauseDuration;
    private final List<ChessPiece> chessPieces;

    public ChessGame(SortingAlgorithm sortingAlgorithm, ListType listType, PieceColor color, int pieceCount, int pauseDuration) {
        this.sortingAlgorithm = sortingAlgorithm;
        this.board = new ChessBoard(listType);
        this.pauseDuration = pauseDuration;
        List<ChessPiece> generatedPieces = generateChessPieces(color, pieceCount);
        this.chessPieces = board.placePiecesRandomly(generatedPieces);
    }

    private List<ChessPiece> generateChessPieces(PieceColor color, int pieceCount) {
        ArrayList<ChessPiece> pieces = new ArrayList<>();
        switch (pieceCount) {
            case 1:
                pieces.add(new ChessPiece(PieceType.KING, color));
                break;
            case 2:
                pieces.add(new ChessPiece(PieceType.KING, color));
                pieces.add(new ChessPiece(PieceType.QUEEN, color));
                break;
            case 4:
                pieces.add(new ChessPiece(PieceType.KING, color));
                pieces.add(new ChessPiece(PieceType.QUEEN, color));
                pieces.add(new ChessPiece(PieceType.BISHOP_ONE, color));
                pieces.add(new ChessPiece(PieceType.BISHOP_TWO, color));
                break;
            case 6:
                pieces.add(new ChessPiece(PieceType.KING, color));
                pieces.add(new ChessPiece(PieceType.QUEEN, color));
                pieces.add(new ChessPiece(PieceType.BISHOP_ONE, color));
                pieces.add(new ChessPiece(PieceType.BISHOP_TWO, color));
                pieces.add(new ChessPiece(PieceType.KNIGHT_ONE, color));
                pieces.add(new ChessPiece(PieceType.KNIGHT_TWO, color));
                break;
            case 8:
                pieces.add(new ChessPiece(PieceType.KING, color));
                pieces.add(new ChessPiece(PieceType.QUEEN, color));
                pieces.add(new ChessPiece(PieceType.BISHOP_ONE, color));
                pieces.add(new ChessPiece(PieceType.BISHOP_TWO, color));
                pieces.add(new ChessPiece(PieceType.KNIGHT_ONE, color));
                pieces.add(new ChessPiece(PieceType.KNIGHT_TWO, color));
                pieces.add(new ChessPiece(PieceType.ROOK_ONE, color));
                pieces.add(new ChessPiece(PieceType.ROOK_TWO, color));
                break;
            case 10:
                pieces.add(new ChessPiece(PieceType.PAWN_ONE, color));
                pieces.add(new ChessPiece(PieceType.PAWN_TWO, color));
                pieces.add(new ChessPiece(PieceType.PAWN_THREE, color));
                pieces.add(new ChessPiece(PieceType.PAWN_FOUR, color));
                pieces.add(new ChessPiece(PieceType.PAWN_FIVE, color));
                pieces.add(new ChessPiece(PieceType.PAWN_SIX, color));
                pieces.add(new ChessPiece(PieceType.PAWN_SEVEN, color));
                pieces.add(new ChessPiece(PieceType.PAWN_EIGHT, color));
                pieces.add(new ChessPiece(PieceType.PAWN_ONE, color));
                pieces.add(new ChessPiece(PieceType.PAWN_TWO, color));
                break;
            case 16:
                pieces.add(new ChessPiece(PieceType.KING, color));
                pieces.add(new ChessPiece(PieceType.QUEEN, color));
                pieces.add(new ChessPiece(PieceType.ROOK_ONE, color));
                pieces.add(new ChessPiece(PieceType.ROOK_TWO, color));
                pieces.add(new ChessPiece(PieceType.BISHOP_ONE, color));
                pieces.add(new ChessPiece(PieceType.BISHOP_TWO, color));
                pieces.add(new ChessPiece(PieceType.KNIGHT_ONE, color));
                pieces.add(new ChessPiece(PieceType.KNIGHT_TWO, color));
                pieces.add(new ChessPiece(PieceType.PAWN_ONE, color));
                pieces.add(new ChessPiece(PieceType.PAWN_TWO, color));
                pieces.add(new ChessPiece(PieceType.PAWN_THREE, color));
                pieces.add(new ChessPiece(PieceType.PAWN_FOUR, color));
                pieces.add(new ChessPiece(PieceType.PAWN_FIVE, color));
                pieces.add(new ChessPiece(PieceType.PAWN_SIX, color));
                pieces.add(new ChessPiece(PieceType.PAWN_SEVEN, color));
                pieces.add(new ChessPiece(PieceType.PAWN_EIGHT, color));
                break;
            default:
                for (int i = 1; i <= pieceCount; i++) {
                    pieces.add(new ChessPiece(PieceType.fromValue(i), color));
                }
                break;
        }
        Collections.shuffle(pieces);
        return pieces;
    }

    public void run() throws InterruptedException {
        System.out.println("\nTipo: " + (board.getListType() == ListType.NUMERIC ? "Numérico" : "Caracter"));

        System.out.println("\n-------------------------------------------------");
        System.out.println("           Tablero Inicial");
        System.out.println("-------------------------------------------------");
        Renderer.displayBoard(board);

        List<ChessPiece> compactedPieces = board.compactPieces();
        chessPieces.clear();
        chessPieces.addAll(compactedPieces);
        board.updateLayout(chessPieces);

        System.out.println("\nValores:");
        System.out.println(GameUtils.chessPiecesToString(chessPieces, board.getListType()));
        Renderer.displayBoard(board);

        long startTime = System.currentTimeMillis();
        sortingAlgorithm.sort(chessPieces, pauseDuration, board);
        long endTime = System.currentTimeMillis();

        System.out.println("\n-------------------------------------------------");
        System.out.println("           Tablero Final");
        System.out.println("-------------------------------------------------");
        System.out.println("\nOrdenamiento:");
        System.out.println(GameUtils.chessPiecesToString(chessPieces, board.getListType()));
        Renderer.displayBoard(board);

        System.out.println("\nAlgoritmo: " + sortingAlgorithm.getName());
        System.out.println("\nTiempo total: " + (endTime - startTime) + " ms");
    }

    public ChessBoard getBoard() {
        return board;
    }
}
