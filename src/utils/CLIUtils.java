package utils;

import enums.SortingAlgorithmType;
import enums.ListType;
import enums.PieceColor;
import exceptions.ExceptionHandler;
import exceptions.InvalidParameterException;
import exceptions.MissingParameterException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

public class CLIUtils {

    private static final Map<String, ParameterHandler> PARAM_HANDLERS = Map.of(
            "a", new ParameterHandler(
                    val -> SortingAlgorithmType.fromCode(val),
                    type -> "[" + ((SortingAlgorithmType) type).getAlgorithm().getName() + "]"
            ),
            "t", new ParameterHandler(
                    val -> ListType.fromCode(val),
                    type -> "[" + ((ListType) type).toString() + "]"
            ),
            "c", new ParameterHandler(
                    val -> PieceColor.fromCode(val),
                    type -> "[" + ((PieceColor) type).toString() + "]"
            ),
            "r", new ParameterHandler(
                    val -> validatePieceCount(Integer.parseInt(val)),
                    type -> "[" + type + "]"
            ),
            "s", new ParameterHandler(
                    val -> validateSpeed(Integer.parseInt(val)),
                    type -> "[" + type + "] ms"
            )
    );

    public static ParsedParams parseParams(String[] args) {
        List<String> params = normalizeParams(args);
        Map<String, Object> results = new HashMap<>();
        Map<String, String> errors = new HashMap<>();

        PARAM_HANDLERS.forEach((key, handler) -> {
            try {
                String val = getParameterValue(params, key);
                Object result = handler.parser.apply(val);
                results.put(key, result);
            } catch (Exception e) {
                errors.put(key, e instanceof MissingParameterException ? "[No presente]" : "[Invalido]");
            }
        });

        if (!errors.isEmpty()) {
            ExceptionHandler.handleParameterError(
                    errors.getOrDefault("a", ""),
                    errors.getOrDefault("t", ""),
                    errors.getOrDefault("c", ""),
                    errors.getOrDefault("r", ""),
                    errors.getOrDefault("s", "")
            );
        }

        return new ParsedParams(
                (SortingAlgorithmType) results.get("a"),
                (ListType) results.get("t"),
                (PieceColor) results.get("c"),
                (Integer) results.get("r"),
                (Integer) results.get("s")
        );
    }

    private static List<String> normalizeParams(String[] args) {
        List<String> normalizedParams = new ArrayList<>();
        for (String param : args) {
            String[] parts = param.split("=", 2);
            if (parts.length == 2) {
                String key = parts[0].toLowerCase().trim();
                String value = parts[1].trim();
                normalizedParams.add(key + "=" + value);
            }
        }
        return normalizedParams;
    }

    private static String getParameterValue(List<String> params, String key) {
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

    private static int validatePieceCount(int pieceCount) {
        if (pieceCount == 1 || pieceCount == 2 || pieceCount == 4 || pieceCount == 6 || pieceCount == 8 || pieceCount == 10 || pieceCount == 16) {
            return pieceCount;
        }
        throw new InvalidParameterException("[Invalido]");
    }

    private static int validateSpeed(int speed) {
        if (speed >= 100 && speed <= 1000) {
            return speed;
        }
        throw new InvalidParameterException("[Invalido]");
    }

    private static class ParameterHandler {
        Function<String, Object> parser;
        Function<Object, String> formatter;

        public ParameterHandler(Function<String, Object> parser, Function<Object, String> formatter) {
            this.parser = parser;
            this.formatter = formatter;
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