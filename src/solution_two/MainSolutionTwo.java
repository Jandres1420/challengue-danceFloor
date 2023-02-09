package solution_two;

import solution_one.ImportMatrix;

public class MainSolutionTwo {
    public static void main(String[] args) {
        ImportMatrix importMatrix = new ImportMatrix();
        ConverterEdge converterEdge = new ConverterEdge(importMatrix.getlengthMatrix(), importMatrix.getMatrix());
        GraphStructure graphStructure = new GraphStructure(converterEdge.getPath());
        graphStructure.conectingEdges();
    }
}