package sortingAlgorithms.algorithms.types;

import sortingAlgorithms.Main;
import sortingAlgorithms.algorithms.utils.SortCell;
import sortingAlgorithms.panels.ListOptionsPanel;

public class QuickSort implements SortingAlgorithm {

	public <T> void sort(SortCell<T>[] list, int min, int max, int reversed) {
		quicksort(list, min, max, reversed);
	}
	
	public <T> void quicksort(SortCell<T>[] list, int min, int max, int reversed) {
		if(min < max) {
			int p = partition(list, min, max, reversed);
			quicksort(list, min, p, reversed);
			quicksort(list, p + 1, max, reversed);
		}
	}
	
	public <T> int partition(SortCell<T>[] list, int min, int max, int reversed) { 
		SortCell<T> pivot = list[min--];
		ListOptionsPanel.addAccesses();
		pivot.actions.sortStart(pivot);
		max++;
		
		while(true) {
			do {
				min++;
				list[min].actions.sortExtra(list[min]);
				ListOptionsPanel.addAccesses();
				ListOptionsPanel.addComparisons();
				pivot.actions.sortStart(pivot);
				Main.paint();
			} while(list[min].compareTo(pivot) == -reversed);
			
			
			do {
				max--;
				list[max].actions.sortExtra(list[max]);
				ListOptionsPanel.addAccesses();
				ListOptionsPanel.addComparisons();
				pivot.actions.sortStart(pivot);
				Main.paint();
			} while(list[max].compareTo(pivot) == reversed);
			
			if(min >= max) return max;
			
			pivot.actions.sortStart(pivot);
			
			SortCell<T> temp = list[min];
			ListOptionsPanel.addAccesses();
			temp.getSortActions().arrayEdit(temp);
			list[min] = list[max];
			ListOptionsPanel.addAccesses();
			temp.getSortActions().arrayEdit(list[min]);
			list[max] = temp;
			ListOptionsPanel.addAccesses();
			
			ListOptionsPanel.addSwaps();
			
			Main.paint();
		}
	}
	
}
