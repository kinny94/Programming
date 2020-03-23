class GuessTheWord {
    private Random rand = new Random();
    
    public void findSecretWord(String[] wordlist, Master master) {
        if (wordlist == null || master == null || wordlist.length == 0){
            return;
        }
        
        int i = rand.nextInt(wordlist.length);
        int numMatch = master.guess(wordlist[i]);
        if (numMatch == 6){
            return;
        }
        
        String[] newList = findCandidates(wordlist, wordlist[i], numMatch);
        findSecretWord(newList, master);
    }
    
    private String[] findCandidates(String[] wordlist, String word, int numMatch){
        List<String> res = new ArrayList<>();
        for (String w : wordlist){
            if (!w.equals(word) && countMatches(w, word) == numMatch){
                res.add(w);
            }
        }
        return res.toArray(new String[]{});
    }
    
    private int countMatches(String w1, String w2){
        //int len = Math.min(w1.length(), w2.length());
        int cnt = 0;
        
        for (int i = 0; i < 6; i++){
            if (w1.charAt(i) == w2.charAt(i)){
                cnt++;
            }
        }
        
        return cnt;
    }
}