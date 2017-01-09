/**
 * Created by lotrik on 09.01.2017.
 */
public class Cockroach {

    private int speed;

    private double time;

    private int distance = 100;

    //Переменная для остановки\запуска бега после каждого этапа
    private boolean cocroachRunning = true;
    //Переменная для остановки потока после всех этапов гонки
    private boolean threadRunning = true;

    private Thread startRace = new Thread(new Run());

    void setSpeed(int speed) {
        this.speed = speed;
    }

    int getSpeed() {
        return speed;
    }

    double getTime() {
        return time;
    }

    void start() {

        startRace.start();

    }

    void restart() {

        time = 0;
        cocroachRunning = true;

    }

    void stopThread() {

        threadRunning = false;

    }

    private class Run implements Runnable {

        @Override
        public void run() {

            while (threadRunning) {
                while (cocroachRunning) {

                    try {
                        Thread.sleep((distance / speed) * 1000);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }

                    time = (double) distance / speed;

                    cocroachRunning = false;
                    break;
                }

                try {
                    Thread.sleep(1);
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
        }
    }
}
