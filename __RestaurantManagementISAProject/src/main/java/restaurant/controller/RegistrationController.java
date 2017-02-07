package restaurant.controller;

import java.util.Properties;


import javax.validation.Valid;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


import restaurant.domain.Email;
import restaurant.domain.UserRegistration;
import restaurant.service.RegistratedUsersService;
import restaurant.validator.RegistrationUserValidator;


@Controller
@RequestMapping("/registracija")
public class RegistrationController {
	
	String ime,prezime,username,password,repeated,role;
	
	@Autowired
	private RegistratedUsersService service;
	
	@Autowired
    private RegistrationUserValidator regValidator;
	
	@GetMapping
	public String showRegistracija(ModelMap model){
		model.addAttribute("userRegistration", new UserRegistration());
		return "registracija";
	}
	
	@RequestMapping(value="/try",method=RequestMethod.POST)
	public ModelAndView tryRegistration(@Valid UserRegistration userRegistration,BindingResult bindingResult,ModelMap model){
		regValidator.validate(userRegistration, bindingResult);
		
		if (bindingResult.hasErrors()) {
			return new ModelAndView("registracija","formErrors",bindingResult.getAllErrors());
        }
		if(!service.findUser(userRegistration.getEmail())){
			
			Email email=new Email();
			email.sendEmail(userRegistration.getEmail(),userRegistration.getPassword());
			
			ime=userRegistration.getIme();
			prezime=userRegistration.getPrezime();
			username=userRegistration.getEmail();
			password=userRegistration.getPassword();
			repeated=userRegistration.getRepeatPassword();
			role=userRegistration.getRole();
			
			model.put("poruka","Registracija uspesna!Da biste se prijavili,potrebno je jos samo kliknuti na link koji vam je mejlom poslat.");
			
			return new ModelAndView("obavestenje","model",model);
		}
		
		else {
			return new ModelAndView("registracija","model",model);
		}
	}
	
	@RequestMapping(value="/success")
	public ModelAndView confirmation(ModelMap model){
		model.put("poruka","Cestitamo!Uspesno ste potvrdili registraciju.Sada mozete da se ulogujete!");
		service.saveUser(ime, prezime, username, password,role);
		return new ModelAndView("obavestenje","model",model);
	}
	
}
