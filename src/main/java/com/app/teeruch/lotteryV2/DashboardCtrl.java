package com.app.teeruch.lotteryV2;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.app.teeruch.model.LotteryModel;
import com.app.teeruch.service.LotterService;
import com.app.teeruch.utility.Mapping;


@Controller
@RestController
@SpringBootApplication
public class DashboardCtrl {
	
	@Autowired
	private LotterService lotterService;
	
	protected Log logger = LogFactory.getLog(this.getClass());
	
    @GetMapping("/login")
    public ModelAndView Welcome() {
    	ModelAndView modelAndView = new ModelAndView(Mapping.PAGE.LOGIN);
        return modelAndView;
    }

    @PostMapping("/dashboard")
    public ModelAndView greetingSubmit() {
      ModelAndView modelAndView = new ModelAndView(Mapping.PAGE.DASHBOARD);
      
      	LotteryModel obj = lotterService.findDashboard();
		modelAndView.addObject("sumTopThree",obj.getSumTopThreePrice());
		modelAndView.addObject("sumTod",obj.getSumTodPrice());
		modelAndView.addObject("sumTopTwo",obj.getSumTopTwoPrice());
		modelAndView.addObject("sumUnderTwo",obj.getSumUnderTwoPrice());
		modelAndView.addObject("sumlottery",obj.getSumPrice());
      return modelAndView;
    }
  

}
