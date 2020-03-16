class LinearAndBinarySearch {

    private int[] array;

    LinearAndBinarySearch(int[] array) {
        this.array = array;
    }

    public int linearSearch(int item) {
        for (int i=0; i<array.length; i++) {
            if (array[i] == item) {
                return i;
            }
        }

        return -1;
    }

    public int binarySearch(int startIndex, int endIndex, int item) {
        if (endIndex < startIndex) {
            System.out.println("Item is not present in the array...");
            return -1;
        }

        int middleIndex = (startIndex + endIndex)/2;
        
        if (item  == array[middleIndex]) {
            return middleIndex;
        } else if (item < array[middleIndex]) {
            return binarySearch(startIndex, middleIndex - 1, item);
        } else {
            return binarySearch(middleIndex + 1, endIndex, item); 
        }
    }

    public int binarySearch(int item) {
        return binarySearch(0, array.length-1, item);
    }

    public static void main(String[] args) {
        int[] ar = new int[]{1, 5, 4, 8, 9, 10, -3};
        int[] arsorted = new int[]{1, 3, 4, 7, 8, 9, 10};
        
        LinearAndBinarySearch lb = new LinearAndBinarySearch(ar);
        System.out.println(lb.linearSearch(-3));
        
        LinearAndBinarySearch lb2 = new LinearAndBinarySearch(arsorted);
        System.out.println(lb2.binarySearch(3));

    }
}