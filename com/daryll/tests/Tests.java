package com.daryll.tests;

public class Tests {
    public static void main(String[] args) {

        String name = "daryll";


        //int[] array = {5,2,4,6,1,3};

        /*
        iterate from position 1 to the last position:
            get current-element
            get preceding-index of position

            while behind-index is greater than -1 and element at behind-index is greater than current-element:
                assign element at behind-index to element at behind-index+1
                decrement behind-index by 1

            assign current-element to element at behind-index+1

         for j = 1 to A.length
            key = A[j]
            //  Insert A[j] into the sorted sequence A[1..j-1]
            i = j - 1
            while i > -1 and A[i] > key
                A[i + 1] = A[i]
                i = i - 1
            A[i + 1] = key
         */

        /*for (int currentIndex = 1; currentIndex < array.length; currentIndex++) {
            int currentElement = array[currentIndex];
            int behindIndex = currentIndex - 1;

            while (behindIndex > -1 && array[behindIndex] > currentElement) {
                array[behindIndex + 1] = array[behindIndex];
                behindIndex--;
            }
            array[behindIndex + 1] = currentElement;
        }

        for (int e : array) {
            System.out.print(e+" ");
        }*/
    }
}

