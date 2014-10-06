/**
 * Created by abby on 06/10/2014.
 */

import java.util.Scanner;

public class Coursework1 {

    public static void main(String[] args) {

        //fillArray
        int[] array = new int[3];
        int input;
        Scanner in = new Scanner(System.in);
        System.out.println("Please enter integer(s), and 0 when finished: ");
        input = in.nextInt();

        for(int i = 0; i < (array.length); i++) {
            if (input!= 0) {
                array[i] = input;
                System.out.println(input);
                if(i != (array.length-1)) {
                    input = in.nextInt();
                }
            }

        }

        //printArray
        for(int i = 0; i < (array.length); i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();


    }
}