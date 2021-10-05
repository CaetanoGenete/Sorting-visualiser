package sortingAlgorithms.panels;

import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JPanel;

import sortingAlgorithms.Sorter;

public class UserInterface extends JPanel {

	public UserInterface(int width, int height, Sorter sorter) {
		super(new GridLayout(2, 1));
		
		setPreferredSize(new Dimension(width, height));
		
		add(new SortingOptions(width, height/2, sorter));
		add(new ListOptionsPanel(width, height/2, sorter));
	}
	
}
