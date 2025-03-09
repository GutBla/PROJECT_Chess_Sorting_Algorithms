import config.GameConfig;

public class Main {
    public static void main(String[] args) {
        try {
            GameConfig.startGame(args);
        } catch (InterruptedException e) {
            System.err.println("Error");
        }
    }
}