package model;

import enums.PieceColor;
import enums.PieceType;

public class ChessPiece implements Comparable<ChessPiece> {
    private final PieceType type;
    private final PieceColor color;

    public ChessPiece(PieceType type, PieceColor color) {
        this.type = type;
        this.color = color;
    }

    public String getSymbol() {
        return type.getSymbol(color);
    }

    public PieceType getType() {
        return type;
    }

    @Override
    public int compareTo(ChessPiece other) {
        return Integer.compare(this.type.ordinal(), other.type.ordinal());
    }
}
