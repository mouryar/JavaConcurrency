package com.mourya.demo;

import javax.management.RuntimeErrorException;

public class FlightRetriver implements IRetriver{

	@Override
	public IProduct getProduct(String id) {
		
		if(true){
			throw new RuntimeException("Error");
		}
		Sleep.sleep(2000);
		System.out.println("Executing Flight Retriver");
		return new IFlight() {
		};
	}
	
	

}
