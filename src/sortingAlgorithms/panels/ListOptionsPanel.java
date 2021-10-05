package sortingAlgorithms.panels;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.text.JTextComponent;

import sortingAlgorithms.Main;
import sortingAlgorithms.Sorter;
import sortingAlgorithms.algorithms.types.Types;
import sortingAlgorithms.algorithms.utils.MiscUtils;

public class ListOptionsPanel extends JPanel{

	private static int coms = 0;
	private static int swps = 0;
	private static int acss = 0;
	private static long time = 0;
	
	private static JLabel comparisons, swaps, acesses, timeElapsed;
	
	private static JTextField listSize;
	
	public ListOptionsPanel(int width, int height, Sorter sorter) {
		super(new GridLayout(7, 2));
		
		JLabel comparisonsLabel = new JLabel("Comparisons: ");
		add(comparisonsLabel);
		
		comparisons = new JLabel("0");
		add(comparisons);
		
		JLabel swapsLabel = new JLabel("Swaps: ");
		add(swapsLabel);
		
		swaps = new JLabel("0");
		add(swaps);
		
		JLabel arrayAccesses = new JLabel("Array Accesses: ");
		add(arrayAccesses);
		
		acesses = new JLabel("0");
		add(acesses);
		
		JLabel timeElpasedLabel = new JLabel("Time elapsed(s): ");
		add(timeElpasedLabel);
		
		timeElapsed = new JLabel("0");
		add(timeElapsed);
		
		JLabel listSizeLabel = new JLabel("List Size: ");
		add(listSizeLabel);
		
		JLabel timeDelayLabel = new JLabel("Time Delay(ms): ");
		add(timeDelayLabel);
		
		listSize = new JTextField("120");
		listSize.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String text = listSize.getText();
				
				if(!text.matches("[-+]?\\d*\\.?\\d+")) {
					listSize.setText(String.valueOf(Sorter.list.getListSize()));
					return;
				}
				
				int value = Integer.parseInt(text);
				value = value < 0 ? 0 : value > 1200 ? 1200 : value;
				listSize.setText(String.valueOf(value));
				Main.setListSize(value);
			}
		});
		add(listSize);
		
		JTextField timeDelay = new JTextField("40");
		timeDelay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String text = timeDelay.getText();
				
				if(!text.matches("[-+]?\\d*\\.?\\d+")) {
					timeDelay.setText(String.valueOf(Sorter.list.getListSize()));
					return;
				}
				
				int value = Integer.parseInt(text);
				value = value < 0 ? 0 : value > 1000 ? 1000 : value;
				timeDelay.setText(String.valueOf(value));
				Main.timeDelay = value;
			}
		});
		
		add(timeDelay);
		
		JButton randomise = new JButton("Randomise");
		randomise.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MiscUtils.randomiseList();
				setComparisons(0);
				setSwaps(0);
				setAccesses(0);
				setTime(0);
				Main.paint();
				
			}
		});
		add(randomise);
		
	}
	
	public static void setComparisons(int comps) {
		ListOptionsPanel.coms = comps;
		
		comparisons.setText(String.valueOf(comps));
	}
	
	public static void setSwaps(int swaps) {
		ListOptionsPanel.swps = swaps;
		
		ListOptionsPanel.swaps.setText(String.valueOf(swaps));

	}
	
	public static void setAccesses(int acesses) {
		ListOptionsPanel.acss = acesses;
		
		ListOptionsPanel.acesses.setText(String.valueOf(acesses));
	}
	
	public static void setTime(long time) {
		ListOptionsPanel.time = time;
		
		ListOptionsPanel.timeElapsed.setText(String.valueOf(time/1000000000.0));
	}
	
	public static void setListSize(int size) {
		ListOptionsPanel.listSize.setText(String.valueOf(size));
		
		Main.setListSize(size);
	}
	
	public static void addComparisons() {
		setComparisons(ListOptionsPanel.coms+1);
	}
	
	public static void addSwaps() {
		setSwaps(ListOptionsPanel.swps+1);

	}
	
	public static void addAccesses() {
		setAccesses(ListOptionsPanel.acss+1);

	}
	
}
