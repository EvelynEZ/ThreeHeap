//Jiaqi Zhang, CSE 373, Winter 2017
//Assignment 2, 1/26/2017
//ThreeHeap: a min heap that implements a priority queue. 
//Each element has three children.

import java.util.Arrays;
import java.util.List; 

public class ThreeHeap implements PriorityQueue {
   private int size; //number of nodes.
   private double[] arr; //arr used to store the heap.
   
   //Declare the structure of a ThreeHeap.
   public ThreeHeap(){
      arr = new double [10];
      size = 0;
   }
   
   //return true if the heap is empty.
   //false if there is at least one node.
   public boolean isEmpty(){
      return (size == 0);
   }
   
   //return the number of nodes in the heap.
   public int size(){
      return size;
   }
   
   //return the smallest value stored in the heap.
   public double findMin(){
      if (isEmpty()){
         throw new EmptyHeapException();
      }
      return arr[1];
   }
   
   //Insert given double to the heap.
   public void insert(double x){
      resize();
		size++;
		arr[size] = x;
		percolateUp();
   }  
   
   
   //Return the smallest value in the heap, and 
   //delete the node from the heap.
   public double deleteMin(){
      if (isEmpty()) {
			throw new EmptyHeapException();
		}
      double ans = findMin();
      arr[1] = arr[size];
      size--;
      percolateDown();
      return ans;
   }
   
   //Reset the ThreeHeap to empty then add given elements 
   //to the queue.
   public void buildQueue(List<Double> list){
      //reset Queue to be empty.
      makeEmpty();
      //Put all elements in queue.
      for (int i = 0; i < list.size(); i++) {
         arr[i + 1] = list.get(i); 
         size++;
         resize();            
      }
      //percolate all parent nodes.
      for (int j = (size+1)/3; j > 0; j--) {
         percolateDown(j);   
      }
   }
   
   //Reset the PriorityQueue to an empty queue.
   public void makeEmpty(){
      size = 0;
      arr = new double[10];
   }

   //Start from last node, if it's smaller than it's parrent, then 
   //switch with its parent node and keep looking. 
   private void percolateUp() {
      int position = size;
      //if child has smaller value than its parrent 
      while (position > 1 && arr[position] < arr[(position+1)/3]){
         swap(position, (position+1)/3);
         position = (position+1)/3;
      }
   }

   //Compare parent with children, if parent is greater than 
   //the any child, swap parent with the smallest child.
   //Then keep comparing on the next level.
   //If not, stop.
   private void percolateDown (int position){
      //While it is a parrent of at least one child
      while(position*3-1 <= size) {
         int left = position*3-1;
         int middle = position*3;
         int right = position*3+1;
         int minTracker = left;
         double min = arr[left];
         //compare left with middle
         if (middle <= size && arr[middle] < min){
            min = arr[middle];
            minTracker = middle;
         } 
         //compare min with right
         if (right <= size && arr[right] < min){
            min = arr[right];
            minTracker = right;
         }
         //compare parrent with min
         if (arr[minTracker] < arr[position]) {
            swap(position, minTracker);
            position = minTracker;
         } else {
            break; 
         } 
      }
   }
   
   //Percolation down from the top of the heap.
   private void percolateDown() {
      percolateDown(1);
   }
   
   //Swap the value at indeces a and b. 
   private void swap(int a, int b) {
      double temp = arr[a];
      arr[a] = arr[b];
      arr[b] = temp;
   }
   
   //Resize to twice as large when the heap is full.
   private void resize(){
      if (size >= arr.length - 1) {
			double[] longArr = Arrays.copyOf(arr, arr.length*2);
         arr = longArr;
		}
   }
   
   //Print the content of the Queue. From the top to bottom. 
   public void display() {
      double line = 1;
      int count = 1;
      for (int i = 1; i <= size; i++) {
         System.out.print(arr[i] + " ");
         count--;
         if (count == 0){
            System.out.println();
            line++;
            count = (int)Math.pow(3.0, line-1);
         }
      }
      System.out.println("");
      System.out.println("");
   }
}