package net.azarquiel.view;

import java.util.Arrays;
import java.util.Comparator;

import net.azarquiel.Main;
import net.azarquiel.model.Match;
import net.azarquiel.model.Results;
import net.azarquiel.model.Round;
import net.azarquiel.model.Team;
import net.azarquiel.model.Util;

public class ShowClasification {
	private static String[] fields = {
		"Puntos",
		"PJ",
		"PG",
		"PE",
		"PP",
		"GF",
		"GC",
		"DG"
	};
	
	private Results[] results;
	
	public ShowClasification() {
		getClasification();
		sortResults();
		int maxLen = Util.getMaxLen() + 2;
		Util.printWithPad("Equipo", maxLen);
		for (String s : fields) Util.printWithPad(s, maxLen);
		System.out.println();
		for (Results result : results) {
			Util.printWithPad(result.name, maxLen);
			Util.printWithPad(result.points, maxLen);
			Util.printWithPad(result.played, maxLen);
			Util.printWithPad(result.won, maxLen);
			Util.printWithPad(result.tied, maxLen);
			Util.printWithPad(result.lost, maxLen);
			Util.printWithPad(result.scoreF, maxLen);
			Util.printWithPad(result.scoreC, maxLen);
			Util.printWithPad(result.scoreDiff, maxLen);
			System.out.println();
		}
	}
	
	private Results[] getClasification() {
		results = new Results[Main.league.teams.length];
		for (Team team : Main.league.teams) results[team.id] = new Results(team.name);
		for (Round round : Main.league.rounds) {
			addToClasification(round.firstMatch);
			addToClasification(round.secondMatch);
		}
		return results;
	}
	
	private void sortResults() {
		Arrays.sort(results, new Comparator<Results>() {
			@Override
			public int compare(Results r1, Results r2) {
				if (r1.points != r2.points) return Integer.compare(r2.points, r1.points);
				else if (r1.scoreF != r2.scoreF) return Integer.compare(r2.scoreF, r1.scoreF);
				else return Integer.compare(r1.scoreC, r2.scoreC);
			}
		});
	}
	
	private void addToClasification(Match match) {
		if (match.check) {
			addToClasification(match.local, match.localScore, match.visitorScore);
			addToClasification(match.visitor, match.visitorScore, match.localScore);
		}
	}
	
	private void addToClasification(Team team, int scoreF, int scoreC) {
		int diff = scoreF - scoreC;
		int i = team.id;

		results[i].played++;

		if (diff > 0) {
			results[i].points += 3;
			results[i].won++;
		} else if (diff < 0) {
			results[i].lost++;
		} else {
			results[i].points++;
			results[i].tied++;
		}

		results[i].scoreF += scoreF;
		results[i].scoreC += scoreC;
		results[i].scoreDiff += diff;
	}
}
