/**
 * Direction.java
 *
 * This file contains the definition for the Direction enum, which represents
 * the possible directions that an elevator can move. The enum includes values
 * for UP, DOWN, and NONE as well as a helper method to get the opposite direction.
 *
 * Author: Nadia Ahmed
 * Date: 2023-05-03
 */
package components;

public enum Direction {
    UP,
    DOWN,
    NONE;

    public static Direction getDirection(String string) {
        if (string.toUpperCase().equals("UP")) {
            return Direction.UP;
        }
        else if (string.toUpperCase().equals("DOWN")) {
            return Direction.DOWN;
        }
        else {
            return Direction.NONE;
        }
    }
}
