import java.util.Date;
import java.util.Scanner;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class main {
    public static void main(String[] args) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please set number of tasks: ");
        int number = scanner.nextInt();

        //Create an instance of ScheduledExecutorService
        ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(number);

        //schedule to run after sometime
        System.out.println("Current Time = " + new Date());
        for (int i = 0; i < number; i++) {
            Thread.sleep(1000);

            //instance of WorkedThread
            WorkedThread worker = new WorkedThread("do heavy processing");

            //create a schedule thread pool based on WorkedThread class with 0sec delay after starting
            scheduledThreadPool.schedule(worker, 0, TimeUnit.SECONDS);
        }

        //shutdown all threads
        scheduledThreadPool.shutdown();

        while (!scheduledThreadPool.isTerminated()) {
            //wait for all tasks to finish using isTerminated command
        }
        //print after all threads are finished
        System.out.println("Finished all threads");
    }
}

