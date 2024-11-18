package algorithms.BitManipulation;

public class BitManipulation {

    public static int countBits(int n) {
        int counter = 0;

        while (n>0) {
            counter++;
            // left shift operator: doubles the value
            // right shift operator: divides the value by 2
            n =  n >> 1;
        }
        return counter;
    }

     public static boolean isEven(int n) {
         // XOR operator with 1 decrements the value for odd numbers
         // XOR operator with 1 increments the value for even numbers
         return (n ^ 1) == n + 1;
     }

    public static void main(String[] args) {
        System.out.println(Integer.toBinaryString(120));
        System.out.println(countBits(120));
        System.out.println(isEven(10));
    }
}
