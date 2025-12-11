package Problems;

class SubstringMatchGFG {
    
    public static int search(String text, String pattern) {
        for (int i=0; i <= text.length() - pattern.length(); i++) {
            int j = 0;
            while (j < pattern.length() && text.charAt(i + j) == pattern.charAt(j)) {
                j++;
            }
            if (j == pattern.length()) {
                return i;
            }
        }
        return -1;
    }

    public static int rabinKarp(String txt, String pat) {
        long hash = 1;
        int prime = 31;
        int modulus = 101;

        // pre compute modulo modules to keep the number small
        for (int i=0; i<pat.length() - 1; i++) {
            hash = (hash * prime) % modulus;
        }

        long patHash = 0;
        long stringHash = 0;
        // calculate the pattern length hash for both the pattern and the string
        for (int i=0; i<pat.length(); i++) {
            patHash = (patHash * prime + pat.charAt(i)) % modulus;
            stringHash = (stringHash * prime + txt.charAt(i)) % modulus;
        }

        // slide the window and calculate the hash again
        for (int i=0; i<=txt.length() - pat.length(); i++) {

            if (patHash == stringHash) {
                if (txt.substring(i, i + pat.length()).equals(pat)) {
                    return i;
                }
            }
            
            if (i < txt.length() - pat.length()) {
                stringHash = (stringHash - txt.charAt(i) * hash) % modulus;
                stringHash = (stringHash * prime) % modulus;
                stringHash = (stringHash + txt.charAt(i + pat.length())) % modulus;
    
                // Ensure the hash remains non-negativ
                if (stringHash < 0) {
                    stringHash += modulus;
                }
            }
        }
        return -1;
    }

    public static boolean hasMatch(String s, String p) {
        int index = p.indexOf('*');
        int firstpos = search(s, p.substring(0, index)); 
        // finding if the pre * pattern is present in the word , if not its -1
        int secondpos = -1;
        if (firstpos != -1 && firstpos + index < s.length()) {
            int secondposRelative = search(s.substring(firstpos + index), p.substring(index + 1));
            secondpos = (secondposRelative != -1) ? firstpos + index + secondposRelative : -1;
        }
        // finding if the post * pattern is present in the word , if not its -1
        if (firstpos != -1 && secondpos != -1) {
            // comparing if both the firstpos and secondpos are not -1 , if not then it means both patterns are present in the word
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        String text = "This is a text";
        String pattern = "text";
        System.out.println(search(text, pattern));
        System.out.println(rabinKarp(text, pattern));
    }
}