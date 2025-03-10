package utils;

public class ConsoleColor {
    public static final String RESET = "\u001B[0m";
    public static final String MORADO = "\u001B[35m";
    public static final String VERDE = "\u001B[32m";
    public static final String AMARILLO = "\u001B[33m";
    public static final String AZUL = "\u001B[34m";
    public static final String ROJO = "\u001B[31m";
    public static final String NARANJA = "\u001B[38;5;214m";

    public static String colorText(String color, String text) {
        return color + text + RESET;
    }
}
