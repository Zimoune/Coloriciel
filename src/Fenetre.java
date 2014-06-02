

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import utils.Button;
import utils.Panel;


public class Fenetre extends JFrame implements ActionListener{

private int x;
private int y;
private String name;
public static Panel menuNmbColor;
public static PanelColor menuColorChoice;
private int nmbColorTotal;
private DisplayColor dc;
private int greyIndicator=220;
private int neededGrey;

	public Fenetre(int x, int y, String name){
		menuNmbColor = new Panel("menuNmbColor", new Color(204,204,204), this.x, this.y);
		this.x = x;
		this.y = y;
		this.name = name;
		this.setVisible(true);
		this.setPreferredSize(new Dimension(this.x, this.y));
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setName(this.name);
		this.setTitle(this.name);
		this.setLayout(null);
		this.setResizable(false);
		this.pack();
		
	}
	
	public void setGreyIndicator(int c){
		greyIndicator = greyIndicator - c;
	}
	public int getGreyIndicator(){
		return greyIndicator;
	}
	public void setNeededGrey(int grey){
		neededGrey= grey;
	}
	public int getNeededGrey(){
		return neededGrey;
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		String str = ((Button)arg0.getSource()).getText();
		
		
		if(str.equals("1")){
			this.nmbColorTotal = 1;
			menuColorChoice = new PanelColor(this, "menuColorChoice", 1, new Color(204, 204, 204), this.x, this.y);
		}
		else if(str.equals("2")){
			this.nmbColorTotal = 2;
			menuColorChoice = new PanelColor(this, "menuColorChoice", 2, new Color(204, 204, 204), this.x, this.y);
		}
		else if(str.equals("3")){
			this.nmbColorTotal = 3;
			menuColorChoice = new PanelColor(this, "menuColorChoice", 3, new Color(204, 204, 204), this.x, this.y);
		}
		else if(str.equals("4")){
			this.nmbColorTotal = 4;
			menuColorChoice = new PanelColor(this, "menuColorChoice", 4, new Color(204, 204, 204), this.x, this.y);
		}
		else if(str.equals("5")){
			this.nmbColorTotal = 5;
			menuColorChoice = new PanelColor(this, "menuColorChoice", 5, new Color(204, 204, 204), this.x, this.y);
		}
		else if(str.equals("6")){
			this.nmbColorTotal = 6;
			menuColorChoice = new PanelColor(this, "menuColorChoice", 6, new Color(204, 204, 204), this.x, this.y);
		}
		else if(str.equals("7")){
			this.nmbColorTotal = 7;
			menuColorChoice = new PanelColor(this, "menuColorChoice", 7, new Color(204, 204, 204), this.x, this.y);
		}
		else if(str.equals("8")){
			this.nmbColorTotal = 8;
			menuColorChoice = new PanelColor(this, "menuColorChoice", 8, new Color(204, 204, 204), this.x, this.y);
		}
		else if(str.equals("9")){
			this.nmbColorTotal = 9;
			menuColorChoice = new PanelColor(this, "menuColorChoice", 9, new Color(204, 204, 204), this.x, this.y);
		}
		else if(str.equals("10")){
			this.nmbColorTotal = 10;
			menuColorChoice = new PanelColor(this, "menuColorChoice", 10, new Color(204, 204, 204), this.x, this.y);
		}
		dc = new DisplayColor(this, this.nmbColorTotal, new Color(204, 204, 204), 0, 0, this.getWidth(), this.getHeight());
		this.setContentPane(menuColorChoice);
		this.repaint();
		
	}
	
	public DisplayColor getDC(){
		return this.dc;
	}
	
	public int getNmbColor(){
		return this.nmbColorTotal;
	}
	
	public void setNmbColor(int nb){
		this.nmbColorTotal = nb;
	}
	
	
	
}
