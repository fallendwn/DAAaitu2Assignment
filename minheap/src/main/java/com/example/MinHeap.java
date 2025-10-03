package com.example;

import java.util.Arrays;

public class MinHeap extends Util{

    private static int size = 0;
    public static int[] arr = new int[size];
    private static int elementsIn = 0;
    public static int getSize(){

        return MinHeap.size;

    }

    public static void createArray(int size){

        arr = new int[size];
        elementsIn = 0;
    }


    public static void insertionInHeap(int number){

        if (elementsIn == arr.length){

            arr = limitExpansion(arr);

        }
        arr[elementsIn] = number;
        elementsIn++;
        heapify(arr);

    }

    private static int[] heapify(int[] arr){
        int position_of_new_element = elementsIn - 1;
        int parent_element;
        while (true){
            parent_element = (position_of_new_element - 1)/2;
            if (arr[position_of_new_element] < arr[parent_element]){
                swap(arr, position_of_new_element, parent_element);
                position_of_new_element = parent_element;

            }else{

                break;

            }

        }
        return arr;

    }

    public static int[] deleteRoot(int[] arr){

        if (elementsIn == 0){

            return arr;

        }else if (elementsIn == 1){
            elementsIn--;
            return delete(arr,0);

        }

        swap(arr, 0, elementsIn - 1); //свапнул элемент с последним
        delete(arr, elementsIn ); //удалил последний, а точнее после свапа последний элемент ?
        elementsIn--;
        //логика сравнивания
        int root = 0;
        int left_child;
        int right_child;
        int temp_smallest_root;
        while (true){
            temp_smallest_root = root;
            left_child = (root * 2) + 1;
            right_child = (root * 2) + 2;

            if (elementsIn > left_child && arr[temp_smallest_root] > arr[left_child]){

                temp_smallest_root = left_child;

            }
            if (elementsIn > right_child && arr[temp_smallest_root] > arr[right_child]){
                
                temp_smallest_root = right_child;

            }
            if(temp_smallest_root != root){

                swap(arr, temp_smallest_root, root);
                root = temp_smallest_root;

            }else{

                return arr;

            }


        }

    }

    public static int[] mergeTwoMinHeaps(int[] arr, int[] arr2){

        for(int i = 0 ; i < arr2.length; i ++){

            insertionInHeap(arr2[i]);

        }
        return arr;

    }


    private static int[] heapifyUp(int pos){
        int parent_element;
        while(pos > 0){
            parent_element = (pos-1)/2;
            if (arr[pos] < arr[parent_element]){

                swap(arr, pos, parent_element);
                pos = parent_element;
            }else{

                break;

            }

        }
        return arr;
    }

    public static void decreaseKey(int pos, int number_to_change){

        if (pos >= elementsIn || number_to_change >= arr[pos]){

            return;

        }

        arr[pos] = number_to_change;
        heapifyUp(pos);

    }

    public static String getArrayString(){

        return Arrays.toString(arr);

    }

}