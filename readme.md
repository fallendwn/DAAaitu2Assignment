MinHeap Implementation

This project implements a MinHeap data structure. Minheap is a complete binary tree where the value of each parent is less or qual to the values of its children.

Features implemented
1. Insert (insertioninheap)
   Insert a new element into the heap with MinHeap property
   Time complexity: O(log n)
2. Delete Root (deleteRoot)
   Removes the root (smallest) element and restructures the heap.
   Time complexity: O(log n)
3. Decrease Key (decreaseKey)
  Decreases the value of a key at a given index and restructures the heap.
  Time complexity O(log n)
4. Heapify (heapify)
   Ensures the heap property is ensured
   Time Complexity O(log n)
5. Heap Up (heapifyUp)
   Used internally when inserting or decreasing key
   Time Complexity O(log n)
