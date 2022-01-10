import java.awt.Color;

public class Giant extends Critter{
    private Color color;
    public String[] stringOptions = {"fee", "fie", "foe", "fum"};
    public int moveCounter;

    public Giant() {
        color = Color.GRAY;
    }

    public Color getColor() {
        return color;
    }

    public String toString() {
        return stringOptions[moveCounter%24/6];
    }

    public Action getMove(CritterInfo info) {
        ++moveCounter;

        if (info.getFront() == Neighbor.OTHER) {
            return Action.INFECT;
        }
        else if (info.getFront() == Neighbor.EMPTY) {
            return Action.HOP;
        }
        return Action.RIGHT;

    }
}
