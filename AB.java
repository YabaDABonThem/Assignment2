import java.awt.Color;
import java.util.Random;

public class AB extends Critter { // class name set to my initials
    // declare private fields
    private Color color;
    private Random random;

    public AB() {
        // set default values
        color = Color.BLUE;
        random = new Random();
    }

    public Color getColor() {
        return color;
    } // return color

    public String toString() {
        return "AB";
    } // return initials

    public Action getMove(CritterInfo info) {
        // if enemy in front then infect
        if (info.getFront() == Neighbor.OTHER) {
            return Action.INFECT;
        }
        // if nothing in front then hop
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
