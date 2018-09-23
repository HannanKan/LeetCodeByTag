import javafx.util.Pair;

import java.util.HashSet;

public class Solution15 {
    public static void main(String[] args){
        HashSet<Pair<Integer,Integer>> hashSet=new HashSet<>();
        hashSet.add(new Pair<>(1,2));
        hashSet.add(new Pair<>(1,9));
        for(Pair<Integer,Integer> p:hashSet){
            System.out.println(p.getKey()+" "+p.getValue());
        }
    }
    public void setZeroes(int[][] matrix) {
        if(matrix==null||matrix.length==0) return;
        HashSet<Pair<Integer,Integer>> setMatrix=new HashSet<>();
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(matrix[i][j]==0) setMatrix.add(new Pair<>(i,j));
            }
        }
        for(Pair<Integer,Integer>p:setMatrix){
            for(int i=0;i<matrix[0].length;i++){
                matrix[p.getKey()][i]=0;
            }
            for(int i=0;i<matrix.length;i++){
                matrix[i][p.getValue()]=0;
            }
        }
    }
}
