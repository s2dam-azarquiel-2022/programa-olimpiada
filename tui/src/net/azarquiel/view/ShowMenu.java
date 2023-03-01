package net.azarquiel.view;

import net.azarquiel.Main;
import net.azarquiel.model.MenuOption;

public class ShowMenu {
	private static final String text = options();
	private static final String errText = "Error: Elegiste una opcion inexistente";
	
	private static String options() {
		StringBuilder result = new StringBuilder("Selecciona una opcion:\n");
		for (MenuOption option : MenuOption.values()) {
			result.append(String.format("%s. %s\n", option.ordinal(), option.getText()));
		}
		result.append("\nTu opcion: ");
		return result.toString();
	}

	public static void showText() { System.out.println(text); }
	
	public static void handleInput() {
		try {
			String opt = Main.scanner.nextLine();
			Main.selectedOption = MenuOption.values()[Integer.valueOf(opt)];
			System.out.println("");
		} catch (Exception e) {
			System.err.println(errText);
			System.out.println("");
		}
	}
}
