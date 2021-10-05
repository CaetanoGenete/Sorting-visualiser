package sortingAlgorithms.panels;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import sortingAlgorithms.Sorter;
import sortingAlgorithms.algorithms.types.Types;

public class SortingOptions extends JPanel {

	private int width, height;
	private Sorter sorter;

	public SortingOptions(int width, int height, Sorter sorter) {
		super(new GridLayout(5, 1));
		
		setPreferredSize(new Dimension(width, height));
		
		this.width = width;
		this.height = height;
		this.sorter = sorter;
		
		JButton quicksort = new JButton("QUICK");
		JButton bubblesort = new JButton("BUBBLE");
		JButton mergeSort = new JButton("MERGE");
		JButton radixSort = new JButton("RADIX");
		JButton bitonicSort = new JButton("BITONIC");
		
		quicksort.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(Sorter.isSorting()) return;
				
				ListOptionsPanel.setComparisons(0);
				ListOptionsPanel.setSwaps(0);
				ListOptionsPanel.setAccesses(0);
				ListOptionsPanel.setTime(0);
				
				sorter.sort(Types.QUICKSORT);
			}
		});
		
		add(quicksort);
		
		bubblesort.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(Sorter.isSorting()) return;
				ListOptionsPanel.setComparisons(0);
				ListOptionsPanel.setSwaps(0);
				ListOptionsPanel.setAccesses(0);
				ListOptionsPanel.setTime(0);

				sorter.sort(Types.BUBBLESORT);
			}
		});
		
		add(bubblesort);
		
		mergeSort.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(Sorter.isSorting()) return;
				
				ListOptionsPanel.setComparisons(0);
				ListOptionsPanel.setSwaps(0);
				ListOptionsPanel.setAccesses(0);
				ListOptionsPanel.setTime(0);

				sorter.sort(Types.MERGESORT);
				
			}
		});
		
		add(mergeSort);
		
		radixSort.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(Sorter.isSorting()) return;
				
				ListOptionsPanel.setComparisons(0);
				ListOptionsPanel.setSwaps(0);
				ListOptionsPanel.setAccesses(0);
				ListOptionsPanel.setTime(0);
				
				sorter.sort(Types.RADIXSORT);
				
			}
		});
		
		add(radixSort);
		
		bitonicSort.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(Sorter.isSorting()) return;
				
				//ListOptionsPanel.setListSize(1 << (int)Math.round(Math.log(Sorter.list.getListSize())/ Math.log(2)));
				
				ListOptionsPanel.setComparisons(0);
				ListOptionsPanel.setSwaps(0);
				ListOptionsPanel.setAccesses(0);
				ListOptionsPanel.setTime(0);
				
				sorter.sort(Types.BITONIC);
				
			}
		});
		
		add(bitonicSort);
		
		
		
	}
	
}
