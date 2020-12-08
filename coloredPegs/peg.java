package coloredPegs;

import java.util.Random;

public class peg {
    private String color;
    private boolean blue;
    private boolean orange;
    private boolean green;
    private boolean pink;
    private boolean yellow;
    private boolean red;


    public peg() {
        Random random = new Random();
        int i = Math.abs(random.nextInt()) % 5;

        if (i == 0) {
            blue = true;
            color = "blue";
        } else if (i == 1) {
            orange = true;
            color = "orange";
        } else if (i == 2) {
            green = true;
            color = "green";
        } else if (i == 3) {
            pink = true;
            color = "pink";
        } else if (i == 4) {
            yellow = true;
            color = "yellow";
        } else if (i == 5) {
            red = true;
            color = "red";
        }
    }

    public String color() {
        return color;
    }

    public boolean isBlue() {
        return blue;
    }
    public boolean isOrange() {
        return orange;
    }
    public boolean isGreen() {
        return green;
    }
    public boolean isPink() {
        return pink;
    }
    public boolean isYellow() {
        return yellow;
    }
    public boolean isRed() {
        return red;
    }



}