package net.azarquiel.model;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;

public class League {
	public Team[] teams = new Team[] {
		new Team("Toledo"),
		new Team("Ciudad Real"),
		new Team("Guadalajara"),
		new Team("Cuenca"),
		new Team("Albacete"),
	};
	
	public Round[] rounds = new Round[teams.length * 2];
	
	public League() { generateCalendar(); }
	
	private void generateCalendar() {
		// Randomized order for teams to rest
		int[] restingIndexes = generateRandomIndexes();
		for (int i = 0; i < teams.length; i++) {
			// Randomized matches
			int[] generated_matches = generateMatches(restingIndexes, i);
			rounds[i] = new Round(
				new Match(teams[generated_matches[0]], teams[generated_matches[1]]),
				new Match(teams[generated_matches[2]], teams[generated_matches[3]]),
				teams[restingIndexes[i]]
			);
		}
		// Generate the reverse of the generated matches
		// So a match A vs B turns to a match B vs A
		int[] duplicateIndexes = generateRandomIndexes();
		for (int i = 0; i < duplicateIndexes.length; i++)
			rounds[i + teams.length] = rounds[duplicateIndexes[i]].reverse();
	}

	private int[] generateRandomIndexes() {
		// Generates an array from 0 to the length of teams and then shuffles it
		int[] result = IntStream.range(0, teams.length).toArray();
		shuffle(result);
		return result;
	}
	
	private int[] generateMatches(int[] arr, int pos) {
		int[] result = new int[arr.length - 1];
		System.arraycopy(arr, 0, result, 0, pos);
		System.arraycopy(arr, pos + 1, result, pos, arr.length - pos - 1);
		shuffle(result);
		return result;
	}
	
	private static void shuffle(int[] arr) {
		Random rnGesus = ThreadLocalRandom.current();
		for (int i = arr.length - 1; i > 0; i--) {
			int index = rnGesus.nextInt(i + 1);
			int tmp = arr[index];
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
