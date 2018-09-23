
public class Solution11 {
    private int cnt = 0;
    private int mark;
    private int[][] globalgrid;
    private int area=0;

    public static void main(String[] args) {
        int[][] island = {{0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0}};
        System.out.println(new Solution11().maxAreaOfIsland(island));
    }

    public int maxAreaOfIsland(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) return 0;
        else globalgrid = grid;//same reference
        mark = grid.length * grid[0].length + 1;
        int maxArea=0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    System.out.println(i + " " + j);
                    traverse(i, j,1);
                    cnt += 1;
                    maxArea=(maxArea>area?maxArea:area);
                }
            }
        }
        return cnt;
        //
        //if requiring the max area of the island
        // return maxArea;
    }

    //@parameter: fromD represeents the direction to current position
    //fromD=0-->left
    //fromD=1-->right
    //fromD=2-->up
    //fromD=3-->down
    private void traverse(int x, int y, int fromD) {
        if (x<0||y<0||(x >= globalgrid.length) || (y >= globalgrid[0].length) || (globalgrid[x][y] != 1)) return;
        else {
            area+=1;
            globalgrid[x][y] = mark;
            if (fromD == 0) {
                traverse(x-1,y,2);
                traverse(x, y - 1,0);
                traverse(x + 1, y,3);
            }
            else if(fromD==1){
                traverse(x-1,y,2);
                traverse(x + 1, y,3);
                traverse(x,y+1,1);
            }
            else if(fromD==2){
                traverse(x-1,y,2);
                traverse(x, y - 1,0);
                traverse(x,y+1,1);
            }else{
                traverse(x, y - 1,0);
                traverse(x +1, y,3);
                traverse(x,y+1,1);
            }

        }

    }
}
