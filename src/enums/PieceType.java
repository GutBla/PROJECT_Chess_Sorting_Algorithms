package enums;

public enum PieceType {
    KING(1, "♔", "♚", "a"),
    QUEEN(2, "♕", "♛", "b"),
    ROOK_ONE(3, "♖", "♜", "c"),
    ROOK_TWO(4, "♖", "♜", "d"),
    BISHOP_ONE(5, "♗", "♝", "e"),
    BISHOP_TWO(6, "♗", "♝", "f"),
    KNIGHT_ONE(7, "♘", "♞", "g"),
    KNIGHT_TWO(8, "♘", "♞", "h"),
    PAWN_ONE(9, "♙", "♟", "i"),
    PAWN_TWO(10, "♙", "♟", "j"),
    PAWN_THREE(11, "♙", "♟", "k"),
    PAWN_FOUR(12, "♙", "♟", "l"),
    PAWN_FIVE(13, "♙", "♟", "m"),
    PAWN_SIX(14, "♙", "♟", "n"),
    PAWN_SEVEN(15, "♙", "♟", "o"),
    PAWN_EIGHT(16, "♙", "♟", "p");

    private final int value;
    private final String whiteSymbol;
    private final String blackSymbol;
    private final String charValue;

    PieceType(int value, String whiteSymbol, String blackSymbol, String charValue) {
        this.value = value;
        this.whiteSymbol = whiteSymbol;
        this.blackSymbol = blackSymbol;
        this.charValue = charValue;
    }

    public int getValue() {
        return value;
    }

    public String getCharValue() {
        return charValue;
    }

    public String getSymbol(PieceColor color) {
        return color == PieceColor.WHITE ? whiteSymbol : blackSymbol;
    }

    public static PieceType fromValue(int value) {
        for (PieceType pt : values()) {
            if (pt.value == value) {
                return pt;
            }
        }
        throw new exceptions.InvalidParameterException("Invalid piece number");
    }
}