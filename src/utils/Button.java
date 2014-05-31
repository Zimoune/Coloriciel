package utils;

import java.awt.Color;
import java.awt.event.MouseEvent;

import javax.swing.JButton;

public class Button extends JButton{

	private String name = "";
	private int posX, posY;
	private Color trueColor;
	
	public Button(int id, int posX, int posY, int width, int height){
		this.posX = posX;
		this.posY = posY;
		this.setBounds(posX, posY, width, height);
		this.name = this.name + id;
		this.setText(name);
	}
	
	public Button(String text, int posX, int posY, int width, int height){
		this.setText(text);
		this.posX = posX;
		this.posY = posY;
		this.setBounds(posX, posY, width, height);
		this.setName(text);
	}
	
	public Button(int posX, int posY, int width, int height){
		this.setBounds(posX, posY, width, height);
	}
	
	public int getPosX(){
		return this.posX;
	}
	
	public int getPosY(){
		return this.posY;
	}
	
	public void setColor(Color c){
		this.trueColor = c;
	}
	
	public Color getColor(){
		return this.trueColor;
	}
	public void mouseReleased(MouseEvent event) {
		System.out.println(event.getButton());
	}
	
}
