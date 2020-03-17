import java.util.*;

class ReverseAnArray {
    
    private static int[] reverseAnArray(int[] array) {
        
        // 1 2 4 5 6 7
        for (int i=0; i<Math.floor(array.length/2); i++) {
            int temp = array[i];
            array[i] = array[array.length - 1 - i];
            array[array.length - 1 - i] = temp;
        }

        return array;
    }

    public static void main(String[] args) {
        int[] a = new int[]{ 1, 2, 3, 4, 5, 6, 7, 8};
        ReverseAnArray raa = new ReverseAnArray();
        System.out.println(Arrays.toString(raa.reverseAnArray(a)));
    }
}