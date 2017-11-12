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
				//Alfabetisch alfabetisch = new Alfabetisch(mainWindow, guiCount, plantenlijst);
			}
		});
		toolBar.add(btnLijst);
		
				
		
		
		
		
				
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
}
