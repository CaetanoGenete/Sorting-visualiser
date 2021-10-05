package sortingAlgorithms.algorithms.types;

import sortingAlgorithms.algorithms.utils.SortCell;

public interface SortingAlgorithm {
	
	public<T> void sort(SortCell<T>[] list, int min, int max, int reversed);
	
}
