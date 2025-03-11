package utils;

import enums.ListType;
import enums.PieceColor;
import enums.SortingAlgorithmType;
import exceptions.InvalidParameterException;
import exceptions.MissingParameterException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

public class CLIUtils {

    private static final Map<String, ParameterHandler<?>> PARAM_HANDLERS = Map.of(
            "a", new ParameterHandler<>(SortingAlgorithmType::fromCode, type -> "[" + type.getAlgorithm().getName() + "]"),
            "t", new ParameterHandler<>(ListType::fromCode, type -> "[" + type.toString() + "]"),
            "c", new ParameterHandler<>(PieceColor::fromCode, type -> "[" + type.toString() + "]"),
            "r", new ParameterHandler<>(val -> validatePieceCount(Integer.parseInt(val)), type -> "[" + type + "]"),
            "s", new ParameterHandler<>(val -> validateSpeed(Integer.parseInt(val)), type -> "[" + type + "]")
    );

    public static ParsedParams parseParams(String[] args) {
        List<String> params = normalizeParams(args);
        Map<String, Object> validParams = new HashMap<>();
        Map<String, String> displayParams = new HashMap<>();
        boolean hasError = false;

        for (String key : PARAM_HANDLERS.keySet()) {
            ParameterHandler<?> handler = PARAM_HANDLERS.get(key);
            try {
                String val = getParameterValue(params, key);
                Object parsed = handler.parser.apply(val);
                validParams.put(key, parsed);
                displayParams.put(key, formatValue(handler, parsed));
            } catch (MissingParameterException e) {
                displayParams.put(key, Constants.MISSING);
                hasError = true;
            } catch (Exception e) {
                displayParams.put(key, Constants.INVALID);
                hasError = true;
            }
        }

        Renderer.printConfig(
                displayParams.get("a"),
                displayParams.get("t"),
                displayParams.get("c"),
                displayParams.get("r"),
                displayParams.get("s")
        );

        if (hasError) {
            System.exit(1);
        }

        return new ParsedParams(
                (SortingAlgorithmType) validParams.get("a"),
                (ListType) validParams.get("t"),
                (PieceColor) validParams.get("c"),
                (Integer) validParams.get("r"),
                (Integer) validParams.get("s")
        );
    }

    private static <T> String formatValue(ParameterHandler<T> handler, Object parsed) {
        return handler.formatter.apply((T) parsed);
    }

    private static List<String> normalizeParams(String[] args) {
        List<String> normalizedParams = new ArrayList<>();
        for (String param : args) {
            String[] parts = param.split("=", 2);
            if (parts.length == 2) {
                normalizedParams.add(parts[0].toLowerCase().trim() + "=" + parts[1].trim());
            }
        }
        return normalizedParams;
    }

    private static String getParameterValue(List<String> params, String key) {
        for (String param : params) {
            if (param.startsWith(key + "=")) {
                String[] parts = param.split("=", 2);
                if (parts.length < 2 || parts[1].trim().isEmpty()) {
                    throw new MissingParameterException(Constants.MISSING);
                }
                return parts[1].trim();
            }
        }
        throw new MissingParameterException(Constants.MISSING);
    }

    private static int validatePieceCount(int pieceCount) {
        if (pieceCount == 1 || pieceCount == 2 || pieceCount == 4 || pieceCount == 6 || pieceCount == 8 || pieceCount == 10 || pieceCount == 16) {
            return pieceCount;
        }
        throw new InvalidParameterException(Constants.INVALID);
    }

    private static int validateSpeed(int speed) {
        if (speed >= 100 && speed <= 1000) {
            return speed;
        }
        throw new InvalidParameterException(Constants.INVALID);
    }

    private static class ParameterHandler<T> {
        final Function<String, T> parser;
        final Function<T, String> formatter;

        public ParameterHandler(Function<String, T> parser, Function<T, String> formatter) {
            this.parser = parser;
            this.formatter = formatter;
        }
    }

    public record ParsedParams(
            SortingAlgorithmType sortingAlgorithm,
            ListType listType,
            PieceColor color,
            int pieceCount,
            int speed
    ) {
    }
}