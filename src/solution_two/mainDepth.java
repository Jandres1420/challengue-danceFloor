package solution_two;

import java.util.Arrays;

public class mainDepth {
    public static void main(String[] args) {
        VertexD<Integer> v0 = new VertexD<>(0);
        VertexD<Integer> v1 = new VertexD<>(1);
        VertexD<Integer> v2 = new VertexD<>(2);
        VertexD<Integer> v3 = new VertexD<>(3);
        VertexD<Integer> v4 = new VertexD<>(4);
        VertexD<Integer> v5 = new VertexD<>(5);
        VertexD<Integer> v6 = new VertexD<>(6);
        v0.setNeighbors(Arrays.asList(v1, v5, v6));
        v1.setNeighbors(Arrays.asList(v3, v4, v5));
        v4.setNeighbors(Arrays.asList(v2, v6));
        v6.setNeighbors(Arrays.asList(v0));
        DepthFirstSearch<Integer> dfs = new DepthFirstSearch<>();
        dfs.traverse(v0);

    }
}