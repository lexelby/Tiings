package tilings;

import java.awt.event.*;
import javax.swing.*;

public class Tilings extends JApplet
{
	private static final long serialVersionUID = 6315406882333636214L;
	public void init() {
		// the look&feel must be set before any swing objects are made.
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) { }

		PanelMain pm = new PanelMain(true);
		getContentPane().add(pm);
		pm.setFocus();
	}

	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) { }

		JFrame f = new JFrame("Tilings");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

      PanelMain pm = new PanelMain(false);
		f.getContentPane().add(pm);

		f.addWindowListener(new WindowAdapter() {
			 public void windowClosing(WindowEvent e) {
				  System.exit(0);
			 }
		});

		f.pack();
      pm.setFocus();
		f.setVisible(true);
	}
	public String getAppletInfo() {
		 return "Tilings, by Jaap Scherphuis";
	}
}
