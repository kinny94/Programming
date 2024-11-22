package algorithms.DynamicProgramming;

import java.util.HashMap;
import java.util.Map;

public class Fibonacci {

    public int fibonacciRecursive(int n) {
        if (n==0) {
            return 1;
        }

        if (n==1) {
            return 1;
        }

        return fibonacciRecursive(n-1) + fibonacciRecursive(n-2);
    }

    // top down approach - Memoization
    public int fibonacciMemoization(int n, Map<Integer, Integer> memo) {
        if (!memo.containsKey(n)) {
            memo.put(n, fibonacciMemoization(n-1, memo) + fibonacciMemoization(n-2, memo));
        }
        return memo.get(n);
    }

    // bottom up - tabulation
    public int fibonacciTabulation(int n, Map<Integer, Integer> memo) {
        for (int i = 2; i <=n; i++) {
            memo.put(i, memo.get(i - 1) + memo.get(i - 2));
        }
        return memo.get(n);
    }

    public static void main(String[] args) {
        Fibonacci fibonacci = new Fibonacci();
        Map<Integer, Integer> memo = new HashMap<>();
        memo.put(1, 1);
        memo.put(0, 1);
        System.out.println(fibonacci.fibonacciRecursive(12));
        System.out.println(fibonacci.fibonacciMemoization(12, memo));
        System.out.println(fibonacci.fibonacciTabulation(12, memo));

    }
}
