package net.azarquiel.model;

public enum MenuOption {
	SHOW_MENU("Mostrar este menu"),
	SHOW_CALENDAR("Mostrar el calendario (creandolo si no existiera)"),
	SET_RESULTS("Introducir los resultados de una jornada"),
	SHOW_RESULTS("Mostrar los resultados de una jornada"),
	SHOW_CLASIFICATION("Mostrar la clasificacion"),
	END_COMPETITION("Finalizar competicion");

	private String text;
	
	MenuOption(String text) {
		this.text = text;
	}
	
	public String getText() { return this.text; }
}
