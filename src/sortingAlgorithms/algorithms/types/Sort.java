package sortingAlgorithms.algorithms.types;

import sortingAlgorithms.algorithms.utils.SortCell;

public class Sort {
	
	public static <T> void sort(SortCell<T>[] list, Types type, boolean reversed) {
		type.getAlgorithm().sort(list, 0, list.length - 1, reversed ? -1 : 1);
	}
	
}
