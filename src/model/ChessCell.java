package model;

public class ChessCell {
    private final int row;
    private final int column;
    private ChessPiece piece;
    public ChessCell(int row, int column) {
        this.row = row;
        this.column = column;
        this.piece = null;
    }
    public int getRow() {
        return row;
    }
    public int getColumn() {
        return column;
    }
    public ChessPiece getPiece() {
        return piece;
    }
    public void setPiece(ChessPiece piece) {
        this.piece = piece;
    }
}
