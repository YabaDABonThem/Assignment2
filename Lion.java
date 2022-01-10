import java.awt.*;
import java.util.Random;

public class Lion extends Critter {
    // declare fields
    private int moveCounter;
    private Color currentColor;
    private Color[] colors = {Color.RED, Color.GREEN, Color.BLUE};
    private Random random;

    public Lion() {
        // set default values
        moveCounter = 0;
        random = new Random();
    }

    public Color getColor() {
        // choose random color every 3 moves
        if (moveCounter % 3 == 0) {
            currentColor = colors[random.nextInt(colors.length)];
        }
        return currentColor;
    }

    public String toString() {
        return "L";
    }

    public Action getMove(CritterInfo info) {
        // update move counter
        ++moveCounter;

        // if enemy in front then attack
        if (info.getFront() == Neighbor.OTHER) {
            return Action.INFECT;
        }
        // if wall in front or to the right then turn left
        else if (info.getFront() == Neighbor.WALL || info.getRight() == Neighbor.WALL) {
            return Action.LEFT;
        }
        // if fellow lion in front turn right, otherwise hop
        else if (info.getFront() == Neighbor.SAME) {
            return Action.RIGHT;
        }
        return Action.HOP;
    }
}
