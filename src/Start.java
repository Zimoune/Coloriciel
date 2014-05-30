import java.awt.Font;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

import utils.Button;
import utils.Label;


public class Start {
	
	public static Label lbl1 = new Label("Coloriciel", 220, 40, 300, 60);
	//public static ComboBox boxNmbColor = new ComboBox(270, 130, 60, 20);
	
	public static ArrayList<Button> buttonList = new ArrayList<Button>();
	
	
	
	
	public static void main(String[] args) {
		Fenetre fen = new Fenetre(600, 300, "Coloriciel");
		fen.setContentPane(Fenetre.menuNmbColor);
		lbl1.setFont(new Font("TimesRoman", Font.BOLD, 30));
		Fenetre.menuNmbColor.add(lbl1);
		int buttonX = 130, buttonY = 110;
		boolean changement = false;
		for(int i = 1; i<=10; i++){
			buttonList.add(new Button(i, buttonX, buttonY, 50, 50));
			buttonX = buttonX+70;
			System.out.println("X : " + buttonX + " Y : " + buttonY);
			if(i>4)
				if(changement == false){
					buttonX = 130;
					buttonY = 180;
					changement = true;
				}	
		}
		for(Button b:buttonList){
			b.addActionListener(fen);
			Fenetre.menuNmbColor.add(b);
		}
		fen.repaint();
	}

	
}
