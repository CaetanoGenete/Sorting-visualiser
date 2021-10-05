package sortingAlgorithms.algorithms.types;

import sortingAlgorithms.Main;
import sortingAlgorithms.algorithms.utils.SortCell;
import sortingAlgorithms.panels.ListOptionsPanel;

public class BitonicSort implements SortingAlgorithm {

	public <T> void sort(SortCell<T>[] list, int min, int max, int reversed) {
		int steps = 0;
		int range = max - min;
		
		steps = (int)(Math.log(range) / Math.log(2));
		
		bitonicSort(steps + 1, list);
	}

	static <T> void bitonicSortComponent(SortCell<T>[] list, final int p, final int q) {
		final int d = 1 << (p - q);
		
		for (int i = 0; i < list.length; i++) {
			boolean up = ((i >> p) & 2) == 0;
			
			list[p].actions.sortStart(list[p]);
			list[d].actions.sortExtra(list[d]);
			
			ListOptionsPanel.addComparisons();
			ListOptionsPanel.addAccesses();
			ListOptionsPanel.addAccesses();
			if ((i & d) == 0 && (list[i].compareTo(list[i | d]) == 1) == up) {
				SortCell<T> temp = list[i];
				ListOptionsPanel.addAccesses();
				temp.getSortActions().arrayEdit(temp);
				list[i] = list[i | d];
				ListOptionsPanel.addAccesses();
				list[i | d].getSortActions().arrayEdit(list[i | d]);
				list[i | d] = temp;
				ListOptionsPanel.addAccesses();
				
				ListOptionsPanel.addSwaps();
			}
			
			Main.paint();
		}
	}

	static <T> void bitonicSort(final int powerOf2, SortCell<T>[] list) {
		assert list.length == 1 << powerOf2;

		for (int i = 0; i < powerOf2; i++) {
			for (int j = 0; j <= i; j++) {
				bitonicSortComponent(list, i, j);
			}
		}
	}
}
