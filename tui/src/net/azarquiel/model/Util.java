package net.azarquiel.model;

import net.azarquiel.Main;

public class Util {
	public static void printWithPad(String v, int n) {
		System.out.print(String.format("%-" + n + "s", v));
	}

	public static void printWithPad(int v, int n) {
		System.out.print(String.format("%-" + n + "d", v));
	}

	public static int getMaxLen() {
		int result = 0;
		for (Team team : Main.league.teams) {
			int n = team.name.length();
			if (n > result) result = n;
		}
		return result;
	}
}
