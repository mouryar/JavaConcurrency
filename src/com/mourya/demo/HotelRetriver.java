package com.mourya.demo;

public class HotelRetriver implements IRetriver{

	@Override
	public IProduct getProduct(String id) {
		Sleep.sleep(1000);
		System.out.println("Executing Hotel retriver");
		return new IHotel() {
		};
	}

	
}
