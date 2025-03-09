package model;

import enums.ListType;
import config.GameConfig;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class ChessBoard {
    private static final int SIZE = GameConfig.BOARD_SIZE;
    private final ChessPiece[][] grid = new ChessPiece[SIZE][SIZE];
    private final ListType listType;

    public ChessBoard(ListType listType) {
        this.listType = listType;
    }

    public List<ChessPiece> placePiecesRandomly(List<ChessPiece> pieces) {
        clearBoard();
        List<ChessPiece> shuffled = new ArrayList<>(pieces);
        Collections.shuffle(shuffled);
        Random random = new Random();
        List<ChessPiece> orderedPieces = new ArrayList<>();

        for (ChessPiece piece : shuffled) {
            int x, y;
            do {
                x = random.nextInt(SIZE);
                y = random.nextInt(SIZE);
            } while (grid[x][y] != null);
            grid[x][y] = piece;
            orderedPieces.add(piece);
        }
        return orderedPieces;
    }

    public void updateLayout(List<ChessPiece> pieces) {
        clearBoard();
        int index = 0;
        for (int i = SIZE - 1; i >= 0 && index < pieces.size(); i--) {
            for (int j = 0; j < SIZE && index < pieces.size(); j++) {
                grid[i][j] = pieces.get(index++);
            }
        }
    }

    public List<ChessPiece> compactPieces() {
        List<ChessPiece> compacted = new ArrayList<>();
        for (int i = SIZE - 1; i >= 0; i--) {
            for (int j = 0; j < SIZE; j++) {
                if (grid[i][j] != null) {
                    compacted.add(grid[i][j]);
                }
            }
        }
        return compacted;
    }

    public ListType getListType() {
        return listType;
    }

    public ChessPiece[][] getGrid() {
        return grid;
    }

    private void clearBoard() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                grid[i][j] = null;
            }
        }
    }
}
