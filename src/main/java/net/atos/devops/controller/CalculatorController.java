package net.atos.devops.controller;

import net.atos.devops.service.CalculatorService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import org.apache.log4j.Logger;

@Controller
public class CalculatorController  {
	
	final static Logger logger = Logger.getLogger(CalculatorController.class);
	
	@Autowired
	private CalculatorService calculatorServiceImpl;

	
	@RequestMapping(value="/calculator/add",method = RequestMethod.GET)
	public String add(Model model,@RequestParam("addParam1") String param1,@RequestParam("addParam2") String param2){
		logger.info("CalculatorController.Add()");
		String viewName="calculator";
		int result = calculatorServiceImpl.add(Integer.parseInt(param1),Integer.parseInt(param2)); 
		model.addAttribute("addResult",result);
		model.addAttribute("addParam1",param1);
		model.addAttribute("addParam2",param2);
		return viewName;
	}
	@RequestMapping(value="/calculator/subtract",method = RequestMethod.GET)
	public String subtract(Model model,@RequestParam("subParam1") String param1,@RequestParam("subParam2") String param2){
		logger.info("CalculatorController.subtract()");
		String viewName="calculator";
		int result = calculatorServiceImpl.subtract(Integer.parseInt(param1),Integer.parseInt(param2)); 
		model.addAttribute("subResult",result);
		model.addAttribute("subParam1",param1);
		model.addAttribute("subParam2",param2);
		return viewName;
	}
	@RequestMapping(value="/calculator/multiply",method = RequestMethod.GET)
	public String multiply(Model model,@RequestParam("mulParam1") String param1,@RequestParam("mulParam2") String param2){
		logger.info("CalculatorController.multiply()");
		String viewName="calculator";
		int result = calculatorServiceImpl.multiply(Integer.parseInt(param1),Integer.parseInt(param2)); 
		model.addAttribute("mulResult",result);
		model.addAttribute("mulParam1",param1);
		model.addAttribute("mulParam2",param2);
		return viewName;
	}
	@RequestMapping(value="/calculator/divide",method = RequestMethod.GET)
	public String divide(Model model,@RequestParam("divParam1") String param1,@RequestParam("divParam2") String param2){
		logger.info("CalculatorController.divide()");
		String viewName="calculator";
		double result = calculatorServiceImpl.divide(Integer.parseInt(param1),Integer.parseInt(param2)); 
		model.addAttribute("divResult",result);
		model.addAttribute("divParam1",param1);
		model.addAttribute("divParam2",param2); 
		return viewName;
	}
}
