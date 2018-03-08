/*
    A Graph is a collection of nodes or vertices and edges between them. We can traverse these node using the edges
    which can or cannot be weigthed.
    
    There are two kinds of Graphs
        * Un-directed Graph - When you traverse either direction between two nodes.
        * Directed Graph - When you can traverse only in the specified direction between two nodes.
    
    There are two common ways to represent a graph
        * Adjancency Matrix - Its is a 2D Matrix array which has the size of VxV, where V are the number of vertices in
            the graph.
            adMatrix[i][j] = 1, when there is a edge between vertex i and vertex j, else 0;
            It's easier to implement because removing and insertion of an edge takes only O(1)
            But the drawback is that it takes O(V2) space even though there are very less edges in the graphs

        * Adjancency List - Its an array of a linkedlist, where array size is the same as number of Vertices in the graph.
            Every vertex has a linkedkist. each node in this linkedlist represents the reference to the other vertices which
            share an edge with the current vertex. the weights can also be stored in the linked list.

*/

class adjNode{

    int source;
    int destination;
    adjNode next;

    public adjNode( int source, int destination ){
        this.source = source; 
        this.destination = destination;
        next = null;
    }
}

class adjList{
    adjNode head;
}

class Graph{
    int V;
    adjList array[];

    //contructor of graph, initialize the number of vertex in the graph
    //and create those many adjacency list and initialize all heads to null

    public Graph( int V ){
        this.V = V;
        array = new adjList[V];

        for( int i=0; i<V; i++ ){
            array[i] = new adjList();
            array[i].head = null;
        }
    }

    public void addEdge( int source, int destination ){
        // first create a forward edge source -> destination
        adjNode adn = new adjNode( source, destination );

        //add this node to the source adj list
        adn.next = array[ source ].head;
        array[ source ].head = adn;

        // now create a reverse edge since its a unidirected graph
        // adn = new adjNode( source );
        // adn.next = array[destination].head
        //array[destination].head = adn;
    }
    public void printGraph( Graph grp ){
        int vertex = grp.V;
        adjNode ad;

        for( int i=0; i<vertex; i++ ){
            ad = grp.array[i].head;
            if( ad != null ){
                System.out.println("\nNode connected to vertex " + ad.source + " are : ");

                while( ad != null ){
                    System.out.println( " " + ad.destination );
                    ad = ad.next;
                }
            }
        }
    }

}

class GraphAdjacencyMatrix{
    public static void main(String args[]) {
		Graph gph = new Graph(5);
		gph.addEdge(0, 1);
		gph.addEdge(0, 2);
		gph.addEdge(0, 3);
		gph.addEdge(1, 2);
		gph.addEdge(2, 4);
		gph.printGraph(gph);
	}
}