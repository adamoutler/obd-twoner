
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;


public class Synchronizer {

  Timer timer;

  public Synchronizer(int seconds) {
    
    Status.UpdateTimer.schedule(new Updater(), 1);
  }

  class Updater extends TimerTask {
        @Override
    public void run() {

      //timer.cancel(); //Not necessary because we call System.exit
      System.exit(0); //Stops the AWT thread (and everything else)
    }
  }

  public static void main() {
    int interval = 1000; // 10 sec
    Date timeToRun = new Date(System.currentTimeMillis() + interval);
    Timer timer = new Timer();
    
    timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("woot");
              // Updater();
            }


        }, timeToRun);
  }

  private static void Updater() {
   ///NewApplication.destroy();

   main();
  }

}



