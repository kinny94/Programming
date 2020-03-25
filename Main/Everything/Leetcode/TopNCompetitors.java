import java.util.*;
// "static void main" must be defined in a public class.

public class TopNCompetitors {
    public static void main(String[] args) {
        
        
        int numCompetitors = 5;
        int topNCompetitors = 2;
        String[] competitors = {"anacell", "betacellular", "cetracular", "deltacellular", "eurocell"};
        int numReviews = 3;
        String[] reviews = {
            "I love anacell best services provided by anacell", 
            "betacellular has great services", 
            "deltacellular provides much better services than betacellular", 
            "cetracular is worse than eurocell",
            "betacellular is better than deltacellular"
        };

        /*
        intuition: Top N frequently used words
        - store the competitors into map, along with their frequent count
        - loop through reviews
            - convert the review to lowercase, and split by space
            - if a word is not a competitor then avoid
            - if a word is being used already for a review then avoid
            - else increase the count of the competitor
        - Create a PriorityQueue to find the N top elements, and provided logic to sort
        - Create an array, and fill up with the N top elements
        */
                
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