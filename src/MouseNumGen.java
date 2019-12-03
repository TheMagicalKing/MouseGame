import com.sun.source.tree.WhileLoopTree;

import java.sql.SQLOutput;
import java.util.concurrent.ThreadLocalRandom;
import java.util.*;



public class MouseNumGen {

    int nutAmount = ThreadLocalRandom.current().nextInt(60,120);
    int nutFirstAmount = nutAmount;
    int nutChoice = (int)(Math.random()*nutAmount);
    int[] nutList = new int[nutAmount];
    boolean lost = false;


    public void NutGame(){
        Scanner input = new Scanner(System.in);
        nutList[nutChoice] = 1;
        System.out.println("The length of the array is: "+ nutList.length);
        System.out.println("The computer has this many nuts: "+nutAmount + " Computer's choice: "+nutChoice);
        int pChoice = input.nextInt();
        System.out.println(nutList[pChoice-1]);
        while (pChoice!=nutChoice){
            if (nutList[pChoice-1]==0){
                nutAmount--;
                System.out.println("You ate a nut! there is "+ nutAmount + " nuts left");
                nutList[pChoice-1] = 2;
                pChoice = input.nextInt();

            }
            else if (nutList[pChoice-1]==2){
                System.out.println("Nut "+pChoice+" has already been eaten, there was a total of " + nutFirstAmount+" nuts");
                int i;
                System.out.println("You have eaten these nuts!");
                for (i=0; i<nutList.length; i++){
                    if (nutList[i]==2){
                        System.out.print(i+1+", ");
                    }
                }
                pChoice = input.nextInt();
            }else if(nutList.length)

        }
        System.out.println("You're the mouse! You have lost with "+nutAmount+" nuts left uneaten!");



    }

}
