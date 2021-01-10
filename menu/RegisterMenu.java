package menu;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import DAO.ConnectionManager;
import DAO.UserDAOImplementation;
import DTO.User;

public class RegisterMenu {
	static Scanner unos = new Scanner(System.in);

	static Connection connection = ConnectionManager.getInstance().getConnection();

	public static void registerMenu() throws SQLException {
		boolean zauzet;
		String sifra = null;
		String username = null;
		Statement st = connection.createStatement();

		System.out.println("Unesite ime: ");
		String ime = unos.nextLine();

		System.out.println("Unesite prezime: ");
		String prezime = unos.nextLine();

		System.out.println("Unesite username: ");
		username = unos.next();

		System.out.println("Unesite sifru: ");
		sifra = unos.next();

		String sql = "SELECT * FROM users WHERE username='" + username + "'";

		ResultSet rs = st.executeQuery(sql);

		if (rs.next()) {
			zauzet = true;
		}

		else {
			zauzet = false;
		}

		if (sifra.length() < 8 || zauzet == true) {
			System.out.println("Neuspjesna registracija.");
			System.out.println("Vasa sifra je prekratka ili je username vec zauzet.");
			System.out.println("Sifra mora biti duza od 7 karaktera.");
		}

		else {
			User user = new User(ime, prezime, username, sifra);
			UserDAOImplementation signup = new UserDAOImplementation();
			signup.dodajKorisnika(user);
		}
	}
}
