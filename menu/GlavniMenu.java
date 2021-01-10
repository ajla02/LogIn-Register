package menu;

import java.sql.SQLException;
import java.util.Scanner;

public class GlavniMenu {
	static Scanner unos = new Scanner(System.in);

	public static void ispisGlavniMenu() throws SQLException {
		System.out.println("Dobro dosli.");
		System.out.println("Unesite 1 za registraciju.");
		System.out.println("Unesite 2 za log-in.");

		int opcija = unos.nextInt();

		switch (opcija) {
		case 1:
			RegisterMenu.registerMenu();
			break;

		case 2:

			LogInMenu.logIn();
			break;

		}
	}
}
