package restaurant.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import restaurant.domain.BidderRegistration;
import restaurant.service.RegistratedBiddersService;

@Component
public class RegistrationBidderValidator implements Validator{

	@Autowired
	private RegistratedBiddersService service;
	
	@Override
	public boolean supports(Class<?> clazz) {
		return BidderRegistration.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		
		BidderRegistration bidderRegistrated=(BidderRegistration)target;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "ime", "NotEmpty");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "prezime", "NotEmpty");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "NotEmpty");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "NotEmpty");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "repeatPassword", "NotEmpty");
		
		
		if (service.findBidder(bidderRegistrated.getEmail())) {
            errors.rejectValue("email", "ExistUser");
        }
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "NotEmpty");
		if(bidderRegistrated.getPassword().length()<5 && bidderRegistrated.getPassword().length()>0){
			errors.rejectValue("password", "LengthPass");
		}
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "repeatPassword", "NotEmpty");
		if(!bidderRegistrated.getRepeatPassword().equals(bidderRegistrated.getPassword()) && bidderRegistrated.getRepeatPassword().length()>0){
			errors.rejectValue("repeatPassword", "MatchPass");
			}
		
		
	}

}
