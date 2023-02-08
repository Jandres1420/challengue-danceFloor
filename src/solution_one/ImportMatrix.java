package solution_one;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.stream.Stream;

public class ImportMatrix {
    private int lengthMatrix;
    private int[][] matrix;

    public ImportMatrix(){
        readMatrix();
    }


    public void readMatrix(){
        String nombreArchivo = "inputs/DanceFloor01.txt";
        try (BufferedReader br = new BufferedReader(new FileReader(nombreArchivo))) {
            String linea;
            int cont = 0;
            while ((linea = br.readLine()) != null) {
                if(cont == 0){
                    lengthMatrix = Integer.parseInt(linea);
                    matrix = new int[lengthMatrix][lengthMatrix];
                }
                else{
                    String[] converter = linea.split(" ");
                    matrix[cont-1]= Stream.of(converter).mapToInt(Integer::parseInt).toArray();
                }
                cont++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public int getlengthMatrix() {
        return lengthMatrix;
    }

    public void setlengthMatrix(int lengthMatrix) {
        this.lengthMatrix = lengthMatrix;
    }

    public void setMatrix(int[][] matrix) {
        this.matrix = matrix;
    }

    public int[][] getMatrix() {
        return matrix;
    }
}
