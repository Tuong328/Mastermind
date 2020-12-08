import coloredPegs.*;

import java.util.LinkedList;
import java.util.Scanner;

public class main {

    public static void main(String args[]) {
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


        String input = "";
        while (!input.equals("close")) {
            input = scanner.nextLine();
            if (input.equals(correctAnswer)) {
                System.out.println("Correct! Game over, try another!");
            }
        }
        scanner.close();

    }
}