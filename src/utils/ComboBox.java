package utils;

import javax.swing.JComboBox;

public class ComboBox extends JComboBox{
private int x, y, width, height;
	public ComboBox(int x, int y, int width, int height){
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.setBounds(x, y, width, height);
	}
	
}
