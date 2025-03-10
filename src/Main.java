import config.GameConfig;

import utils.ConsoleColor;

public class Main {
    public static void main(String[] args) {
        try {
            GameConfig.startGame(args);
        } catch (InterruptedException e) {
            System.err.println(ConsoleColor.colorText(ConsoleColor.ROJO, "Error"));
        }
    }
}
