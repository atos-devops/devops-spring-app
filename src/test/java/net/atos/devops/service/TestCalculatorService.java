package net.atos.devops.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import net.atos.devops.config.AppConfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.Matchers.is;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {AppConfig.class})
public class TestCalculatorService {
	
	@Autowired
    CalculatorService calculatorServiceImpl;

	@Test
    public void testAddSuccess() {

        //assert correct type/impl
        assertThat(calculatorServiceImpl, instanceOf(CalculatorService.class));
        
        int param1 = 10;
        int param2 = 5;
        
        //assert true
        assertThat(calculatorServiceImpl.add(param1, param2), is(15));

    }
	@Test
    public void testSubtractSuccess() {

        //assert correct type/impl
        assertThat(calculatorServiceImpl, instanceOf(CalculatorService.class));
        
        int param1 = 10;
        int param2 = 5;
        
        //assert true
        assertThat(calculatorServiceImpl.subtract(param1, param2), is(5));

    }
	@Test
    public void testMultiplySuccess() {

        //assert correct type/impl
        assertThat(calculatorServiceImpl, instanceOf(CalculatorService.class));
        
        int param1 = 10;
        int param2 = 5;
        
        //assert true
        assertThat(calculatorServiceImpl.multiply(param1, param2), is(50));

    }
	@Test
    public void testDivideSuccess() {

        //assert correct type/impl
        assertThat(calculatorServiceImpl, instanceOf(CalculatorService.class));
        
        int param1 = 10;
        int param2 = 5;
        
        //assert true
        
        assertThat(calculatorServiceImpl.divide(param1, param2), is(2.0));
    }	
}
