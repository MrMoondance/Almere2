import java.awt.Color;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;

public class Kalender {
	
	public Kalender(final JFrame mainWindow, int guiCount, final ArrayList<Plant> lijst) {
		
		while (mainWindow.getContentPane().getComponentCount() > guiCount) {
			mainWindow.getContentPane().remove(guiCount);
		}
						
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(758, 62, 321, 546);
		mainWindow.getContentPane().add(scrollPane);	
	
		DefaultListModel<String> lijstB = new DefaultListModel<String>();
		for (int i = 0; i < 12; i++) {
			lijstB.addElement(String.valueOf(i+1));
			
		}
		final JList<String> bomenLijst = new JList<String>(lijstB);
		scrollPane.setViewportView(bomenLijst);
				
		JPanel kalender = new JPanel();
		kalender.setBounds(10, 62, 730, 546);
		mainWindow.getContentPane().add(kalender);
		kalender.setLayout(null);
						
		
		
		
		
	   

		
		buttonCreator(kalender, 10, 21, "test2");
		
		mainWindow.repaint();
	
	}
	
	private void buttonCreator(JPanel kalender, int x, int y, String tekst) {
		
		final JButton button = new JButton();
	    button.setText(tekst);	    
	    button.setBorderPainted(false);
	    button.setOpaque(false);
	    button.setBackground(Color.WHITE);
	    button.setBounds(x, y, 89, 20);
	    kalender.add(button);
	    button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {						
				String naam = button.getText();		
				System.out.println(naam);
			}
		});
	}
	
	//TODO maand in lijst aanvinken. lijst alle acties van aangevinkte maanden. klikken gaat naar overzicht voor die plant

}
