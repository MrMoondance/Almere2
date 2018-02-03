import java.awt.EventQueue;
import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {

		final ArrayList<Plant> plantenlijst = ReadInfo.getPlantenlijst();

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI window = new GUI(plantenlijst);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}

}
