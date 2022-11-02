package com.app.teeruch.lotteryV2;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.app.finanacial.utility.Mapping;

@RestController
public class WelcomeController {
	
    @GetMapping("/welcome")
    public ModelAndView Welcome() {
    	ModelAndView modelAndView = new ModelAndView(Mapping.PAGE.LOGIN);
        return modelAndView;
    }
	
	/*
	 * @RequestMapping(method = RequestMethod.GET, value = Mapping.CONTROLLER.LOGIN)
	 * public ModelAndView Welcome() { ModelAndView modelAndView = new
	 * ModelAndView(Mapping.PAGE.LOGIN); return modelAndView; }
	 */

}
