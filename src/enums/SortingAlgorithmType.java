package enums;

import algorithms.BubbleSort;
import algorithms.CountingSort;
import algorithms.HeapSort;
import algorithms.InsertionSort;
import algorithms.MergeSort;
import algorithms.QuickSort;
import algorithms.RadixSort;
import algorithms.SelectionSort;
import algorithms.SortingAlgorithm;
import exceptions.InvalidParameterException;
import utils.Constants;

public enum SortingAlgorithmType {
    BUBBLE_SORT("b", new BubbleSort()),
    SELECTION_SORT("s", new SelectionSort()),
    INSERTION_SORT("i", new InsertionSort()),
    MERGE_SORT("m", new MergeSort()),
    QUICK_SORT("q", new QuickSort()),
    HEAP_SORT("h", new HeapSort()),
    COUNTING_SORT("c", new CountingSort()),
    RADIX_SORT("r", new RadixSort());
    private final String code;
    private final SortingAlgorithm algorithm;
    SortingAlgorithmType(String code, SortingAlgorithm algorithm) {
        this.code = code.toLowerCase();
        this.algorithm = algorithm;
    }
    public SortingAlgorithm getAlgorithm() {
        return algorithm;
    }
    public static SortingAlgorithmType fromCode(String code) {
        String normalized = code.trim().toLowerCase();
        for (SortingAlgorithmType type : values()) {
            if (type.code.equals(normalized)) {
                return type;
            }
        }
        throw new InvalidParameterException(Constants.INVALID);
    }
}
