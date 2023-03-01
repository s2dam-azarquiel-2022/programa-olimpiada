package net.azarquiel.view;

import net.azarquiel.Main;
import net.azarquiel.model.League;

public class ShowCalendar {
	public static void showCalendar() {
		checkCalendarExists();
		System.out.println(Main.league);
	}
	
	private static void checkCalendarExists() {
		if (Main.league == null) {
			System.out.println("Creando calendario ...");
			Main.league = new League();
		}
	}
}
