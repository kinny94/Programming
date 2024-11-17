package algorithms.BasicRecursion;

public class TowersOfHanoi {

    public void solve(int disk, char source, char middle, char destination) {
        // base plate
        if (disk == 0) {
            System.out.println("Plate " + disk + " from " + source + " to " + destination);
            return;
        }

        // we move n-1 plate to the middle rod so that we can move the largest one to the last rod
        solve(disk - 1, source, destination, middle);

        // we move the large plate to the destination
        System.out.println("Plate " + disk + " from " + source + " to " + destination);
        // we move n-1 plate from middle to the destination with the help of the first rod
        solve(disk - 1, middle, source, destination);
    }

    public static void main(String[] args) {
        TowersOfHanoi towers = new TowersOfHanoi();
        towers.solve(3, 'A', 'B', 'C'); //
    }
}