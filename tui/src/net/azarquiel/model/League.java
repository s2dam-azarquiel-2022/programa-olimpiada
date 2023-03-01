package net.azarquiel.model;

import java.util.HashMap;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class League {
	public Team[] teams = new Team[] {
		new Team("Toledo"),
		new Team("Ciudad Real"),
		new Team("Guadalajara"),
		new Team("Cuenca"),
		new Team("Albacete"),
	};
	
	public Round[] rounds = new Round[teams.length * 2];
	
	public HashMap<Team, Match[]> matchesAsLocal = new HashMap<>(teams.length);
	
	public League() {
		shuffle(teams);
		for (int i = 0; i < teams.length; i++) teams[i].id = i;
		generateRounds();
		shuffle(rounds, teams.length, rounds.length);
		for (int i = 0; i < rounds.length; i++) rounds[i].n = i + 1;
		generateMatchesAsLocal();
	}
	
	private void generateRounds() {
		rounds[0] = new Round(new Match(teams[1], teams[2]), new Match(teams[3], teams[4]), teams[0]);
		rounds[1] = new Round(new Match(teams[0], teams[3]), new Match(teams[2], teams[4]), teams[1]);
		rounds[2] = new Round(new Match(teams[0], teams[4]), new Match(teams[1], teams[3]), teams[2]);
		rounds[3] = new Round(new Match(teams[1], teams[4]), new Match(teams[0], teams[2]), teams[3]);
		rounds[4] = new Round(new Match(teams[0], teams[1]), new Match(teams[2], teams[3]), teams[4]);
		for (int i = 0; i < teams.length; i++) {
			rounds[teams.length + i] = rounds[i].reverse();
		}
	}
	
	private void generateMatchesAsLocal() {
		for (Round round : rounds) {
			addMatch(round.firstMatch);
			addMatch(round.secondMatch);
		}
	}
	
	private void addMatch(Match match) {
		matchesAsLocal.compute(match.local, (k, v) -> {
			if (v == null) return newMatchList(match);
			else {
				v[match.visitor.id] = match;
				return v;
			}
		});
	}
	
	private Match[] newMatchList(Match match) {
		Match[] result = new Match[teams.length];
		result[match.visitor.id] = match;
		return result;
	}

	private static <T> void shuffle(T[] arr) {
		shuffle(arr, 0, arr.length);
	}
	
	private static <T> void shuffle(T[] arr, int start, int end) {
		Random rnGesus = ThreadLocalRandom.current();
		for (int i = end - 1; i > start; i--) {
			int index = start + rnGesus.nextInt(i - start);
			T tmp = arr[index];
			arr[index] = arr[i];
			arr[i] = tmp;
		}
	}

	@Override
	public String toString() {
		StringBuilder result = new StringBuilder("Calendario:\n\n");
		for (Round round : rounds) {
			result.append(round);
			result.append("\n\n");
		}
		return result.toString();
	}
}
