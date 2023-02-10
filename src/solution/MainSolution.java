package solution;

public class MainSolution {
    public static void main(String[] args) {
        ImportMatrix importMatrix = new ImportMatrix();
        ConverterEdge converterEdge = new ConverterEdge(importMatrix.getlengthMatrix(), importMatrix.getMatrix());
        GraphStructure graphStructure = new GraphStructure(converterEdge.getPath(),converterEdge.getLength());
        graphStructure.conectingEdges();
    }
}