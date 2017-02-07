package restaurant.controller;

import java.util.List;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


import restaurant.domain.BidderRegistration;
import restaurant.domain.RestaurantRegistration;
import restaurant.domain.UserLogin;
import restaurant.domain.UserRegistration;
import restaurant.domain.WorkerRegistration;
import restaurant.service.RegistratedBiddersService;
import restaurant.service.RegistratedRestaurantsService;
import restaurant.service.RegistratedUsersService;
import restaurant.service.RegistratedWorkersService;
import restaurant.validator.RegistrationBidderValidator;
import restaurant.validator.RegistrationRestaurantValidator;
import restaurant.validator.RegistrationUserValidator;

@Controller
public class RestaurantManagerController {

	@Autowired
	private RegistratedBiddersService rbservice;
	
	@Autowired
	private RegistratedRestaurantsService rrservice;
	
	@Autowired
	private RegistrationBidderValidator regValidator;
	
	@Autowired
	private RegistrationRestaurantValidator rrValidator;
	
	@Autowired
	private RegistrationUserValidator ruValidator;
	
	@Autowired
	private RegistratedWorkersService rwservice;
	
	
	
	@RequestMapping(value="/restaurantManager/registracijaPonudjaca")
	public ModelAndView registracijaPonudjaca(ModelMap model,HttpServletRequest request){
		model.addAttribute("bidderRegistration",new BidderRegistration());
		return new ModelAndView("registracijaPonudjaca","model",model);
	}
	
	
	
	@RequestMapping(value="/restaurantManager/registracijaPonudjaca/try",method=RequestMethod.POST)
	public ModelAndView tryRegistracijaPonudjaca(@Valid BidderRegistration bidderRegistration,BindingResult bindingResult,ModelMap model,HttpServletRequest request){
		regValidator.validate(bidderRegistration, bindingResult);
		if (bindingResult.hasErrors()) {	
			return new ModelAndView("registracijaPonudjaca","formErrors",bindingResult.getAllErrors());
        }
		
		UserLogin ur=(UserLogin) request.getSession().getAttribute("logged");
		List<RestaurantRegistration>restaurantList=rrservice.getAllFromRM(ur.getEmail());
		request.getSession().setAttribute("restaurantList",restaurantList);
		
		rbservice.saveBidder(bidderRegistration.getIme(), bidderRegistration.getPrezime(), bidderRegistration.getEmail(), bidderRegistration.getPassword(), bidderRegistration.getRole(), bidderRegistration.getNazivRestorana());
		model.put("poruka","Registracija uspesno obavljena!");
		model.addAttribute("bidderRegistration", new BidderRegistration());
		return new ModelAndView("registracijaPonudjaca","model",model);
	}
	
	
	@RequestMapping(value="/restaurants")
	public ModelAndView restorani(ModelMap model){
		return new ModelAndView("restorani","model",model);
	}
	
	
	@RequestMapping(value="/restaurant/{naziv}")
	public ModelAndView showRestoran(@PathVariable String naziv,ModelMap model){
		model.put("naziv",naziv);
		RestaurantRegistration rr=rrservice.getRestaurantByName(naziv);
		model.put("restaurant", rr);
		model.addAttribute("restaurantRegistration",new RestaurantRegistration());
		return new ModelAndView("profilRestorana","model",model);
		
	}
	
	
	@RequestMapping(value="/urediProfil/{naziv1}/try")
	public ModelAndView urediProfil(@PathVariable String naziv1,@Valid RestaurantRegistration restaurantRegistration,BindingResult bindingResult,ModelMap model){
		rrValidator.validate(restaurantRegistration, bindingResult);
		if (bindingResult.hasErrors()) {	
			return new ModelAndView("profilRestorana","formErrors",bindingResult.getAllErrors());
        }
		rrservice.editRestaurantInfo(restaurantRegistration.getNaziv(),restaurantRegistration.getAdresa(),restaurantRegistration.getVrsta(),restaurantRegistration.getEmailManager());
		model.addAttribute("restaurantRegistration", new RestaurantRegistration());
		model.put("poruka", "Izmena uspesno obavljena!");
		return new ModelAndView("profilRestorana","model",model);
	}

	
	@RequestMapping(value="/employee")
	public ModelAndView showEmployeeEditor(ModelMap model){
		
		model.addAttribute("workerRegistration", new WorkerRegistration());
		return new ModelAndView("zaposleni","model",model);
	}
	
	
	@RequestMapping(value="/employeeRegistration/try")
	public ModelAndView registerEmployee(@Valid WorkerRegistration workerRegistration,BindingResult bindingResult,ModelMap model){
		
		if (bindingResult.hasErrors()) {	
			return new ModelAndView("zaposleni","formErrors",bindingResult.getAllErrors());
        }
		
		rwservice.saveWorker(workerRegistration.getIme(), workerRegistration.getPrezime(), workerRegistration.getEmail(), workerRegistration.getPassword(), workerRegistration.getRole(), workerRegistration.getDatumRodjenja(), workerRegistration.getKonfekcijskiBr(), workerRegistration.getObucaBr(),workerRegistration.getNazivRestorana());
		model.addAttribute("workerRegistration", new WorkerRegistration());
		model.put("poruka", "Registracija uspesno obavljena!");
		return new ModelAndView("zaposleni","model",model);
	}
	
	
	
	
}
