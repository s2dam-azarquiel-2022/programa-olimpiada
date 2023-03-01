package net.azarquiel.model;

public class Match {
	public Team local;
	public Team visitor;
	public int localScore;
	public int visitorScore;
	public boolean check = false;

	public Match(Team local, Team visitor) {
		this.local = local;
		this.visitor = visitor;
	}

	@Override
	public String toString() {
		return String.format("%s - %s", local.name, visitor.name);
	}
	
	public Match reverse() { return new Match(this.visitor, this.local); }
}
