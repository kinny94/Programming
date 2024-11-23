package algorithms.BinPacking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class Bin {
    public int id;
    public int capacity;
    public int actualSize;
    public List<Integer> items;

    public boolean put(Integer item) {
        if (actualSize + item > capacity) {
            return false;
        }
        // add the item to the bin
        items.add(item);
        actualSize += item;
        return true;
    }

    @Override
    public String toString() {
        String contentOfBin = "Items in bin #" + this.id + "";
        for (Integer item : this.items) {
             contentOfBin += " " + item;
        }
        return contentOfBin;
    }

    public Bin(int id, int capacity) {
        this.id = id;
        this.capacity = capacity;
        this.items = new ArrayList<>();
    }
}

class BinPacking {

    public List<Bin> bins;
    public List<Integer> items;
    public int binCapacity;
    public int binCounter;

    BinPacking(List<Integer> items, int binCapacity) {
        this.binCapacity = binCapacity;
        this.items = items;
        this.bins = new ArrayList<>(this.items.size());
    }

    public void solve() {
        // sort the items in descending order
        items.sort(Collections.reverseOrder());

        // that there is no feasible solution
        if (items.get(0) > binCapacity) {
            System.out.println("No feasible solution..");
            return;
        }

        // first bin
        bins.add(new Bin(binCounter, binCapacity));
        for (Integer item : items) {
             boolean isOk = false;
             int currentBin = 0;
             while (!isOk) {
                 // this means we have checked all the current bins
                 if (currentBin == bins.size()) {
                     Bin newBin = new Bin(++binCounter, binCapacity);
                     newBin.put(item);
                     bins.add(newBin);
                     isOk = true;
                 } else if (bins.get(currentBin).put(item )) {
                     isOk = true;
                 } else {
                     currentBin++;
                 }
             }
        }
    }

    public void showResult() {
        for (Bin bin : bins) {
            System.out.println(bin);
        }
    }

    public static void main(String[] args) {
        List<Integer> items = Arrays.asList(5, 5, 5);
        int binCapacity = 3 ;
        BinPacking bp = new BinPacking(items, binCapacity);
        bp.solve();
        bp.showResult();
    }
}
