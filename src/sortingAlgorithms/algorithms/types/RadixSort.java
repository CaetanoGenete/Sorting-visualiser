package sortingAlgorithms.algorithms.types;

import java.util.LinkedList;

import sortingAlgorithms.Main;
import sortingAlgorithms.algorithms.utils.SortCell;
import sortingAlgorithms.panels.ListOptionsPanel;

public class RadixSort implements SortingAlgorithm {

	private static int digits = 1;
	
	public <T> void sort(SortCell<T>[] list, int min, int max, int reversed) {
		digits = 1;
		
		boolean firstTime = true;
		
		int i = 1, m = 10;
		for(int j = 0; j < digits; j++) {
			radixSort(list, i, m, min, max + 1, reversed, firstTime);
			firstTime = false;
			
			i *= 10;
			m *= 10;
		}
	}

	public static <T> void radixSort(SortCell<T>[] list, int i, int m, int min, int max, int reversed, boolean firstTime) {
		LinkedList<LinkedList<SortCell<T>>> lists = new LinkedList<>();
		
		for(int j = 0; j < 10; j++) {
			lists.add(new LinkedList<>());
		}
		
		int maxNumber = 0;
		for(int j = min; j < max; j++) {
			SortCell<T> item = list[j];
			ListOptionsPanel.addAccesses();
			item.actions.sortStart(item);
			Main.paint();
			
			int itemValue = item.getSortValue();
			
			if(firstTime)
				maxNumber = Math.max(itemValue, maxNumber);
			
			int pos = (itemValue % m) / i;
			
			lists.get(pos).add(item); 
			ListOptionsPanel.addAccesses();
		}
		
		if(firstTime)
			digits = (int) (Math.log10(maxNumber)) + 1;
		
		int arrayPos = min;
		for(int j = 0; j < 10; j++)  {
			LinkedList<SortCell<T>> digitList = lists.get(j);
			for(int k = 0; k < digitList.size(); k++) {
				list[arrayPos] = digitList.get(k);
				ListOptionsPanel.addAccesses();
				ListOptionsPanel.addAccesses();
				SortCell<T> item = list[arrayPos++];
				item.actions.arrayEdit(item);
				Main.paint();
			}
		}
		
	}
	
}
