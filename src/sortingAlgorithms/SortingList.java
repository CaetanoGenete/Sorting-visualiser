package sortingAlgorithms;

import sortingAlgorithms.Main;
import sortingAlgorithms.algorithms.utils.SortActions;
import sortingAlgorithms.algorithms.utils.SortCell;

public class SortingList<T> {

	private SortCell<T>[] list;
	private int min, max;
	
	private double rectWidth = 0;
	
	@SuppressWarnings("unchecked")
	public SortingList(T[] objectData, SortActions actions) {
		
		list = new SortCell[objectData.length];
		
		for(int i = 0; i < list.length; i++)
			list[i] = new SortCell<T>(i, objectData[i], actions);
		
		rectWidth = (double)(Main.getScreenWidth())/list.length;
	}
	
	public T getObject(int index) {
		return list[index].getObject();
	}
	
	public double getRectWidth() {
		return rectWidth;
	}
	
	public int getListSize() {
		return list.length;
	}
	
	public void swap(int i, int j) {
		SortCell<T> temp = list[i];
		list[i] = list[j];
		list[j] = temp;
	}
	
	SortCell<T>[] getList() {
		return list;
	}
	
}
