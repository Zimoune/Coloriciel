package utils;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;


public class Panel extends JPanel{
private String name;
private Color bgColor;
private int x, y;
	public Panel(String name, Color c, int w, int h){
		this.setPreferredSize(new Dimension(w, h));
		this.setName(this.name);
		this.setVisible(true);
		this.setLayout(null);
		this.bgColor = c;
		this.setBackground(this.bgColor);
		this.repaint();
	}
	
	public Panel(Color c, int x, int y, int w, int h){
		this.x = x;
		this.y = y;
		this.setBounds(x, y, w, h);
		this.setName(this.name);
		this.setVisible(true);
		this.setLayout(null);
		this.bgColor = c;
		this.setBackground(this.bgColor);
		this.repaint();
	}
	
	public int getPosX(){
		return this.x;
	}
	
	public int getPosY(){
		return this.y;
	}
	
}
