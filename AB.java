import java.awt.Color;
import java.util.Random;

public class AB extends Critter {
    private Color color;
    private Random random;

    public AB() {
        color = Color.BLUE;
        random = new Random();
    }

    public Color getColor() {
        return color;
    }

    public String toString() {
        return "AB";
    }

    public Action getMove(CritterInfo info) {
        if (info.getFront() == Neighbor.OTHER) {
            return Action.INFECT;
        }
        else if (info.getFront() == Neighbor.EMPTY) {
            return Action.HOP;
        }
        // If you can't move forward then randomly turn left or right
        else if (random.nextBoolean()) {
            return Action.RIGHT;
        }
        return Action.LEFT;
    }
}
