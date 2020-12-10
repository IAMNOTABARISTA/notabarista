package com.notabarista.authentication.controller;
import com.notabarista.authentication.service.Userservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.notabarista.authentication.model.User;
import org.springframework.ui.ModelMap;
import javax.validation.Valid;

@Controller
public class AuthenticationController {

    @Autowired
    Userservice userService;
    @RequestMapping(value = { "/login" }, method = RequestMethod.GET)
    public ModelAndView login() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("login"); // resources/template/login.html
        return modelAndView;
    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public ModelAndView register() {
        ModelAndView modelAndView = new ModelAndView();
         User user = new User();
         modelAndView.addObject("user", user);
         modelAndView.setViewName("register"); // resources/template/register.html
        return modelAndView;
    }
//URL  mapping for /home after login.
 @RequestMapping(value = "/home", method = RequestMethod.GET)
    public ModelAndView home() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("home"); // resources/template/home.html
        return modelAndView;
    }
//URL mapping for /admin after login
@RequestMapping(value = "/admin", method = RequestMethod.GET)
public ModelAndView admin() {
    ModelAndView modelAndView = new ModelAndView();
    modelAndView.setViewName("admin"); // resources/template/home.admin
    return modelAndView;
}

    @RequestMapping(value ="/register", method= RequestMethod.POST )
    public ModelAndView registerUser(@Valid User user, BindingResult bindingresult, ModelMap modelMap) {
        ModelAndView modelAndView = new ModelAndView();
// checking for validation
        if (bindingresult.hasErrors()) {
    modelAndView.addObject("successMessage", "There is an error!!");
// to show the binding result to the screen. add it to model map.
          modelMap.addAttribute("bindingresult", bindingresult);

        }
        else if ( userService.IsUserAlreadyPresent(user)) {
        modelAndView.addObject("successMessage", "user already exists!");
        }
        // if the binding errors doesn't have errors. User will be saved to DB.
else {
            userService.saveUser(user);
            modelAndView.addObject("successMessage", "user created successfully!");
        }
// save user registration.
            modelAndView.addObject("user", new User());
            modelAndView.setViewName(("register"));
            return modelAndView;
        }
    }
