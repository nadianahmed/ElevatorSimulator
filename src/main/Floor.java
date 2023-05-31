/**
 * Direction.java
 *
 * This file contains the definition for the Floor class, which represents
 * a floor in a building. The class provides methods for ...........
 *
 * Author: Nadia Ahmed
 * Date: 2023-05-03
 */

package main;

import components.Direction;
import components.Event;

import java.io.*;
import java.util.*;

public class Floor implements Runnable {

    private Scheduler scheduler;
    private ArrayList<Event> events;
    private Queue<Event> eventQueue;
    private int floorNum;

    public Floor() {
        this.events = new ArrayList<Event>();
    }

    public Floor(int floorNum, Scheduler scheduler) {
        this.floorNum = floorNum;
        this.scheduler = scheduler;
        this.events = new ArrayList<Event>();
    }

    /**
     * Reads events from input.csv file
     * @throws FileNotFoundException
     */
    public void readInput() throws FileNotFoundException {
        String line = "";
        String[] row = null;

        try {
            // read input.csv into buffer
            BufferedReader br = new BufferedReader(new FileReader(
                    new File("src/input.csv").getAbsolutePath()));

            // read each row of data
            while( (line = br.readLine()) != null) {
                row = line.split(",");

                System.out.println(Arrays.toString(row));

                String timestamp = row[0];
                int floorNum = Integer.parseInt(row[1]);
                Direction direction = Direction.getDirection(row[2]);
                int carButton = Integer.parseInt(row[3]);

                Event event = new Event(timestamp, floorNum,
                                        direction, carButton);

                events.add(event);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void printFloorEvents() {
        if (events != null) {
            for (Event event : events) {
                event.printEvent();
            }
        } else {
            System.out.println(Thread. currentThread(). getName() + ": No Events.");
        }
    }

    @Override
    public void run() {
        try {
            readInput();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        printFloorEvents();

    }

    public static void main(String args[]) throws InterruptedException {
        Thread floor_t = new Thread(new Floor(), "Floor Thread");
        floor_t.start();
        floor_t.join();
    }
}
