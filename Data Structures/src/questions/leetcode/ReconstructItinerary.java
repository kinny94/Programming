package questions.leetcode;

import java.util.*;

public class ReconstructItinerary {
    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String, List<String>> flightMap = new HashMap<>();
        List<String> result = new ArrayList<>();

        for (List<String> ticket: tickets) {
            flightMap.putIfAbsent(ticket.get(0), new ArrayList<>());
            flightMap.get(ticket.get(0)).add(ticket.get(1));
        }

        for (List<String> destinations: flightMap.values()) {
            destinations.sort(Collections.reverseOrder());
        }

        dfsTraversal("JFK", flightMap, result);
        Collections.reverse(result);
        return result;
    }

    private void dfsTraversal(String current, Map<String, List<String>> flightMap, List<String> result) {
        List<String> destinations = flightMap.get(current);
        while(destinations != null && !destinations.isEmpty()) {
            String nextDestination = destinations.remove(destinations.size() - 1);
            dfsTraversal(nextDestination, flightMap, result);
        }
        result.add(current);
    }
}
