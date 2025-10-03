package com;

import com.example.MinHeap;

public class CLI {
    
    public static void main(String[] args){

        int length = Integer.parseInt(args[0]);
        int temp;
        MinHeap exampleHeap = new MinHeap();
        exampleHeap.createArray(length);
        for(int i = 0 ; i < length; i++){
            temp = Integer.parseInt(args[i]);
            exampleHeap.insertionInHeap(temp);


        }
        System.out.printf(exampleHeap.getArrayString());

    }

}
