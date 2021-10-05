package sortingAlgorithms.panels;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

import sortingAlgorithms.Sorter;
import sortingAlgorithms.algorithms.utils.SortRectangle;

public class SortingScreen extends JPanel {

	private int width, height;
	
	private BufferedImage screen;
	private int x, y;

	private int startColour = 0xFF00FF, endColour = 0x00FFFF;
	
	public SortingScreen(int x, int y, int width, int height) {
		super(true);
		
		setPreferredSize(new Dimension(width, height));
		
		this.width = width;
		this.height = height;
		this.x = x;
		this.y = y;
		
		screen = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
	}
	
	public void paint(Graphics g) {
		Graphics g2 = screen.getGraphics();
		
		g2.setColor(Color.BLACK);
		g2.fillRect(0, 0, width, height);
		
		for(int i = 0; i < Sorter.list.getListSize(); i++)
			drawRect(Sorter.list.getObject(i), i * Sorter.list.getRectWidth(), g2);
		
		g.drawImage(screen, x, y, getWidth(), getHeight(), null);
	}
	
	private void drawRect(SortRectangle rect, double x, Graphics g) {
		int xPos = (int)x;
		double rWidth = (x - xPos) + Sorter.list.getRectWidth();
		
		//g.setColor(getInBetweenColour((double)rect.height/height));
		g.setColor(rect.getColor());
		g.fillRect(xPos, height - rect.getRect().height, (int)Math.round(rWidth), rect.getRect().height);
		g.setColor(Color.BLACK);
		
		if(Sorter.list.getListSize() <= 500)
			g.drawRect(xPos, height - rect.getRect().height, (int)Math.round(rWidth), rect.getRect().height);

	}
	
	private Color getInBetweenColour(double value) {
		int startRed = (startColour >> 16) & 0xFF;
		int startGreen = (startColour >> 8) & 0xFF;
		int startBlue = (startColour) & 0xFF;

		int endRed = (endColour >> 16) & 0xFF;
		int endGreen = (endColour >> 8) & 0xFF;
		int endBlue = (endColour) & 0xFF;
		
		int red = (int)((startRed * (1 - value)) + (endRed * value));
		int green = (int)((startGreen * (1 - value)) + (endGreen * value));
		int blue = (int)((startBlue * (1 - value)) + (endBlue * value));
	
		return new Color(red, green, blue);
	}
	
}
