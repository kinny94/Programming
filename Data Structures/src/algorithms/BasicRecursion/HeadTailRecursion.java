package algorithms.BasicRecursion;

public class HeadTailRecursion {

    public void head(int n) {
        if (n == 0) {
            return;
        }
        head(n - 1);
        System.out.println("value " + n);
    }

    public void tail(int n) {
        if (n == 0) {
            return;
        }
        System.out.println("value " + n);
        tail(n - 1);
    }

    public int tailWithAcc(int n, int acc) {
        if (n == 0) {
            return acc;
        }
        return tailWithAcc(n - 1, n * acc);
    }

    public static void main(String[] args) {
        HeadTailRecursion headTailRecursion = new HeadTailRecursion();
        headTailRecursion.head(5);
        System.out.println();
        headTailRecursion.tail(5);
        System.out.println();
        System.out.println(headTailRecursion.tailWithAcc(5, 1));
    }
}
