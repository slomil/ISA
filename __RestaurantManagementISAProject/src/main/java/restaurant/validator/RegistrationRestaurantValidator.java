package restaurant.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import restaurant.domain.RestaurantRegistration;
import restaurant.domain.UserRegistration;

@Component
public class RegistrationRestaurantValidator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		return RestaurantRegistration.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		
		RestaurantRegistration restaurantRegistrated=(RestaurantRegistration)target;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "naziv", "NotEmpty");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "adresa", "NotEmpty");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "vrsta", "NotEmpty");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "emailManager", "NotEmpty");
	}

}
