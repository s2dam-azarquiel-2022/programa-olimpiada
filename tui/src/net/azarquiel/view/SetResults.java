package net.azarquiel.view;

import java.util.StringTokenizer;

import net.azarquiel.Main;
import net.azarquiel.model.Match;
import net.azarquiel.model.Round;

public class SetResults {
	public static void askResults() {
		Round round;
		try {
			System.out.println("Selecciona Jornada: ");
			int n = Integer.valueOf(Main.scanner.nextLine());
	    	round = Main.league.rounds[n - 1];
		} catch (Exception e) {
			System.err.println("Error: Jornada inexistente\n");
			return;
		}
		SetResults.waitForInput(round.firstMatch);
		SetResults.waitForInput(round.secondMatch);
		System.out.println("Resultado anotado\n");
	}
	
	public static void waitForInput(Match match) {
		boolean flag = true;
		do {
			try {
				setMatchScore(match);
				flag = false;
			} catch (Exception e) {
				System.err.println("Puntuacion incorrecta");
			}
		} while (flag);
	}
	
	private static void setMatchScore(Match match) throws Exception {
	    System.out.println(match + ": ");
	    String score = Main.scanner.nextLine();
	    StringTokenizer st1 = new StringTokenizer(score, "-");
	    match.localScore = Integer.valueOf(st1.nextToken());
	   	match.visitorScore = Integer.valueOf(st1.nextToken());
	   	match.check = true;
	}
}
