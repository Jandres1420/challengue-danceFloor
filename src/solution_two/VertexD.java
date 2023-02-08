package solution_two;

import java.util.ArrayList;
import java.util.List;

public class VertexD<T> {
    private final T data;

    private boolean visited;

    private List<VertexD<T>> neighbors = new ArrayList<>();

    public VertexD(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public List<VertexD<T>> getNeighbors() {
        return neighbors;
    }

    public void setNeighbors(List<VertexD<T>> neighbors) {
        this.neighbors = neighbors;
    }

    @Override
    public String toString() {
        return "VertexD{" +
                "neighbors=" + neighbors +
                '}';
    }
}


