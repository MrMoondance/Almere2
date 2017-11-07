import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;

public class Main {

	public static void main(String[] args) {
		
		ArrayList<Plant> plantenlijst = ReadInfo.getPlantenlijst();
		
		
		GUI mainWindow = GUI.appReturn(plantenlijst);
		
		
		
		
		
		
		
		
	}

}
