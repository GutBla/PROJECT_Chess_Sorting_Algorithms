package exceptions;
import utils.Renderer;

public class ExceptionHandler {
    public static void handleParameterError(String algoritmo, String tipoLista, String color, String numPiezas, String velocidad) {
        Renderer.printTitle();
        System.out.println("==========================================================");
        System.out.println("|                INFORMACION PRINCIPAL                   |");
        System.out.println("==========================================================");
        System.out.println("Algoritmo: " + algoritmo);
        System.out.println("Tipo de lista: " + tipoLista);
        System.out.println("Color de piezas: " + color);
        System.out.println("Número de piezas: " + numPiezas);
        System.out.println("Velocidad: " + velocidad);
        System.out.println("==========================================================");
        System.exit(1);
    }
}
