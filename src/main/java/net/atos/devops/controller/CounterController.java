package net.atos.devops.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import org.apache.log4j.Logger;

@Controller
public class CounterController {

	final static Logger logger = Logger.getLogger(CounterController.class);
	private static int counter = 0;
	private static final String VIEW_INDEX = "counter";
	
	@RequestMapping(value = "/counter", method = RequestMethod.GET)
	public String incrementCounter(ModelMap model) {
		logger.info("incrementCounter");
		model.addAttribute("message", "Welcome");
		model.addAttribute("counter", ++counter);
		logger.info("[welcome] counter : "+ counter);

		// Spring uses InternalResourceViewResolver and return back index.jsp
		return VIEW_INDEX;

	}

	@RequestMapping(value="/calculator")
	public ModelAndView startCalculator(){
		logger.info("CounterController.startCalculator()");		 
		return new ModelAndView("calculator");
	}

}