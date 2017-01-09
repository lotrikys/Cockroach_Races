import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Random;

/**
 * Created by lotrik on 09.01.2017.
 */
public class Judge {

    private Cockroach firstCocroach;
    private Cockroach secondCocroach;
    private Cockroach thirdCocroach;
    private Cockroach fourthCocroach;
    private Cockroach fifthCocroach;

    private boolean running = true;

    private NumberFormat formatter;

    //Инициализация тараканов, установка рандомной скорости каждому таракану
    void initialize() {

        firstCocroach = new Cockroach();
        firstCocroach.setSpeed(new Random().nextInt(20 - 10 + 1) + 10);

        secondCocroach = new Cockroach();
        secondCocroach.setSpeed(new Random().nextInt(20 - 10 + 1) + 10);

        thirdCocroach = new Cockroach();
        thirdCocroach.setSpeed(new Random().nextInt(20 - 10 + 1) + 10);

        fourthCocroach = new Cockroach();
        fourthCocroach.setSpeed(new Random().nextInt(20 - 10 + 1) + 10);

        fifthCocroach = new Cockroach();
        fifthCocroach.setSpeed(new Random().nextInt(20 - 10 + 1) + 10);

        startRace();
    }

    //Старт 3-х этапов гонки тараканов
    private void startRace() {

        formatter = new DecimalFormat("#.00");

        for (int i = 1; i <= 3; i++) {

            System.out.println("Start " + i + " stage");

            if (i == 1) {

                firstCocroach.start();
                secondCocroach.start();
                thirdCocroach.start();
                fourthCocroach.start();
                fifthCocroach.start();

            } else {

                firstCocroach.setSpeed(new Random().nextInt(20 - 10 + 1) + 10);
                firstCocroach.restart();

                secondCocroach.setSpeed(new Random().nextInt(20 - 10 + 1) + 10);
                secondCocroach.restart();

                thirdCocroach.setSpeed(new Random().nextInt(20 - 10 + 1) + 10);
                thirdCocroach.restart();

                fourthCocroach.setSpeed(new Random().nextInt(20 - 10 + 1) + 10);
                fourthCocroach.restart();

                fifthCocroach.setSpeed(new Random().nextInt(20 - 10 + 1) + 10);
                fifthCocroach.restart();
            }

            while (running) {

                if (fifthCocroach.getTime() > 1 && secondCocroach.getTime() > 1 && thirdCocroach.getTime() > 1 &&
                        fourthCocroach.getTime() > 1 && fifthCocroach.getTime() > 1) {

                    System.out.println("Stage " + i + " complete");

                    break;
                }

                System.out.print(".");
                try {
                    Thread.sleep(400);
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }

            }

            System.out.println("Results:");
            System.out.println("First cocroach: " + formatter.format(firstCocroach.getTime()) +
                    " seconds with speed: " + firstCocroach.getSpeed());

            System.out.println("Second cocroach: " + formatter.format(secondCocroach.getTime()) +
                    " seconds with speed: " + secondCocroach.getSpeed());

            System.out.println("Third cocroach: " + formatter.format(thirdCocroach.getTime()) +
                    " seconds with speed: " + thirdCocroach.getSpeed());

            System.out.println("Fourth cocroach: " + formatter.format(fourthCocroach.getTime()) +
                    " seconds with speed: " + fourthCocroach.getSpeed());

            System.out.println("Fifth cocroach: " + formatter.format(fifthCocroach.getTime()) +
                    " seconds with speed: " + fifthCocroach.getSpeed());
            System.out.println();
        }

        firstCocroach.stopThread();
        secondCocroach.stopThread();
        thirdCocroach.stopThread();
        fourthCocroach.stopThread();
        fifthCocroach.stopThread();
    }

}
