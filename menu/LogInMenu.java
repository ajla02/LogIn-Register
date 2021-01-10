package menu;

import java.util.Scanner;
import DTO.User;
import DAO.UserDAOImplementation;
import java.sql.SQLException;

public class LogInMenu {

	static Scanner unos = new Scanner(System.in);
	static User user = null;

	public static void logIn() throws SQLException {
		UserDAOImplementation login = new UserDAOImplementation();
		System.out.println("Unesite username: ");
		String username = unos.next();

		System.out.println("Unesite sifru: ");
		String sifra = unos.next();

		user = login.pronadjiKorisnikaPoUsernameu(username);
		if (user.getSifra().equals(sifra)) {
			System.out.println("Uspjesno ste se log in-ovali.");

			System.out.println("UNESITE 1 ZA LOG OUT");
			System.out.println("UNESITE 2 ZA PROMJENU IMENA");
			System.out.println("UNESITE 3 ZA PROMJENU PREZIMENA");
			System.out.println("UNESITE 4 ZA PROMJENU SIFRE");
			System.out.println("UNESITE 5 ZA PROMJENU USERNAMEA");

			int izbor = unos.nextInt();

			switch (izbor) {

			case 1:
				GlavniMenu.ispisGlavniMenu();
				break;

			case 2:

				System.out.print("Unesite novo ime: ");
				String ime = unos.next();

				login.promijeniIme(username, ime);
				System.out.println("Uspjesno ste promijenili podatke.");
				break;

			case 3:

				System.out.print("Unesite novo prezime: ");
				String prezime = unos.next();

				login.promijeniPrezime(username, prezime);
				System.out.println("Uspjesno ste promijenili podatke.");
				break;
			case 4:

				System.out.println("Unesite novu sifru: ");
				unos.nextLine();
				String novaSifra = unos.nextLine();
				if (novaSifra.length() < 8) {
					System.out.println("Neuspjesna promjena.");
					System.out.println("Vasa sifra je prekratka.");
					System.out.println("Sifra mora biti duza od 7 karaktera.");
				}

				else {

					System.out.print("Unesite novu sifru ponovo: ");
					novaSifra = unos.next();

					login.promijeniIme(username, novaSifra);
					System.out.println("Uspjesno ste promijenili podatke.");

				}
				break;
			case 5:

				System.out.print("Unesite novi username: ");
				String noviUsername = unos.next();

				login.promijeniPrezime(username, noviUsername);
				System.out.println("Uspjesno ste promijenili podatke.");
				break;
			}
		}

	}
}
