class TwitterRecommendations{
    static int[] getRecommendedTweets(int[][] followGraph_edges, int[][] likeGraph_edges, int targetUser, int minLikeThreshold) {

        ArrayList<Integer> followers = new ArrayList<Integer>();
        for( int i[]: followGraph_edges ){
            if( i[0] == targetUser ){
                followers.add(i[1]);
            }
        }
        
        Map<Integer, Integer> recommendedPossibleTweets = new HashMap<Integer, Integer>();
        for( int j[]: likeGraph_edges ){
            int count = 0;
            if( followers.contains(j[0])){
                if( recommendedPossibleTweets.containsKey( j[1] )){
                    count = recommendedPossibleTweets.get( j[1] );
                }
                recommendedPossibleTweets.put( j[1], ++count );
            }
        }
        
        List<Integer> unpopularTweets = new ArrayList<Integer>();
        for( Map.Entry<Integer, Integer> temp: recommendedPossibleTweets.entrySet()){
            if( temp.getValue() < minLikeThreshold ){
                unpopularTweets.add( temp.getKey() );
            }
        }
        
        for( Iterator<Integer> iterator = unpopularTweets.iterator(); iterator.hasNext(); ){
            Integer key = iterator.next();
            recommendedPossibleTweets.remove( key );
        }
        
        Set<Integer> recommendations = recommendedPossibleTweets.keySet();
        int ans[] = new int[recommendations.size()];
        int index = 0;
        for( Integer element: recommendations ){
            ans[index++] = element.intValue();
        }
        
        return ans;
    }

        public static void main(String[] args) throws IOException{
            Scanner in = new Scanner(System.in);
            final String fileName = System.getenv("OUTPUT_PATH");
            BufferedWriter bw = new BufferedWriter(new FileWriter(fileName));
            int[] res;
            
            String[] _followGraph_nodesm = in.nextLine().split(" ");
            int _followGraph_nodes = Integer.parseInt(_followGraph_nodesm[0]);
            int _followGraph_edges = Integer.parseInt(_followGraph_nodesm[1]);
            
            int[] _followGraph_from = new int[_followGraph_edges];
            int[] _followGraph_to = new int[_followGraph_edges];
            
            for (int _followGraph_i = 0; _followGraph_i < _followGraph_edges; _followGraph_i++) {
                String[] _followGraph_fromv = in.nextLine().split(" ");
                _followGraph_from[_followGraph_i] = Integer.parseInt(_followGraph_fromv[0]);
                _followGraph_to[_followGraph_i] = Integer.parseInt(_followGraph_fromv[1]);
            }
            
            
            String[] _likeGraph_nodesm = in.nextLine().split(" ");
            int _likeGraph_nodes = Integer.parseInt(_likeGraph_nodesm[0]);
            int _likeGraph_edges = Integer.parseInt(_likeGraph_nodesm[1]);
            
            int[] _likeGraph_from = new int[_likeGraph_edges];
            int[] _likeGraph_to = new int[_likeGraph_edges];
            
            for (int _likeGraph_i = 0; _likeGraph_i < _likeGraph_edges; _likeGraph_i++) {
                String[] _likeGraph_fromv = in.nextLine().split(" ");
                _likeGraph_from[_likeGraph_i] = Integer.parseInt(_likeGraph_fromv[0]);
                _likeGraph_to[_likeGraph_i] = Integer.parseInt(_likeGraph_fromv[1]);
            }
            
            // generate follow Graph
            int[][] followGraph = new int[_followGraph_edges][2];
            for (int i = 0; i < _followGraph_edges; i++) {
                followGraph[i][0] = _followGraph_from[i];
                followGraph[i][1] = _followGraph_to[i];
            }
            // generate like Graph
            int[][] likeGraph = new int[_likeGraph_edges][2];
            for (int i = 0; i < _likeGraph_edges; i++) {
                likeGraph[i][0] = _likeGraph_from[i];
                likeGraph[i][1] = _likeGraph_to[i];
            }
            int _targetUser;
            _targetUser = Integer.parseInt(in.nextLine().trim());
            
            int _minLikeThreshold;
            _minLikeThreshold = Integer.parseInt(in.nextLine().trim());
            
            res = getRecommendedTweets(followGraph, likeGraph, _targetUser, _minLikeThreshold);
            if (res == null) {
                bw.write("Null Result");
                bw.newLine();
                bw.close();
                return;
            }
            for(int res_i=0; res_i < res.length; res_i++) {
                bw.write(String.valueOf(res[res_i]));
                bw.newLine();
            }
            bw.close();
        }
}