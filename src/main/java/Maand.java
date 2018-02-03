import java.util.ArrayList;

import javax.swing.JCheckBox;

public class Maand {
	public int i;
	public String naam;
	public ArrayList<Action> actionList;
	public JCheckBox cb;

	public Maand(int i, String naam, JCheckBox cb) {
		this.i = i;
		this.naam = naam;
		this.cb = cb;

		actionListGenerator();
	}

	private void actionListGenerator() {
		actionList = ReadAction.getSpecificColumn(String.valueOf(i), 1);
	}
}
