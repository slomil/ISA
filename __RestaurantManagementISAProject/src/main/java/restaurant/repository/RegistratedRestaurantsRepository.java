package restaurant.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import restaurant.domain.RestaurantRegistration;
import restaurant.domain.UserRegistration;
import restaurant.repository.RegistratedUsersRepository.UserRegistrationRowMapper;



@Repository
public class RegistratedRestaurantsRepository {

	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Transactional
	public boolean saveRestaurant(String naziv,String adresa,String vrsta,String emailMenadzera){
		jdbcTemplate.update("insert into rrestaurant(naziv,adresa,vrsta,emailMenadzera) values (?,?,?,?)",naziv,adresa,vrsta,emailMenadzera);
		return true;
	}
	
	
	@Transactional
    public List<RestaurantRegistration> getAll() {
    	return jdbcTemplate.query("select * from rrestaurant", 
                new RestaurantRegistrationRowMapper());

    }
	
	//trazi restorane koje menadzer sa datim emailom vodi
	@Transactional
	public List<RestaurantRegistration> getAllFromRM(String email){
		return jdbcTemplate.query("select * from rrestaurant where emailMenadzera= ? ",new Object[]{email},
                new RestaurantRegistrationRowMapper());
	}
	
	
	@Transactional
	public RestaurantRegistration getRestaurantByManagerEmail(String email){
		List<RestaurantRegistration>u=getAll();
		
		for(int i=0;i<u.size();i++){
			if(u.get(i).getEmailManager().equals(email)) return u.get(i);
		}
		return null;
	}
	
	//nalazenje restorana po imenu
	@Transactional
	public RestaurantRegistration getRestaurantByName(String naziv){
		return jdbcTemplate.queryForObject("select * from rrestaurant where naziv=?", new Object[]{naziv},
				new RestaurantRegistrationRowMapper());
	}
	
	
	//izmena tekstualnih podataka restorana
	@Transactional
	public boolean editRestaurantInfo(String naziv,String adresa,String vrsta,String emailMenadzera){
		jdbcTemplate.update("update rrestaurant set naziv=? where emailMenadzera=? ",new Object[]{naziv,emailMenadzera});
		jdbcTemplate.update("update rrestaurant set adresa=? where emailMenadzera=? ",new Object[]{adresa,emailMenadzera});
		jdbcTemplate.update("update rrestaurant set vrsta=? where emailMenadzera=? ",new Object[]{vrsta,emailMenadzera});
		return true;
	}
	
	
	
	class RestaurantRegistrationRowMapper implements RowMapper<RestaurantRegistration>{

		public RestaurantRegistration mapRow(ResultSet rs, int rowNum) throws SQLException {
			RestaurantRegistration u=new RestaurantRegistration();
			u.setNaziv(rs.getString("naziv"));
			u.setAdresa(rs.getString("adresa"));
			u.setVrsta(rs.getString("vrsta"));
			u.setEmailManager(rs.getString("emailMenadzera"));
			return u;
		}
		
		
	}
}
