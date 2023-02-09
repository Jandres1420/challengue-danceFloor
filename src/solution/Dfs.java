package solution;

import java.util.*;

class Dfs {
    private int max = 0;
    private String longestPath = "";
    private int size = 0;
    public void findLongestPath(String node, HashMap<String, ArrayList<String>> graph, String path) {
        path = path + node + " -> ";
        if (!graph.containsKey(node) || graph.get(node).isEmpty()) {
            if (path.length() > max) {
                max = path.length();
                longestPath = path;
                size++;
            }
            return;
        }
        ArrayList<String> neighbours = graph.get(node);
        for (String neighbour : neighbours) {
            findLongestPath(neighbour, graph, path);
        }
    }

    public int getPathSize(){
        int totalCharacters = 0;
        char temp;
        for (int i = 0; i < longestPath.length(); i++) {

            temp = longestPath.charAt(i);
            if (temp == '[')
                totalCharacters++;
        }
        return totalCharacters/2;
    }



    public String getLongestPath() {
        return longestPath;
    }

    public int getSize() {
        return size;
    }

}