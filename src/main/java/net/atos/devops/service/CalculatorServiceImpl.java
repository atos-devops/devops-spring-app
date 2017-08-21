package net.atos.devops.service;

import org.springframework.stereotype.Service;

import org.apache.log4j.Logger;

@Service
public class CalculatorServiceImpl implements CalculatorService {
	final static Logger logger = Logger.getLogger(CalculatorServiceImpl.class);
	@Override
	public int add(int param1, int param2) {
		logger.info("CalculatorServiceImpl.add("+param1+","+param2+")");
		return (param1+param2);
	}

	@Override
	public int subtract(int param1, int param2) {
		logger.info("CalculatorServiceImpl.subtract("+param1+","+param2+")");
		return (param1 - param2);
	}

	@Override
	public int multiply(int param1, int param2) {
		logger.info("CalculatorServiceImpl.multiply("+param1+","+param2+")");
		return (param1 * param2);
	}

	@Override
	public double divide(int param1, int param2) {
		logger.info("CalculatorServiceImpl.divide("+param1+","+param2+")");
		return (param1/param2);
	}

	
}
