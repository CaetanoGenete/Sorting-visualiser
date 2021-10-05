package sortingAlgorithms.algorithms.utils;

import java.awt.Color;
import java.awt.Rectangle;

public class SortRectangle {

	private Rectangle rect;
	private Color original, show;
	
	public SortRectangle(Rectangle rect, Color original) {
		this.original = original;
		this.show = new Color(original.getRGB());
		
		this.rect = rect;
	}
	
	public void setColor(Color colour) {
		this.show = colour;
	}
	
	public Color getColor() {
		Color col = new Color(show.getRGB());
		show = new Color(original.getRGB());
		
		return col;
	}
	
	public Rectangle getRect() {
		return rect;
	}
	
}
