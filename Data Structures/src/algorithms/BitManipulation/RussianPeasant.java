package algorithms.BitManipulation;

public class RussianPeasant {

    /*
        a= 5 b=10
        10    5
        20    2
        40    1
        80    0

        150 != 5x10=50
        therefore only sum up the odd values
        10 + 40 = 50
     */
    public static int mulitply(int a, int b) {
        int result = 0;
        while (b > 0) {
            // if b becomes odd (XOR operator decrements the value by 1 for odd numbers
            // we want to skip when 'b' is even
            if ((b^1) == b-1) {
                result = result + a;
            }
            // double the first number
            a = a << 1;
            // halve the second number
            b = b >> 1;
        }
        return result;
    }

    public static void main(String[] args) {
        RussianPeasant r = new RussianPeasant();
        System.out.println(r.mulitply(3, 2));
        System.out.println(r.mulitply(100, 200));
    }
}
