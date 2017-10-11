//Jiaqi Zhang, CSE 373, Winter 2017
//Assignment 2, 1/26/2017
//MyClient: Client code which tests the ThreeHeap implementation.

import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;

public class MyClient {
		public static void main(String[] args) {
			ThreeHeap Q = new ThreeHeap();
			//Check if it's empty
         System.out.println("Is queue empty?: " + Q.isEmpty());
         //Add 11 values. Check if size expands.
         for (int i = 10; i >=1; i--) {
            Q.insert((double)i);
         }
         //Check Heap
         Q.display();
         //Add more values. 
         for (int j = 1; j < 11; j++) {
            Q.insert(j);
         }
         //Check size()
         System.out.println("Size of queue: " + Q.size());
         Q.display();
         //check deleteMin().
         for (int k = 0; k < 15; k ++) {
            System.out.println("Remove min: " + Q.deleteMin());
         }
         System.out.println("Size of queue: " + Q.size());
         //check findMin().
         System.out.println("Min is: " + Q.findMin());
         Q.display();
         Q.makeEmpty();
         System.out.println("Queue is made empty, size of queue: " + Q.size());
         //check buildHeap().
         List<Double> list = new ArrayList<Double>();
         for (int h = 0; h < 13; h++){
            list.add((double)h);
         }
         Q.buildQueue(list);
         Q.display();
         //Given example in spec.
         List<Double> list2 = new ArrayList<Double>();
         list2.add(3.0);
         list2.add(3.0);
         list2.add(6.0);
         list2.add(7.0);
         Q.buildQueue(list2);
         Q.display();
         for (int n = 0; n < 4; n ++) {
            System.out.println("Remove min: " + Q.deleteMin());
         }
         
		}
}