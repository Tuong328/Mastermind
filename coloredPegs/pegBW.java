package coloredPegs;

public class pegBW {
    private String color;
    private boolean black;
    private boolean white;
    private boolean empty;

    public pegBW(int status) {
        if (status == 0) {
            black = true;
            color = "black";
        }
        if (status == 1) {
            white = true;
            color = "white";
        }
        if (status == 2) {
            empty = true;
            color = "empty";
        }
    }

    public boolean isBlack() {
        return black;
    }
    public boolean isWhite() {
        return white;
    }
    public boolean isEmpty() {
        return empty;
    }
    public String color() {
        return color;
    }

}
