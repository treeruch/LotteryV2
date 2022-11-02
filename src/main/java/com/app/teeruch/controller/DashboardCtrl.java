package com.app.teeruch.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.app.teeruch.model.LotteryModel;
import com.app.teeruch.utility.Mapping;

@Controller
public class DashboardCtrl {
	
	protected Log logger = LogFactory.getLog(this.getClass());
	
	  @PostMapping("/login1")
	    public ModelAndView Welcome1() {
	    	ModelAndView modelAndView = new ModelAndView(Mapping.PAGE.DASHBOARD);
	    	System.out.println("Test Dashboard...");
	        return modelAndView;
	    }


	 @RequestMapping(method = RequestMethod.POST, value = "/dashboard")
	 public ModelAndView dashboard1(HttpServletRequest request,HttpSession session) { 
		ModelAndView modelAndView = new ModelAndView(Mapping.PAGE.DASHBOARD);
		logger.info("Dashboard...");
       /*  LotteryModel obj = lotterService.findDashboard();
		
		modelAndView.addObject("sumTopThree",obj.getSumTopThreePrice());
		modelAndView.addObject("sumTod",obj.getSumTodPrice());
		modelAndView.addObject("sumTopTwo",obj.getSumTopTwoPrice());
		modelAndView.addObject("sumUnderTwo",obj.getSumUnderTwoPrice());
		modelAndView.addObject("sumlottery",obj.getSumPrice()); */
		return modelAndView; 
	}
	
	
	@GetMapping("/logout")
	public ModelAndView logout(String name, Model model) {
		ModelAndView modelAndView = new ModelAndView(Mapping.PAGE.LOGIN);
		logger.info("Log out...");
		return modelAndView; 
	}
	
}
