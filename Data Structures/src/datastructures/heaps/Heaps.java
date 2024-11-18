package datastructures.heaps;

class Constants {
   private Constants() {}
   public static final int CAPACITY = 10;
}

class Heaps {

   private int[] heap;
   private int heapSize;

   Heaps() {
      heap = new int[Constants.CAPACITY];
   }

   private boolean isFull() {
      return heapSize == Constants.CAPACITY;
   }

   public void insert(int value) {
      if (isFull()) {
         throw new RuntimeException("Heap is full");
      }

      heap[heapSize] = value;
      heapSize++;
      fixUp(heapSize-1);
   }

   private void fixUp(int index) {
      //check if the properties of the heap are violated
      // parent should be greater than the child - max heap
      int parentIndex= (index- 1)/2; // coz child index is 2i + 1
      if (index > 0 && heap[index] > heap[parentIndex]) {
         swap(index, parentIndex);
         // go up to the root to check for violations - index 0
         fixUp(parentIndex);
      }
   }

   private void swap(int index1, int index2) {
      int temp = heap[index1];
      heap[index1] = heap[index2];
      heap[index2] = temp;
   }

   // max-heap has the highest element at the root
   public int getMax() {
      return heap[0];
   }

   // poll removed the max item from the root
   public int poll() {
      int maxItem = heap[0];
      // swap the root node with the last item in the array/tree and then remove the last item
      // after that call the heapify method to resolve the violations
      swap(0, heapSize-1);
      heapSize--;
      fixDown(0);
      return maxItem;
   }

   private void fixDown(int index) {
      // since we have replaced one of the smallest item with the root node (which is then deleted).
      // we compare this new root node with its children and then swap it with its largest child
      int leftChildIndex = (index*2) + 1;
      int rightChildIndex = (index*2) + 2;

      int largestIndex = index;
      if (leftChildIndex < heapSize && heap[leftChildIndex] > heap[largestIndex]) {
         largestIndex = leftChildIndex;
      }

      if (rightChildIndex < heapSize && heap[rightChildIndex] > heap[largestIndex]) {
         largestIndex = rightChildIndex;
      }

      // one of the children is larger than the parent
      if (index != largestIndex) {
         swap(index, largestIndex);
         fixDown(largestIndex);
      }
   }

   public boolean isEmpty() {
      return heapSize == 0;
   }

   public void heapSort() {
      int n = heapSize;
      for (int i=0; i<n; i++) {
         int max = poll();
         System.out.println(max);
      }
   }

   public static void main(String[] args) {

      Heaps heaps = new Heaps();
      heaps.insert(6);
      System.out.println(heaps.getMax());
      heaps.insert(1);
      System.out.println(heaps.getMax());
      heaps.insert(12);
      System.out.println(heaps.getMax());
      heaps.insert(-2);
      System.out.println(heaps.getMax());
      heaps.insert(3);
      System.out.println(heaps.getMax());
      heaps.insert(8);
      System.out.println(heaps.getMax());
      heaps.insert(-5);
      System.out.println(heaps.getMax());
      heaps.heapSort();
   }
}
