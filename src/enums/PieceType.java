package enums;

public enum PieceType {
    KING(1, "♔", "♚", "a"),
    QUEEN(2, "♕", "♛", "b"),
    ROOK_I(3, "♖", "♜", "c"),
    ROOK_II(4, "♖", "♜", "d"),
    BISHOP_I(5, "♗", "♝", "e"),
    BISHOP_II(6, "♗", "♝", "f"),
    KNIGHT_I(7, "♘", "♞", "g"),
    KNIGHT_II(8, "♘", "♞", "h"),
    PAWN_1(9, "♙", "♟", "i"),
    PAWN_2(10, "♙", "♟", "j"),
    PAWN_3(11, "♙", "♟", "k"),
    PAWN_4(12, "♙", "♟", "l"),
    PAWN_5(13, "♙", "♟", "m"),
    PAWN_6(14, "♙", "♟", "n"),
    PAWN_7(15, "♙", "♟", "o"),
    PAWN_8(16, "♙", "♟", "p");

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
        throw new exceptions.InvalidParameterException("Número de piezas");
    }
}
