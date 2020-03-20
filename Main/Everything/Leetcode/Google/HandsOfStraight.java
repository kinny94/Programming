class HandsOfStraight {
    public boolean isNStraightHand(int[] hand, int W) {
        if (hand.length % W != 0) {
            return false;
        }
        
        Map<Integer, Integer> map = new TreeMap();
        
        for (int i: hand) {
            map.put(i, map.getOrDefault(i, 0)+1);
        }
        
        for (int item: map.keySet()) {
            if (map.get(item) > 0) {
                for (int i=W-1; i>=0; --i) {
                    if (map.getOrDefault(item+ i, 0) < map.get(item)) return false;
                    map.put(item + i, map.get(item + i) - map.get(item));
                }
            }
        }
        
        return true;
    }
}