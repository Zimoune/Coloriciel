package utils;

import java.text.NumberFormat;
import java.text.ParseException;

import javax.swing.JFormattedTextField;
import javax.swing.text.MaskFormatter;

public class TextField extends JFormattedTextField{
int color;

	public TextField(int name, int posX, int posY, int w, int h){
		
		super(NumberFormat.getIntegerInstance());
		this.color = name;
		this.setBounds(posX, posY, w, h);
		this.setText(""+name);
		this.repaint();
		try{
			this.setFormatter(new MaskFormatter("###"));
		}catch(ParseException e){
			e.printStackTrace();
		}
	}
	
	public int getColor(){
		return this.color;
	}
	
	public void setColor(String c){
	try{
		int n = 0;
		if(c.length() == 3){
			n = 100;
		}
		else if(c.length() == 2){
			n = 10;
		}
		else if(c.length() == 1){
			n = 1;
		}
		else{
			this.color = 0;
			return;
		}
		this.color = 0;
		for(int i=0; i<c.length(); i++){
			if((c.charAt(i)-48)<0 || (c.charAt(i)-48)>9){
				this.color = 0;
				return;
			}
			this.color = ((c.charAt(i)-48)*n) + this.color;
		n = n/10;
		}
	}catch(Exception e){
		System.out.println("Erreur lors de la mise en place d'une couleur");
	}

	}
	
}
