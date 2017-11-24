import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.ListModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class Siertuin {

	JLabel siertuin;
	
	
	public Siertuin(final JFrame mainWindow, int guiCount, final ArrayList<Plant> lijst) {
		
		while (mainWindow.getContentPane().getComponentCount() > guiCount) {
			mainWindow.getContentPane().remove(guiCount);				
		}
		siertuin = new JLabel("");
		siertuin.setBounds(10, 62, 730, 746);
		mainWindow.getContentPane().add(siertuin);	
		ImageIcon siertuinIcon = new ImageIcon("Siertuin.jpg");
		siertuin.setIcon(siertuinIcon);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(758, 62, 321, 546);
		mainWindow.getContentPane().add(scrollPane);
		
		JButton reset = new JButton("Reset");
		reset.setBounds(630,1, 100, 50);
		reset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mainWindow.repaint();
			}
		});
		siertuin.add(reset);
		
		DefaultListModel<String> lijstB = new DefaultListModel<String>();
		for(int i = 0; i <lijst.size(); i++) {
			Plant plant = lijst.get(i);
			if (plant.tuin.equals("s")) {				
				lijstB.addElement(plant.referentie + ": " + plant.plantnaam);
			}			
		}		

		
		
		final JList bomenLijst = new JList( lijstB);				
		scrollPane.setViewportView(bomenLijst);	
		
		bomenLijst.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent arg0) {

				
				int c = 0;
				String selectedString = bomenLijst.getSelectedValue().toString();

				while (selectedString.charAt(c) != ':') {
					c++;
				}
				String ref = selectedString.substring(0, c);

				String coord = new String();
				for (int i = 0; i < lijst.size(); i++) {
					if (lijst.get(i).referentie.equals(ref)) {
						coord = lijst.get(i).coordinaten;
					}
				}				
				c = 0;
				while (coord.charAt(c) != ',' && coord.charAt(c) != '.') {

					c++;
				}
				String sX = coord.substring(0, c);
				String sY = coord.substring(c + 1, coord.length());

				int x = Integer.parseInt(sX);
				int y = Integer.parseInt(sY);

				paintComponent(siertuin.getGraphics(), x, y);
				
			}
		});
		
		mainWindow.repaint();
	}
	
	public void paintComponent(Graphics g, int x, int y) {
		g.setColor(Color.red);
		g.drawOval(x, y, 45, 45);
	}
	
	public JLabel getSiertuin() {
		return siertuin;
	}

	public void setSiertuin(JLabel siertuin) {
		this.siertuin = siertuin;
	}
	//TODO op kaart klikken naar overzicht, zelfde als bomen
}
