/**
 * Event.java
 *
 * Author: Nadia Ahmed
 * Date: 2023-05-03
 */
package components;

public class Event {
    private String timestamp;
    private int floorNum;
    private Direction direction;
    private int carButton;

    public Event(String timestamp, int floorNum, Direction direction, int carButton) {
        this.timestamp = timestamp;
        this.floorNum = floorNum;
        this.direction = direction;
        this.carButton = carButton;
    }

    public void printEvent() {
        System.out.print(timestamp + " ");
        System.out.print(floorNum + " ");
        System.out.print(direction + " ");
        System.out.println(carButton);
    }
}
