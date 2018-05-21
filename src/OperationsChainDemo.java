import java.util.concurrent.CompletableFuture;

public class OperationsChainDemo {
	public static void main(String args[]) {
		CompletableFuture<Integer> future = new CompletableFuture<>();
		
		future
			.thenApply(data -> data * 2)
			.thenAccept(data -> System.out.println(data));
		
		Sleep.sleep(100);
		
		future.complete(100);
	}
}
