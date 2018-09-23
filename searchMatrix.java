public class Solution16 {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix==null|| matrix.length==0||matrix[0].length==0) return false;
        int len=matrix.length*matrix[0].length;
        int[] newM=new int[len];
        int s=0;
        for(int i=0;i<matrix.length;i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                newM[s] = matrix[i][j];
                s++;
            }
        }
        int left=0,right=len-1;
        while(left<=right){
            if(right==left){
                if(newM[left]==target) return true;
                else return false;
            }
            int mid=(right+left)/2;
            if(newM[mid]==target) return true;
            else if(newM[mid]>target) right=mid-1;
            else left=mid+1;
        }
        return false;

    }
}
