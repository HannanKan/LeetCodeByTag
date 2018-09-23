import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Solution6 {
    public static void main(String[] args){
        int[][] matrix={{1, 2, 3, 4},
                {5, 6, 7, 8},
                {9,10,11,12}};
        List<Integer> list=new Solution6().spiralOrder(matrix);
        Iterator<Integer> iterator=list.iterator();
        while(iterator.hasNext())
            System.out.println(iterator.next());
        System.out.println(matrix.length*matrix[0].length+" "+list.size());
    }
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        if (matrix == null || matrix.length == 0) return list;
        int direction = 1;
        int[][] mark = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < mark.length; i++) {
            for (int j = 0; j < mark[0].length; j++) {
                mark[i][j] = 0;
            }
        }
        int count = 0;
        int i = 0, j = 0;
        for (; count <matrix[0].length * matrix.length; count++) {
            //todo: current pos
            list.add(matrix[i][j]);
            mark[i][j]=1;
            //todo:right movement iff direction=1
            if (direction == 1 && j + 1 < matrix[0].length && mark[i][j + 1] == 0) {
                j = j + 1;
                continue;
            } else if(direction==1) {
                direction = 2;
                i = i + 1;
                continue;
            }
            //todo:downwawrd movement iff direction=2;
            if (direction == 2 && i + 1 < matrix.length && mark[i + 1][j] == 0) {
                i = i + 1;
                continue;
            } else if(direction==2){
                direction = 3;
                j= j - 1;
                continue;
            }
            //todo: left movement iff direction==3;
            if (direction == 3 && j - 1 >= 0 && mark[i][j - 1] == 0) {
                j = j - 1;
                continue;
            } else if(direction==3){
                direction = 4;
                i = i - 1;
                continue;
            }
            //todo: upward movement iff direction= 4;
            if (direction == 4 && i - 1 >= 0 && mark[i - 1][j] == 0) {
                i = i - 1;
                continue;
            } else if(direction==4){
                direction = 1;
                j = j + 1;
                continue;
            }
        }
        return list;
    }
}
