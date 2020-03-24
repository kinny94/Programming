class OptimalAccountBalancing {
    public int minTransfers(int[][] transactions) {
        if(transactions == null) return 0;
        if(transactions.length <= 1) return transactions.length;
        
        Map<Integer, Integer> txn = new HashMap<>();
        for(int[] t : transactions) {
            txn.put(t[0], txn.getOrDefault(t[0], 0) + t[2]);
            txn.put(t[1], txn.getOrDefault(t[1], 0) - t[2]);
        }
        
        int[] balance = new int[txn.size()];
        int i = 0;
        for(int bal : txn.values())
        balance[i++] = bal;
        
        Arrays.sort(balance);
        
        return zeroTxn(balance) + minTransfers(0, balance);
    }
    
    private int zeroTxn(int[] balance) {
        int start = 0, end = balance.length -1, ans = 0;
        while(start < end) {
            if(balance[start] == 0) start++;
            else if(balance[start] + balance[end] == 0) {
                balance[start++] = balance[end--] = 0;
                ans++;
            } else if(balance[start] + balance[end] < 0) start++;
            else end--;
        }
        
        return ans;
    }
    
    private int minTransfers(int k, int[] balance) {
        while(k < balance.length && balance[k] == 0) k++;
        if(k == balance.length) return 0;
        
        
        int current = balance[k];
        
        int min = Integer.MAX_VALUE;
        for(int i = k + 1; i < balance.length; i++) {
            int next = balance[i];
            
            if(next * current < 0) {
                balance[i] = next + current;
                min = Math.min(min, 1 + minTransfers(k+1, balance));
                balance[i] = next;
            }
        }
        
        return min;
    }
}