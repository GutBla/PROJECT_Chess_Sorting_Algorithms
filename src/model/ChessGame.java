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
    private final SortingAlgorithm algorithm;
    private final ChessBoard board;
    private final int speed;
    private final List<ChessPiece> pieces;

    public ChessGame(SortingAlgorithm algorithm, ListType listType, PieceColor color, int pieceCount, int speed) {
        this.algorithm = algorithm;
        this.board = new ChessBoard(listType);
        this.speed = speed;
        List<ChessPiece> generatedPieces = generatePieces(color, pieceCount);
        this.pieces = board.placePiecesRandomly(generatedPieces);
    }

    private List<ChessPiece> generatePieces(PieceColor color, int pieceCount) {
        List<ChessPiece> pieces = new ArrayList<>();
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
                pieces.add(new ChessPiece(PieceType.BISHOP_I, color));
                pieces.add(new ChessPiece(PieceType.BISHOP_II, color));
                break;
            case 6:
                pieces.add(new ChessPiece(PieceType.KING, color));
                pieces.add(new ChessPiece(PieceType.QUEEN, color));
                pieces.add(new ChessPiece(PieceType.BISHOP_I, color));
                pieces.add(new ChessPiece(PieceType.BISHOP_II, color));
                pieces.add(new ChessPiece(PieceType.KNIGHT_I, color));
                pieces.add(new ChessPiece(PieceType.KNIGHT_II, color));
                break;
            case 8:
                pieces.add(new ChessPiece(PieceType.KING, color));
                pieces.add(new ChessPiece(PieceType.QUEEN, color));
                pieces.add(new ChessPiece(PieceType.BISHOP_I, color));
                pieces.add(new ChessPiece(PieceType.BISHOP_II, color));
                pieces.add(new ChessPiece(PieceType.KNIGHT_I, color));
                pieces.add(new ChessPiece(PieceType.KNIGHT_II, color));
                pieces.add(new ChessPiece(PieceType.ROOK_I, color));
                pieces.add(new ChessPiece(PieceType.ROOK_II, color));
                break;
            case 10:
                pieces.add(new ChessPiece(PieceType.PAWN_1, color));
                pieces.add(new ChessPiece(PieceType.PAWN_2, color));
                pieces.add(new ChessPiece(PieceType.PAWN_3, color));
                pieces.add(new ChessPiece(PieceType.PAWN_4, color));
                pieces.add(new ChessPiece(PieceType.PAWN_5, color));
                pieces.add(new ChessPiece(PieceType.PAWN_6, color));
                pieces.add(new ChessPiece(PieceType.PAWN_7, color));
                pieces.add(new ChessPiece(PieceType.PAWN_8, color));
                pieces.add(new ChessPiece(PieceType.PAWN_1, color));
                pieces.add(new ChessPiece(PieceType.PAWN_2, color));
                break;
            case 16:
                pieces.add(new ChessPiece(PieceType.KING, color));
                pieces.add(new ChessPiece(PieceType.QUEEN, color));
                pieces.add(new ChessPiece(PieceType.ROOK_I, color));
                pieces.add(new ChessPiece(PieceType.ROOK_II, color));
                pieces.add(new ChessPiece(PieceType.BISHOP_I, color));
                pieces.add(new ChessPiece(PieceType.BISHOP_II, color));
                pieces.add(new ChessPiece(PieceType.KNIGHT_I, color));
                pieces.add(new ChessPiece(PieceType.KNIGHT_II, color));
                pieces.add(new ChessPiece(PieceType.PAWN_1, color));
                pieces.add(new ChessPiece(PieceType.PAWN_2, color));
                pieces.add(new ChessPiece(PieceType.PAWN_3, color));
                pieces.add(new ChessPiece(PieceType.PAWN_4, color));
                pieces.add(new ChessPiece(PieceType.PAWN_5, color));
                pieces.add(new ChessPiece(PieceType.PAWN_6, color));
                pieces.add(new ChessPiece(PieceType.PAWN_7, color));
                pieces.add(new ChessPiece(PieceType.PAWN_8, color));
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
        System.out.println("\nTipo: " + (board.getListType() == ListType.NUMERIC ? "Numérico" : "Caracter") );

        System.out.println("\n-------------------------------------------------");
        System.out.println("           Tablero Inicial");
        System.out.println("-------------------------------------------------");
        Renderer.displayBoard(board);

        List<ChessPiece> compactedPieces = board.compactPieces();
        pieces.clear();
        pieces.addAll(compactedPieces);
        board.updateLayout(pieces);

        System.out.println("\nValores:");
        System.out.println(GameUtils.listToString(pieces, board.getListType()));
        Renderer.displayBoard(board);

        long startTime = System.currentTimeMillis();
        algorithm.sort(pieces, speed, board);
        long endTime = System.currentTimeMillis();

        System.out.println("\n-------------------------------------------------");
        System.out.println("           Tablero Final");
        System.out.println("-------------------------------------------------");
        System.out.println("\nOrdenamiento:");
        System.out.println(GameUtils.listToString(pieces, board.getListType()));
        Renderer.displayBoard(board);

        System.out.println("\nAlgoritmo :" + algorithm.getName());
        System.out.println("\nTiempo total: " + (endTime - startTime) + " ms");
    }

    public ChessBoard getBoard() {
        return board;
    }
}
