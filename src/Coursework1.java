/**
 * @author Abby Sassel
 * @since 06/10/2014
 *
 * Given two arrays of integers, Coursework1 program performs the necessary array operations to print:
 *  - the values which occur in both arrays
 *  - those which occur only in the first array
 *  - and those which occur only in the second.
 *
 * (NB: Some material taken from draft version on 01/10/2014, at author's personal Github account
 * https://github.com/sassela/asasse01-sp2-cw1-2014. This version is for historical validation only, not to be marked.)
 *
 */

import java.util.Scanner;

public class Coursework1 {
    final static int ARRAYLENGTH = 100;
    final static int TERMINATINGINT = 0;

    public static void main(String[] args) {
        int[] array1 = fillArray(ARRAYLENGTH);
        int[] array2 = fillArray(ARRAYLENGTH);

        if (!arraysEmpty(array1, array2)) {
            int[] commonData = compareCommon(array1, array2);
            int[] uniqueData1 = compareUnique(array1, array2);
            int[] uniqueData2 = compareUnique(array2, array1);

            printResultArray("Array 1 values: ", array1);
            printResultArray("Array 2 values: ", array2);
            printResultArray("Common data: ", commonData);
            if (commonData.length != 0) {
                System.out.println("Number of common data: " + commonData.length);
            }
            printResultArray("Unique values for array 1: ", uniqueData1);
            printResultArray("Unique values for array 2: ", uniqueData2);

            System.out.println();
        }
;

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
        System.out.println("Please enter up to " + arrayLength + " unique integer(s), and " + TERMINATINGINT + " when finished: ");

        while (i < (maxArray.length)) {
            input = in.nextInt();
            if (input != TERMINATINGINT) {
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
     * @param input integer to search for in array
     * @param array array to search
     * @return boolean value indicating presence of integer in array
     */
    public static boolean dupeInput(int input, int[] array) {
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
     * integer elements not equal to 0.
     * avoids use of Arrays class, as required in coursework brief
     * @param longArray integer array to be copied
     * @return fitArray integer array with exact number of indices required
     */
    private static int[] fitArray(int[] longArray) {
        int size = 0;

        for(int element : longArray){
            if (element != TERMINATINGINT){
                size++;
            }
        }

        int[] fitArray = new int[size];
        System.arraycopy(longArray, 0, fitArray, 0, (size));

        return fitArray;
    }


    /**
     * printResultArray method creates a String of array elements and prints
     * avoids use of Arrays class, as required in coursework brief
     * @param description description of array
     * @param array integer array to convert to String
     */
    private static void printResultArray(String description, int[] array) {
        if(array == null || array.length == 0 ) {
            System.out.println(description + "none");
        } else {

            String resultString = "";

            for (int element : array) {
                resultString += element + " ";
            }

            System.out.println(description + resultString);
        }
    }


    /**
     * compareCommon method compares two arrays and returns single array of common elements
     * @param array1 one of two integer arrays to compare
     * @param array2 one of two integer arrays to compare
     * @return common array of common integer elements
     */
    private static int[] compareCommon(int[] array1, int[] array2) {
        int arrayLength;
        int k = 0;

        if(array1.length >= array2.length){
            arrayLength = array1.length;

        } else arrayLength = array2.length;

        int[] maxArray = new int[arrayLength];

        for(int i : array1){
            for(int j : array2){
                if(i == j){
                    if (!dupeInput(i, maxArray)) { //single && loop?
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
    }


    /**
     * compareUnique method compares two arrays and returns single array of unique elements in the first array
     * @param arrayToPrintUnique one of two integer arrays to compare, unique elements will be printed from this array
     * @param arrayToCompare two of two integer arrays to compare,
     * @return unique array of unique integer elements in first array
     */
    private static int[] compareUnique(int[] arrayToPrintUnique, int[] arrayToCompare) {
        int[] unique;

        if (arrayToCompare.length == 0) {
            unique = arrayToPrintUnique;

        } else if (arrayToPrintUnique.length == 0) {
            unique = null;
        } else {
            int[] common = compareCommon(arrayToPrintUnique, arrayToCompare); //overload method for optional common param?
            int arrayLength = (arrayToPrintUnique.length) - (common.length);
            int[] maxArray = new int[arrayLength];
            boolean uniqueEl = true;
            int k = 0;

            for (int i : arrayToPrintUnique) {
                for (int j : common) {
                    if (i == j) {
                        uniqueEl = false;
                        break;
                    }
                    if (uniqueEl) {
                        if (!dupeInput(i, maxArray)) {
                            if (k < maxArray.length) {
                                maxArray[k] = i;
                                k++;
                            }
                        }
                    }
                    uniqueEl = true;
                }

            }

            unique = fitArray(maxArray);
        }

        return unique;

    }


    /**
     * arraysEmpty method check two arrays and prints message if both are null or empty
     * @param array1 one of two integer arrays to check
     * @param array2 one of two integer arrays to check
     * @return boolean value indicating both arrays are empty/null
     */
    private static boolean arraysEmpty(int[] array1, int[] array2) {
        boolean empty = false;
         if ((array1 == null && array2 == null) || (array1.length == 0 && array2.length == 0)) {
             empty = true;
             System.out.println("Both arrays are empty.");
         }

        return empty;
    }

}