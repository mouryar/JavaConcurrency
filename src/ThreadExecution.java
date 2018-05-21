import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ForkJoinPool;

public class ThreadExecution {

	public static int getNumber() {
		System.out.println("In GetNumber"+ Thread.currentThread());
		Sleep.sleep(1000);
		return 10;
	}
	
	public static void printNumber(Integer data) {
		System.out.println("In printNumber" + Thread.currentThread());
	}
	public static void main(String args[]) {
		
		ForkJoinPool pool1 = new ForkJoinPool(10);
		ForkJoinPool pool2 = new ForkJoinPool(20);
		CompletableFuture<Integer> future = CompletableFuture.supplyAsync(ThreadExecution::getNumber);
		future.thenAccept(ThreadExecution::printNumber);	
		
		Sleep.sleep(1000);
		
		System.out.println("In main");
	}
}
