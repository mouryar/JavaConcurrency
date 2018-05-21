import java.util.concurrent.CompletableFuture;

public class ExceptionDemo {
	
	public static int getNumber(){
		throw new RuntimeException("I am an Idiot");
	}
	
	public static void printNumber(Integer n) {
		System.out.println("PrintIt:" + Thread.currentThread().getName());
	}
	
	public static int processError(Throwable t) {
		System.out.println("Error" + t.getMessage());
		throw new RuntimeException("I knew it");
	}
	
	public static void main(String args[]) {
		CompletableFuture.supplyAsync(ExceptionDemo::getNumber)
			.exceptionally(ExceptionDemo::processError)
			.thenApply(data -> data  * 2)
			.exceptionally(ExceptionDemo::processError)
			.thenAccept(data -> System.out.println(data));
		
	}
}
