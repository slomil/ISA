package restaurant.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import restaurant.domain.UserRegistration;
import restaurant.repository.RegistratedUsersRepository;

@Service
public class RegistratedUsersService {

	@Autowired
	private RegistratedUsersRepository uRepository;
	
	public boolean saveUser(String ime,String prezime,String email,String password,String role) {
		 
		 uRepository.saveUser(ime, prezime, email, password,role);
		 return true;
	 }
	
	public List<UserRegistration> findAll() {
	    	
	     return uRepository.findAll(); 
	 }
	
	public List<UserRegistration> getAllRManagers(){
		
		return uRepository.getAllRManagers();
	}
	
	public boolean findUser(String email){
		
		return uRepository.findUser(email);
	}

	
	public boolean findUser2(String email,String password){
		
		return uRepository.findUser2(email, password);
	}
	
	
	public UserRegistration getUser(String email){
		
		return uRepository.getUser(email);
	}
	
	public UserRegistration getUser2(String email,String password){
		
		return uRepository.getUser2(email,password);
	}

	
	
}
