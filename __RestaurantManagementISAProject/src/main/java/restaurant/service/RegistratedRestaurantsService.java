package restaurant.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import restaurant.domain.RestaurantRegistration;
import restaurant.domain.UserRegistration;
import restaurant.repository.RegistratedRestaurantsRepository;
import restaurant.repository.RegistratedUsersRepository;

@Service
public class RegistratedRestaurantsService {

	@Autowired
	private RegistratedRestaurantsRepository rRepository;
	
	
	public boolean saveRestaurant(String naziv,String adresa,String vrsta,String email) {
		 
		 rRepository.saveRestaurant(naziv,adresa,vrsta,email);
		 return true;
	 }
	
	public List<RestaurantRegistration> getAll() {
	    	
	     return rRepository.getAll(); 
	 }
	
	public List<RestaurantRegistration> getAllFromRM(String email){
		return rRepository.getAllFromRM(email);
	}
	
	public RestaurantRegistration getRestaurantByManagerEmail(String email){
		
		return rRepository.getRestaurantByManagerEmail(email);
	}
	
	
	public RestaurantRegistration getRestaurantByName(String naziv){
		
		return rRepository.getRestaurantByName(naziv);
		
	}
	
	
	public boolean editRestaurantInfo(String naziv,String adresa,String vrsta,String emailMenadzera){
		
		return rRepository.editRestaurantInfo(naziv, adresa, vrsta, emailMenadzera);
		
	}
	
}
