package algorithms.BasicRecursion;

public class GCDEuclidean {

    public int greatestCommonDivisor(int a, int b) {
        // base case - remainder is 0
        if (a % b == 0) {
            return b;
        }

        return greatestCommonDivisor(b, a % b);
    }

    public int GCDIteration(int a, int b) {
        int temp = 0;
        while (b != 0) {
            temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    public static void main(String[] args) {
        GCDEuclidean gcd = new GCDEuclidean();
        System.out.println(gcd.greatestCommonDivisor(24, 12));
        System.out.println(gcd.greatestCommonDivisor(24, 9));
        System.out.println(gcd.greatestCommonDivisor(31, 11));

        System.out.println(gcd.GCDIteration(24, 12));
        System.out.println(gcd.GCDIteration(24, 9));
        System.out.println(gcd.GCDIteration(31, 11));
    }
}
