package solution_one;


public class Main {
    public static void main(String[] args) {
        ImportMatrix importMatrix = new ImportMatrix();
        EndavaDanceFloor endavaDanceFloor = new EndavaDanceFloor(importMatrix.getlengthMatrix(), importMatrix.getMatrix());
        endavaDanceFloor.getShortestPath();

    }
}