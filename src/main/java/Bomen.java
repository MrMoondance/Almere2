import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class Bomen {	

	public Bomen(final JFrame mainWindow, final ArrayList<Plant> lijst) {		

		final JLabel bomen = new JLabel("");
		bomen.setBounds(10, 62, 730, 546);
		mainWindow.getContentPane().add(bomen);
		final ImageIcon bomenIcon = new ImageIcon("Bomen.jpg");
		bomen.setIcon(bomenIcon);

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
		bomen.add(reset);

		DefaultListModel<String> lijstB = new DefaultListModel<String>();
		for (int i = 0; i < lijst.size(); i++) {
			Plant plant = lijst.get(i);
			if (plant.tuin.equals("b")) {
				lijstB.addElement(plant.referentie + ": " + plant.plantnaam);
			}
		}
		final JList<String> bomenLijst = new JList<String>(lijstB);
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

				paintComponent(bomen.getGraphics(), x, y);
				
			}
		});
		bomen.addMouseListener(new MouseListener() {

			public void mouseClicked(MouseEvent e) {
				int x = e.getX() - 22;
				int y = e.getY() - 22;
				muisklik(x,y, lijst);
				//String sX = String.valueOf(x);
				//String sY = String.valueOf(y);
				//System.out.println(sX + "," + sY);

			}

			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub				
			}

			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			

		});

		mainWindow.repaint();
	}

	private void paintComponent(Graphics g, int x, int y) {
		g.setColor(Color.red);
		g.drawOval(x, y, 45, 45);

	}
		
	public void muisklik(int x, int y, ArrayList<Plant> lijst) {
		for (int i = 0; i < lijst.size(); i++) {
			Plant plant = lijst.get(i);
			//TODO klikken op kaart-> naar overzicht
			
			
		}
	}

}
