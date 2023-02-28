package net.azarquiel;

import java.util.Scanner;

import net.azarquiel.model.MenuOption;
import net.azarquiel.view.ShowMenu;

public class Main {
	public static MenuOption selectedOption = MenuOption.SHOW_MENU;
	public static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		while (selectedOption != MenuOption.END_COMPETITION) {
			switch (selectedOption) {
			case SHOW_MENU:
				ShowMenu.showText();
				ShowMenu.handleInput();
				break;

			default:
				break;
			}
		}
	}
}
