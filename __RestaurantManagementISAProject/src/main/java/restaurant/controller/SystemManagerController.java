package restaurant.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import restaurant.domain.Email;
import restaurant.domain.RestaurantRegistration;
import restaurant.domain.UserLogin;
import restaurant.domain.UserRegistration;
import restaurant.repository.RegistratedRestaurantsRepository;
import restaurant.service.RegistratedUsersService;
import restaurant.validator.RegistrationRestaurantValidator;
import restaurant.validator.RegistrationUserValidator;

@Controller
@RequestMapping(value="/systemManager")
public class SystemManagerController {

	@Autowired
	RegistrationUserValidator regValidator;
	
	@Autowired
	RegistrationRestaurantValidator resValidator;
	
	@Autowired
	private RegistratedUsersService uservice;
	
	@Autowired
	private RegistratedRestaurantsRepository rservice;
	
	
	
	
	@RequestMapping(value="/registracijaMenadzeraRestorana")
	public ModelAndView registracijaMenadzeraRestorana(ModelMap model,HttpServletRequest request){
		model.addAttribute("userRegistration", new UserRegistration());
		return new ModelAndView("registracijaMenadzeraRestorana","model",model);
	}
	
	
	
	@RequestMapping(value="/registracijaMenadzeraRestorana/try",method=RequestMethod.POST)
	public ModelAndView tryRegistracijaMenadzeraRestorana(@Valid UserRegistration userRegistration,BindingResult bindingResult,ModelMap model,HttpServletRequest request){
		regValidator.validate(userRegistration, bindingResult);
		
		if (bindingResult.hasErrors()) {	
			return new ModelAndView("registracijaMenadzeraRestorana","formErrors",bindingResult.getAllErrors());
        }
		
		uservice.saveUser(userRegistration.getIme(), userRegistration.getPrezime(), userRegistration.getEmail(), userRegistration.getPassword(), userRegistration.getRole());
		
		List<UserRegistration>ur=uservice.getAllRManagers();
		request.getSession().setAttribute("restaurantManagers", ur);
		
		model.put("poruka","Registracija uspesno obavljena!");
		model.addAttribute("userRegistration", new UserRegistration());
		return new ModelAndView("registracijaMenadzeraRestorana","model",model);
	}
	
	
	
	@RequestMapping(value="/registracijaRestorana")
	public ModelAndView registracijaRestorana(ModelMap model,HttpServletRequest request){
		model.addAttribute("restaurantRegistration", new RestaurantRegistration());
		
		return new ModelAndView("registracijaRestorana","model",model);
	}
	
	
	
	
	@RequestMapping(value="/registracijaRestorana/try")
	public ModelAndView tryRegistracijaRestorana(@Valid RestaurantRegistration restaurantRegistration,BindingResult bindingResult,ModelMap model,HttpServletRequest request){
		resValidator.validate(restaurantRegistration, bindingResult);
		if (bindingResult.hasErrors()) {	
			return new ModelAndView("registracijaMenadzeraSistema","formErrors",bindingResult.getAllErrors());
        }
		
		rservice.saveRestaurant(restaurantRegistration.getNaziv(), restaurantRegistration.getAdresa(), restaurantRegistration.getVrsta(), restaurantRegistration.getEmailManager());
		model.put("poruka","Registracija uspesno obavljena!");
		model.addAttribute("restaurantRegistration", new RestaurantRegistration());
		return new ModelAndView("registracijaRestorana","model",model);
	}

	
	
	
	@RequestMapping(value="/registracijaMenadzeraSistema")
	public ModelAndView registracijaMenadzeraSistema(ModelMap model,HttpServletRequest request){
		model.addAttribute("userRegistration", new UserRegistration());
		return new ModelAndView("registracijaMenadzeraSistema","model",model);
	}
	
	
	
	
	@RequestMapping(value="/registracijaMenadzeraSistema/try",method=RequestMethod.POST)
	public ModelAndView tryRegistracijaMenadzeraSistema(@Valid UserRegistration userRegistration,BindingResult bindingResult,ModelMap model,HttpServletRequest request){
		regValidator.validate(userRegistration, bindingResult);
		
		if (bindingResult.hasErrors()) {	
			return new ModelAndView("registracijaMenadzeraSistema","formErrors",bindingResult.getAllErrors());
        }
		
		uservice.saveUser(userRegistration.getIme(), userRegistration.getPrezime(), userRegistration.getEmail(), userRegistration.getPassword(), userRegistration.getRole());
		
		model.addAttribute("userRegistration", new UserRegistration());
		model.put("poruka","Registracija uspesno obavljena!");
		return new ModelAndView("registracijaMenadzeraSistema","model",model);
	}
	
	
	
	
	@RequestMapping(value="/profil")
	public ModelAndView getProfile(ModelMap model,HttpServletRequest request){
		return new ModelAndView("profilMenadzeraSistema");
	}
	
	
	
}
