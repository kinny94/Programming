import java.util.*;
// "static void main" must be defined in a public class.

public class TopNCompetitors {
    public static void main(String[] args) {
                
        List<String> result = getTopCompetitors(numCompetitors, topNCompetitors, competitors, numReviews, reviews);
        
        System.out.println(result);
    }
    
    
    public static List<String> getTopCompetitors(int numCompetitors, int topNCompetitors
                                                 , String[] competitors, int numReviews, String[] reviews) {
        HashMap<String, Integer> map = new HashMap<>();
        // add all competitors into HashMap
        for(int i=0; i<numCompetitors; i++) {
            map.put(competitors[i].toLowerCase(), 0);
        }
        
        // O(N)
        // loop through all reveiws
        for(String review: reviews) {
            String[] words = review.toLowerCase().split(" ");
            
            Set<String> used = new HashSet<>();
            // loop through all words in a review
            for(String word: words) {
                if(map.containsKey(word)
                   && used.add(word)) {
                    map.put(word, map.get(word) + 1);
                }
            }
        }
        
        // O(log N)
        PriorityQueue<Map.Entry<String, Integer>> queue = new PriorityQueue<>((a, b) -> ( a.getValue() == b.getValue() 
                                                                                                                                               ? b.getKey().compareTo(a.getKey())
                                                                                                                                               : a.getValue() - b.getValue() ));
        
        // O(N)
        for(Map.Entry entry: map.entrySet()) {
            queue.offer(entry);
            if(queue.size() > topNCompetitors) {
                queue.poll();
            }
        }
        
        // O(N)
        String[] result = new String[topNCompetitors];
        for(int i=topNCompetitors-1; i>=0 && !queue.isEmpty(); i--) {
            Map.Entry<String, Integer> entry = queue.poll();
            result[i] = entry.getKey();
        }
        
        ArrayList<String> r = new ArrayList<>();
        for(String d: result) {
            r.add(d);
        }
        return r;
    }
}