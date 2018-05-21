package com.mourya.demo;

import java.util.concurrent.CompletableFuture;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CombineDemo {
	
	private static IProduct processError(Throwable t) {
		throw new RuntimeException(t);
	}
	public static void main(String args[]) {
		
		
		CompletableFuture<IProduct> flightProductFuture = CompletableFuture.supplyAsync(() -> new FlightRetriver().getProduct(""))
					.exceptionally(CombineDemo::processError);
		CompletableFuture<IProduct> hotelProductFuture = CompletableFuture.supplyAsync(() -> new CarRetriver().getProduct(""));
		CompletableFuture<IProduct> carProductFuture = CompletableFuture.supplyAsync(() -> new HotelRetriver().getProduct(""));
		
		long startTime = System.currentTimeMillis();
		Stream.of(flightProductFuture, hotelProductFuture, carProductFuture)
			.map(CompletableFuture::join)
			.collect(Collectors.toList()).size();
			
		long endTime = System.currentTimeMillis();
		
		System.out.println("Execution time" + (endTime - startTime));
		
		
	}

}
