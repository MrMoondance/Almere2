import java.awt.Graphics;

import javax.swing.JLabel;

public class Draw {
	
	
	public Draw(JLabel jlabel, int x, int y) {
		
		jlabel.getGraphics().drawOval(x,y, 45, 45);
	}
}
