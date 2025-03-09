package model;
import enums.ListType;
import config.GameConfig;
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

    private void placePiecesForRendering(List<ChessPiece> chessPieces) {
        int[][] piecePositions;
        int pieceCount = chessPieces.size();

        switch (pieceCount) {
            case 1:
                piecePositions = new int[][]{{7, 4}};
                break;
            case 2:
                piecePositions = new int[][]{{7, 4}, {7, 3}};
                break;
            case 4:
                piecePositions = new int[][]{
                        {7, 4}, {7, 3},
                        {7, 2}, {7, 5}
                };
                break;
            case 6:
                piecePositions = new int[][]{
                        {7, 4}, {7, 3},
                        {7, 2}, {7, 5},
                        {7, 1}, {7, 6}
                };
                break;
            case 8:
                piecePositions = new int[][]{
                        {7, 4}, {7, 3},
                        {7, 2}, {7, 5},
                        {7, 1}, {7, 6},
                        {7, 0}, {7, 7}
                };
                break;
            case 10:
                piecePositions = new int[][]{
                        {6, 0}, {6, 1}, {6, 2}, {6, 3},
                        {6, 4}, {6, 5}, {6, 6}, {6, 7},
                        {7, 4}, {7, 3}
                };
                break;
            case 16:
                piecePositions = new int[][]{
                        {7, 4}, {7, 3},
                        {7, 0}, {7, 7},
                        {7, 2}, {7, 5},
                        {7, 1}, {7, 6},
                        {6, 0}, {6, 1}, {6, 2}, {6, 3},
                        {6, 4}, {6, 5}, {6, 6}, {6, 7}
                };
                break;
            default:
                throw new IllegalArgumentException("Cantidad de piezas no soportada");
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
