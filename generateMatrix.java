public class Solution7 {
    public static void main(String[] args) {
        int[][] res = new Solution7().generateMatrix(3);
        for (int i = 0; i < res.length; i++) {
            for (int j = 0; j < res[0].length; j++) {
                System.out.println(res[i][j]);
            }
        }
    }

    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        int cnt = 0;
        int i = 0;
        int j = 0;
        int direction = 1;
        for (; cnt < n * n; cnt++) {
            //todo: current pos
            res[i][j] = cnt + 1;
            //todo:right movement iff direction=1
            if (direction == 1 && j + 1 < res[0].length && res[i][j + 1] == 0) {
                j = j + 1;
                continue;
            } else if (direction == 1) {
                direction = 2;
                i = i + 1;
                continue;
            }
            //todo:downwawrd movement iff direction=2;
            if (direction == 2 && i + 1 < res.length && res[i + 1][j] == 0) {
                i = i + 1;
                continue;
            } else if (direction == 2) {
                direction = 3;
                j = j - 1;
                continue;
            }
            //todo: left movement iff direction==3;
            if (direction == 3 && j - 1 >= 0 && res[i][j - 1] == 0) {
                j = j - 1;
                continue;
            } else if (direction == 3) {
                direction = 4;
                i = i - 1;
                continue;
            }
            //todo: upward movement iff direction= 4;
            if (direction == 4 && i - 1 >= 0 && res[i - 1][j] == 0) {
                i = i - 1;
                continue;
            } else if (direction == 4) {
                direction = 1;
                j = j + 1;
                continue;
            }

        }
        return res;
    }
}
