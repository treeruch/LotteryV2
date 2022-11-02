package com.app.teeruch.lotteryV2;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.app.teeruch.utility.Mapping;

@RestController
public class WelcomeController {
	
    @GetMapping("/login")
    public ModelAndView Welcome() {
    	ModelAndView modelAndView = new ModelAndView(Mapping.PAGE.LOGIN);
        return modelAndView;
    }
    
    @GetMapping("/dashboard")
    public ModelAndView Dashboard() {
    	ModelAndView modelAndView = new ModelAndView(Mapping.PAGE.DASHBOARD);
    	System.out.println("dashboard");
        return modelAndView;
    }
	
	/*
	 * @RequestMapping(method = RequestMethod.GET, value = Mapping.CONTROLLER.LOGIN)
	 * public ModelAndView Welcome() { ModelAndView modelAndView = new
	 * ModelAndView(Mapping.PAGE.LOGIN); return modelAndView; }
	 */

}
