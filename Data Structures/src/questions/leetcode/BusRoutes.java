package questions.leetcode;

import java.util.*;

class BusRoutes {
    public int numBusesToDestination(int[][] routes, int source, int dest) {
        int N=routes.length;
        Map<Integer, List<Integer>> stopRouteMap=new HashMap<>();
        for (int index=0;index<N;index++){
            for (int stop:routes[index]){
                stopRouteMap.putIfAbsent(stop,new ArrayList<Integer>());
                stopRouteMap.get(stop).add(index);
            }
        }
        if(source==dest){
            return 0;
        }
        if(!stopRouteMap.containsKey(source)|| !stopRouteMap.containsKey(dest)){
            return -1;
        }
        Queue<Integer> queue=new LinkedList<Integer>();
        queue.add(source);
        int counter=0;
        Set<Integer> visitedStops=new HashSet<>();
        boolean visitedRoutes[]=new boolean[N];
        while(!queue.isEmpty()){
            counter++;
            int stopSize=queue.size();
            for(int ctr=1;ctr<=stopSize;ctr++){
                int stop=queue.poll();
                for(int routeIdx: stopRouteMap.get(stop)){
                    if(visitedRoutes[routeIdx]){
                        continue;
                    }
                    visitedRoutes[routeIdx]=true;
                    for(int rstop:routes[routeIdx]){
                        if(rstop==dest){
                            return counter;
                        }
                        if(!visitedStops.contains(rstop)){
                            queue.add(rstop);
                            visitedStops.add(rstop);
                        }
                    }
                }
            }
        }return -1;
    }}
