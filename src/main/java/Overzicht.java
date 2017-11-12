import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.ListModel;

public class Overzicht {
	
	public Overzicht(final JFrame mainWindow, int guiCount, final ArrayList<Plant> lijst) {
		
		while (mainWindow.getContentPane().getComponentCount() > guiCount) {
			mainWindow.getContentPane().remove(guiCount);
		}
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(758, 62, 321, 546);
		mainWindow.getContentPane().add(scrollPane);
		
		List<String> lijstB=new ArrayList();
		for (int i = 0; i < lijst.size(); i++) {
			Plant plant = lijst.get(i);
			lijstB.add(plant.plantnaam);
			
		}
		Collections.sort(lijstB);
		
		DefaultListModel<String> lijstC = new DefaultListModel<String>();
		for (int i = 0; i < lijstB.size(); i++) {		
			lijstC.addElement(lijstB.get(i));			
		}
		
		final JList<String> bomenLijst = new JList<String>(lijstC);
		scrollPane.setViewportView(bomenLijst);
		
		mainWindow.repaint();
	}
}
