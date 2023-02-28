package net.azarquiel;

import java.util.Scanner;

import net.azarquiel.model.League;
import net.azarquiel.model.MenuOption;
import net.azarquiel.model.Round;
import net.azarquiel.view.SetResults;
import net.azarquiel.view.ShowCalendar;
import net.azarquiel.view.ShowMenu;

public class Main {
	public static MenuOption selectedOption = MenuOption.SHOW_MENU;
	public static League league;
	public static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		while (selectedOption != MenuOption.END_COMPETITION) {
			switch (selectedOption) {
			case SHOW_MENU:
				ShowMenu.showText();
				ShowMenu.handleInput();
				break;
				
			case SHOW_CALENDAR:
				ShowCalendar.showCalendar();
				break;

			case SET_RESULTS:
				Round round = SetResults.askRound();
				if (round == null) break;
				SetResults.setMatchScore(round.firstMatch);
				SetResults.setMatchScore(round.secondMatch);
				System.out.println("Resultado anotado\n");
				Main.selectedOption = MenuOption.SHOW_MENU;
				break;

			default:
				break;
			}
		}
	}
}
