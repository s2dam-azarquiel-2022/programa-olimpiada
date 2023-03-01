package net.azarquiel.view;

import net.azarquiel.model.Clasification;

public class EndCompetition {
	public static void endCompetition() {
		Clasification clasification = new Clasification();
		System.out.println("Campeon: " + clasification.results[0].name);
		System.out.println("Subcampeon: " + clasification.results[1].name);
	}
}
