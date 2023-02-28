package net.azarquiel.view;

import java.util.StringTokenizer;

import net.azarquiel.Main;
import net.azarquiel.model.MenuOption;
import net.azarquiel.model.Round;

public class SetResults {
	public static void askRound() {
		System.out.println("Selecciona Jornada: ");
		int n = Integer.valueOf(Main.scanner.nextLine());
	    Round jornada = Main.league.rounds[n - 1];
	    System.out.println(jornada.firstMatch + ": ");
	    String p1 = Main.scanner.nextLine();
	    StringTokenizer st1 = new StringTokenizer(p1, "-");
	   jornada.firstMatch.localScore = Integer.valueOf(st1.nextToken()) ;
	   jornada.firstMatch.visitorScore = Integer.valueOf(st1.nextToken()) ;
	   System.out.println(jornada.secondMatch + ": ");
	    String p2 = Main.scanner.nextLine();
	    StringTokenizer st2 = new StringTokenizer(p2 , "-");
	   jornada.firstMatch.localScore = Integer.valueOf(st2.nextToken());
	   jornada.firstMatch.visitorScore = Integer.valueOf(st2.nextToken());
	   System.out.println("Resultado anotado \n");
	   Main.selectedOption = MenuOption.SHOW_MENU;
	}

}
