package DTO;

public class User {
	private int userID;
	private String ime;
	private String prezime;
	private String username;
	private String sifra;

	public User() {

	}

	public User(int userID, String ime, String prezime, String username, String sifra) {
		this.userID = userID;
		this.ime = ime;
		this.prezime = prezime;
		this.username = username;
		this.sifra = sifra;
	}

	public User(String ime, String prezime, String username, String sifra) {
		this.ime = ime;
		this.prezime = prezime;
		this.username = username;
		this.sifra = sifra;
	}

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public String getIme() {
		return ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public String getPrezime() {
		return prezime;
	}

	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getSifra() {
		return sifra;
	}

	public void setSifra(String sifra) {
		this.sifra = sifra;
	}

}
