package restaurant.domain;

public class BidderRegistration {

	
	private String ime;
	private String prezime;
	private String email;
	private String password;
	private String repeatPassword;
	private String role;
	private String nazivRestorana;
	
	
	public BidderRegistration(){
		
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


	public String getRole() {
		return role;
	}


	public void setRole(String role) {
		this.role = role;
	}


	public String getNazivRestorana() {
		return nazivRestorana;
	}


	public void setNazivRestorana(String nazivRestorana) {
		this.nazivRestorana = nazivRestorana;
	}


	@Override
	public String toString() {
		return "BidderRegistration [ime=" + ime + ", prezime=" + prezime + ", email=" + email + ", password=" + password
				+ ", repeatPassword=" + repeatPassword + ", role=" + role + ", nazivRestorana=" + nazivRestorana + "]";
	}


	

	
	
	
}
