package com.zipcodewilmington;

import java.util.ArrayList;

/**
 * Created by leon on 1/29/18.
 */
public class StringArrayUtils {
    //https://stackoverflow.com/questions/35024593/what-does-array-length-1-mean-in-javascript
    /**
     * @param array array of String objects
     * @return first element of specified array
     */ // TODO
    public static String getFirstElement(String[] array) {
        return array[0];
    }

    /**
     * @param array array of String objects
     * @return second element in specified array
     */
    public static String getSecondElement(String[] array) {
        return array[1];
    }

    /**
     * @param array array of String objects
     * @return last element in specified array
     */ // TODO
    public static String getLastElement(String[] array) {
        return array[array.length - 1];
    }

    /**
     * @param array array of String objects
     * @return second to last element in specified array
     */ // TODO
    public static String getSecondToLastElement(String[] array) {
        return array[array.length - 2];
    }

    /**
     * @param array array of String objects
     * @param value value to check array for
     * @return true if the array contains the specified `value`
     */ // TODO
    public static boolean contains(String[] array, String value) {
        for (int i = 0; i < array.length; i++){
            if (array[i].contains(value)){ return true; }
        }
        return false;
    }

    /**
     * @param array of String objects
     * @return an array with identical contents in reverse order
     */ // TODO
    public static String[] reverse(String[] array) {
        String newArr[] = new String[array.length];
        int j = 0;
        //traverse through original array string from the end till it gets to the beginning of the array
        for (int i = array.length - 1; i >= 0; i--){

                //assign end value of original array to start of new array
                newArr[j] = array[i];
                j++; //increment index of new array
        }
        return newArr;
    }

    /**
     * @param array array of String objects
     * @return true if the order of the array is the same backwards and forwards
     */ // TODO
    public static boolean isPalindromic(String[] array) {

        for (int i = 0; i < array.length; i++){
            if (!array[i].equals(array[array.length - 1 - i])){
                return false;
            }
        } return true;}

    /**
     * @param array array of String objects
     * @return true if each letter in the alphabet has been used in the array
     */ // TODO
    public static boolean isPangramic(String[] array) {
        return false;
    }

    /**
     * @param array array of String objects
     * @param value value to check array for
     * @return number of occurrences the specified `value` has occurred
     */ // TODO
    public static int getNumberOfOccurrences(String[] array, String value) {
        int occur = 0;
        //traverse through array
        //https://stackoverflow.com/questions/35024593/what-does-array-length-1-mean-in-javascript
        for (int i = 0; i < array.length; i++){
            //condition to check if element in array contains value
            if (array[i].equals(value)){
                occur += 1;
            }

        }
        return occur;
    }

    /**
     * @param array         array of String objects
     * @param valueToRemove value to remove from array
     * @return array with identical contents excluding values of `value`
     */ // TODO
    public static String[] removeValue(String[] array, String valueToRemove) {
        ArrayList<String> excluded = new ArrayList<>();

        for (int i = 0; i < array.length; i++){
            if (array[i] != valueToRemove){
                excluded.add(array[i]);
            }
        }
        //Integer arr[] = new Integer[ArrLis.size()];
        //arr = ArrLis.toArray(arr);
        String[] newarray = new String[excluded.size()];
        newarray = excluded.toArray(newarray);
        return newarray;
    }

    /**
     * @param array array of chars
     * @return array of Strings with consecutive duplicates removes
     */ // TODO
    public static String[] removeConsecutiveDuplicates(String[] array) {
        return null;
    }

    /**
     * @param array array of chars
     * @return array of Strings with each consecutive duplicate occurrence concatenated as a single string in an array of Strings
     */ // TODO
    public static String[] packConsecutiveDuplicates(String[] array) {
        return null;
    }


}
