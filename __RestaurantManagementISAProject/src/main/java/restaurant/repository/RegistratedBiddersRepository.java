package restaurant.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import restaurant.domain.BidderRegistration;
import restaurant.domain.RestaurantRegistration;
import restaurant.domain.UserRegistration;
import restaurant.repository.RegistratedRestaurantsRepository.RestaurantRegistrationRowMapper;

@Repository
public class RegistratedBiddersRepository {

	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	
	@Transactional
	public boolean saveBidder(String ime,String prezime,String email,String password,String role,String nazivRestorana){
		jdbcTemplate.update("insert into rbidder(ime,prezime,email,password,role,nazivRestorana) values (?,?,?,?,?,?)",ime,prezime,email,password,role,nazivRestorana);
		return true;
	}
	
	
	@Transactional
	public BidderRegistration getBidder(String email){
		return (BidderRegistration) jdbcTemplate.query("select * from rbidder where email=?",new Object[]{email}, 
                new BidderRegistrationRowMapper());
	}
	
	
	@Transactional
	public List<BidderRegistration> findAll(){
		return jdbcTemplate.query("select * from rbidder", 
                new BidderRegistrationRowMapper());
	}
	
	
	@Transactional
	public boolean findBidder(String email){
		List<BidderRegistration>u=findAll();
		
		for(int i=0;i<u.size();i++){
			if(u.get(i).getEmail().equals(email)) return true;
		}
		return false;
	}
	
	
	class BidderRegistrationRowMapper implements RowMapper<BidderRegistration>{

		public BidderRegistration mapRow(ResultSet rs, int rowNum) throws SQLException {
			BidderRegistration u=new BidderRegistration();
			u.setIme(rs.getString("ime"));
			u.setPrezime(rs.getString("prezime"));
			u.setEmail(rs.getString("email"));
			u.setPassword(rs.getString("password"));
			u.setRole(rs.getString("role"));
			u.setNazivRestorana(rs.getString("nazivRestorana"));
			return u;
		}
		
		
	}
	
	
}
