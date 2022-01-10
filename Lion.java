import java.awt.*;
import java.util.Random;

public class Lion extends Critter {

    private int moveCounter;
    private Color currentColor;
    private Color[] colors = {Color.RED, Color.GREEN, Color.BLUE};
    private Random random;

    public Lion() {
        moveCounter = 0;
        random = new Random();
    }

    public Color getColor() {
        if (moveCounter % 3 == 0) {
            currentColor = colors[random.nextInt(colors.length)];
        }
        return currentColor;
    }

    public String toString() {
        return "L";
    }

    public Action getMove(CritterInfo info) {

        ++moveCounter;

        if (info.getFront() == Neighbor.OTHER) {
            return Action.INFECT;
        }
        else if (info.getFront() == Neighbor.WALL || info.getRight() == Neighbor.WALL) {
            return Action.LEFT;
        }
        else if (info.getFront() == Neighbor.SAME) {
            return Action.RIGHT;
        }
        return Action.HOP;
    }
}
