import java.util.*;
class Fibonacci
{
    public static int fibRec(int num) {
        if (num == 0) {
            return 0;
        } else if (num == 1 || num == 2) {
            return 1;
        } else {
            return fibRec(num - 1) + fibRec(num - 2);
        }
    }
      
    public static void main (String args[])
    {
    int n = 2;
    System.out.println(fibRec(n));
    }
}