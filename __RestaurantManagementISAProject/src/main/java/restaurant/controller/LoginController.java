package restaurant.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.ServerProperties.Session;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.ModelAndView;


import restaurant.domain.UserLogin;
import restaurant.service.RegistratedUsersService;
import restaurant.validator.LoginValidator;
import restaurant.validator.RegistrationUserValidator;


@Controller
@RequestMapping("/login")
public class LoginController {
	
	@Autowired
	private RegistratedUsersService service;
	
	@Autowired
    private LoginValidator logValidator;
	
	
	
	@GetMapping
	public ModelAndView showLoginPage(ModelMap model){
		model.addAttribute("userLogin", new UserLogin());
		return new ModelAndView("login","model",model);
		
	}
	
	 
	@RequestMapping(value="/try",method=RequestMethod.POST)
	public ModelAndView tryLogin(@Valid UserLogin userLogin,BindingResult bindingResult,ModelMap model,HttpServletRequest request){	
		logValidator.validate(userLogin, bindingResult);
		if (bindingResult.hasErrors()) {	
			return new ModelAndView("login","model",model);
        }
		if(service.findUser2(userLogin.getEmail(),userLogin.getPassword())){
			HttpSession session=request.getSession();
			session.setAttribute("logged", userLogin);
			
			//LOGOVANI KORISNIK JE U SESIJI POD NAZIVOM "LOGGED"
			
			return new ModelAndView("redirect:/home");
		}
		else{
			return new ModelAndView("login","model",model);
		}
		
	}
	
	
}
