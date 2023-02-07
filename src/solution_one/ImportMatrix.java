package solution_one;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.stream.Stream;

public class ImportMatrix {
    private int lenghtMatrix;
    private int[][] matrix;

    public ImportMatrix() {

    }

    public void getMatrix(){
        String nombreArchivo = "DanceFloor01.txt";
        try (BufferedReader br = new BufferedReader(new FileReader(nombreArchivo))) {
            String linea;
            int cont = 0;
            while ((linea = br.readLine()) != null) {
                if(cont == 0) lenghtMatrix = Integer.parseInt(linea);
                else{
                    String[] matrix = linea.split(" ");
                }
                System.out.println(linea);
                cont++;
            }
            System.out.println("La longitud de la matriz es " + lenghtMatrix);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void mientras(){
        /**
        int lenght = scanner.nextInt();
        int[][] final_matrix = new int[lenght][lenght];
        for (int i = 0 ; i < lenght; i++){
            scanner = new Scanner(System.in);
            String filas = scanner.nextLine();
            String[] matrix = filas.split(" ");
            final_matrix[0]= Stream.of(matrix).mapToInt(Integer::parseInt).toArray();;}*/

    }

    public int getLenghtMatrix() {
        return lenghtMatrix;
    }

    public void setLenghtMatrix(int lenghtMatrix) {
        this.lenghtMatrix = lenghtMatrix;
    }

    public void setMatrix(int[][] matrix) {
        this.matrix = matrix;
    }
}
