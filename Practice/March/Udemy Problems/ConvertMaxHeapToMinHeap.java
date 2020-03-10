// we have to consider the internal nodes exclusively. We to find the smallest child and swap it with the parent
class ConvertMaxHeapToMinHeap {

  private int[] heap;

  public ConvertMaxHeapToMinHeap(int[] heap) {
    this.heap = heap;
  }

  public int[] transform() {
    for (int i=((heap.length-2)/2); i>=0; i--) {
      heapify(i);
    } 

    return this.heap;
  }

  public void heapify(int index) {
    int leftChildIndex = 2 * index  + 1;
    int rightChildIndex = 2 * index + 2;
    int smallest = index;

    if (leftChildIndex < heap.length && heap[leftChildIndex] < heap[index]) {
      smallest = leftChildIndex;
    }

    if (rightChildIndex < heap.length && heap[rightChildIndex] < heap[smallest]) {
      smallest = rightChildIndex;
    }

    if (smallest != index) {
      swap(smallest, index);
      heapify(smallest);
    }
  }


  public void swap(int index1, int index2) {
    int temp = heap[index1];
    heap[index1] = heap[index2];
    heap[index2] = temp;
  }

  public static void main(String[] args) {
    int[] maxHeap = {200, 100, 23, 2, 5};
    ConvertMaxHeapToMinHeap heapConverter = new ConvertMaxHeapToMinHeap(maxHeap);
    int[] minHeap = heapConverter.transform();
    for (int i=0; i<minHeap.length; i++) {
      System.out.println(minHeap[i] + " ");
    }
  }
}