
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;

import utils.Button;

public class CarreColor extends JPanel implements ActionListener{
	
	private Button[][] tab = new Button[6][4];
	private ArrayList<Color> listColor = new ArrayList<Color>();
	public PanelColor pc;

	
	public CarreColor(String name, Color c, PanelColor pc){ //int w, int h){
		this.pc = pc;
		//this.setLayout(new GridLayout());
		this.setLayout(new GridLayout(4,3));
		this.setName(name);
		this.setPreferredSize(new Dimension(120, 120));
		this.setBackground(c);
		remplirList();
		int c1 = 0, c2 = 0, c3 = 0;
	    for(int i = 0; i<(4*3); i++){
	    	
	    	JButton b = new JButton("");
	    	b.setSize(new Dimension(50, 40));
	    	b.addActionListener(this);
	    	b.setBackground(listColor.get(i));
	    	this.add(b);
	    	c1 = c1 + 1;
	    	c2 = c2 + 1;
	    	c3 = c3 + 1;
	    }
		this.setBounds(233, 30, 140, 140);
		creerTableau();
		this.setVisible(true);	
	}
	
	public void creerTableau(){
		for(int i=0; i<this.tab.length; i++){
			for(int j=0; j<2; j++){
				
			}
		}
		this.repaint();
	}
	
	public void remplirList(){
		listColor.add(new Color(255,0,0));
		listColor.add(new Color(255,128,0));
		listColor.add(new Color(255,255,0));
		listColor.add(new Color(128,255,0));
		listColor.add(new Color(0,255,0));
		listColor.add(new Color(0,255,128));
		listColor.add(new Color(0,255,255));
		listColor.add(new Color(0,128,255));
		listColor.add(new Color(0,0,255));
		listColor.add(new Color(128,0,255));
		listColor.add(new Color(255,0,255));
		listColor.add(new Color(255,0,128));
	}


	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		int r = ((JButton)arg0.getSource()).getBackground().getRed();
		int g = ((JButton)arg0.getSource()).getBackground().getGreen();
		int b = ((JButton)arg0.getSource()).getBackground().getBlue();
		pc.validColor(r, g, b);
		pc.colorR.setText(""+pc.colorChoice.getBackground().getRed());
		pc.colorG.setText(""+pc.colorChoice.getBackground().getGreen());
		pc.colorB.setText(""+pc.colorChoice.getBackground().getBlue());
		System.out.println("r = " + r + " g = " + g + " b = " + b);
		pc.repaint();
	}

}
