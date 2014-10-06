/**
 * Created by abby on 06/10/2014.
 */

import java.util.Scanner;

public class Coursework1 {

    public static void main(String[] args) {
        int[] array1 = fillArray(10);
        int[] array2 = fillArray(10);
        int[] commonData = compareCommon(array1, array2);

        printResultArray("Array 1 values: ", array1);
        printResultArray("Array 2 values: ", array2);
        printResultArray("Common data is: ", commonData);
        System.out.println("Number of common data is: " + commonData.length);


    }


    /**
     * fillArray method fills array with user input, returns array of unique elements
     * @param arrayLength number of elements to initialise array
     * @return array containing user input
     */
    private static int[] fillArray(int arrayLength) {
        int[] maxArray = new int[arrayLength];
        int input;
        int i = 0;

        Scanner in = new Scanner(System.in);
        System.out.println("Please enter up to " + arrayLength + " unique integer(s), and 0 when finished: "); //remove magic num

        while (i < (maxArray.length)) {
            input = in.nextInt();
            if (input != 0) {
                if (!dupeInput(input, maxArray)) {
                    maxArray[i] = input;
                    i++;
                } else System.out.println("That number has already been entered.");

            } else break;

        }

        int[] array = fitArray(maxArray);

        return array;
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


    /**
     * fitArray method copies elements from original array into new array with length corresponding to number of
     * elements not equal to 0.
     * avoids use of Arrays class, as required in coursework brief
     * @param longArray array to be copied
     * @return fitArray array with required number of indices
     */
    private static int[] fitArray(int[] longArray) {
        int size = 0;

        for(int element : longArray){
            if (element != 0){ //remove magic num
                size++;
            }
        }

        int[] fitArray = new int[size];
        System.arraycopy(longArray, 0, fitArray, 0, (size));

        return fitArray;
    }


    /**
     * printResultArray method fills array with user input, returns array
     * avoids use of Arrays class, as required in coursework brief
     * @param description description of array
     * @param array array to print
     */
    private static void printResultArray(String description, int[] array){
        String resultString = "";

        for(int element : array){
            resultString += element + " ";
        }

        System.out.println(description + resultString);
    }

    //tesing
    private static int[] compareCommon(int[] array1, int[] array2){ //fix common
        int arrayLength;
        int k = 0;

        if(array1.length >= array2.length){
            arrayLength = array1.length;
        } else arrayLength = array2.length;

        int[] maxArray = new int[arrayLength];
        for(int i : array1){
            for(int j : array2){
                if(i == j){
                    if (!dupeInput(i, maxArray)) {
                        if (k < maxArray.length) {
                            maxArray[k] = j;
                            k++;
                        }
                    }
                }
            }

        }

        int[] common = fitArray(maxArray);

        return common;

        //printResultArray("Common: ", common);



    }


}