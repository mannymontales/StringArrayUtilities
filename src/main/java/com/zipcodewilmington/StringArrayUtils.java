package com.zipcodewilmington;

import java.util.ArrayList;
import java.util.Arrays;

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
        String[] newArr = new String[array.length];
        int j = 0;
        //traverse through original array string from the end till it gets to the beginning of the array
        for (int i = array.length - 1; i >= 0; i--){

                //assign end value of original array to the start of new array
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
            //compare from the start and end and move into the middle of the array
            if (!array[i].equals(array[array.length - 1 - i])){
                return false;
            }
        } return true;}

    /**
     * @param array array of String objects
     * @return true if each letter in the alphabet has been used in the array
     */ // TODO
    public static boolean isPangramic(String[] array) {
/* This line of code did not work because you tried to do too many things at once, the first for loop you were trying to take the input from the array concatenate it to a new string and turn it into
a character array all at once !!! The solution to this was first doing it in smalls steps by:
    1) First adding all the elements into the new string THEN 2) converting that string with all the concatenated values into a char array OUTSIDE THE FOR LOOP
        String convert = "";
        char[] converted = new char[array.length];

        for (String element: array){
            convert += element;
            converted = convert.toLowerCase().toCharArray();
        }

        for (int i = 0; i < array.length; i++){
            if (alphabet.contains(converted[i])){
                alphabet.remove(converted[i]);
                i++;
            }
        }
        return false;
        */
        //turn string array into char array
        Character[] alphabet1 = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
        ArrayList<Character> alphabet = new ArrayList<>(Arrays.asList(alphabet1));

        String completeString = "";
        for (int i = 0; i < array.length; i++){
            completeString += array[i];
        }
        completeString = completeString.replace(" ","");

        char[] converted = completeString.toLowerCase().toCharArray();
        System.out.println(Arrays.toString(converted));

//        for (int i = 0; i < converted.length - 1; i++) {
//            if (alphabet.contains(Character.toLowerCase(converted[i]))) {
//                alphabet.remove(Character.toLowerCase(converted[i]));
//            }
//        }

        for (int i = 0; i < converted.length; i++) {
            if (alphabet.contains(Character.toLowerCase(converted[i]))) {
                alphabet.remove(Character.toLowerCase(converted[i]));
            }
        }


        return alphabet.isEmpty();
    }
    //https://chat.openai.com/share/1b45b519-e161-432c-a8af-1d85546dd7da

        /*
        for (int i = 0; i < alphabet.size(); i++){
            alphabet.remove(convertedArr[i]);
        }*/

        // If all letters have been removed from the alphabet list, it is pangramic


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
            if (!array[i].equals(valueToRemove)){
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
        ArrayList<String> dupRemoved = new ArrayList<>();

        for (int i = 0; i < array.length - 1; i++){ //traverse through original array
            //compare array element with the one next to it
            //if the element is not the same add it to the array list
                if (!array[i].equals(array[i + 1])) {
                    dupRemoved.add(array[i]);
                }
            //the next element becomes the new value to compare with if appended to the arraylist
        }

        //this line of code adds the last element of the original array after exiting the for loop
        //this is because if I tried to use "i <array.length" it would go out of bounds when comparing "array[i + 1];
        //but if i use array.length - 1 it would not append the last element into the array list this is what this code is for
        dupRemoved.add(array[array.length - 1]);

        String[] newarray = new String[dupRemoved.size()];
        newarray = dupRemoved.toArray(newarray);
        return newarray;
    }

    /**
     * @param array array of chars
     * @return array of Strings with each consecutive duplicate occurrence concatenated as a single string in an array of Strings
     */ // TODO
    public static String[] packConsecutiveDuplicates(String[] array) {
        return null;
    }


}
