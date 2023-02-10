package solution;


import java.util.*;


public class ConverterEdge {
    private int[][] matrix;
    private int length;
    private ArrayList<Integer> possiblePaths;
    private LinkedList<Integer> integerLinkedList;

    private HashMap<String,ArrayList<String>> path;
    public ConverterEdge(int length,int[][]matrix){
        this.length = length;
        this.matrix = matrix;
        possiblePaths = new ArrayList<>();
        integerLinkedList = new LinkedList<>();
        path = new HashMap<>();
       // getRecursive(matrix,0,0);
        getPossiblePaths();
    }
    public void getPossiblePaths(){

        if(length ==1) {
            System.out.println("The longest path is: " + matrix[0][0] + " \nTotal of Endavans " + 1);
        }
        for (int i = 0 ; i < length ; i++){
            for (int j = 0 ; j < length ; j++){ // O(n) + O(n^2)
                if(i==length-1 && j==length-1)break;
                else addingPath(i,j);
            }
        }
    }

    public void getRecursive(int[][] matrix,int i , int j ) {
        if(i < matrix.length){
            if(j < matrix.length){
                if(isValid(matrix[i][j],matrix[i][j+1]) && j!=length-1){
                    addingRightValue(matrix,i,j);
                  //  if (((isValid(matrix[i][j],matrix[i+1][j]) && i!=length-1) && j!=length)
                    getRecursive(matrix,i,j+1);
                }if((isValid(matrix[i][j],matrix[i+1][j]) && i!=length-1) && j!=length){
                    addingDownValue(matrix,i,j);
                    getRecursive(matrix,i,j+1);
                }else getRecursive(matrix,i,j+1);
            }
        }
    }

    public void addingDownValue(int[][] matrix, int i , int  j){
        integerLinkedList.add(matrix[i][j]);
        integerLinkedList.add(matrix[i+1][j]);
    }

    public void addingRightValue(int[][] matrix, int i , int  j){
        integerLinkedList.add(matrix[i][j]);
        integerLinkedList.add(matrix[i][j+1]);
    }
        
        
    public void addingPath(int i, int j){
        String position = "["+i+"]"+"["+j+"]";
        String positionBellow = "["+(i+1)+"]"+"["+j+"]";
        String positionRight = "["+i+"]"+"["+(j+1)+"]";
        if(j==length-1){
            if(isValid(matrix[i][j],matrix[i+1][j])){
                if (path.containsKey(""+matrix[i][j]+position)) path.get(""+matrix[i][j]+position).add(""+matrix[i+1][j]+positionBellow);
                else path.put(""+matrix[i][j]+position,new ArrayList<>(Arrays.asList(""+matrix[i+1][j]+positionBellow)));
                }
        }else if(i==length-1){
            if(isValid(matrix[i][j],matrix[i][j+1])){
                if (path.containsKey(""+matrix[i][j]+position)) path.get(""+matrix[i][j]+"["+i+"]").add(""+matrix[i][j+1]+positionRight);
                else path.put(""+matrix[i][j]+position,new ArrayList<>(Arrays.asList(""+matrix[i][j+1]+positionRight)));
                }
        }else{
            if(isValid(matrix[i][j],matrix[i+1][j])){
                if (path.containsKey(""+matrix[i][j]+position)) path.get(""+matrix[i][j]+position).add(""+matrix[i+1][j]+positionBellow);
                else path.put(""+matrix[i][j]+position,new ArrayList<>(Arrays.asList(""+matrix[i+1][j]+positionBellow)));
                }
            if(isValid(matrix[i][j],matrix[i][j+1])){
                if (path.containsKey(""+matrix[i][j]+position)) path.get(""+matrix[i][j]+position).add(""+matrix[i][j+1]+positionRight);
                else path.put(""+matrix[i][j]+position,new ArrayList<>(Arrays.asList(""+matrix[i][j+1]+positionRight)));}
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


    public HashMap<String, ArrayList<String>> getPath() {
        return path;
    }

    public int getLength() {
        return length;
    }

    public void setPath(HashMap<String, ArrayList<String>> path) {
        this.path = path;
    }
}
