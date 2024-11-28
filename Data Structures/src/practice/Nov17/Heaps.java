package practice.Nov17;

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
        if (heapSize == Constants.CAPACITY) {
            return true;
        }
        return false;
    }

    public void insert(int value) {
        // check if there is space in the heap memory
        if (isFull()) {
            System.out.println("Heap out of memory!");
        }

        heap[heapSize] = value;
        heapSize++;
        // Now that we have added the item, we need to fix the violations
        fixUp(heapSize - 1);    
    }

    private void fixUp(int index) {
        // check if the properties of the heaps are violated
        // children should be smaller than the parent - MAX HEAP
        int parentIndex = (index - 1)/2; // because child is 2i + 1
        if (index > 0 && heap[index] > heap[parentIndex]) {
            swap(index, parentIndex);
            // go to the root and fix
            fixUp(parentIndex);
        }
    }
    
    public int poll() {
        int maxItem = getMax();
        // swap the root node with last item in the array/tree and then remove last item
        // after that call the fixDown method to fix the violations
        swap(0, heapSize - 1);
        heapSize--;
        fixDown(0);
        return maxItem;
    }

    private void fixDown(int index) {
        // since we have replaced the smallest item with the root node (which is then deleted)
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

    private void swap(int i, int j) {
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    } 

    public void heapsort() {
        int n = heapSize;
        for (int i=0; i<n; i++) {
            int max = poll();
            System.out.print(max + " ");
        }
    }

    public int getMax() {
        return heap[0];
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
      heaps.heapsort();
    }

}
