import java.util.Arrays;

/*
 * leetcode:870. Advantage Shuffle
 * */
public class Solution34 {
    public static void main(String[] args) {
        int[] a = {2,0,4,1,2};
        int[] b = {1,3,0,0,2};
        System.out.println(Arrays.toString(new Solution34().advantageCount(a, b)));
    }

    public int[] advantageCount(int[] A, int[] B) {
        if (A == null || A.length == 0) return A;
        int[] res = new int[A.length];
        int[] mark = new int[A.length];
        for (int i = 0; i < A.length; i++)
            res[i] = -1;
        Arrays.sort(A);
        for (int i = 0; i < B.length; i++) {
            int index = Arrays.binarySearch(A, B[i]);
            //todo:not found
            if (index < 0) {
                int x = -index - 1;
                while (x < A.length && mark[x] == -1) x++;
                if (x == A.length) continue;
                else {
                    res[i] = A[x];
                    mark[x] = -1;
                }
            }
            //todo: A[index]==B[i]
            else{
                while(index<A.length&&(mark[index]==-1||A[index]==B[i])) index++;
                if(index==A.length) continue;
                else {
                    res[i]=A[index];
                    mark[index]=-1;
                }
            }

        }
        int ib=0;
        for(int ia=0;ia<A.length;){
            while(ia<A.length&&mark[ia]==-1) ia++;
            if(ia==A.length) break;
            //or mark[ia]=0;
            while(ib<A.length&&res[ib]!=-1) ib++;
            res[ib]=A[ia];
            mark[ia]=-1;

        }
        return res;
    }
}
