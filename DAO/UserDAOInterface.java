package DAO;

import java.sql.SQLException;

import DTO.User;

public interface UserDAOInterface {

	public void dodajKorisnika(User user) throws SQLException;

	public User pronadjiKorisnikaPoUsernameu(String username) throws SQLException;

	public void promijeniIme(String username, String ime) throws SQLException;

	public void promijeniPrezime(String username, String prezime) throws SQLException;

	public void promijeniUsername(String username, String noviUsername) throws SQLException;

	public void PromijeniSifru(String username, String sifra) throws SQLException;
}
