package main;

import property.util.ActionsForOrganisms;

import java.time.LocalTime;

/** This class is runnable and runs the born processes*/
public class FixedOrganismBornExecutionRunnable implements Runnable {
    private ActionsForOrganisms actionsForOrganisms = new ActionsForOrganisms();

    @Override
    public void run() {
        try {
            Thread.currentThread().setPriority(10);
            System.out.println(Thread.currentThread().getName() + " -------- " + Thread.currentThread().getPriority());
            System.out.println("Thread C - "+ LocalTime.now());
            actionsForOrganisms.bornHerbivores();
            actionsForOrganisms.bornPredators();
            actionsForOrganisms.growPlants();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
