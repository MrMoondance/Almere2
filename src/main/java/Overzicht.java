import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class Overzicht {
	
	public Overzicht(final JFrame mainWindow, int guiCount, final ArrayList<Plant> lijst) {
		
		
		
		while (mainWindow.getContentPane().getComponentCount() > guiCount) {
			mainWindow.getContentPane().remove(guiCount);
		}
		
		ArrayList<Action> actionlijst = ReadAction.getActionlijst();
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(758, 62, 321, 546);
		mainWindow.getContentPane().add(scrollPane);
		
		List<String> lijstB=new ArrayList();
		for (int i = 0; i < lijst.size(); i++) {
			Plant plant = lijst.get(i);
			lijstB.add(plant.plantnaam);
			
		}
		Collections.sort(lijstB);
		
		DefaultListModel<String> lijstModel = new DefaultListModel<String>();
		for (int i = 0; i < lijstB.size(); i++) {		
			lijstModel.addElement(lijstB.get(i));			
		}
		
		final JList<String> bomenLijst = new JList<String>(lijstModel);
		scrollPane.setViewportView(bomenLijst);
		
		bomenLijst.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent arg0) {
				System.out.println(bomenLijst.getSelectedValue().toString());
				
				
				
			}
		});
		
		
		JTextArea omschrijvingField = new JTextArea();			
		omschrijvingField.setBounds(1, 1, 730, 1000);
		omschrijvingField.setText(" test");
		
		JScrollPane omschrijvingScroll = new JScrollPane(omschrijvingField);
		omschrijvingScroll.setBounds(10, 62, 730, 346);
		mainWindow.getContentPane().add(omschrijvingScroll);
		
		
		
		
		mainWindow.repaint();
	}
	
	private void description(Plant plant) {
		
		String omschrijving = plant.omschrijving;
		
		JTextField omschrijvingField = new JTextField();
		omschrijvingField.setBounds(10, 62, 730, 546);
	}
	
	//TODO groot tekstveld beschrijving
	//TODO groot tekstveld actielijst
}
