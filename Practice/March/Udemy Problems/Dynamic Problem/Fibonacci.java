import java.util.HashMap;
import java.util.Map;

class Fibonacci {


    private Map<Integer, Integer> memoizeTable;

    Fibonacci() {
        this.memoizeTable = new HashMap<>();
        this.memoizeTable.put(0, 0);
        this.memoizeTable.put(1, 1);
    }
    // exponential running time
    public int naiveApproach(int n) {
        if (n==0) return 0;
        if (n==1) return 1;

        return naiveApproach(n-1) + naiveApproach(n-2);
    }

    public int dpFibonacci(int num) {
        if (memoizeTable.containsKey(num)) {
            return memoizeTable.get(num );
        }

        memoizeTable.put(num - 1, dpFibonacci(num-1));
        memoizeTable.put(num - 2, dpFibonacci(num- 2));

        int total = memoizeTable.get(num-1) + memoizeTable.get(num-2);
        memoizeTable.put(num, total);
        return total;
    }

    public static void main(String[] args) {
        Fibonacci fibonacci = new Fibonacci();
        System.out.println(fibonacci.dpFibonacci(45));
    }
}