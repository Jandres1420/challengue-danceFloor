package solution_one;

public class EndavaDanceFloor {
    private int length;
    private int[][] matrix;
    public EndavaDanceFloor(int length, int[][] matrix){
        this.length = length;
        this.matrix = matrix;
    }

    public int getShortestPath(){
        for (int i = 0 ; i < length ; i++){
            for (int j = 0 ; j < length ; j++){
                System.out.println('h');
                if(isValid(matrix[i][j],matrix[i+1][j])||isValid(matrix[i][j],matrix[i][j+1]))
                    System.out.println("Numero i j " + matrix[i][j]  +  " numero a la derecha " + matrix[i][j+1]);
            }
        }

        return 0;
    }

    public String getPath(){
        return "";
    }

    public boolean isValid(int a , int b ){
        if(a+1 == b || a-1==b) return true;
        return false;
    }
}
