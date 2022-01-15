// Name: Allen Bao
// Date: 1/14/2022
// Class: CS 211
// Reason for Code: This is the code for the AB critter for the Critters Assignment

import java.awt.Color;

public class Giant extends Critter{
    // declare fields
    private Color color;
    public String[] stringOptions = {"fee", "fie", "foe", "fum"};
    public int moveCounter;

    public Giant() {
        color = Color.GRAY;
    } // declare default values

    public Color getColor() {
        return color;
    } // return color

    public String toString() {
        // returns one of the items in the String array every 6 moves
        // integer division rounds down and mod eliminates indexOutOfBounds errors
        return stringOptions[moveCounter%(stringOptions.length*6)/6];
    }

    public Action getMove(CritterInfo info) {
        // update move counter
        ++moveCounter;

        // if enemy in front then infect
        if (info.getFront() == Neighbor.OTHER) {
            return Action.INFECT;
        }
        // if nothing in front then hop, otherwise go right
        else if (info.getFront() == Neighbor.EMPTY) {
            return Action.HOP;
        }
        return Action.RIGHT;

    }
}
