import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.ListModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class Siertuin {

	JLabel siertuin;
	
	
	public Siertuin(JFrame mainWindow, int guiCount, ArrayList<Plant> lijst) {
		
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
		
		DefaultListModel<String> lijstB = new DefaultListModel<String>();
		for(int i = 0; i <lijst.size(); i++) {
			Plant plant = lijst.get(i);
			if (plant.tuin.equals("s")) {				
				lijstB.addElement(plant.referentie + ": " + plant.plantnaam);
				System.out.println(plant.plantnaam);
				System.out.println(plant.tuin);
			}			
		}		

		
		
		final JList bomenLijst = new JList( lijstB);				
		scrollPane.setViewportView(bomenLijst);	
		
		bomenLijst.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent arg0) {
				
				
			}
		});
		
		mainWindow.repaint();
	}
	public JLabel getSiertuin() {
		return siertuin;
	}

	public void setSiertuin(JLabel siertuin) {
		this.siertuin = siertuin;
	}

}
