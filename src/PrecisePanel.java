import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JColorChooser;
import javax.swing.colorchooser.AbstractColorChooserPanel;

import utils.Button;
import utils.Panel;

public class PrecisePanel extends Panel implements ActionListener {
	private JColorChooser j = new JColorChooser();
	private Button valider = new Button("valider", 400, 5, 90, 30);
	private Fenetre frame;
	private PanelColor pc;
	private Button color = new Button(300, 5, 60, 30);

	public PrecisePanel(Fenetre frame, PanelColor pc, Color c, int x, int y,
			int w, int h) {
		super("", c, w, h);
		this.pc = pc;
		this.frame = frame;
		this.setLayout(null);
		AbstractColorChooserPanel[] panel = j.getChooserPanels();
		j.setBounds(0, 0, frame.getWidth(), frame.getHeight());
		j.removeChooserPanel(panel[1]);
		j.removeChooserPanel(panel[2]);
		j.removeChooserPanel(panel[0]);
		j.removeChooserPanel(panel[4]);
		j.remove(0);
		this.valider.addActionListener(this);
		this.add(valider);
		this.add(color);
		this.add(j);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == valider) {
			int b = this.j.getColor().getBlue();
			int g = this.j.getColor().getGreen();
			int r = this.j.getColor().getRed();
			this.pc.colorB.setText("" + b);
			this.pc.colorR.setText("" + r);
			this.pc.colorG.setText("" + g);
			this.pc.colorChoice.setBackground(new Color(r, g, b));
			this.frame.setContentPane(this.pc);
			this.frame.revalidate();

			// this.j.getColor();
		}

	}
}
