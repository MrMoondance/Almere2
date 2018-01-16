import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JToolBar;
import javax.swing.JScrollPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class GUI {

	private JFrame mainFrame;
	private ArrayList<Plant> plantenlijst;			
	
	public GUI(ArrayList<Plant> lijst) {
		
		plantenlijst = lijst;		
		
		mainFrame = new JFrame();
		
		mainFrame.setBounds(100, 50, 1107, 781);
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.getContentPane().setLayout(null);
		mainFrame.setVisible(true);		
		
		JToolBar toolBar = makeToolBar();
		mainFrame.getContentPane().add(toolBar);
	}
	
	JToolBar makeToolBar() {
		
		JToolBar toolBar = new JToolBar();
		toolBar.setBounds(10, 11, 560, 39);
			
		JButton btnBomen = new JButton("Bomen");	
		btnBomen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {	
				while (mainFrame.getContentPane().getComponentCount() > 1) {
					mainFrame.getContentPane().remove(1);
				}
				Bomen bomen = new Bomen(mainFrame, plantenlijst);				
			}
		});
		toolBar.add(btnBomen);
		
		JButton btnSiertuin = new JButton("Siertuin");
		btnSiertuin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {	
				while (mainFrame.getContentPane().getComponentCount() > 1) {
					mainFrame.getContentPane().remove(1);
				}
				Siertuin siertuin = new Siertuin(mainFrame, plantenlijst);				
			}
		});
		toolBar.add(btnSiertuin);
		
		JButton btnLijst = new JButton("Overzicht");
		btnLijst.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				while (mainFrame.getContentPane().getComponentCount() > 1) {
					mainFrame.getContentPane().remove(1);
				}
				Overzicht overzicht = new Overzicht(mainFrame, plantenlijst);
			}
		});
		toolBar.add(btnLijst);
		
		JButton btnKalender = new JButton("Kalender");	
		btnKalender.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {	
				while (mainFrame.getContentPane().getComponentCount() > 1) {
					mainFrame.getContentPane().remove(1);
				}
				Kalender kalender = new Kalender(mainFrame, plantenlijst);				
			}
		});
		toolBar.add(btnKalender);		
		
		return toolBar;		
	}
	//planten kunnen aanmaken en verwijderen + manier om coordinaten te krijgen
}
