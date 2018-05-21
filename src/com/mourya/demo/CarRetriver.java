package com.mourya.demo;

public class CarRetriver implements IRetriver{

	@Override
	public IProduct getProduct(String id) {
		Sleep.sleep(1000);
		System.out.println("Executing Car retriver");
		return new ICar() {
		};
	}

}
