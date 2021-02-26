import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class WorkedThread implements Runnable{
    private String command;

    Random random = new Random();
    int randomNum = random.nextInt(9001)+1000; // create a new time delay between 1 and 10 sec (int)
    double randomDouble = randomNum; // convert int random time to double to show in results

   public WorkedThread(String s){
        this.command=s;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+" Start. Time = "+new Date());
        processCommand();
        System.out.println(Thread.currentThread().getName()+" was in waiting  "+  randomDouble/1000 + "sec " + "and ended at "+new Date());
    }

    //method to make thread slept for a random(1-10sec) time
    private void processCommand() {
        try {
            Thread.sleep(randomNum);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
