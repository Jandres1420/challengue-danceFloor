
package solution_two;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class GraphStructure {

    private HashMap<String, ArrayList<String>> graph;
    private ArrayList<String> nodes;
    public GraphStructure(HashMap<String, ArrayList<String>> graph){
        this.graph =graph;
        nodes = new ArrayList<>();
        creatingNodes();
    }

    private void creatingNodes(){
        for(String key : graph.keySet()){
            nodes.add(key);
            for (int i = 0 ; i <graph.get(key).size();i++){
                if(!nodes.contains(graph.get(key).get(i))){
                    nodes.add(graph.get(key).get(i));
                }
            }

        }
    }

    public void conectingEdges(){
        Dfs dfs = new Dfs();
        for (String node : nodes) {
            dfs.findLongestPath(node, graph, "");
        }
        System.out.println("The longest path is: " + dfs.getLongestPath() + " size " + dfs.getPathSize()) ;
    }


}
