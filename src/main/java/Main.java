import javax.sound.midi.Soundbank;
import java.util.concurrent.TimeUnit;

public class Main {

  public static void main(String[] args) {
    System.out.println("Hello World");


    Runnable task = () -> {
      String threadName = Thread.currentThread().getName();
      System.out.println(threadName);
    };

    task.run();

    Thread thread = new Thread(task);

    thread.start();

    System.out.println("Done");



    Runnable task1 = () -> {
      try{
        String name = Thread.currentThread().getName();
        System.out.println(name);

        TimeUnit.SECONDS.sleep(1);

        System.out.println(String.format("Second time %s", name));

      }catch(InterruptedException ie) {
        ie.printStackTrace();
      }


    };

    Thread newThread = new Thread(task1);
    newThread.start();



  }

}
