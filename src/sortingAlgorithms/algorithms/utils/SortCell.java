package sortingAlgorithms.algorithms.utils;

public class SortCell<T> implements Comparable<SortCell<T>>{

	private int sortValue;
	private T object;
	
	public SortActions actions;
	
	public SortCell(int sortValue, T object, SortActions actions) {
		this(sortValue, object);
		
		this.actions = actions;
	}
	
	public SortCell(int sortValue, T object) {
		this.sortValue = sortValue;
		this.object = object;
		
		actions = new SortActions() {
			public void arrayEdit(Object obj) {
			}

			public void sortStart(Object obj) {
			}

			public void sortExtra(Object obj) {
				
			}
		};
	}
	
	public T getObject() {
		return object;
	}
	
	public SortActions getSortActions() {
		return actions;
	}
	
	public int compareTo(SortCell<T> cell) {
		return sortValue > cell.sortValue ? 1 : sortValue < cell.sortValue ? -1 : 0;
	}
	
	public int getSortValue() {
		return sortValue;
	}

}
