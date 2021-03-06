import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.Collator;
import java.util.ArrayList;
import java.util.Collection;
import java.util.TreeSet;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JToolBar;

public class Alfabetisch {
	public Alfabetisch(final JFrame mainWindow, int guiCount, final ArrayList<Plant> lijst) {
		while (mainWindow.getContentPane().getComponentCount() > guiCount) {
			mainWindow.getContentPane().remove(guiCount);
		}

		JToolBar sorteren = new JToolBar();
		sorteren.setBounds(10, 62, 560, 39);
		mainWindow.getContentPane().add(sorteren);

		JButton alfabetisch = new JButton("Alfabetisch");
		alfabetisch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

			}
		});
		sorteren.add(alfabetisch);

		JButton referentie = new JButton("Referentie");
		referentie.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		sorteren.add(referentie);

		JButton maand = new JButton("Maand");
		maand.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		sorteren.add(maand);

		JButton grootte = new JButton("Grootte");
		grootte.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		sorteren.add(grootte);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 105, 331, 647);
		mainWindow.getContentPane().add(scrollPane);

		DefaultListModel<String> lijstB = new DefaultListModel<String>();
		for (int i = 0; i < lijst.size(); i++) {
			Plant plant = lijst.get(i);
			lijstB.addElement(plant.referentie + ": " + plant.plantnaam);

		}

		final JList<String> bomenLijst = new JList<String>(lijstB);
		scrollPane.setViewportView(bomenLijst);

		mainWindow.repaint();
	}

	private JList<String> sortLijst(ArrayList<Plant> lijst) {
		Collection<String> namen = new TreeSet<String>(Collator.getInstance());

		for (int i = 0; i < lijst.size(); i++) {
			namen.add(lijst.get(i).plantnaam);
		}
		namen.add("UK");
		namen.add("Germany");
		namen.add("Australia");

		return null;

	}
}
