package restaurant.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import restaurant.domain.RestaurantRegistration;
import restaurant.domain.UserLogin;
import restaurant.domain.UserRegistration;
import restaurant.service.RegistratedRestaurantsService;
import restaurant.service.RegistratedUsersService;

@Controller
@RequestMapping("/home")
public class HomeController {
	
	@Autowired
	private RegistratedUsersService service;
	
	@Autowired
	private RegistratedRestaurantsService rservice;
	
	@GetMapping
	public ModelAndView showHome(HttpServletRequest request,ModelMap model){
		UserLogin user=(UserLogin) request.getSession().getAttribute("logged");
		UserRegistration userR=service.getUser(user.getEmail());
		model.put("userR", userR);

		List<UserRegistration>ur=service.getAllRManagers();
		request.getSession().setAttribute("restaurantManagers", ur);
		model.put("restaurantManagers", ur);
		
		List<RestaurantRegistration>rr=rservice.getAllFromRM(user.getEmail());
		request.getSession().setAttribute("restaurantList",rr);
		model.put("restaurantList", rr);
		return new ModelAndView("home","model",model);
	}
	
	@RequestMapping(value="/logout")
	public ModelAndView logout(ModelMap model,HttpServletRequest request){
		request.getSession().invalidate();
		return new ModelAndView("redirect:/login");
	}
	
	
}
