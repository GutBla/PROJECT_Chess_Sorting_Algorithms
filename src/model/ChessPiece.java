package model;
import enums.PieceColor;
import java.util.HashMap;
import java.util.Map;
public abstract class ChessPiece implements Comparable<ChessPiece> {
    protected final PieceColor color;
    protected final int originalValue;
    protected final String charValue;
    protected final String whiteSymbol;
    protected final String blackSymbol;

    public ChessPiece(PieceColor color, int originalValue, String charValue, String whiteSymbol, String blackSymbol) {
        this.color = color;
        this.originalValue = originalValue;
        this.charValue = charValue;
        this.whiteSymbol = whiteSymbol;
        this.blackSymbol = blackSymbol;
    }
    public PieceColor getColor() {
        return color;
    }
    public int getPieceValue() {
        return originalValue;
    }
    public String getCharValue() {
        return charValue;
    }
    public String getSymbol() {
        return color == PieceColor.WHITE ? whiteSymbol : blackSymbol;
    }
    public String getDisplayValue(boolean numeric) {
        return numeric ? String.valueOf(originalValue) : charValue;
    }
    @Override
    public int compareTo(ChessPiece other) {
        return Integer.compare(this.originalValue, other.originalValue);
    }
}
