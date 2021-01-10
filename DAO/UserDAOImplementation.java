package DAO;

import DTO.User;
import java.sql.*;

public class UserDAOImplementation implements UserDAOInterface {
	Connection connection = ConnectionManager.getInstance().getConnection();

	@Override
	public void dodajKorisnika(User user) throws SQLException {
		String query = "INSERT INTO users (ime, prezime, username, sifra) VALUES (?, ?, ?, ?)";

		try (PreparedStatement statement = connection.prepareStatement(query);) {
			statement.setString(1, user.getIme());
			statement.setString(2, user.getPrezime());
			statement.setString(3, user.getUsername());
			statement.setString(4, user.getSifra());

			statement.executeUpdate();

			System.out.println("Uspjesno ste se registrovali.");
		}

	}

	@Override
	public User pronadjiKorisnikaPoUsernameu(String username) throws SQLException {

		User user = null;

		String query = "SELECT * FROM users WHERE username = ?";

		ResultSet rs = null;

		try (PreparedStatement statement = connection.prepareStatement(query);) {
			statement.setString(1, username);

			rs = statement.executeQuery();

			if (rs.next()) {
				user = new User(rs.getInt("userID"), rs.getString("ime"), rs.getString("prezime"),
						rs.getString("username"), rs.getString("sifra"));
				rs.close();
			}
		}

		return user;
	}

	@Override
	public void promijeniIme(String username, String ime) throws SQLException {
		String query = "UPDATE users SET ime = ? WHERE username = ?";

		try (PreparedStatement statement = connection.prepareStatement(query);) {

			statement.setString(1, ime);
			statement.setString(2, username);

			statement.executeUpdate();
		}

	}

	@Override
	public void promijeniPrezime(String username, String prezime) throws SQLException {

		String query = "UPDATE users SET prezime = ? WHERE username = ?";

		try (PreparedStatement statement = connection.prepareStatement(query);) {

			statement.setString(1, prezime);
			statement.setString(2, username);

			statement.executeUpdate();
		}
	}

	@Override
	public void promijeniUsername(String username, String noviUsername) throws SQLException {
		String query = "UPDATE users SET username = ? WHERE username = ?";

		try (PreparedStatement statement = connection.prepareStatement(query);) {

			statement.setString(1, noviUsername);
			statement.setString(2, username);

			statement.executeUpdate();
		}
	}

	@Override
	public void PromijeniSifru(String username, String sifra) throws SQLException {

		String query = "UPDATE users SET sifra = ? WHERE username = ?";

		try (PreparedStatement statement = connection.prepareStatement(query);) {

			statement.setString(1, sifra);
			statement.setString(2, username);

			statement.executeUpdate();
		}
	}

}
