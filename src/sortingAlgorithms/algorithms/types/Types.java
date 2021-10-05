package sortingAlgorithms.algorithms.types;

public enum Types {

	QUICKSORT(new QuickSort()),
	RADIXSORT(new RadixSort()),
	MERGESORT(new MergeSort()),
	BUBBLESORT(new BubbleSort()),
	BITONIC(new BitonicSort());
	
	private SortingAlgorithm algorithm;
	
	private Types(SortingAlgorithm algorithm) {
		this.algorithm = algorithm;
	}
	
	SortingAlgorithm getAlgorithm() {
		return algorithm;
	}
	
}
