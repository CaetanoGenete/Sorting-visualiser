package sortingAlgorithms.algorithms.utils;

import java.util.Random;

import sortingAlgorithms.Sorter;

public class MiscUtils {

	public static void randomiseList() {
		Random random = new Random();
		
		for(int i = Sorter.list.getListSize() - 1; i >= 0; i--) {
			
			int index = random.nextInt(i + 1);
			
			Sorter.list.swap(index, i);
		}
	}
	
	public static void randomList() {
		for(int i = 0; i < Sorter.list.getListSize(); i++) {
		}
	}
	
}
