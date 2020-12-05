import coloredPegs.*;

import java.util.LinkedList;
import java.util.Scanner;

public class main {

    public static void main(String args[]) {
        LinkedList<peg> pegBoard = new LinkedList<>();
        for (int i = 0; i < 4; i++) {
            pegBoard.add(new peg());
        }
        for (int i = 0; i < 4; i++) {
          System.out.println(pegBoard.get(i).color());
        }
        System.out.println("Take your guess");

        Scanner sc = new Scanner(System.in);
        sc.nextLine();
        if (sc.next().equals('b')) {
          if (pegBoard.get(0).isBlue()) {
            System.out.print("Correct");
          } else {
            System.out.print("Wrong");
          }
        }






    }
}