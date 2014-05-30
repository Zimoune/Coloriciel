package utils;

import javax.swing.JLabel;

public class Label extends JLabel{

	private String name;
	private int posX, posY, width, height;
	public Label(String name, int posX, int posY, int width, int height){
		this.name = name;
		this.setText(this.name);
		this.posX = posX;
		this.posY = posY;
		this.width = width;
		this.height = height;
		this.setBounds(this.posX, this.posY, this.width, this.height);
	}
	
}
