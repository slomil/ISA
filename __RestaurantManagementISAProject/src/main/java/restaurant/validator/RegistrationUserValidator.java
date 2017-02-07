package restaurant.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import restaurant.domain.UserRegistration;
import restaurant.service.RegistratedUsersService;

@Component
public class RegistrationUserValidator implements Validator{

	@Autowired
	private RegistratedUsersService service;
	
	@Override
	public boolean supports(Class<?> clazz) {
		return UserRegistration.class.equals(clazz);
	}
	
	@Override
	public void validate(Object target, Errors errors) {
		
		
		UserRegistration guestRegistrated=(UserRegistration)target;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "ime", "NotEmpty");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "prezime", "NotEmpty");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "NotEmpty");
		
		if (service.findUser(guestRegistrated.getEmail())) {
            errors.rejectValue("email", "ExistUser");
        }
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "NotEmpty");
		if(guestRegistrated.getPassword().length()<5 && guestRegistrated.getPassword().length()>0){
			errors.rejectValue("password", "LengthPass");
		}
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "repeatPassword", "NotEmpty");
		if(!guestRegistrated.getRepeatPassword().equals(guestRegistrated.getPassword()) && guestRegistrated.getRepeatPassword().length()>0){
			errors.rejectValue("repeatPassword", "MatchPass");
			}
		
	
		
		
	}

	
}
