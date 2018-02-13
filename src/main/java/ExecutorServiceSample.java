import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ExecutorServiceSample {


  public static void main(String[] args) {

    ExecutorService executorService = Executors.newSingleThreadExecutor();

    executorService.submit(()->{
      String threadName = Thread.currentThread().getName();

      System.out.println(threadName);
    });

    try{
      System.out.println("Attempting shut down");
      executorService.shutdown();

      executorService.awaitTermination(5,TimeUnit.SECONDS);

    }catch (InterruptedException ie) {
      System.out.println("Task Interrupted");
    }
    finally {
      if (!executorService.isTerminated()) {
        System.out.println("Cancel all tasks");
      }
      executorService.shutdownNow();
      System.out.println("shut down completed");
    }

  }

}
