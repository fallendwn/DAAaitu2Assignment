package com.example;

import java.util.Arrays;

import com.Metrics.Metrics;

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
        Metrics.startTimer();
        if (elementsIn == arr.length){

            arr = limitExpansion(arr);

        }
        arr[elementsIn] = number;
        elementsIn++;
        Metrics.insertions++;
        heapify(arr);
        Metrics.stopTimer();
        Metrics.logReport("Insertion in Heap");

    }

    private static int[] heapify(int[] arr){
        int position_of_new_element = elementsIn - 1;
        int parent_element;
        while (true){
            parent_element = (position_of_new_element - 1)/2;
            Metrics.comparisons++;
            if (arr[position_of_new_element] < arr[parent_element]){
                Metrics.swaps++;
                swap(arr, position_of_new_element, parent_element);
                position_of_new_element = parent_element;

            }else{

                break;

            }

        }
        return arr;

    }

    public static int[] deleteRoot(int[] arr){
        Metrics.startTimer();
        if (elementsIn == 0){
            Metrics.stopTimer();
            Metrics.logReport("DeleteRoot(empty)");
            return arr;
        

        }else if (elementsIn == 1){
            elementsIn--;
            Metrics.stopTimer();
            Metrics.logReport("DeleteRoot(1 element)");
            return delete(arr,0);

        }
        Metrics.swaps++;
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
            Metrics.comparisons++;
            if (elementsIn > left_child && arr[temp_smallest_root] > arr[left_child]){

                temp_smallest_root = left_child;

            }
            Metrics.comparisons++;
            if (elementsIn > right_child && arr[temp_smallest_root] > arr[right_child]){
                
                temp_smallest_root = right_child;

            }
            Metrics.comparisons++;
            if(temp_smallest_root != root){
                Metrics.swaps++;
                swap(arr, temp_smallest_root, root);
                root = temp_smallest_root;

            }else{
                Metrics.stopTimer();
                Metrics.logReport("DeleteRoot");
                return arr;

            }


        }

    }

    public static int[] mergeTwoMinHeaps(int[] arr, int[] arr2){
        Metrics.startTimer();
        for(int i = 0 ; i < arr2.length; i ++){

            insertionInHeap(arr2[i]);

        }
        Metrics.stopTimer();
        Metrics.logReport("MergeTwoMinHeaps");
        return arr;

    }


    private static int[] heapifyUp(int pos){
        Metrics.startTimer();
        int parent_element;
        while(pos > 0){
            parent_element = (pos-1)/2;
            Metrics.comparisons++;
            if (arr[pos] < arr[parent_element]){
                swap(arr, pos, parent_element);
                Metrics.swaps++;
                pos = parent_element;
            }else{

                break;

            }

        }
        Metrics.stopTimer();
        Metrics.logReport("HeapifyUp");
        return arr;
    }

    public static void decreaseKey(int pos, int number_to_change){
        Metrics.startTimer();
        if (pos >= elementsIn || number_to_change >= arr[pos]){
            Metrics.stopTimer();
            Metrics.logReport("DecreaseKey(invalid value)");
            return;

        }

        arr[pos] = number_to_change;
        heapifyUp(pos);
        Metrics.stopTimer();
        Metrics.logReport("DecreaseKey");
    }

    public static String getArrayString(){

        return Arrays.toString(arr);

    }

}