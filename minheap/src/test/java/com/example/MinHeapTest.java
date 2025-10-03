package com.example;


import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MinHeapTest {

    @BeforeEach
    void setUp() {
        MinHeap.createArray(10);
    }

    @Test
    void testInsertionInHeap() {
        MinHeap.insertionInHeap(5);
        MinHeap.insertionInHeap(3);
        MinHeap.insertionInHeap(8);


        assertEquals(3, MinHeap.arr[0]);
    }

    @Test
    void testDeleteRoot() {
        MinHeap.insertionInHeap(5);
        MinHeap.insertionInHeap(3);
        MinHeap.insertionInHeap(8);

        MinHeap.deleteRoot(MinHeap.arr);


        assertEquals(5, MinHeap.arr[0]);
    }

    @Test
    void testDecreaseKey() {
        MinHeap.insertionInHeap(10);
        MinHeap.insertionInHeap(15);
        MinHeap.insertionInHeap(30);

        MinHeap.decreaseKey(2, 5); 


        assertEquals(5, MinHeap.arr[0]);
    }

    @Test
    void testMergeTwoHeaps() {
        MinHeap.insertionInHeap(4);
        MinHeap.insertionInHeap(7);

        int[] arr2 = {1, 9};
        MinHeap.mergeTwoMinHeaps(MinHeap.arr, arr2);

        assertTrue(contains(MinHeap.arr, 1));
        assertTrue(contains(MinHeap.arr, 9));
    }

    private boolean contains(int[] arr, int val) {
        for (int x : arr) {
            if (x == val) return true;
        }
        return false;
    }
    
}
