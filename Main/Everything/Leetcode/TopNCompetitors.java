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
        List<String> res = new ArrayList<>();
	Set<String> set = new HashSet<>(Arrays.asList(keywords));
	Map<String, Integer> map = new HashMap<>();
	for(String r : reviews) {
		String[] strs = r.split("\\W");
		Set<String> added = new HashSet<>();
		for(String s : strs) {
			s = s.toLowerCase();
			if(set.contains(s) && !added.contains(s)) {
				map.put(s, map.getOrDefault(s, 0) + 1);
				added.add(s);
			}
		}
	}
	Queue<Map.Entry<String, Integer>> maxHeap = new PriorityQueue<>((a, b)->a.getValue() == b.getValue() ? a.getKey().compareTo(b.getKey()) : b.getValue() - a.getValue());
	maxHeap.addAll(map.entrySet());
	while(!maxHeap.isEmpty() && k-- > 0) {
		res.add(maxHeap.poll().getKey());
	}
	return res;
    }
}