package exceptions;

import utils.Renderer;

public class ExceptionHandler {
    public static void handleParameterError(String algorithm, String listType, String color, String pieceCount, String speed) {
        Renderer.printTitle();
        System.out.println("==========================================================");
        System.out.println("|                INFORMACION PRINCIPAL                   |");
        System.out.println("==========================================================");
        System.out.println("Algoritmo: " + algorithm);
        System.out.println("Tipo de lista: " + listType);
        System.out.println("Color de piezas: " + color);
        System.out.println("Número de piezas: " + pieceCount);
        System.out.println("Velocidad: " + speed);
        System.out.println("==========================================================");
        System.exit(1);
    }
}
