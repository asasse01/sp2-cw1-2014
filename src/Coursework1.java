/**
 * Created by abby on 06/10/2014.
 */

import java.util.Scanner;

public class Coursework1 {

    public static void main(String[] args) {


        int[] array1 = fillArray(3);
        int[] array2 = fillArray(3);

        printResultArray("Array 1 values: ", array1);
        printResultArray("Array 2 values: ", array2);


        //commonEls


    }


    /**
     * fillArray method fills array with user input, returns array fo unique elements
     * @param arrayLength number of elements to initialise array
     * @return array containing user input
     */
    private static int[] fillArray(int arrayLength) {

        int[] array = new int[arrayLength];
        int input;
        int i = 0;

        Scanner in = new Scanner(System.in);
        System.out.println("Please enter up to " + arrayLength + " unique integer(s), and 0 when finished: "); //remove magic num

        while (i < (array.length)) {
            input = in.nextInt();
            if (input != 0 /*&& i != (array.length)*/) {
                if (!dupeInput(input, array)) {
                    array[i] = input;
                    i++;
                }
            } else break;

        }

        return array;
    }


    /**
     * printResultArray method fills array with user input, returns array
     * @param arrayLength number of elements to initialise array
     * @param array array to return
     * @return array containing user input
     */
    private static void printResultArray(String description, int[] array){
        String resultString = "";

        for(int element : array){
            resultString += element + " ";
        }

        System.out.println(description + resultString);
    }


    /**
     * dupeInput method checks to see whether input integer is already in the array
     * @param input integer input to search for in array
     * @param array array to search
     * @return boolean value indicating presence of integer in array
     */
    public static boolean dupeInput(int input, int[] array){
        boolean duplicate = false;

        for(int i : array){
            if(input == i){
                duplicate = true;
            }
        }

        return duplicate;
    }

}