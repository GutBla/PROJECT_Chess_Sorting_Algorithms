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
        CLIUtils.ParsedParams parsedParams = CLIUtils.parseParams(args);
        Renderer.printConfig(
                parsedParams.getSortingAlgorithm().getAlgorithm().getName(),
                parsedParams.getListType(),
                parsedParams.getColor(),
                parsedParams.getPieceCount(),
                parsedParams.getSpeed()
        );
        ChessGame chessGame = new ChessGame(
                parsedParams.getSortingAlgorithm().getAlgorithm(),
                parsedParams.getListType(),
                parsedParams.getColor(),
                parsedParams.getPieceCount(),
                parsedParams.getSpeed()
        );
        chessGame.run();
    }
}
