package sortingAlgorithms.algorithms.types;

import sortingAlgorithms.Main;
import sortingAlgorithms.algorithms.utils.SortCell;
import sortingAlgorithms.panels.ListOptionsPanel;

public class MergeSort implements SortingAlgorithm {

	public <T> void sort(SortCell<T>[] list, int min, int max, int reversed) {
		SortCell<T>[] help = new SortCell[list.length];
		
		split(list, help, min, max + 1, -reversed);
	}
	
	private <T> void split(SortCell<T>[] array, SortCell<T>[] help, int min, int max, int reversed) {

		if (max - min < 2)
			return;

		int mid = (max + min + 1) / 2;

		split(array, help, min, mid, reversed);
		split(array, help, mid, max, reversed);

		merge(array, help, min, mid, max, reversed);

	}

	private <T> void merge(SortCell<T>[] array, SortCell<T>[] help, int min, int mid, int max, int reversed) {
		
		int left = min; int right = mid;
		int pos = min;
		
		array[mid].actions.sortStart(array[mid]);
		
		while(left < mid && right < max) {
			SortCell<T> leftArray = array[left];
			ListOptionsPanel.addAccesses();
			SortCell<T> rightArray = array[right];
			ListOptionsPanel.addAccesses();
			
			ListOptionsPanel.addComparisons();
			if(leftArray.compareTo(rightArray) == reversed) {
				help[pos] = leftArray;
				ListOptionsPanel.addAccesses();
				left++;
			} else {
				help[pos] = rightArray;
				ListOptionsPanel.addAccesses();
				right++;
			}
			
			SortCell<T> current = help[pos++];
			
			current.actions.arrayEdit(current);
			array[mid].actions.sortStart(array[mid]);
			array[min].actions.sortExtra(array[min]);
			array[max - 1].actions.sortExtra(array[max - 1]);
			Main.paint();
		}
		
		while(left < mid) {
			help[pos] = array[left++];
			ListOptionsPanel.addAccesses();
			ListOptionsPanel.addAccesses();
			SortCell<T> current = help[pos++];
			current.actions.arrayEdit(current);
			array[mid].actions.sortStart(array[mid]);
			array[min].actions.sortExtra(array[min]);
			array[max - 1].actions.sortExtra(array[max - 1]);
			Main.paint();
		}
		
		while(right < max) {
			help[pos] = array[right++];
			ListOptionsPanel.addAccesses();
			ListOptionsPanel.addAccesses();
			SortCell<T> current = help[pos++];
			current.actions.arrayEdit(current);
			array[mid].actions.sortStart(array[mid]);
			array[min].actions.sortExtra(array[min]);
			array[max - 1].actions.sortExtra(array[max - 1]);
			Main.paint();
		}
		
		for(int i = min; i < max; i++) {
			array[i] = help[i];
			ListOptionsPanel.addAccesses();
			ListOptionsPanel.addAccesses();
			SortCell<T> current = array[i];
			current.actions.arrayEdit(current);
			array[mid].actions.sortStart(array[mid]);
			array[min].actions.sortExtra(array[min]);
			array[max - 1].actions.sortExtra(array[max - 1]);
			Main.paint();
		}
	}

}
