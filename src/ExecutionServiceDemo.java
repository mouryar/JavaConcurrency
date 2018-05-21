import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class ExecutionServiceDemo {
	public static void main(String args[]){
		
		
		final BlockingQueue<Runnable> queue = new ArrayBlockingQueue<>(1000);
		ExecutorService executorService = new ThreadPoolExecutor(5, 5,
		        0L, TimeUnit.MILLISECONDS,
		        queue);
		
		
		Runnable runnable = () ->{
			try {
				TimeUnit.SECONDS.sleep(2);
				System.out.println(Thread.currentThread().getName());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		};
		IntStream.range(0, 30).forEach(nbr -> executorService.execute(runnable));
		executorService.shutdown();
		
	}

}
