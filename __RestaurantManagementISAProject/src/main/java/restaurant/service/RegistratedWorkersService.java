package restaurant.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import restaurant.domain.WorkerRegistration;
import restaurant.repository.RegistratedWorkersRepository;

@Service
public class RegistratedWorkersService {

	
	@Autowired
	private RegistratedWorkersRepository rwRepository;
	
	
	public boolean saveWorker(String ime,String prezime,String email,String password,String role,String datumRodjenja,String konfekcijskiBr,Integer obucaBr,String nazrest){
		rwRepository.saveWorker(ime, prezime, email, password, role, datumRodjenja, konfekcijskiBr, obucaBr,nazrest);
		return true;
	}
	
	
	public boolean findWorker(String email,String nazrest){
		return rwRepository.findWorker(email,nazrest);
	}
	
	
	public WorkerRegistration getWorker(String email,String nazrest){
		return rwRepository.getWorker(email,nazrest);
	}
	
	
	public List<WorkerRegistration> getAllForRestaurant(String nazrest){
		
		return rwRepository.getAllForRestaurant(nazrest);
	}
	
	
	
}
