import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CompletableFutureDemo {
	
	public static int getNumber(){
		//Sleep.sleep(1000);
		System.out.println("GetNumber" + Thread.currentThread().getName());
		return 2;
	}
	
	public static void printNumber(Integer n) {
		System.out.println("PrintIt:" + Thread.currentThread().getName());
	}
	public static void main(String args[]) throws InterruptedException, ExecutionException {
		
		CompletableFuture<Integer> future = CompletableFuture.supplyAsync(CompletableFutureDemo::getNumber);
		
		future.thenAccept(CompletableFutureDemo::printNumber);
		Sleep.sleep(1000);
		System.out.println("Main: " + Thread.currentThread());
	}
	
	
}
