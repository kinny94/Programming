import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Kangaroo {

    public static void kangaroo(int x1, int v1, int x2, int v2) {
    int dx = x1 - x2;
    int dv = v2 - v1;

    if(dv == 0) {
        System.out.println("NO");
    } else if((dx % dv == 0) && (dx / dv > 0)) {
        System.out.println("YES");
    } else {
        System.out.println("NO");
    }
}

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int x1 = in.nextInt();
        int v1 = in.nextInt();
        int x2 = in.nextInt();
        int v2 = in.nextInt();
        kangaroo(x1, v1, x2, v2);
        //System.out.println(result);
    }
}
