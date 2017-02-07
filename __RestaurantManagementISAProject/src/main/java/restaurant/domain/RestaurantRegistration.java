package restaurant.domain;

public class RestaurantRegistration {

	private String naziv;
	private String adresa;
	private String vrsta;
	private String emailManager;
	
	
	public RestaurantRegistration(){
		
		
	}


	public String getNaziv() {
		return naziv;
	}


	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}


	public String getAdresa() {
		return adresa;
	}


	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}


	public String getEmailManager() {
		return emailManager;
	}


	public void setEmailManager(String emailManager) {
		this.emailManager = emailManager;
	}


	public String getVrsta() {
		return vrsta;
	}


	public void setVrsta(String vrsta) {
		this.vrsta = vrsta;
	}


	@Override
	public String toString() {
		return "RestaurantRegistration [naziv=" + naziv + ", adresa=" + adresa + ", vrsta=" + vrsta + ", emailManager="
				+ emailManager + "]";
	}


	
	
	
	
}
