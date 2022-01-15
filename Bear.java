// Name: Allen Bao
// Date: 1/14/2022
// Class: CS 211
// Reason for Code: This is the code for the AB critter for the Critters Assignment

import java.awt.*;

public class Bear extends Critter {

    private boolean isBlack; // Determines the color of the bear
    private boolean isOddMove; // Determines the returned String

    public Bear(boolean isBlack) {
        this.isBlack = isBlack;

        isOddMove = true; // this is to start at "0th" move, because getMove() flips the variable
    }

    public Color getColor() {
        // use tertiary operator to avoid using if-else block
        return isBlack ? Color.BLACK : Color.WHITE;
    }

    public String toString() {
        // use tertiary operator to alternate between returning / and \ every move
        return isOddMove ? "/" : "\\";
    }

    public Action getMove(CritterInfo info) {
        isOddMove = !isOddMove; // update our move counter

        // if enemy in front then infect
        if (info.getFront() == Neighbor.OTHER) {
            return Action.INFECT;
        }
        // in nothing in front then hop, otherwise turn left
        else if (info.getFront() == Neighbor.EMPTY) {
            return Action.HOP;
        }
        return Action.LEFT;
    }

}