package utils;

import enums.SortingAlgorithmType;
import enums.ListType;
import enums.PieceColor;
import exceptions.ExceptionHandler;
import exceptions.InvalidParameterException;
import exceptions.MissingParameterException;
import java.util.ArrayList;
import java.util.Arrays;

public class CLIUtils {

    public static String getParameterValue(ArrayList<String> params, String key) {
        for (String param : params) {
            if (param.startsWith(key + "=")) {
                String[] parts = param.split("=", 2);
                if (parts.length < 2 || parts[1].trim().isEmpty()) {
                    throw new MissingParameterException("[No presente]");
                }
                return parts[1].trim();
            }
        }
        throw new MissingParameterException("[No presente]");
    }

    public static ParsedParams parseParams(String[] args) {
        ArrayList<String> params = new ArrayList<>(Arrays.asList(args));
        String algorithmStr = "";
        String listTypeStr = "";
        String colorStr = "";
        String pieceCountStr = "";
        String speedStr = "";

        SortingAlgorithmType sortingAlgorithmType = null;
        ListType listType = null;
        PieceColor pieceColor = null;
        int pieceCount = -1;
        int pauseDuration = -1;

        try {
            String val = getParameterValue(params, "a");
            sortingAlgorithmType = SortingAlgorithmType.fromCode(val);
            algorithmStr = "[" + sortingAlgorithmType.getAlgorithm().getName() + "]";
        } catch (MissingParameterException e) {
            algorithmStr = "[No presente]";
        } catch (InvalidParameterException e) {
            algorithmStr = "[Invalido]";
        }

        try {
            String val = getParameterValue(params, "t");
            listType = ListType.fromCode(val);
            listTypeStr = "[" + (listType == ListType.NUMERIC ? "Numérico" : "Caracter") + "]";
        } catch (MissingParameterException e) {
            listTypeStr = "[No presente]";
        } catch (InvalidParameterException e) {
            listTypeStr = "[Invalido]";
        }

        try {
            String val = getParameterValue(params, "c");
            pieceColor = PieceColor.fromCode(val);
            colorStr = "[" + (pieceColor == PieceColor.WHITE ? "Blancas" : "Negras") + "]";
        } catch (MissingParameterException e) {
            colorStr = "[No presente]";
        } catch (InvalidParameterException e) {
            colorStr = "[Invalido]";
        }

        try {
            String val = getParameterValue(params, "r");
            pieceCount = Integer.parseInt(val);
            if (pieceCount == 0) {
                pieceCountStr = "[No presente]";
            } else if (pieceCount == 1 || pieceCount == 2 || pieceCount == 4 ||
                    pieceCount == 6 || pieceCount == 8 || pieceCount == 10 || pieceCount == 16) {
                pieceCountStr = "[" + pieceCount + "]";
            } else {
                pieceCountStr = "[Invalido]";
            }
        } catch (MissingParameterException e) {
            pieceCountStr = "[No presente]";
        } catch (NumberFormatException e) {
            pieceCountStr = "[Invalido]";
        }

        try {
            String val = getParameterValue(params, "s");
            pauseDuration = Integer.parseInt(val);
            if (pauseDuration == 0) {
                speedStr = "[No presente]";
            } else if (pauseDuration >= 100 && pauseDuration <= 1000) {
                speedStr = "[" + pauseDuration + "] ms";
            } else {
                speedStr = "[Invalido]";
            }
        } catch (MissingParameterException e) {
            speedStr = "[No presente]";
        } catch (NumberFormatException e) {
            speedStr = "[Invalido]";
        }

        if (algorithmStr.equals("[Invalido]") || listTypeStr.equals("[Invalido]") ||
                colorStr.equals("[Invalido]") || pieceCountStr.equals("[Invalido]") ||
                speedStr.equals("[Invalido]") || algorithmStr.equals("[No presente]") ||
                listTypeStr.equals("[No presente]") || colorStr.equals("[No presente]") ||
                pieceCountStr.equals("[No presente]") || speedStr.equals("[No presente]")) {
            ExceptionHandler.handleParameterError(algorithmStr, listTypeStr, colorStr, pieceCountStr, speedStr);
        }

        validateParams(pieceCount, pauseDuration);
        return new ParsedParams(sortingAlgorithmType, listType, pieceColor, pieceCount, pauseDuration);
    }

    private static void validateParams(int pieceCount, int pauseDuration) {
        if (!(pieceCount == 1 || pieceCount == 2 || pieceCount == 4 ||
                pieceCount == 6 || pieceCount == 8 || pieceCount == 10 || pieceCount == 16)
                || pauseDuration < 100 || pauseDuration > 1000) {
            ExceptionHandler.handleParameterError("[Invalido]", "[Invalido]", "[Invalido]", "[Invalido]", "[Invalido]");
        }
    }

    public static class ParsedParams {
        private final SortingAlgorithmType sortingAlgorithm;
        private final ListType listType;
        private final PieceColor color;
        private final int pieceCount;
        private final int speed;

        public ParsedParams(SortingAlgorithmType sortingAlgorithm, ListType listType, PieceColor color, int pieceCount, int speed) {
            this.sortingAlgorithm = sortingAlgorithm;
            this.listType = listType;
            this.color = color;
            this.pieceCount = pieceCount;
            this.speed = speed;
        }

        public SortingAlgorithmType getSortingAlgorithm() {
            return sortingAlgorithm;
        }

        public ListType getListType() {
            return listType;
        }

        public PieceColor getColor() {
            return color;
        }

        public int getPieceCount() {
            return pieceCount;
        }

        public int getSpeed() {
            return speed;
        }
    }
}
