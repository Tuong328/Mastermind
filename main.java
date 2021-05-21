import coloredPegs.*;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class main {

    public static void main(String args[]) {
        /** Rules: A random board of four colors is generated
         * from a total of 6 different colors. The objective
         * of the game is to guess what the order of the colors
         * are in 6 tries. With each guess, if you chose a correct
         * color and it is in the correct spot, you will get a black peg,
         * if you get a white peg, that means that you have a correct
         * color, but it is not in the right spot.
         * Colors in this variation of game are: blue, orange, green, pink, yellow, red,
         * We are using the first letter of the color: b, o, g, p, y, r
         * Example Game: red -> red -> blue -> orange
         *
         * Example Guess 1: borb, will return 4 white pegs;
         * Guess 1 Explanation: user chose the right colors, but they are
         * not in the right order/position;
         *
         * Example Guess 2: rrbb, will return 3 black pegs
         * Guess 2 Explanation: red, red, and blue are the correct guesses,
         * but the last color is orange;
         *
         * **/


        //Board is a linked list of pegs, and this for loop generates our random board;
        LinkedList<peg> pegBoard = new LinkedList<>();
        for (int i = 0; i < 4; i++) {
            pegBoard.add(new peg());
        }
        System.out.println("Board generated, Good Luck!");

        //This for loop gives us our 4 colors in text if we want them
       /* for (int i = 0; i < 4; i++) {
            System.out.println(pegBoard.get(i).color());
        }*/

        System.out.println("Take your guess");
        System.out.println("6 Letters are: p, o, g, b, y, r");

        //This for loop gives us our correct answer;
        String correctAnswer = "";
        for (int i = 0; i < 4; i++) {
            correctAnswer += pegBoard.get(i).color().charAt(0);
        }

        //Scanners for User Inputs;
        Scanner scanner = new Scanner(System.in);


        /** Keep in mind that the user gets 6 turns
         * they need to know if they have the right
         * color pegs or if they are in the right spot**/
        //String can only contain: b, o, g, p, y, r
        ArrayList<Character> whiteList = new ArrayList<>();
        whiteList.add('b');
        whiteList.add('o');
        whiteList.add('g');
        whiteList.add('p');
        whiteList.add('y');
        whiteList.add('r');


        String input = "";
        int guessesLeft = 6;
        while (guessesLeft > 0) {
            input = scanner.nextLine();
            //Invalid Input;
            if (input.length() != 4 || !inputCheck(input, whiteList)) {
                System.out.println("Invalid guess, you do not lose any attempts");
                guessesLeft++;
            } else if (input.equals(correctAnswer)) {
                System.out.println("4 Black Pegs");
                System.out.println("Correct! Game over, try another!");
                guessesLeft--;
                System.out.println("You finished with " + guessesLeft + " guesses left");
                guessesLeft = -10; //Arbitary number for later method that signifies end of game;
            } else if (!input.equals(correctAnswer)) {
                System.out.println(BWPegs(input, correctAnswer));
            }
            guessesLeft--;
            if (guessesLeft != -11) {
                System.out.println("You have " + (guessesLeft) + " guesses left");
            }
        }
        System.out.println("Correct Answer is: " + correctAnswer);
        scanner.close();

    }

    //Helper methods
    static boolean inputCheck(String input, ArrayList<Character> whiteList) {
        boolean isValid = true;
        for (int i = 0; i < input.length(); i++) {
            if (!whiteList.contains(input.charAt(i))) {
                isValid = false;
            }
        }

        return isValid;
    }


    static String BWPegs(String input, String correctAnswer) {
        int black = 0;
        int white = 0;
        //For black pegs
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == correctAnswer.charAt(i)) {
                black++;
            }
        }
        //For white pegs
        int b = 0;
        int o = 0;
        int g = 0;
        int p = 0;
        int y = 0;
        int r = 0;
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == 'b') {
                b++;
            }
            if (input.charAt(i) == 'o') {
                o++;
            }
            if (input.charAt(i) == 'g') {
                g++;
            }
            if (input.charAt(i) == 'p') {
                p++;
            }
            if (input.charAt(i) == 'y') {
                y++;
            }
            if (input.charAt(i) == 'r') {
                r++;
            }
        }
        //Correct Answer
        int b1 = 0;
        int o1 = 0;
        int g1 = 0;
        int p1 = 0;
        int y1 = 0;
        int r1 = 0;
        for (int i = 0; i < correctAnswer.length(); i++) {
            if (correctAnswer.charAt(i) == 'b') {
                b1++;
            }
            if (correctAnswer.charAt(i) == 'o') {
                o1++;
            }
            if (correctAnswer.charAt(i) == 'g') {
                g1++;
            }
            if (correctAnswer.charAt(i) == 'p') {
                p1++;
            }
            if (correctAnswer.charAt(i) == 'y') {
                y1++;
            }
            if (correctAnswer.charAt(i) == 'r') {
                r1++;
            }
        }
        while (b > 0 && b1 > 0) {
            white++;
            b--;
            b1--;
        }
        while (o > 0 && o1 > 0) {
            white++;
            o--;
            o1--;
        }
        while (g > 0 && g1 > 0) {
            white++;
            g--;
            g1--;
        }
        while (p > 0 && p1 > 0) {
            white++;
            p--;
            p1--;
        }
        while (y > 0 && y1 > 0) {
            white++;
            y--;
            y1--;
        }
        while (r > 0 && r1 > 0) {
            white++;
            r--;
            r1--;
        }

        white = white - black; //Counts blacks as whites so subtract them.
        String BW = black + " Black Pegs, " + white + " White Pegs";
        return BW;
    }
}