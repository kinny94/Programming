package practice.Nov28;

public class Heaps {
    
    public int[] heap;
    public int heapSize;
    public int capacity;
    
    public Heaps() {
        this.capacity = 10;
        this.heap = new int[capacity];
        this.heapSize = 0;
    }
    
    public boolean isFull() {
        return this.heapSize == this.capacity;
    }
    
    public void swap(int i, int j) {
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }
    
    public void insert(int item) {
        if (isFull()) {
            System.out.println("Heap out of memory!");
        }
        
        heap[heapSize] = item;
        fixUp(heapSize);
        heapSize++;
    }
    
    private void fixUp(int index) {
        if (index == 0) { // reached the root
            return;
        }
        // We will check if the properties of the heap are violated or not
        int parentIndex = (index - 1) / 2;
        if (heap[index] > heap[parentIndex]) {
            swap(index, parentIndex);
            fixUp(parentIndex);
        }
    }
    
    public int getMax() {
        return heap[0];
    }
    
    public int poll() {
        if (isEmpty()) {
            System.out.println("Heap is empty");
            return -1;
        }
        
        int maxItem = heap[0];
        // swap the root with the leadnode;
        swap(0, heapSize-1);
        heapSize--;
        fixDown(0);
        return maxItem;
    }
    
    private void fixDown(int index) {
        int leftChildIndex = (2 * index) + 1;
        int rightChildIndex = (2 * index) + 2;
        
        int largestIndex = index;
        if (leftChildIndex < heapSize && heap[leftChildIndex] > heap[largestIndex]) {
            largestIndex = leftChildIndex;
        }
        
        if (rightChildIndex < heapSize && heap[rightChildIndex] > heap[largestIndex]) { 
            largestIndex = rightChildIndex;
        }
        
        if (index != largestIndex) {
            swap(index, largestIndex);
            fixDown(largestIndex);
        }
    }
    
    private boolean isEmpty() {
        return heapSize == 0;
    }
    
    public void heapSort() {
        int n = heapSize;
        for (int i=0; i<n; i++) {
            int max = poll();
            System.out.print(max + " ");
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
        System.out.println();
        heaps.heapSort();
    }
}
