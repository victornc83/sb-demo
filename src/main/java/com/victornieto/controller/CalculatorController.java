package com.victornieto.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.victornieto.model.Calculator;

@RestController
@RequestMapping("/api/v1/calculator")
public class CalculatorController {

	 private static final String PATTERN = "^-?+\\d+.?+\\d*$";

	    @RequestMapping("/add")
	    public Calculator add(@RequestParam(value = "oper1") String a, @RequestParam(value = "oper2") String b) {
	    	List<String> input = new ArrayList();
	    	input.add(a);
	    	input.add(b);
	    	List<String> output = new ArrayList();
	    	String addValue = "" ;
	    	if (a != null && b != null && a.matches(PATTERN) && b.matches(PATTERN)) {
	            addValue = String.valueOf(Double.valueOf(a) + Double.valueOf(b));
	        } else {
	            addValue = "Base or/and Exponent is/are not set to numeric value.";
	        }
	    	output.add(addValue);
	    	return new Calculator(input, output, "add") ;
	    }

	    @RequestMapping("/sub")
	    public Calculator sub(@RequestParam(value = "oper1") String a, @RequestParam(value = "oper2") String b) {
	    	List<String> input = new ArrayList();
	    	input.add(a);
	    	input.add(b);
	    	List<String> output = new ArrayList();
	    	String addValue = "" ;
	    	if (a != null && b != null && a.matches(PATTERN) && b.matches(PATTERN)) {
	            addValue = String.valueOf(Double.valueOf(a) - Double.valueOf(b));
	        } else {
	            addValue = "Base or/and Exponent is/are not set to numeric value.";
	        }
	    	output.add(addValue);
	    	return new Calculator(input, output, "sub") ;
	    }

	 	@RequestMapping("/power")
	    public Calculator pow(@RequestParam(value = "base") String b, @RequestParam(value = "exponent") String e) {
	        List<String> input = new ArrayList();
	        input.add(b);
	        input.add(e);
	        List<String> output = new ArrayList();
	        String powValue = "";
	        if (b != null && e != null && b.matches(PATTERN) && e.matches(PATTERN)) {
	            powValue = String.valueOf(Math.pow(Double.valueOf(b), Double.valueOf(e)));
	        } else {
	            powValue = "Base or/and Exponent is/are not set to numeric value.";
	        }
	        output.add(powValue);
	        return new Calculator(input, output, "power");
	    }

	    @RequestMapping(value = "/sqrt/{value:.+}", method = RequestMethod.GET)
	    public Calculator sqrt(@PathVariable(value = "value") String aValue) {
	        List<String> input = new ArrayList();
	        input.add(aValue);
	        List<String> output = new ArrayList();
	        String sqrtValue = "";
	        if (aValue != null && aValue.matches(PATTERN)) {
	            sqrtValue = String.valueOf(Math.sqrt(Double.valueOf(aValue)));
	        } else {
	            sqrtValue = "Input value is not set to numeric value.";
	        }
	        output.add(sqrtValue);
	        return new Calculator(input, output, "sqrt");
	    }

}
