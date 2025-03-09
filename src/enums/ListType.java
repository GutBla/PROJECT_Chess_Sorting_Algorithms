package enums;

import exceptions.InvalidParameterException;

public enum ListType {
    NUMERIC("n"),
    CHARACTER("c");

    private final String code;

    ListType(String code) {
        this.code = code.toLowerCase();
    }

    public static ListType fromCode(String code) {
        String normalized = code.trim().toLowerCase();
        for (ListType type : values()) {
            if (type.code.equals(normalized)) {
                return type;
            }
        }
        throw new InvalidParameterException("[Invalido]");
    }
}