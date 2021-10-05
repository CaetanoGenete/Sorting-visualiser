package sortingAlgorithms.algorithms.types;

import sortingAlgorithms.Main;
import sortingAlgorithms.algorithms.utils.SortCell;
import sortingAlgorithms.panels.ListOptionsPanel;

public class BubbleSort implements SortingAlgorithm {

	public <T> void sort(SortCell<T>[] list, int min, int max, int reversed) {
		bubbleSort(list, min, max, reversed);
	}
	
	public <T> void bubbleSort(SortCell<T>[] list, int min, int max, int reversed) {
		if(max > min) {
			bubbleSortComp(list, min, max--, reversed);
			bubbleSort(list, min, max, reversed);
		}
	}
	
	public <T> void bubbleSortComp(SortCell<T>[] list, int min, int max, int reversed) {
		for(int i = min; i < max; i++) {
			list[max].actions.sortStart(list[max]);
			
			ListOptionsPanel.addAccesses();
			ListOptionsPanel.addAccesses();
			ListOptionsPanel.addComparisons();
			if(list[i].compareTo(list[i + 1]) == reversed) {
				SortCell<T> temp = list[i];
				ListOptionsPanel.addAccesses();
				temp.actions.arrayEdit(temp);
				list[i] = list[i + 1];
				ListOptionsPanel.addAccesses();
				list[i + 1].actions.arrayEdit(list[i + 1]);
				list[i + 1] = temp;
				ListOptionsPanel.addAccesses();
				
				ListOptionsPanel.addSwaps();
			}
			Main.paint();
		}
	}
}
