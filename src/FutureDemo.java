import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FutureDemo {
	
	public static void main(String[] args) throws InterruptedException, ExecutionException{
		CompletableFuture<String> future1  
		  = CompletableFuture.supplyAsync(() -> {
			  Sleep.sleep(1000);
			  return "Hello";
		  });
		CompletableFuture<String> future2  
		  = CompletableFuture.supplyAsync(() -> {
			  Sleep.sleep(1000);
			  return "Mourya";
		  });
		CompletableFuture<String> future3  
		  = CompletableFuture.supplyAsync(() -> {
			  Sleep.sleep(1000);
			  return "Kumar";
		  });
		
		long startTime = System.currentTimeMillis();
		String combined = Stream.of(future1, future2, future3)
				  .map(CompletableFuture::join)
				  .collect(Collectors.joining(" "));
		
		long stopTime = System.currentTimeMillis();
		long elapsedTime = stopTime - startTime;
	    System.out.println(elapsedTime);

		System.out.println(combined);
		
	}

}
