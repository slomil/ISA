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
import restaurant.domain.WorkerRegistration;

@Repository
public class RegistratedWorkersRepository {

	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	
	
	
	@Transactional
	public boolean saveWorker(String ime,String prezime,String email,String password,String role,String datumRodjenja,String konfekcijskiBr,Integer obucaBr,String restoran){
		jdbcTemplate.update("insert into rworkers(ime,prezime,email,password,role,datumRodjenja,konfekcijskiBroj,obucaBroj,nazivRestorana)"
				+ " values(?,?,?,?,?,?,?,?,?)",ime,prezime,email,password,role,datumRodjenja,konfekcijskiBr,obucaBr,restoran);
		return true;
		
	}
	
	
	
	@Transactional
	public List<WorkerRegistration> getAllForRestaurant(String nazrest){
		return jdbcTemplate.query("select * from rworkers where nazivRestorana=?",new Object[]{nazrest}, new WorkerRegistrationRowMapper());
	}
	
	
	
	@Transactional
	public boolean findWorker(String email,String nazrest){
		List<WorkerRegistration>u=getAllForRestaurant(nazrest);
		
		for(int i=0;i<u.size();i++){
			if(u.get(i).getEmail().equals(email)==true) return true;
		}
		return false;
	}
	
	
	
	@Transactional
	public WorkerRegistration getWorker(String email,String nazrest){
		return jdbcTemplate.queryForObject("select * from rworkers where email=? and nazrest=?", new Object[]{email,nazrest},new WorkerRegistrationRowMapper());
	}
	
	
	
	
	class WorkerRegistrationRowMapper implements RowMapper<WorkerRegistration>{

		public WorkerRegistration mapRow(ResultSet rs, int rowNum) throws SQLException {
			WorkerRegistration u=new WorkerRegistration();
			u.setIme(rs.getString("ime"));
			u.setPrezime(rs.getString("prezime"));
			u.setEmail(rs.getString("email"));
			u.setPassword(rs.getString("password"));
			u.setRole(rs.getString("role"));
			u.setDatumRodjenja(rs.getString("datumRodjenja"));
			u.setKonfekcijskiBr(rs.getString("konfekcijskiBroj"));
			u.setObucaBr(rs.getInt("obucaBroj"));
			u.setNazivRestorana(rs.getString("nazivRestorana"));
			return u;
		}
	}
}
