package net.azarquiel.view;

import net.azarquiel.Main;
import net.azarquiel.model.Match;
import net.azarquiel.model.Team;
import net.azarquiel.model.Util;

public class ShowResults {
	
	public static void showResultTable() {
		final int maxLen = Util.getMaxLen();
		Util.printWithPad("| ", maxLen + 2);
		for (Team team : Main.league.teams)
			Util.printWithPad(" | " + team.name, maxLen + 3);
		System.out.println(" |");
		for (Team team : Main.league.teams) {
			Util.printWithPad("| " + team.name, maxLen + 2);
			Match[] matches = Main.league.matchesAsLocal.get(team);
			for (int j = 0; j < matches.length; j++) {
				if (matches[j] == null) {
					Util.printWithPad(" | * ", maxLen + 3);
				} else Util.printWithPad(String.format(
					" | %s - %s",
					matches[j].localScore,
					matches[j].visitorScore
				), maxLen + 3);
			}
			System.out.println(" |");
		}
		System.out.println();
	}	
}
