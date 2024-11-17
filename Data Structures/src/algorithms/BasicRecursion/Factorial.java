package algorithms.BasicRecursion;

public class Factorial {

    public int factorial(int n) {
        if (n == 0) return 1;
        return n * factorial(n - 1);
    }

    public int factorialToAvoidStackOverflow(int n, int acc) {
        if (n == 0) return acc;
        return n * factorialToAvoidStackOverflow(n - 1, acc);
    }

    public int headFactorial(int n) {
        if (n == 1) return 1;
        int res1 = headFactorial(n - 1);
        int res2 = n * res1;
        return res2;
    }

    public int tailFactorial(int n, int acc) {
        if (n == 0) return acc;
        return tailFactorial(n-1, n * acc);
    }

    public static void main(String[] args) {
        Factorial factorial = new Factorial();
        System.out.println(factorial.factorial(5));
        System.out.println(factorial.factorialToAvoidStackOverflow(5, 1));
        System.out.println(factorial.headFactorial(5));
        System.out.println(factorial.tailFactorial(5, 1));
    }
}
