package io.github.vartikasingh.project.calculator;

public class Add  implements Operate{
	
	@Override
	// ... is used for varchar
	public Double getResult(Double... numbers) {
		
		Double sum = 0.0;
		
		for(Double num: numbers) {
			sum += num;
		}
		return sum;
	}

}
