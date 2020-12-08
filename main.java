import coloredPegs.*;

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
        //This for loop gives us our 4 colors;
        for (int i = 0; i < 4; i++) {
          System.out.println(pegBoard.get(i).color());
        }
        System.out.println("Take your guess");

        //This for loop gives us our correct answer;
        String correctAnswer = "";
        for (int i = 0; i < 4; i++) {
            correctAnswer += pegBoard.get(i).color().charAt(0);
        }
        System.out.println(correctAnswer);

        //Scanners for User Inputs;
        Scanner scanner = new Scanner(System.in);
        Scanner inputs = new Scanner(System.in);

        /** Keep in mind that the user gets 6 turns
         * they need to know if they have the right
         * color pegs or if they are in the right spot**/
        //String can only contain: b, o, g, p, y, r
        char[] blackList = {'q', 'w', 'e', 't', 'u', 'i', 'a', 's', 'd', 'f', 'h', 'j', 'k', 'l', 'z', 'x', 'c', 'v', 'n', 'm'};

        String input = "";
        int guessesLeft = 6;
        while (guessesLeft > 0) {
            input = scanner.nextLine();
            //Invalid Input;
            if (input.length() != 4 || inputCheck(input, blackList)) {
                System.out.println("Invalid guess, you do not lose any attempts");
                guessesLeft++;
            }
            //Correct Guess
            if (input.equals(correctAnswer)) {
                System.out.println("4 Black Pegs");
                System.out.println("Correct! Game over, try another!");
                guessesLeft--;
                System.out.println("You finished with " + guessesLeft + " guesses left");
                guessesLeft = -10; //Arbitary number for later method;
            }
            //Incorrect Guess
            if (!input.equals(correctAnswer)) {
                //System.out.println(BWPegs(input, correctAnswer));
                //BW pegs
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
    static boolean inputCheck(String input, char[] blackList) {
        for (char v: blackList) {
            for (int i = 0; i < input.length(); i++) {
                if (input.charAt(i) == v) {
                    return true;
                }
            }
        }
        return false;
    }

    static String BWPegs(String guess, String correctAnswer) {

        String BW = "";
        return guess;
    }
}