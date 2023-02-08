package solution_two;

import java.util.ArrayList;
import java.util.List;

public class GraphStructure {
    private ArrayList<Integer> possiblePaths;
    private List<Edge> edges;
    public GraphStructure(ArrayList<Integer> possiblePaths){
        this.possiblePaths = possiblePaths;
         edges = new ArrayList<>();
    }

    public void createEdges(){
        for(int i = 0; i < possiblePaths.size();i++){
            if(i==possiblePaths.size()-1){
                break;
            }else{
                System.out.println("source " +possiblePaths.get(i)+ " destination " +possiblePaths.get(i+1));
              //  edges.add(new Edge(possiblePaths.get(i),possiblePaths.get(i+1),1));
                i++;
            }
          //
        }
    }

    public int numberOfNodes(){

        return 0;
    }

}
