package algorithms.factory;
import algorithms.SortingAlgorithm;
import enums.SortingAlgorithmType;
public class SortingAlgorithmFactory {
    public static SortingAlgorithm getAlgorithm(String code) {
        return SortingAlgorithmType.fromCode(code).getAlgorithm();
    }
}
