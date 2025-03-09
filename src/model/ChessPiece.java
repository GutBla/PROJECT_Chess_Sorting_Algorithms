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
    private static final Map<Integer, Integer> customOrderMapping = new HashMap<>();
    static {
        customOrderMapping.put(1, 14);
        customOrderMapping.put(2, 0);
        customOrderMapping.put(3, 10);
        customOrderMapping.put(4, 6);
        customOrderMapping.put(5, 2);
        customOrderMapping.put(6, 15);
        customOrderMapping.put(7, 1);
        customOrderMapping.put(8, 11);
        customOrderMapping.put(9, 13);
        customOrderMapping.put(10, 9);
        customOrderMapping.put(11, 8);
        customOrderMapping.put(12, 4);
        customOrderMapping.put(13, 12);
        customOrderMapping.put(14, 3);
        customOrderMapping.put(15, 7);
        customOrderMapping.put(16, 5);
    }
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
