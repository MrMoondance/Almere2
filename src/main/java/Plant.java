import java.util.ArrayList;

public class Plant {

	public String plantnaam;
	public String aantal;
	public String referentie;
	public String tuin;
	public String coordinaten;
	public String plaatjes;
	public String omschrijving;
	public ArrayList<Action> action;

	public Plant(String plantnaam, String aantal, String referentie, String tuin, String coordinaten, String plaatjes,
			String omschrijving, ArrayList<Action> action) {
		this.plantnaam = plantnaam;
		this.aantal = aantal;
		this.referentie = referentie;
		this.tuin = tuin;
		this.coordinaten = coordinaten;
		this.plaatjes = plaatjes;
		this.omschrijving = omschrijving;
		this.action = action;

	}
}
