package net.azarquiel.model;

public class Round {
	private static int idGenerator = 1;
	public int n;
	public Match firstMatch;
	public Match secondMatch;
	public Team rest;

	public Round(Match firstMatch, Match secondMatch, Team rest) {
		this.firstMatch = firstMatch;
		this.secondMatch = secondMatch;
		this.rest = rest;
		n = idGenerator++;
	}

	@Override
	public String toString() {
		return String.format(
			"Jornada %d\n%s\n%s\nDescansa: %s",
			n,
			firstMatch,
			secondMatch,
			rest.name
		);
	}
	
	public Round reverse() {
		Round result = new Round(
			this.firstMatch.reverse(),
			this.secondMatch.reverse(),
			this.rest
		);
		return result;
	}
}
