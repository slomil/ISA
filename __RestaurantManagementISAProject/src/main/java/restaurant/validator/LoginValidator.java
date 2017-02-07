package restaurant.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import restaurant.domain.UserLogin;
import restaurant.service.RegistratedUsersService;

@Component
public class LoginValidator implements Validator{

	@Autowired
	private RegistratedUsersService service;
	
	@Override
	public boolean supports(Class<?> clazz) {
		return UserLogin.class.equals(clazz);
		
	}

	@Override
	public void validate(Object target, Errors errors) {
		
		UserLogin userLogin=(UserLogin)target;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "NotEmpty");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "NotEmpty");
		
	
		if (!service.findUser(userLogin.getEmail()) && !userLogin.getEmail().equals("")) {
            errors.rejectValue("email", "NotExistUser");
        }
	
		if(service.findUser(userLogin.getEmail())&&!service.findUser2(userLogin.getEmail(), userLogin.getPassword()) && !userLogin.getPassword().equals("")){
			errors.rejectValue("password", "MatchUserPass");
		}
	
	}

	
}
