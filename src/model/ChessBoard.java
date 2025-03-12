package model;

import config.GameConfig;
import enums.ListType;
import enums.PieceColor;
import utils.Constants;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class ChessBoard {
    private static final int SIZE = GameConfig.BOARD_SIZE;
    private final ChessCell[][] grid = new ChessCell[SIZE][SIZE];
    private final ListType listType;

    public ChessBoard(ListType listType) {
        this.listType = listType;
        initializeBoard();
    }

    private void initializeBoard() {
        for (int row = 0; row < SIZE; row++) {
            for (int col = 0; col < SIZE; col++) {
                grid[row][col] = new ChessCell(row, col);
            }
        }
    }
    public List<ChessPiece> placePiecesRandomly(List<ChessPiece> chessPieces) {
        clearBoard();
        List<ChessPiece> shuffledPieces = new ArrayList<>(chessPieces);
        Collections.shuffle(shuffledPieces);
        Random random = new Random();
        for (ChessPiece piece : shuffledPieces) {
            int x, y;
            do {
                x = random.nextInt(SIZE);
                y = random.nextInt(SIZE);
            } while (grid[x][y].getPiece() != null);
            grid[x][y].setPiece(piece);
        }
        return shuffledPieces;
    }


    public void updateLayout(List<ChessPiece> chessPieces) {
        clearBoard();
        placePiecesForRendering(chessPieces);
    }


    public void placePiecesForRendering(List<ChessPiece> chessPieces) {
        clearBoard();
        int[][] piecePositions = null;
        PieceColor color = chessPieces.get(0).getColor();

        boolean soloPeones = chessPieces.size() == 8 && chessPieces.get(0) instanceof model.pieces.Pawn;

        if (soloPeones) {
            if (color == PieceColor.WHITE) {
                piecePositions = new int[][]{
                        {1, 0}, {1, 1}, {1, 2}, {1, 3},
                        {1, 4}, {1, 5}, {1, 6}, {1, 7}
                };
            } else {
                piecePositions = new int[][]{
                        {6, 0}, {6, 1}, {6, 2}, {6, 3},
                        {6, 4}, {6, 5}, {6, 6}, {6, 7}
                };
            }
        } else {
            if (color == PieceColor.WHITE) {
                switch (chessPieces.size()) {
                    case 1 -> piecePositions = new int[][]{{0, 4}};
                    case 2 -> piecePositions = new int[][]{{0, 4}, {0, 3}};
                    case 4 -> piecePositions = new int[][]{{0, 4}, {0, 3}, {0, 2}, {0, 5}};
                    case 6 -> piecePositions = new int[][]{{0, 4}, {0, 3}, {0, 2}, {0, 5}, {0, 1}, {0, 6}};
                    case 8 -> piecePositions = new int[][]{
                            {0, 4}, {0, 3}, {0, 0}, {0, 7},
                            {0, 2}, {0, 5}, {0, 1}, {0, 6}
                    };
                    case 10 -> piecePositions = new int[][]{
                            {1, 0}, {1, 1}, {1, 2}, {1, 3},
                            {1, 4}, {1, 5}, {1, 6}, {1, 7},
                            {0, 4}, {0, 3}
                    };
                    case 16 -> piecePositions = new int[][]{
                            {0, 4}, {0, 3}, {0, 0}, {0, 7},
                            {0, 2}, {0, 5}, {0, 1}, {0, 6},
                            {1, 0}, {1, 1}, {1, 2}, {1, 3},
                            {1, 4}, {1, 5}, {1, 6}, {1, 7}
                    };
                    default -> throw new IllegalArgumentException(Constants.INVALID);
                }
            } else {
                switch (chessPieces.size()) {
                    case 1 -> piecePositions = new int[][]{{7, 4}};
                    case 2 -> piecePositions = new int[][]{{7, 4}, {7, 3}};
                    case 4 -> piecePositions = new int[][]{{7, 4}, {7, 3}, {7, 2}, {7, 5}};
                    case 6 -> piecePositions = new int[][]{{7, 4}, {7, 3}, {7, 2}, {7, 5}, {7, 1}, {7, 6}};
                    case 8 -> piecePositions = new int[][]{
                            {7, 4}, {7, 3}, {7, 0}, {7, 7},
                            {7, 2}, {7, 5}, {7, 1}, {7, 6}
                    };
                    case 10 -> piecePositions = new int[][]{
                            {6, 0}, {6, 1}, {6, 2}, {6, 3},
                            {6, 4}, {6, 5}, {6, 6}, {6, 7},
                            {7, 4}, {7, 3}
                    };
                    case 16 -> piecePositions = new int[][]{
                            {7, 4}, {7, 3}, {7, 0}, {7, 7},
                            {7, 2}, {7, 5}, {7, 1}, {7, 6},
                            {6, 0}, {6, 1}, {6, 2}, {6, 3},
                            {6, 4}, {6, 5}, {6, 6}, {6, 7}
                    };
                    default -> throw new IllegalArgumentException(Constants.INVALID);
                }
            }
        }

        for (int i = 0; i < chessPieces.size(); i++) {
            int row = piecePositions[i][0];
            int col = piecePositions[i][1];
            grid[row][col].setPiece(chessPieces.get(i));
        }
    }


    public List<ChessPiece> compactPieces() {
        List<ChessPiece> compacted = new ArrayList<>();
        for (int row = SIZE - 1; row >= 0; row--) {
            for (int col = 0; col < SIZE; col++) {
                ChessPiece piece = grid[row][col].getPiece();
                if (piece != null) {
                    compacted.add(piece);
                }
            }
        }
        return compacted;
    }


    public ChessCell[][] getGrid() {
        return grid;
    }

    private void clearBoard() {
        for (int row = 0; row < SIZE; row++) {
            for (int col = 0; col < SIZE; col++) {
                grid[row][col].setPiece(null);
            }
        }
    }

    public ListType getListType() {
        return listType;
    }
}