package net.azarquiel.view;

import net.azarquiel.Main;
import net.azarquiel.model.Match;
import net.azarquiel.model.Team;

public class ShowResults {
	
	public static void showResultTable() {
		final int maxLen = getMaxLen();
		printWithPad("| ", maxLen + 2);
		for (Team team : Main.league.teams) printWithPad(" | " + team.name, maxLen + 3);
		System.out.println(" |");
		for (Team team : Main.league.teams) {
			printWithPad("| " + team.name, maxLen + 2);
			Match[] matches = Main.league.matchesAsLocal.get(team);
			for (int j = 0; j < matches.length; j++) {
				if (matches[j] == null) {
					printWithPad(" | * ", maxLen + 3);
				} else printWithPad(String.format(
					" | %s - %s",
					matches[j].localScore,
					matches[j].visitorScore
				), maxLen + 3);
			}
			System.out.println(" |");
		}
		System.out.println();
	}
	
	private static void printWithPad(String s, int n) {
		System.out.print(String.format("%-" + n + "s", s));
	}
	
	private static int getMaxLen() {
		int result = 0;
		for (Team team : Main.league.teams) {
			int n = team.name.length();
			if (n > result) result = n;
		}
		return result;
	}
}
