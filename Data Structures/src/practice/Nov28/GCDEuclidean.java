package practice.Nov28;

public class GCDEuclidean {

    public int greatestCommonDivisor(int a, int b) {
        if (a % b == 0) {
            return b;
        }
        return greatestCommonDivisor(b, a % b);
    }

    public static void main(String[] args) {
        GCDEuclidean gcd = new GCDEuclidean();
        System.out.println(gcd.greatestCommonDivisor(24, 12));
        System.out.println(gcd.greatestCommonDivisor(24, 9));
        System.out.println(gcd.greatestCommonDivisor(31, 11));
    }
    
}
