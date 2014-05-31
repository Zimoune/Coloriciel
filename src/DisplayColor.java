import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import utils.Button;
import utils.Panel;


public class DisplayColor extends Panel implements MouseListener{
	private ArrayList<Color> listColor = new ArrayList<Color>();
	private ArrayList<Button> buttonList = new ArrayList<Button>();
	private int nmbColor;
	private Fenetre frame;
	private Color[] tabColor;
	private PanelColor modify;
	boolean estPasse = false;
	public DisplayColor(Fenetre frame, int nmbColor, Color c, int x, int y, int w, int h) {
		super(c, x, y, w, h);
		this.frame = frame;
		this.nmbColor = nmbColor;
	}
	
	public void addColor(Color c){
		this.listColor.add(c);
	}
	
	public void updatePanel(){
		int buttonX = 130, buttonY = 110;
		boolean changement = false;
		for(int i = 0; i<nmbColor; i++){
			buttonList.add(new Button(i, buttonX, buttonY, 50, 50));
			buttonList.get(i).setBackground(listColor.get(i));
			buttonList.get(i).setColor(buttonList.get(i).getBackground());
		//	buttonList.get(i).setColor(c);
			buttonX = buttonX+70;
			if(i>4)
				if(changement == false){
					buttonX = 130;
					buttonY = 180;
					changement = true;
				}	
		}
		for(Button b:buttonList){
			b.addMouseListener(this);
			
			this.add(b);
		}
		tabColor = new Color[buttonList.size()];
		this.repaint();
		this.frame.revalidate();
	}
	
	public void setColorAtButton(int index, Color c){
		this.buttonList.get(index).setBackground(c);
		this.buttonList.get(index).setColor(c);
		this.updatePanel();
	}
	
	public ArrayList<Button> getButtonList(){
		return this.buttonList;
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		if(arg0.getSource() instanceof Button){
			Button b = (Button) arg0.getSource();
			System.out.println("------------------");
			System.out.println(this.frame);
			System.out.println(this);
			System.out.println(b);
			modify = new PanelColor(b.getId(), this.frame, this, b, 600, 300);
			this.frame.setContentPane(modify);
			this.frame.revalidate();
		}
	}
	

	@Override
	public void mouseEntered(MouseEvent arg0) {
		if(estPasse == false){
			for(int i = 0; i<buttonList.size(); i++){
				tabColor[i] = buttonList.get(i).getBackground();
				int r, g, b;
				r = (int) (0.299*tabColor[i].getRed());
				//System.out.println(r);
				g = (int) (0.587*tabColor[i].getGreen());
				//System.out.println(g);
				b = (int) (0.114*tabColor[i].getBlue());
				//System.out.println(b);
				buttonList.get(i).setBackground(new Color(r+g+b, r+g+b, r+g+b));
			}
			this.frame.revalidate();
			estPasse = true;
		}

	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		if(estPasse == true){
			for(int i = 0; i<buttonList.size(); i++){
				buttonList.get(i).setBackground(buttonList.get(i).getColor());
			}
			estPasse = false;
			this.frame.revalidate();
		}
		

	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	
	
}
