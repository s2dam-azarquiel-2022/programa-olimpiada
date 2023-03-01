package net.azarquiel.view;

import net.azarquiel.model.Clasification;
import net.azarquiel.model.Results;
import net.azarquiel.model.Util;

public class ShowClasification {
	private static String[] fields = {
		"Puntos",
		"PJ",
		"PG",
		"PE",
		"PP",
		"GF",
		"GC",
		"DG"
	};
	
	public static void showClasification() {
		Clasification clasification = new Clasification();
		int maxLen = Util.getMaxLen() + 2;
		Util.printWithPad("Equipo", maxLen);
		for (String s : fields) Util.printWithPad(s, maxLen);
		System.out.println();
		for (Results result : clasification.results) {
			Util.printWithPad(result.name, maxLen);
			Util.printWithPad(result.points, maxLen);
			Util.printWithPad(result.played, maxLen);
			Util.printWithPad(result.won, maxLen);
			Util.printWithPad(result.tied, maxLen);
			Util.printWithPad(result.lost, maxLen);
			Util.printWithPad(result.scoreF, maxLen);
			Util.printWithPad(result.scoreC, maxLen);
			Util.printWithPad(result.scoreDiff, maxLen);
			System.out.println();
		}
	}
}
