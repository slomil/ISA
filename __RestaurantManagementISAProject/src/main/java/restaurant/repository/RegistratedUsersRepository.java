package restaurant.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import restaurant.domain.UserRegistration;

@Repository
public class RegistratedUsersRepository {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Transactional
	public boolean saveUser(String ime,String prezime,String email,String password,String role){
		jdbcTemplate.update("insert into users(ime,prezime,email,password,role"
				+ ") values (?,?,?,?,?)",ime,prezime,email,password,role);
		return true;
	}
	
	@Transactional
    public List<UserRegistration> findAll() {
    	return jdbcTemplate.query("select * from users", 
                new UserRegistrationRowMapper());

    }
	
	@Transactional
	public List<UserRegistration> getAllRManagers(){
		return jdbcTemplate.query("select * from users where role='RESTAURANT_MANAGER' ", 
                new UserRegistrationRowMapper());
	}
	
	@Transactional
	public boolean findUser(String email){
		List<UserRegistration>u=findAll();
		
		for(int i=0;i<u.size();i++){
			if(u.get(i).getEmail().equals(email)) return true;
		}
		return false;
	}
	
	@Transactional
	public boolean findUser2(String email,String password){
		List<UserRegistration>u=findAll();
		
		for(int i=0;i<u.size();i++){
			if(u.get(i).getEmail().equals(email)==true
		    && u.get(i).getPassword().equals(password)==true) return true;
		}
		return false;
	}
	
	@Transactional
	public UserRegistration getUser(String email){
		List<UserRegistration>u=findAll();
		
		for(int i=0;i<u.size();i++){
			if(u.get(i).getEmail().equals(email)) return u.get(i);
		}
		return null;
	}

	@Transactional
	public UserRegistration getUser2(String email,String password){
		List<UserRegistration>u=findAll();
		for(int i=0;i<u.size();i++){
			if(u.get(i).getEmail().equals(email)==true
		    && u.get(i).getPassword().equals(password)==true) return u.get(i);
		}
		return null;
	}
	
	
	class UserRegistrationRowMapper implements RowMapper<UserRegistration>{

		public UserRegistration mapRow(ResultSet rs, int rowNum) throws SQLException {
			UserRegistration u=new UserRegistration();
			u.setIme(rs.getString("ime"));
			u.setPrezime(rs.getString("prezime"));
			u.setEmail(rs.getString("email"));
			u.setPassword(rs.getString("password"));
			u.setRole(rs.getString("role"));
			return u;
		}
		
		
	}
	
	
}
