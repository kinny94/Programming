import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class FirstDecreasingAlgorithm {
    private List<Bin> bins = new ArrayList<Bin>();
    private List<Integer> items;
    private int binCapacity;
    private int binCounter = 1;

    FirstDecreasingAlgorithm(List<Integer> items, int binCapacity) {
        this.items = items;
        this.binCapacity = binCapacity;
        this.bins = new ArrayList<Bin>(this.items.size());
    }

    public void  solveBinPackaging() {
        Collections.sort(this.items , Collections.reverseOrder());

        if (this.items.get(0) > this.binCapacity) {
            System.out.println("No feasible Solution");
            return;
        }

        this.bins.add(new Bin(binCapacity, binCounter));

        for (Integer currentItem: items) {

            boolean isOk = false;
            int currentBin = 0;

            while (!isOk) {
                if (currentBin == this.bins.size()) {
                    Bin newBin = new Bin(binCapacity, ++binCounter);
                    newBin.put(currentItem);
                    this.bins.add(newBin);
                    isOk = true;
                } else if (this.bins.get(currentBin).put(currentItem)) {
                    isOk = true;
                } else {
                    currentBin++;
                }
            }
        }
    }

    public void showResults() {
        for (Bin bin: this.bins) {
            System.out.println(bin);
        }
    }
}

class BinPacking {

    private int id; 
    private int currentSize;
    private int capacity;
    private List<Integer> items;

    public BinPacking(int capacity, int id) {
        this.capacity = capacity;
        this.id = id;
        this.items = new ArrayList<Integer>();
    }

    public boolean put(Integer item) {
        if (this.currentSize + item > this.capacity) {
            return false;
        } 

        this.items.add(item);
        this.currentSize += item;

        return true;
    }

    @Override
    public String toString() {
        String currentOfBin = "Items in bin #" + this.id + ": ";

        for (Integer item: this.items) {
            currentOfBin += item + " ";
        }

        return currentOfBin;
    }
    
    public static void main(String[] args) {
        List<Integer> items = Arrays.asList(10, 5 ,5);
        int binCapacity = 10;

        FirstDecreasingAlgorithm algo =  new FirstDecreasingAlgorithm(items, binCapacity);
        algo.solveBinPackaging();
        algo.showResults();
    }
}