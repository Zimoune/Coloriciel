import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JColorChooser;
import javax.swing.JPanel;
import javax.swing.colorchooser.AbstractColorChooserPanel;

import utils.Button;
import utils.Label;
import utils.TextField;

public class PanelColor extends JPanel implements MouseListener {
	private int nmbColor;
	private ArrayList<Button> buttonList = new ArrayList<Button>();
	private CarreColor carreColor = new CarreColor("stfu", new Color(255, 255,
			255), this);
	public TextField colorR = new TextField(Color.yellow.getRed(), 240, 230,
			30, 30);
	public TextField colorB = new TextField(Color.yellow.getBlue(), 340, 230,
			30, 30);
	public TextField colorG = new TextField(Color.yellow.getGreen(), 290, 230,
			30, 30);
	public Button colorChoice = new Button(280, 180, 50, 30);
	private Button next = new Button("Suivant", 500, 225, 90, 40);
	private Button choseColor = new Button("précision", 490, 30, 100, 40);
	private Color bgColor;
	private Fenetre frame;
	private DisplayColor dc;
	private Label numColor = new Label("Il reste ", 450, 175, 150, 40);
	private Button lastButton;
	private boolean estConstructeurBis = false;

	public PanelColor(Fenetre f, String name, int nbColor, Color c, int w, int h) {
		this.bgColor = c;
		choseColor.addMouseListener(this);
		this.add(choseColor);
		this.nmbColor = nbColor - 1;
		this.numColor.setText(this.numColor.getText() + this.nmbColor
				+ " couleur(s)");
		this.add(this.numColor);
		this.frame = f;
		this.setBackground(this.bgColor);
		this.setSize(new Dimension(w, h));
		this.setName(name);
		this.setLayout(null);
		this.addMouseListener(this);
		// carreColor.setMaximumSize(new Dimension(200, 200));
		this.add(carreColor);
		System.out.println(this.carreColor.getBackground());
		this.add(colorR);
		validColor(colorR.getColor(), colorG.getColor(), colorB.getColor());
		this.add(colorChoice);
		this.next.addMouseListener(this);
		this.add(next);
		this.add(colorB);
		this.add(colorG);
	}

	public PanelColor(int id, Fenetre f, DisplayColor dc, Button backButton,
			int w, int h) {
		this.estConstructeurBis = true;
		this.bgColor = dc.getBackground();
		this.dc = dc;
		this.setBounds(0, 0, w, h);
		this.lastButton = backButton;
		this.setBackground(this.bgColor);
		this.add(colorB);
		this.add(colorG);
		this.add(colorR);
		System.out.println(this.lastButton);
		this.colorB.setColor("" + this.lastButton.getColor().getBlue());
		this.colorR.setColor("" + this.lastButton.getColor().getRed());
		this.colorG.setColor("" + this.lastButton.getColor().getGreen());
		this.colorChoice.setBackground(lastButton.getColor());
		this.next.setId(lastButton.getId());
		choseColor.addMouseListener(this);
		this.add(choseColor);
		// this.add(this.numColor);
		this.frame = f;
		this.setSize(new Dimension(w, h));
		this.setLayout(null);
		this.addMouseListener(this);
		// carreColor.setMaximumSize(new Dimension(200, 200));
		this.add(carreColor);
		validColor(colorR.getColor(), colorG.getColor(), colorB.getColor());
		this.add(colorChoice);
		this.next.addMouseListener(this);
		this.add(next);

	}

	public void validColor(int r, int g, int b) {
		if (r < 0 || r > 255)
			r = 0;
		if (g < 0 || g > 255)
			g = 0;
		if (b < 0 || b > 255)
			b = 0;
		this.colorChoice.setBackground(new Color(r, g, b));
		this.colorR.setText("" + r);
		this.colorG.setText("" + g);
		this.colorB.setText("" + b);
		this.repaint();
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		Button b;
		if (arg0.getSource() instanceof Button) {
			b = (Button) arg0.getSource();
			int red = this.stringToInt(this.colorR.getText());
			int green = this.stringToInt(this.colorG.getText());
			int blue = this.stringToInt(this.colorB.getText());
			if (arg0.getSource() == next) {
				if (this.nmbColor != 0) {
					this.frame.getDC().addColor(new Color(red, green, blue));
					b.setColor(this.colorChoice.getBackground());
					this.frame.setContentPane(new PanelColor(this.frame,
							"menuColorChoice", this.nmbColor, this.bgColor,
							this.getWidth(), this.getHeight()));
				} else {
					if (estConstructeurBis == true) {
						System.out.println("id ===== "+b.getId());
						dc.getButtonList().get(b.getId()).setBackground(new Color(red, green, blue));
						dc.getButtonList().get(b.getId()).setColor(new Color(red, green, blue));
						//dc.getButtonList().set(b.getId(), b);
						dc.repaint();
						//this.frame.getDC().updatePanel();
						this.frame.setContentPane(dc);
						dc.repaint();
						this.frame.revalidate();
						estConstructeurBis = false;
					} else {
						this.frame.getDC()
								.addColor(
										new Color(this.stringToInt(this.colorR
												.getText()), this
												.stringToInt(this.colorG
														.getText()), this
												.stringToInt(this.colorB
														.getText())));
						b.setColor(this.colorChoice.getBackground());
						this.frame.getDC().updatePanel();
						this.frame.setContentPane(this.frame.getDC());
					}

				}
				this.frame.revalidate();
			}

			else if (arg0.getSource() == choseColor) {
				PrecisePanel p = new PrecisePanel(this.frame, this,
						this.getBackground(), 0, 0, this.getWidth(),
						this.getHeight());
				this.frame.setContentPane(p);
				this.frame.revalidate();
			}

			else {
				System.out.println(colorR.getText() + " " + colorG.getText()
						+ " " + colorB.getText());
				this.colorR.setColor(colorR.getText());
				this.colorG.setColor(colorG.getText());
				this.colorB.setColor(colorB.getText());
				validColor(colorR.getColor(), colorG.getColor(),
						colorB.getColor());
				this.colorR.setText("" + colorR.getColor());
				this.colorG.setText("" + colorG.getColor());
				this.colorB.setText("" + colorB.getColor());
				this.repaint();
			}
		}

	}
	
	

	public int stringToInt(String c) {
		int color = 0;
		try {
			int n = 0;
			if (c.length() == 3) {
				n = 100;
			} else if (c.length() == 2) {
				n = 10;
			} else if (c.length() == 1) {
				n = 1;
			} else {
				color = 0;
			}
			color = 0;
			for (int i = 0; i < c.length(); i++) {
				if ((c.charAt(i) - 48) < 0 || (c.charAt(i) - 48) > 9) {
					color = 0;
				}
				if (c.charAt(i) == ' ') {
					return color = 0;
				}
				color = ((c.charAt(i) - 48) * n) + color;
				n = n / 10;
			}
		} catch (Exception e) {
			System.out.println("Erreur lors de la mise en place d'une couleur");
		}
		return color;
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub

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
