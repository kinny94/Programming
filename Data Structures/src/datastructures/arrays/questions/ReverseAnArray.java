package datastructures.arrays.questions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ReverseAnArray {

    public static List<Integer> reverse(List<Integer> list) {
        int secondPointer = list.size() - 1;
        for (int i=0; i<list.size()/2; i++) {
            int temp;
            temp = list.get(i);
            list.set(i, list.get(secondPointer));
            list.set(secondPointer, temp);
            secondPointer--;
        }
        return list;
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<Integer>(Arrays.asList(12, 6, 2, 1, 9, 10, 3));
        System.out.println(reverse(list));
    }
}
