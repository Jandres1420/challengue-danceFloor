package solution_two;

public class traverseRecursively<T> {

    public void traverseRecursively (VertexD<T> vertex) {
        vertex.setVisited(true);
        System.out.println (vertex);

        vertex.getNeighbors().forEach(neighbor -> {
            if (!neighbor.isVisited()){
                traverseRecursively(neighbor);
                }
            });
        }

    }
