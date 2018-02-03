import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class Kalender {

	JPanel kalender;
	Maand[] maand = new Maand[12];

	public Kalender(final JFrame mainWindow, final ArrayList<Plant> lijst) {

		String[] maandNaam = { "januari", "februari", "maart", "april", "mei", "juni", "juli", "augustus", "september",
				"oktober", "november", "december" };
		for (int i = 0; i < 12; i++) {

			JCheckBox cb = new JCheckBox(maandNaam[i]);
			cb.setBounds(800, 60 + i * 40, 100, 40);
			mainWindow.getContentPane().add(cb);
			cb.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					mainWindow.getContentPane().remove(kalender);
					createList();
					mainWindow.getContentPane().add(kalender);
					mainWindow.repaint();
				}
			});

			Maand m = new Maand(i + 1, maandNaam[i], cb);
			maand[i] = m;
		}

		Calendar cal = Calendar.getInstance();
		int nu = cal.get(Calendar.MONTH);
		maand[nu].cb.setSelected(true);

		if (nu == 11) {
			nu = nu - 12;
		}
		maand[nu + 1].cb.setSelected(true);
		createList();
		mainWindow.getContentPane().add(kalender);
		mainWindow.repaint();
	}

	private void createList() {

		kalender = new JPanel();
		kalender.setBounds(10, 62, 730, 546);
		kalender.setLayout(null);

		int x = 1;
		int y = 10;

		for (int i = 0; i < 12; i++) {
			Maand m = maand[i];
			if (m.cb.isSelected()) {

				if (y > 530) {
					y = 10;
					x = x + 260;
				}
				JLabel label = new JLabel(maand[i].naam);
				label.setBounds(x, y, 80, 20);
				y = y + 20;

				kalender.add(label);

				ArrayList<Action> actionList = m.actionList;
				for (Action a : actionList) {

					actionButton(x, y, a.plant, a.actie);

					y = y + 45;
					if (y > 530) {
						y = 10;
						x = x + 260;
					}
				}
				y = y + 30;
			}
		}

	}

	private void actionButton(int x, int y, String plant, String actie) {

		final JButton button = new JButton();
		button.setText(plant);
		button.setOpaque(false);
		button.setBorderPainted(false);
		button.setBackground(Color.WHITE);
		button.setBounds(x, y, 250, 20);
		button.setHorizontalAlignment(SwingConstants.LEFT);
		kalender.add(button);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String naam = button.getText();
				System.out.println(naam);
			}
		});
		JLabel label = new JLabel(actie);
		label.setBounds(x + 17, y + 20, 235, 20);
		kalender.add(label);
	}
}
