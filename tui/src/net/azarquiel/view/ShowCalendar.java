package net.azarquiel.view;

import net.azarquiel.Main;
import net.azarquiel.model.League;
import net.azarquiel.model.MenuOption;

public class ShowCalendar {
	public static void showCalendar() {
		checkCalendarExists();
		System.out.println(Main.league);
		Main.selectedOption = MenuOption.SHOW_MENU;
	}
	
	private static void checkCalendarExists() {
		if (Main.league == null) {
			System.out.println("Creando calendario ...");
			Main.league = new League();
		}
	}
}
