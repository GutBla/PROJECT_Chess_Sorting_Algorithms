package model;

import algorithms.SortingAlgorithm;
import enums.ListType;
import enums.PieceColor;
import exceptions.InvalidParameterException;
import metrics.MetricsManager;
import model.pieces.*;
import utils.Constants;
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
                pieces.add(new King(color));
                break;
            case 2:
                pieces.add(new King(color));
                pieces.add(new Queen(color));
                break;
            case 4:
                pieces.add(new King(color));
                pieces.add(new Queen(color));
                pieces.add(new Bishop(color, 1));
                pieces.add(new Bishop(color, 2));
                break;
            case 6:
                pieces.add(new King(color));
                pieces.add(new Queen(color));
                pieces.add(new Bishop(color, 1));
                pieces.add(new Bishop(color, 2));
                pieces.add(new Knight(color, 1));
                pieces.add(new Knight(color, 2));
                break;
            case 8:
                pieces.add(new King(color));
                pieces.add(new Queen(color));
                pieces.add(new Bishop(color, 1));
                pieces.add(new Bishop(color, 2));
                pieces.add(new Knight(color, 1));
                pieces.add(new Knight(color, 2));
                pieces.add(new Rook(color, 1));
                pieces.add(new Rook(color, 2));
                break;
            case 10:
                for (int i = 1; i <= 8; i++) {
                    pieces.add(new Pawn(color, i));
                }
                break;
            case 16:
                pieces.add(new King(color));
                pieces.add(new Queen(color));
                pieces.add(new Rook(color, 1));
                pieces.add(new Rook(color, 2));
                pieces.add(new Bishop(color, 1));
                pieces.add(new Bishop(color, 2));
                pieces.add(new Knight(color, 1));
                pieces.add(new Knight(color, 2));
                for (int i = 1; i <= 8; i++) {
                    pieces.add(new Pawn(color, i));
                }
                break;
            default:
                throw new InvalidParameterException(Constants.INVALID);
        }
        Collections.shuffle(pieces);
        return pieces;
    }

    public void run() throws InterruptedException {
        Renderer.printTypeAndBoard(board);
        Renderer.printBoardTitle(" Tablero Inicial ");
        Renderer.displayBoard(board);

        List<ChessPiece> compactedPieces = board.compactPieces();
        chessPieces.clear();
        chessPieces.addAll(compactedPieces);
        board.updateLayout(chessPieces);

        System.out.println(GameUtils.chessPiecesToString(chessPieces, board.getListType()));
        Renderer.displayBoard(board);

        MetricsManager.getInstance().getStepCounter().reset();
        MetricsManager.getInstance().getTimeCounter().start();
        sortingAlgorithm.sort(chessPieces, pauseDuration, board);
        MetricsManager.getInstance().getTimeCounter().stop();

        Renderer.printBoardTitle("  Tablero Final  ");
        System.out.println(GameUtils.chessPiecesToString(chessPieces, board.getListType()));
        Renderer.printSortingInfo(sortingAlgorithm);
        Renderer.displayBoard(board);
        Renderer.printMetrics();
    }


    public ChessBoard getBoard() {
        return board;
    }
}