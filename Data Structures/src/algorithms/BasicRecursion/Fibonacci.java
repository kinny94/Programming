package algorithms.BasicRecursion;

public class Fibonacci {

    public int fibonacci(int n) {
        if (n == 0) {
            return 0;
        }

        if (n == 1) {
            return 1;
        }

        int fib1 = fibonacci(n-1);
        int fib2 = fibonacci(n-2);
        return fib1 + fib2;
    }

    public int fibonacciWithTail(int n, int a, int b) {
        if (n == 0) {
            return a;
        }

        if (n == 1) {
            return b;
        }

        return fibonacciWithTail(n-1, b, a+b);
    }

    public static void main(String[] args) {
        Fibonacci fibonacci = new Fibonacci();
        System.out.println(fibonacci.fibonacci(10));
        System.out.println(fibonacci.fibonacciWithTail(10,0,1));
    }
}
