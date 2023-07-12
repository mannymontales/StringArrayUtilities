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
        //alphabet arraylist to compare original array
        Character[] alphabet1 = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
        ArrayList<Character> alphabet = new ArrayList<>(Arrays.asList(alphabet1));

        //turn string array into char array by first getting a new string with all the values
        String completeString = "";
        for (int i = 0; i < array.length; i++){
            completeString += array[i].toLowerCase();
        }
        //make sure to remove the whitespace and assign into new char array
        completeString = completeString.replace(" ","");
        char[] converted = completeString.toCharArray();
        System.out.println(converted);


        for (int i = 0; i < converted.length; i++){
            if (alphabet.contains(converted[i])){
                //alphabet.remove(converted[i] did not work because of this via chatgpt:
                /*
               alphabet.remove(converted[i]) uses the primitive char type directly as the argument for removal.
               This relies on autoboxing, which automatically converts the primitive char to its corresponding wrapper class Character.
               On the other hand, alphabet.remove(Character.valueOf(converted[i])) explicitly creates a Character object using the valueOf() method and passes it as an argument to the remove() method.
               This ensures that the removal is performed based on the Character object.
                 */
                alphabet.remove(Character.valueOf(converted[i]));
            }
        }
        //if the alphabet arraylist is empty return the result
        return alphabet.isEmpty();
    }
    //https://chat.openai.com/share/1b45b519-e161-432c-a8af-1d85546dd7da


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
        //You don't need to check the last letter because you already did that in the previous iteration of the loop
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
        //use arraylist for dynamic size
        ArrayList<String> dupRemoved = new ArrayList<>();

        //traverse through original array

        //     String[] array = {"a", "a", "a", "b", "c", "c", "a", "a", "d"};
        //        String[] expected = {"aaa", "b", "cc", "aa", "d"};

        //        String[] array = {"t", "t", "q", "a", "a", "a", "b", "c", "c", "a", "a", "d", "e", "e", "e"};
        //        String[] expected = {"tt", "q", "aaa", "b", "cc", "aa", "d", "eee"};

        int counter = 0;
        for (counter = 0; counter < array.length - 2; counter++) {

            String temp = ""; //temporary string to store consecutive letters to add to arraylist, gets cleared everytime after appending the consecutive letters for a new set of letters

            //function to concatenate the array elements into temporary string
            while (array[counter].equals(array[counter + 1])) {
                temp += array[counter];//adds the current element to temp if the element next to it is the same

                if (counter != array.length - 2){
                    counter++;
                } else {
                    break;
                }

                /*
                if(counter == array.length -1){
                    temp += array[counter];
                    dupRemoved.add(temp);
                    System.out.println(temp);
                    break;
                }*/
            }
            temp += array[counter];//adds the last current element that was consecutive to the previous characters since the element next to it is going to be a different character
            dupRemoved.add(temp);//add the concatenated temporary string into the arraylist
            //System.out.println(temp);
            //then concatenate into single string
        }

        if ((array[counter] != array[counter - 1]) && (array[counter - 1] != array[counter - 2])){
            dupRemoved.add(array[counter]);
            dupRemoved.add(array[array.length -1]);//adds the last element of the array does not work currently with second test case
        }
        else if ((array[counter - 1] == array[counter - 2]) && (array[counter] != array[counter - 1])){
            dupRemoved.add(array[array.length -1]);
        }

        //System.out.println(array[array.length- 1]);


        //create newarray with size of arraylist and assign the values of arraylist to new array
        String[] newarray = new String[dupRemoved.size()];
        newarray = dupRemoved.toArray(newarray);
        return newarray;
    }


}
