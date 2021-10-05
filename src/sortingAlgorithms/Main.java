package sortingAlgorithms;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Rectangle;

import javax.swing.JFrame;

import sortingAlgorithms.algorithms.utils.MiscUtils;
import sortingAlgorithms.algorithms.utils.SortActions;
import sortingAlgorithms.algorithms.utils.SortCell;
import sortingAlgorithms.algorithms.utils.SortRectangle;
import sortingAlgorithms.panels.ListOptionsPanel;
import sortingAlgorithms.panels.SortingScreen;
import sortingAlgorithms.panels.UserInterface;

public class Main {
	
	private static int scWidth = 1200, scHeight = 800;
	
	private static SortingScreen screen;
	private static UserInterface ui;
	
	public static int timeDelay = 40;
	
	private Sorter sorter;
	
	public Main() {
		setListSize(32);
		setListSize(100);
		
		MiscUtils.randomiseList();
		
		sorter = new Sorter();
		sorter.start();
		
		screen = new SortingScreen(0, 0, scWidth, scHeight);
		ui = new UserInterface(200, 0, sorter);
		
		JFrame frame = new JFrame();
		
		frame.setLayout(new BorderLayout());
		frame.add(screen, BorderLayout.CENTER);
		frame.add(ui, BorderLayout.LINE_START);
		frame.setVisible(true);
		frame.setResizable(true);
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
	}
	
	public static void main(String[] args) {
		new Main();
	}
	
	public static void paint() {
		if(screen == null || ui == null) return;
		
		if(Sorter.isSorting()) {
			long now = System.nanoTime();
			ListOptionsPanel.setTime(now - Sorter.lastTime);
		}
		screen.repaint();
		ui.repaint();
		
		try {
			Thread.sleep(timeDelay);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public static void setListSize(int size) {
		SortRectangle[] objects = new SortRectangle[size];
		
		for(int i = 0; i < size; i++) {
			Rectangle rect = new Rectangle(scWidth/size, (int)(((double)scHeight/size) * (i + 1)));
			
			objects[i] = new SortRectangle(rect, Color.WHITE);
		}
		
		Sorter.list = new SortingList<>(objects, new SortActions() {
			@SuppressWarnings("unchecked")
			public void sortStart(Object obj) {
				SortRectangle rect = ((SortCell<SortRectangle>)obj).getObject();
				
				rect.setColor(Color.GREEN);
			}
			
			@SuppressWarnings("unchecked")
			public void arrayEdit(Object obj) {
				SortRectangle rect = ((SortCell<SortRectangle>)obj).getObject();
				
				rect.setColor(Color.RED);
			}

			@SuppressWarnings("unchecked")
			public void sortExtra(Object obj) {
				SortRectangle rect = ((SortCell<SortRectangle>)obj).getObject();
				
				rect.setColor(Color.BLUE);
			}

		});
 	}
 	
	
	public static int getScreenWidth() {
		return scWidth;
	}
	
	
}
