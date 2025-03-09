package utils;

import enums.ListType;
import enums.PieceColor;
import enums.SortingAlgorithmType;
import exceptions.ExceptionHandler;
import exceptions.InvalidParameterException;
import exceptions.MissingParameterException;
import java.util.ArrayList;
import java.util.Arrays;

public class CLIUtils {

    public static String getParamValue(ArrayList<String> params, String key) {
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
        String algoritmoStr, tipoListaStr, colorStr, piezaStr, velocidadStr;
        algoritmoStr = tipoListaStr = colorStr = piezaStr = velocidadStr = "";

        SortingAlgorithmType algorithmType = null;
        ListType listType = null;
        PieceColor color = null;
        int pieceCount = -1;
        int speed = -1;

        try {
            String val = getParamValue(params, "a");
            algorithmType = SortingAlgorithmType.fromCode(val);
            algoritmoStr = "[" + algorithmType.getAlgorithm().getName() + "]";
        } catch (MissingParameterException e) {
            algoritmoStr = "[No presente]";
        } catch (InvalidParameterException e) {
            algoritmoStr = "[Invalido]";
        }

        try {
            String val = getParamValue(params, "t");
            listType = ListType.fromCode(val);
            tipoListaStr = "[" + (listType == ListType.NUMERIC ? "Numérico" : "Caracter") + "]";
        } catch (MissingParameterException e) {
            tipoListaStr = "[No presente]";
        } catch (InvalidParameterException e) {
            tipoListaStr = "[Invalido]";
        }

        try {
            String val = getParamValue(params, "c");
            color = PieceColor.fromCode(val);
            colorStr = "[" + (color == PieceColor.WHITE ? "Blancas" : "Negras") + "]";
        } catch (MissingParameterException e) {
            colorStr = "[No presente]";
        } catch (InvalidParameterException e) {
            colorStr = "[Invalido]";
        }

        try {
            String val = getParamValue(params, "r");
            pieceCount = Integer.parseInt(val);
            if (pieceCount == 0) {
                piezaStr = "[No presente]";
            } else if (pieceCount == 1 || pieceCount == 2 || pieceCount == 4 ||
                    pieceCount == 6 || pieceCount == 8 || pieceCount == 10 || pieceCount == 16) {
                piezaStr = "[" + pieceCount + "]";
            } else {
                piezaStr = "[Invalido]";
            }
        } catch (MissingParameterException e) {
            piezaStr = "[No presente]";
        } catch (NumberFormatException e) {
            piezaStr = "[Invalido]";
        }

        try {
            String val = getParamValue(params, "s");
            speed = Integer.parseInt(val);
            if (speed == 0) {
                velocidadStr = "[No presente]";
            } else if (speed >= 100 && speed <= 1000) {
                velocidadStr = "[" + speed + "] ms";
            } else {
                velocidadStr = "[Invalido]";
            }
        } catch (MissingParameterException e) {
            velocidadStr = "[No presente]";
        } catch (NumberFormatException e) {
            velocidadStr = "[Invalido]";
        }

        if (algoritmoStr.equals("[Invalido]") || tipoListaStr.equals("[Invalido]") ||
                colorStr.equals("[Invalido]") || piezaStr.equals("[Invalido]") ||
                velocidadStr.equals("[Invalido]") || algoritmoStr.equals("[No presente]") ||
                tipoListaStr.equals("[No presente]") || colorStr.equals("[No presente]") ||
                piezaStr.equals("[No presente]") || velocidadStr.equals("[No presente]")) {
            ExceptionHandler.handleParameterError(algoritmoStr, tipoListaStr, colorStr, piezaStr, velocidadStr);
        }

        validateParams(pieceCount, speed);
        return new ParsedParams(algorithmType, listType, color, pieceCount, speed);
    }

    private static void validateParams(int pieceCount, int speed) {
        if (!(pieceCount == 1 || pieceCount == 2 || pieceCount == 4 ||
                pieceCount == 6 || pieceCount == 8 || pieceCount == 10 || pieceCount == 16)
                || speed < 100 || speed > 1000) {
            ExceptionHandler.handleParameterError("[Invalido]", "[Invalido]", "[Invalido]", "[Invalido]", "[Invalido]");
        }
    }

    public static class ParsedParams {
        private final SortingAlgorithmType algorithmType;
        private final ListType listType;
        private final PieceColor color;
        private final int pieceCount;
        private final int speed;

        public ParsedParams(SortingAlgorithmType algorithmType, ListType listType, PieceColor color, int pieceCount, int speed) {
            this.algorithmType = algorithmType;
            this.listType = listType;
            this.color = color;
            this.pieceCount = pieceCount;
            this.speed = speed;
        }

        public SortingAlgorithmType getAlgorithmType() {
            return algorithmType;
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
