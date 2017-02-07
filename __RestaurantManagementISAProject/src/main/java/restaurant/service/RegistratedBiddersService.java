package restaurant.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import restaurant.domain.BidderRegistration;
import restaurant.repository.RegistratedBiddersRepository;

@Service
public class RegistratedBiddersService {

	@Autowired
	private RegistratedBiddersRepository rbRepository;
	
	
	
	public boolean saveBidder(String ime,String prezime,String email,String password,String role,String emailMR){
		
		return rbRepository.saveBidder(ime, prezime, email, password, role, emailMR);
	
	}
	
	public List<BidderRegistration> findAll(){
		
		return rbRepository.findAll();
		
	}
	
	public boolean findBidder(String email){
		return rbRepository.findBidder(email);
	}
	
	
	public BidderRegistration getBidder(String email){
		
		return (BidderRegistration) rbRepository.getBidder(email);
		
	}
	
}
