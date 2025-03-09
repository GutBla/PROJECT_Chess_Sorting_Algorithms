package config;

import enums.ListType;
import enums.PieceColor;
import enums.SortingAlgorithmType;
import model.ChessGame;
import utils.CLIUtils;
import utils.Renderer;

public class GameConfig {
    public static final int BOARD_SIZE = 8;

    public static void startGame(String[] args) throws InterruptedException {

        CLIUtils.ParsedParams params = CLIUtils.parseParams(args);

        Renderer.printConfig(params.getAlgorithmType().getAlgorithm().getName(),
                params.getListType(),
                params.getColor(),
                params.getPieceCount(),
                params.getSpeed());

        ChessGame game = new ChessGame(params.getAlgorithmType().getAlgorithm(),
                params.getListType(),
                params.getColor(),
                params.getPieceCount(),
                params.getSpeed());
        game.run();
    }
}
