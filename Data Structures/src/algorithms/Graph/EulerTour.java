package algorithms.Graph;

import java.util.ArrayList;
import java.util.List;

public class EulerTour {

    public List<Integer> nodes;
    public int[] timeIn;
    public int[] timeOut;
    public int time;

    EulerTour(List<Integer> nodes) {
        this.nodes = nodes;
        this.timeIn = new int[nodes.size()];
        this.timeOut = new int[nodes.size()];
        time = 0;
    }

    public void eulerTour1(int current, int parent) {
        System.out.println("RECORD TIME IN HERE");
        timeIn[current] = time++;
        for (Integer node : nodes) {
            if (node != parent) {
                eulerTour1(node, current);
            }
        }
        timeOut[current] = time++;
        System.out.println("RECORD TIME OUT HERE - WHILE LEAVING");
    }

    public void eulerTour2(int current, int parent) {
        System.out.println("RECORD TIME IN HERE");
        for (Integer node : nodes) {
            if (node != parent) {
                eulerTour1(node, current);
                System.out.println("RECORD TIME OUT HERE - WHEN BACK ON THIS NODE");
            }
        }
    }

    public void eulerTour3(int current, int parent) {
        System.out.println("RECORD TIME IN HERE");
        timeIn[current] = ++time; // increment time and save it
        for (Integer node : nodes) {
            if (node != parent) {
                eulerTour1(node, current);
                System.out.println("");
            }
        }
        timeOut[current] = time;
    }

    public static void main(String[] args) {

    }
}
