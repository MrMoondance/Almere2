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

	private JFrame mainWindow;
	private ArrayList<Plant> plantenlijst;	
	private int guiCount;
	

	/**
	 * Launch the application.
	 */
	public static GUI appReturn(final ArrayList<Plant> plantenlijst) {
		final GUI window = new GUI();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					window.setPlantenlijst(plantenlijst);
					window.getFrame().setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		return window;
	}

	/**
	 * Create the application.
	 */
	public GUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		mainWindow = new JFrame();
		mainWindow.setBounds(100, 50, 1107, 781);
		mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainWindow.getContentPane().setLayout(null);
		
		JToolBar toolBar = new JToolBar();
		toolBar.setBounds(10, 11, 560, 39);
		mainWindow.getContentPane().add(toolBar);
		
		
		JButton btnBomen = new JButton("Bomen");	
		btnBomen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {						
				Bomen bomen = new Bomen(mainWindow, guiCount, plantenlijst);				
			}
		});
		toolBar.add(btnBomen);
		
		JButton btnSiertuin = new JButton("Siertuin");
		btnSiertuin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {				
				Siertuin siertuin = new Siertuin(mainWindow, guiCount, plantenlijst);				
			}
		});
		toolBar.add(btnSiertuin);
		
		JButton btnLijst = new JButton("Overzicht");
		btnLijst.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Overzicht overzicht = new Overzicht(mainWindow, guiCount, plantenlijst);
			}
		});
		toolBar.add(btnLijst);
		
		JButton btnKalender = new JButton("Kalender");	
		btnKalender.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {						
				Kalender kalender = new Kalender(mainWindow, guiCount, plantenlijst);				
			}
		});
		toolBar.add(btnKalender);
		
		JToolBar toolBar2 = new JToolBar();
		toolBar2.setBounds(570, 11, 511, 39);
		mainWindow.getContentPane().add(toolBar2);
		
		JTextField textField = new JTextField();
		textField.setBounds(1, 1, 10, 10);
		toolBar2.add(textField);
		textField.setColumns(1);
		
		JTextField textField2 = new JTextField();
		textField2.setBounds(1, 1, 10, 10);
		toolBar2.add(textField2);
		textField2.setColumns(1);
		
		JTextField textField3 = new JTextField();
		textField3.setBounds(1, 1, 10, 10);
		toolBar2.add(textField3);
		textField3.setColumns(1);
		
		
		
		
				
		
		
		
		
				
		guiCount = mainWindow.getContentPane().getComponentCount();
		
	}

	
	
	
	public JFrame getFrame() {		
		return mainWindow;
	}

	public void setFrame(JFrame frame) {
		this.mainWindow = frame;
	}
	
	public ArrayList<Plant> getPlantenlijst() {
		return plantenlijst;
	}

	public void setPlantenlijst(ArrayList<Plant> plantenlijst) {
		this.plantenlijst = plantenlijst;
	}
	
	//Acties opslaan en lezen
	//planten kunnen aanmaken en verwijderen + manier om coordinaten te krijgen
}
