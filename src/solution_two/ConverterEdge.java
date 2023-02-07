package solution_two;

import com.sun.deploy.net.MessageHeader;

import java.util.ArrayList;
import java.util.Iterator;

public class ConverterEdge {
    private int[][] matrix;
    private int length;
    private ArrayList<Integer> possiblePaths;
    public ConverterEdge(int length,int[][]matrix){
        this.length = length;
        this.matrix = matrix;
        possiblePaths = new ArrayList<>();
        getPossiblePaths();
    }
    public void getPossiblePaths(){

        for (int i = 0 ; i < length ; i++){
            for (int j = 0 ; j < length ; j++){
                if(i==length-1 && j==length-1)break;
                else addingPath(i,j);
            }
        }
    }
        
    public void addingPath(int i, int j){
        if(j==length-1){
            if(isValid(matrix[i][j],matrix[i+1][j])){
                System.out.println("Numero i j " + matrix[i][j]  +  " numero a la abajo " + matrix[i+1][j]);
                possiblePaths.add(matrix[i][j]);
                possiblePaths.add(matrix[i+1][j]);
                }
        }else if(i==length-1){
            if(isValid(matrix[i][j],matrix[i][j+1])){
                System.out.println("Numero i j " + matrix[i][j]  +  " numero a la derecha " + matrix[i][j+1]);
                possiblePaths.add(matrix[i][j]);
                possiblePaths.add(matrix[i][j+1]);
                }
        }else{
            if(isValid(matrix[i][j],matrix[i+1][j])){
                System.out.println("Numero i j " + matrix[i][j]  +  " numero a la abajo " + matrix[i+1][j]);
                possiblePaths.add(matrix[i][j]);
                possiblePaths.add(matrix[i+1][j]);
                }
            if(isValid(matrix[i][j],matrix[i][j+1])){
                System.out.println("Numero i j " + matrix[i][j]  +  " numero a la derecha " + matrix[i][j+1]);
                possiblePaths.add(matrix[i][j]);
                possiblePaths.add(matrix[i][j+1]);}
        }
    }

    public boolean isValid(int a , int b ){
        if(a+1 == b || a-1==b) return true;
        return false;
    }

    public void setPossiblePaths(ArrayList<Integer> possiblePaths) {
        this.possiblePaths = possiblePaths;
    }


    public ArrayList<Integer> getPaths(){
        return possiblePaths;
    }
}
