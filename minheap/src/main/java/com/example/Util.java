package com.example;
public class Util {

    protected static int[] swap(int[] arr, int pos1, int pos2){


        int temp = arr[pos1];
        arr[pos1] = arr[pos2];
        arr[pos2] = temp;        

        return arr;
    
    } 
    
    protected static int[] limitExpansion(int[] arr){

        int[] newArray = new int[arr.length * 2];

        for (int i = 0 ; i < arr.length; i++){

            newArray[i] = arr[i];


        }

        return newArray;

    }

    protected static int[] delete(int[] arr, int pos){
        int[] newArray = new int[arr.length-1];
        for (int i = 0, k = 0 ; i< arr.length ; i++){

            if (i == pos){
                continue;
            }
            newArray[k++] = arr[i];

        }
        return newArray;


    }
    

}
