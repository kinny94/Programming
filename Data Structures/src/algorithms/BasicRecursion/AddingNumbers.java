package algorithms.BasicRecursion;

public class AddingNumbers {

    public int addIteration(int n) {
        int result = 0;
        for (int i = 1; i <= n; i++) {
            result += i;
        }
        return result;
    }

    public int addRecursion(int n) {
        if (n == 1) {
            return 1;
        }
        return n + addRecursion(n - 1);
    }

    public static void main(String[] args) {
        AddingNumbers addingNumbers = new AddingNumbers();
        System.out.println(addingNumbers.addIteration(5));
        System.out.println(addingNumbers.addRecursion(5));
    }
}
