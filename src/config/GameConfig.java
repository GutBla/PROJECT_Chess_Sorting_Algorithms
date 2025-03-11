package config;

import model.ChessGame;
import utils.CLIUtils;

public class GameConfig {
    public static final int BOARD_SIZE = 8;
    public static void startGame(String[] args) throws InterruptedException {
        CLIUtils.ParsedParams parsedParams = CLIUtils.parseParams(args);
        ChessGame chessGame = new ChessGame(
                parsedParams.sortingAlgorithm().getAlgorithm(),
                parsedParams.listType(),
                parsedParams.color(),
                parsedParams.pieceCount(),
                parsedParams.speed()
        );
        chessGame.run();
    }
}