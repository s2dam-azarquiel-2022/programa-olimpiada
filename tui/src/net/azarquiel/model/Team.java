package net.azarquiel.model;

public class Team {
	public String name;

	public Team(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return String.format("%s", name);
	}
}
