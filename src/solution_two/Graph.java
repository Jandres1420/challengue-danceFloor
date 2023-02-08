package solution_two;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// A class to store a graph edge
class Edge
{
    int  weight;
    double source,dest;

    public Edge(double source, double dest, int weight)
    {
        this.source = source;
        this.dest = dest;
        this.weight = weight;
    }
}

// A class to represent a graph object
class Graph
{
    // A list of lists to represent an adjacency list
    List<List<Edge>> adjList = null;

    // Constructor
    Graph(List<Edge> edges, int n)
    {
        adjList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }

        // add edges to the directed graph
        for (Edge edge: edges) {
            adjList.get((int) edge.source).add(edge);
        }
    }
}

class Main
{
    // Perform DFS on the graph and set the departure time of all
    // vertices of the graph
    private static int DFS(Graph graph, int v, boolean[] discovered,
                           int[] departure, int time)
    {
        // mark the current node as discovered
        discovered[v] = true;

        // set arrival time – not needed
        // time++;

        // do for every edge (v, u)
        for (Edge e: graph.adjList.get(v))
        {
            int u = (int) e.dest;

            // if `u` is not yet discovered
            if (!discovered[u]) {
                time = DFS(graph, u, discovered, departure, time);
            }
        }

        // ready to backtrack
        // set departure time of vertex `v`
        departure[time] = v;
        time++;

        return time;
    }

    // The function performs the topological sort on a given DAG and then finds
    // the longest distance of all vertices from a given source by running
    // one pass of the Bellman–Ford algorithm
    public static void findLongestDistance(Graph graph, int source, int n)
    {
        // departure[] stores vertex number having its departure
        // time equal to the index of it
        int[] departure = new int[n];
        Arrays.fill(departure, -1);

        // to keep track of whether a vertex is discovered or not
        boolean[] discovered = new boolean[n];
        int time = 0;

        // perform DFS on all undiscovered vertices
        for (int i = 0; i < n; i++)
        {
            if (!discovered[i]) {
                time = DFS(graph, i, discovered, departure, time);
            }
        }

        int[] cost = new int[n];
        Arrays.fill(cost, Integer.MAX_VALUE);

        cost[source] = 0;

        // Process the vertices in topological order, i.e., in order
        // of their decreasing departure time in DFS
        for (int i = n - 1; i >= 0; i--)
        {
            // for each vertex in topological order,
            // relax the cost of its adjacent vertices
            int v = departure[i];
            for (Edge e: graph.adjList.get(v))
            {
                // edge `e` from `v` to `u` having weight `w`
                int u = (int) e.dest;
                int w = e.weight * -1;		// make edge weight negative

                // if the distance to destination `u` can be shortened by
                // taking edge (v, u), then update cost to the new lower value
                if (cost[v] != Integer.MAX_VALUE && cost[v] + w < cost[u]) {
                    cost[u] = cost[v] + w;
                }
            }
        }

        // print the longest paths
        for (int i = 0; i < n; i++) {
            System.out.printf("dist(%d, %d) = %2d\n", source, i, cost[i] * -1);
        }
    }

    public static void main(String[] args)
    {
        // List of graph edges as per the above diagram
        List<Edge> edges = Arrays.asList(
                new Edge(25, 24, 1), new Edge(22, 21, 1), new Edge(23, 24, 1),
                new Edge(23, 24, 1), new Edge(24, 25, 1), new Edge(25, 24, 1),
                new Edge(25, 26, 1), new Edge(26, 25, 1), new Edge(26, 27, 1),
                new Edge(27, 28, 1), new Edge(27, 28, 1), new Edge(28, 29, 1),
                new Edge(23, 24, 1), new Edge(24, 25, 1), new Edge(28, 27, 1),
                new Edge(28, 29, 1), new Edge(23, 24, 1), new Edge(24, 25, 1),
                new Edge(28, 27, 1), new Edge(28, 29, 1), new Edge(23, 22, 1),
                new Edge(27, 26, 1)
        );

        // total number of nodes in the graph (labelled from 0 to 7)
        int n = 8;

        // build a graph from the given edges
        Graph graph = new Graph(edges, n);

        // source vertex
        int source = 7;

        // find the longest distance of all vertices from a given source
        findLongestDistance(graph, source, n);
    }
}