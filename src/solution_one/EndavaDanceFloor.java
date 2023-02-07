package solution_one;

import java.util.ArrayList;
import java.util.Iterator;

public class EndavaDanceFloor {
    private int length;
    private int[][] matrix;
    private ArrayList<ArrayList<Integer>> correctPath;
    public EndavaDanceFloor(int length, int[][] matrix){
        this.length = length;
        this.matrix = matrix;
        correctPath = new ArrayList<ArrayList<Integer>>();
    }

    public int getShortestPath(){
        ArrayList<Integer> flag = new ArrayList<>();
        for (int i = 0 ; i < length ; i++){
            for (int j = 0 ; j < length ; j++){
                if(i==length-1 && j==length-1)break;
                else addingPath(i,j,flag);
                }
        }
        Iterator i = correctPath.iterator();
        while (i.hasNext()){

        }
        return 0;
    }

    public String getPath(){
        return "";
    }

    public void addingPath(int i, int j, ArrayList<Integer> possiblePaths){
        if(j==length-1){
            if(isValid(matrix[i][j],matrix[i+1][j])){
                System.out.println("Numero i j " + matrix[i][j]  +  " numero a la abajo " + matrix[i+1][j]);
                possiblePaths.add(matrix[i][j]);
                possiblePaths.add(matrix[i+1][j]);
                correctPath.add(possiblePaths);}
        }else if(i==length-1){
            if(isValid(matrix[i][j],matrix[i][j+1])){
                System.out.println("Numero i j " + matrix[i][j]  +  " numero a la derecha " + matrix[i][j+1]);
                possiblePaths.add(matrix[i][j]);
                possiblePaths.add(matrix[i][j+1]);
                correctPath.add(possiblePaths);}
        }else{
            if(isValid(matrix[i][j],matrix[i+1][j])){
                System.out.println("Numero i j " + matrix[i][j]  +  " numero a la abajo " + matrix[i+1][j]);
                possiblePaths.add(matrix[i][j]);
                possiblePaths.add(matrix[i+1][j]);
                correctPath.add(possiblePaths);}
            if(isValid(matrix[i][j],matrix[i][j+1])){
                System.out.println("Numero i j " + matrix[i][j]  +  " numero a la derecha " + matrix[i][j+1]);
                possiblePaths.add(matrix[i][j]);
                possiblePaths.add(matrix[i][j+1]);
                correctPath.add(possiblePaths);}
        }

    }

    public boolean isValid(int a , int b ){
        if(a+1 == b || a-1==b) return true;
        return false;
    }
}
