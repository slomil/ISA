package restaurant.domain;

import java.sql.Date;

public class WorkerRegistration {

	private String ime;
	private String prezime;
	private String email;
	private String password;
	private String repeatPassword;
	private String role;
	private String datumRodjenja;
	private String konfekcijskiBr;
	private Integer obucaBr;
	private String nazivRestorana;
	
	
	public WorkerRegistration(){
		
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




	public String getEmail() {
		return email;
	}




	public void setEmail(String email) {
		this.email = email;
	}




	public String getPassword() {
		return password;
	}




	public void setPassword(String password) {
		this.password = password;
	}




	public String getRepeatPassword() {
		return repeatPassword;
	}




	public void setRepeatPassword(String repeatPassword) {
		this.repeatPassword = repeatPassword;
	}




	public String getDatumRodjenja() {
		return datumRodjenja;
	}




	public void setDatumRodjenja(String datumRodjenja) {
		this.datumRodjenja = datumRodjenja;
	}




	public String getKonfekcijskiBr() {
		return konfekcijskiBr;
	}




	public void setKonfekcijskiBr(String konfekcijskiBr) {
		this.konfekcijskiBr = konfekcijskiBr;
	}




	public Integer getObucaBr() {
		return obucaBr;
	}




	public void setObucaBr(Integer obucaBr) {
		this.obucaBr = obucaBr;
	}




	public String getRole() {
		return role;
	}




	public void setRole(String role) {
		this.role = role;
	}

	

	public String getNazivRestorana() {
		return nazivRestorana;
	}




	public void setNazivRestorana(String restoran) {
		this.nazivRestorana = restoran;
	}


	
	
	@Override
	public String toString() {
		return "WorkerRegistration [ime=" + ime + ", prezime=" + prezime + ", email=" + email + ", password=" + password
				+ ", repeatPassword=" + repeatPassword + ", role=" + role + ", datumRodjenja=" + datumRodjenja
				+ ", konfekcijskiBr=" + konfekcijskiBr + ", obucaBr=" + obucaBr + ", nazivRestorana=" + nazivRestorana + "]";
	}
	
	
	
}
