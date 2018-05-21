import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class AsynchronousFutureDemo {
	
	public static void main(String args[]) throws InterruptedException, ExecutionException{
		Future<Integer> future = new SquareCalculator().calculate(10);
		Integer result = future.get();
				
		Thread.sleep(1000);
		
		Future<Integer> future1 = new SquareCalculator().calculate(10);
		Integer result1 = future1.get();
	}
}



class SquareCalculator {    
    
    private ExecutorService executor 
      = Executors.newFixedThreadPool(10);
     
    public Future<Integer> calculate(Integer input) {        
        return executor.submit(() -> {
        	System.out.println(Thread.currentThread().getName());
            Thread.sleep(1000);
            return input * input;
        });
    }
}

