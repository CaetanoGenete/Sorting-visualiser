package sortingAlgorithms;

import sortingAlgorithms.algorithms.types.Sort;
import sortingAlgorithms.algorithms.types.Types;
import sortingAlgorithms.algorithms.utils.SortRectangle;

public class Sorter implements Runnable {

	private Thread thread;
	
	private boolean running = true;
	
	private static boolean sorting = false;
	private static Types sortingType;
	
	public static SortingList<SortRectangle> list;
	
	public static long lastTime = System.nanoTime();
	
	public synchronized void start() {
		thread = new Thread(this);
		thread.start();
	}
	
	public synchronized void stop() {
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void run() {
		while(running) {
			if(sorting) {
				lastTime = System.nanoTime();
				
				Sort.sort(list.getList(), sortingType, false);
				
				sorting = false;
			} else {
				Main.paint();
				
				try {
					Thread.sleep(50);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public synchronized void sort(Types sortingTypes) {
		sorting = true;
		
		this.sortingType = sortingTypes;
	}
	
	public static void endSorting() {
		sorting = false;
	}
	
	public static Types getSortingType() {
		return sortingType;
	}
	
	public static boolean isSorting() {
		return sorting;
	}

}
