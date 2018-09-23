public class Solution8 {
    //@author hannankan
    //succeed
    public int[][] matrixReshape(int[][] nums, int r, int c) {
        if(r*c!=nums.length*nums[0].length) return nums;
        int [][] res=new int[r][c];
        int resi=0;
        int resj=0;
        for(int i=0;i<nums.length;i++){
            for(int j=0;j<nums[0].length;j++){
                res[resi][resj]=nums[i][j];
                resj++;
                if(resj==c){
                    resi++;
                    resj=0;
                }
            }
        }
        return res;
    }
}
