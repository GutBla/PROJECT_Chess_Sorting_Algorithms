package enums;

import exceptions.InvalidParameterException;

public enum PieceColor {
    WHITE("w"),
    BLACK("b");

    private final String code;

    PieceColor(String code) {
        this.code = code.toLowerCase();
    }

    public static PieceColor fromCode(String code) {
        String normalized = code.trim().toLowerCase();
        for (PieceColor color : values()) {
            if (color.code.equals(normalized)) {
                return color;
            }
        }
        throw new InvalidParameterException("[Invalido]");
    }
}
