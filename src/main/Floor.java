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
import java.util.ArrayList;

public class Floor implements Runnable {

    private Scheduler scheduler;
    private ArrayList<Event> events;
    private int floorNum;

    public Floor() {
    }

    public Floor(int floorNum, Scheduler scheduler) {
        this.floorNum = floorNum;
        this.scheduler = scheduler;
        this.events = new ArrayList<Event>();
    }

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
                for (String cell : row) {
                    System.out.println(cell);
                }
                Event event = new Event(row[0], 1,
                        Direction.getDirection(row[2]), 1);
//                events.add(event);
                event.printEvent();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        try {
            readInput();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

    public static void main(String args[]) throws InterruptedException {
        Thread floor_t = new Thread(new Floor(), "Floor Thread");
        floor_t.start();
        floor_t.join();
    }
}
