package restaurant.domain;

public class RestaurantManager {

	private String ime;
	private String prezime;
	private String email;
	private String password;
	
	
	public RestaurantManager(){
		
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


	@Override
	public String toString() {
		return "RestaurantManager [ime=" + ime + ", prezime=" + prezime + ", email=" + email + ", password=" + password
				+ "]";
	}
	
	
	
}
