package net.azarquiel.view;

import java.util.StringTokenizer;

import net.azarquiel.Main;
import net.azarquiel.model.Match;
import net.azarquiel.model.Round;

public class SetResults {
	public static Round askRound() {
		try {
			System.out.println("Selecciona Jornada: ");
			int n = Integer.valueOf(Main.scanner.nextLine());
	    	return Main.league.rounds[n - 1];
		} catch (Exception e) {
			System.err.println("Error: Jornada inexistente");
			return null;
		}
	}
	
	public static void setMatchScore(Match match) {
	    System.out.println(match + ": ");
	    String score = Main.scanner.nextLine();
	    StringTokenizer st1 = new StringTokenizer(score, "-");
	    match.localScore = Integer.valueOf(st1.nextToken());
	   	match.visitorScore = Integer.valueOf(st1.nextToken());
	}
}
