import com.sun.source.tree.WhileLoopTree;

import java.io.FileNotFoundException;
import java.sql.SQLOutput;
import java.util.concurrent.ThreadLocalRandom;
import java.util.*;



public class MouseNumGen {

    int nutAmount = ThreadLocalRandom.current().nextInt(10,20);
    int nutFirstAmount = nutAmount;
    int nutChoice = (int)(Math.random()*nutAmount+1);
    int winAmount = nutAmount-1;
    int[] nutList = new int[nutAmount];
    boolean lost = false;
    java.io.File file = new java.io.File("mouseLog.txt");


    public void NutGame() throws FileNotFoundException {
        Scanner input = new Scanner(System.in);
        java.io.PrintWriter output = new java.io.PrintWriter(file);
        System.out.println("The length of the array is: " + nutList.length);
        System.out.println("The computer has this many nuts: " + nutAmount + " Computer's choice: " + nutChoice);
        int pChoice = input.nextInt();
        winAmount--;
        System.out.println(winAmount);

        while (pChoice != nutChoice) {
            if (nutList[pChoice - 1] == 0) {
                nutAmount--;
                System.out.println("You ate a nut! there is " + nutAmount + " nuts left");
                nutList[pChoice - 1] = 2;
                output.println("Player chose: "+ pChoice);


                pChoice = input.nextInt();
                winAmount--;
                System.out.println(winAmount);


            } else if (nutList[pChoice - 1] == 2) {
                System.out.println("Nut " + pChoice + " has already been eaten, there was a total of " + nutFirstAmount + " nuts");
                int i;
                System.out.println("You have eaten these nuts!");
                for (i = 0; i < nutList.length; i++) {
                    if (nutList[i] == 2) {
                        System.out.print(i + 1 + ", ");
                    }
                }
                output.println("Player chose: " + pChoice + "That nut has already been eaten");

                pChoice = input.nextInt();


            } if (winAmount == 0)  {
                output.close();
                break;
            }
            output.close();

        }
            if (pChoice==nutChoice){System.out.println("You're the mouse! You have lost with " + nutAmount + " nuts left uneaten!");}
        else{ System.out.println("You've eaten all the nuts! you win!");}


        }

    }
