package com.victornieto.model;

import java.util.List;

import lombok.Data;

@Data
public class Calculator {
	String function ;
	private List<String> input ;
	private List<String> output ;

	public Calculator(List<String> input, List<String> output, String function) {
        this.function = function;
        this.input = input;
        this.output = output;
    }
}
