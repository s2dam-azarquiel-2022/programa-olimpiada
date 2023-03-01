package net.azarquiel;

import java.util.Scanner;

import net.azarquiel.model.League;
import net.azarquiel.model.MenuOption;
import net.azarquiel.view.EndCompetition;
import net.azarquiel.view.SetResults;
import net.azarquiel.view.ShowCalendar;
import net.azarquiel.view.ShowClasification;
import net.azarquiel.view.ShowMenu;
import net.azarquiel.view.ShowResults;

public class Main {
	public static MenuOption selectedOption = MenuOption.SHOW_MENU;
	public static League league;
	public static Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) {
		boolean flag = true;
		while (flag) {
			switch (selectedOption) {
			case SHOW_MENU:
				ShowMenu.showText();
				ShowMenu.handleInput();
				break;
				
			case SHOW_CALENDAR:
				ShowCalendar.showCalendar();
				Main.selectedOption = MenuOption.SHOW_MENU;
				break;

			case SET_RESULTS:
				if (league == null) {
					noCalendarErr();
					break;
				}
				SetResults.askResults();
				Main.selectedOption = MenuOption.SHOW_MENU;
				break;
				
			case SHOW_RESULTS:
				if (league == null) {
					noCalendarErr();
					break;
				}
				ShowResults.showResultTable();
				Main.selectedOption = MenuOption.SHOW_MENU;
				break;
				
			case SHOW_CLASIFICATION:
				if (league == null) {
					noCalendarErr();
					break;
				}
				ShowClasification.showClasification();
				Main.selectedOption = MenuOption.SHOW_MENU;
				break;
				
			case END_COMPETITION:
				if (league == null) {
					noCalendarErr();
					break;
				}
				EndCompetition.endCompetition();
				flag = false;
				Main.selectedOption = MenuOption.SHOW_MENU;
				break;
			}
		}
	}
	
	private static void noCalendarErr() {
		System.err.println("Tienes que crear el calendario primero");
		Main.selectedOption = MenuOption.SHOW_MENU;
	}
}
