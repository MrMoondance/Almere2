import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class Bomen {
	private int guiCount;
	private JLabel bomen;
	
	public Bomen(JFrame mainWindow, int guiCount, final ArrayList<Plant> lijst) {
		
		
		while (mainWindow.getContentPane().getComponentCount() > guiCount) {
			mainWindow.getContentPane().remove(guiCount);				
		}
		
		final JLabel bomen = new JLabel("");
		bomen.setBounds(10, 62, 730, 546);
		mainWindow.getContentPane().add(bomen);		
		ImageIcon bomenIcon= new ImageIcon("Bomen.jpg");		
		bomen.setIcon(bomenIcon);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(758, 62, 321, 546);
		mainWindow.getContentPane().add(scrollPane);
		
		DefaultListModel<String> lijstB = new DefaultListModel<String>();
		for(int i = 0; i <lijst.size(); i++) {
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
				for (int i=0; i<lijst.size(); i++) {
					if (lijst.get(i).referentie.equals(ref)) {
						coord = lijst.get(i).coordinaten;
					}
				}
				System.out.println(coord);
				c = 0;
				while (coord.charAt(c) != ',' && coord.charAt(c) != '.') {
					
					c++;
				}	
				String sX = coord.substring(0, c);
				String sY = coord.substring(c+1,coord.length());
				
				int x = Integer.parseInt(sX);	
				int y = Integer.parseInt(sY);	
				
				Draw draw = new Draw(bomen,x,y);			
			}
		});
		bomen.addMouseListener(new MouseListener() {
			   

			@Override
			public void mouseClicked(MouseEvent e) {
				int x=e.getX()-22;
			    int y=e.getY()-22;
			    
			   
			    String sX = String.valueOf(x);
			    String sY = String.valueOf(y);
			    System.out.println(sX+","+sY);//these co-ords are relative to the component
				
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			
		});	
		
		mainWindow.repaint();		
	}

	
	
	
	
	
	
	
	
	
	
	public JLabel getBomen() {
		return bomen;
	}

	public void setBomen(JLabel bomen) {
		this.bomen = bomen;
	}
	
}
