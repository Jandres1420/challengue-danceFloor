package solution_two;

import solution_one.ImportMatrix;

import java.util.*;

class LongestPath {
    static int max = 0;
    static String longestPath = "";
    static int size = 0;
    public static void findLongestPath(String node, HashMap<String, ArrayList<String>> graph, String path) {
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

    static int getPathSize(){
        int totalCharacters = 0;
        char temp;
        for (int i = 0; i < longestPath.length(); i++) {

            temp = longestPath.charAt(i);
            if (temp == '[')
                totalCharacters++;
        }
        return totalCharacters/2;
    }

    public static void main(String[] args) {
        ImportMatrix importMatrix = new ImportMatrix();
        ConverterEdge converterEdge = new ConverterEdge(importMatrix.getlengthMatrix(), importMatrix.getMatrix());
        HashMap<String, ArrayList<String>> graph = converterEdge.getPath();
        ArrayList<String> nodes = new ArrayList<>();

        for(String key : graph.keySet()){
            nodes.add(key);
            for (int i = 0 ; i <graph.get(key).size();i++){
                if(!nodes.contains(graph.get(key).get(i))){
                    nodes.add(graph.get(key).get(i));
                }

            }

        }
        for (String node : nodes) {
            findLongestPath(node, graph, "");
        }
        System.out.println("The longest path is: " + longestPath + " size " + getPathSize()) ;
    }
}