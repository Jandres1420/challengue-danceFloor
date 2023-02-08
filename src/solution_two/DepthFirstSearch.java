package solution_two;

import java.util.Collection;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;

public class DepthFirstSearch<T>{

    public void traverse(VertexD<T> startVertex ){
        Deque<VertexD<T>> stack = new LinkedList<>();
        stack.push(startVertex);
        while (!stack.isEmpty()){
            VertexD<T> current = stack.pop();
            current.setVisited(true);
            System.out.println(current);
            Collections.reverse(current.getNeighbors());
            current.getNeighbors().forEach(stack::push);
        }
    }
}
