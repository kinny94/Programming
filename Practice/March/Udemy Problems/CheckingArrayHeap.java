// write a program to check if heap is  valid heap or not

// node with index i has the left child (2I + 1) and right child (2I + 2)

// we just have to check the items where 2i + 2 <= N where N is the size of the array

// no need to check the leaf node (they dont have any children) - if 2i + 1 and  2i + 2 are out of range, then its a leaf node

class CheckingArrayHeap {
  public boolean isMinHeap(int[] heap) {
    for (int i=0; i<=(heap.length - 2)/2; i++) { // by rarraingin 2*i + 2 = N
      if (heap[i] > heap[2*i + 1] || heap[i] > heap[2*i + 2]) { // for max heap reverse the sign
        return false;
      }
    }

    return true;
  }

  public static void main(String[] args) {

    CheckingArrayHeap check = new CheckingArrayHeap();
    int[] array = { 10, 14, 19, 26, 31, 42, 27, 44, 35, 33, 35 };
    int[] array2 = { 100, 14, 19, 26, 31, 42, 27, 44, 35, 33, 35 };
    System.out.println(check.isMinHeap(array));
    System.out.println(check.isMinHeap(array2));
  }
}