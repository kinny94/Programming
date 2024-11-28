package practice.Nov28;

import algorithms.substringsearch.KnuttMorrisPratt;

public class KnuttMoris {

    private int[] piTable;

    public void constructTable(String text, String pattern) {
        this.piTable = new int[pattern.length()];
        int prefixCounter = 0;
        int i = 1;

        while (i < pattern.length()) {
            if (text.charAt(i) == pattern.charAt(prefixCounter)) {
                prefixCounter++;
                piTable[i] = prefixCounter;
                i++;
            } else {
                if (prefixCounter != 0) {
                    prefixCounter = piTable[prefixCounter - 1];
                } else {
                    piTable[i] = 0;
                    i++;
                }
            }
        }
    } 

    public boolean search(String text, String pattern) {
        boolean found = false;
        constructTable(text, pattern);
        
        int  i=0;
        int j=0;

        while (i<text.length() && j<pattern.length()) {
            if (text.charAt(i) == pattern.charAt(j)) {
                i++;
                j++;
            }

            // we have found a pattern
            if (j == pattern.length()) {
                System.out.println("Found pattern at index " + ( i - j));
                j = piTable[j-1];
                found = true;
            }

            // in case of a mismtach
            if (i<text.length() && text.charAt(i) != pattern.charAt(j)) {
                if (j != 0) {
                    j = piTable[j-1];
                } else {
                    i++;
                }
            }
        }

        return found;
    }
    
     public static void main(String[] args) {
        KnuttMoris knuttMorrisPratt = new KnuttMoris();
        System.out.println(knuttMorrisPratt.search("This is a text", "text"));
        System.out.println(knuttMorrisPratt.search("ttttta", "tta"));
        System.out.println(knuttMorrisPratt.search("ttttta", "tat"));
    }
}  
