package com.hannankan.leetcode.main;

import java.util.Scanner;

/**
 * Created by lenovo on 2018.3.12.
 */
public class Main {

    public static void main(String[] args) {
    /*    int[][] A = {
                {1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}
        };*/
        int[][] A = {{1, 2, 3, 4, 5},
                {6, 7, 8, 9, 10},
                {11, 12, 13, 14, 15},
                {16, 17, 18, 19, 20},
                {21, 22, 23, 24, 25}};

        while (true) {
            System.out.println("input target:");
            Scanner scanner = new Scanner(System.in);
            int x = scanner.nextInt();
            System.out.println(new Solution2(A, x).searchMatrix());

        }

    }
}

/*
* this solution is used to Search a 2D Matrix II
* method: D&C to merge the matrix first
* */
class Solution2{
    private  int[][] matrix;
    private  int target;
    Solution2(int[][] M,int T){
        matrix=M;
        target=T;
    }
    boolean searchMatrix(){
        if(matrix.length==0) return false;
        int[] result=mergeMatrix(matrix,0,matrix.length-1);
        return binarySearch(result,target);
    }
    boolean binarySearch(int[] array,int target){
        int left=0,right=array.length-1;

        while(left<=right){
            int i=(left+right)/2;
            if(array[i]==target) return  true;
            else if(array[i]<target) left=i+1;
            else right=i-1;
        }
        return false;
    }
    int[] mergeMatrix(int[][] matrix,int left,int right){
        if(left==right) return matrix[left];
        if(left+1==right) return mergeTwoArray(matrix[left],matrix[right]);
        int[] l_a=mergeMatrix(matrix,left,(left+right)/2);
        int[] r_a=mergeMatrix(matrix,(left+right)/2+1,right);
        return mergeTwoArray(l_a,r_a);
    }
    int[] mergeTwoArray(int[]left ,int[] right){
        int[] result=new int[left.length+right.length];
        int i=0,j=0;
        int ir=0;
        for(;i<left.length&&j<right.length;ir++){
            if(left[i]<=right[j]) result[ir]=left[i++];
            else result[ir]=right[j++];
        }
        while(i<left.length)
            result[ir++]=left[i++];
        while(j<right.length)
            result[ir++]=right[j++];
        return result;
    }

}
/*
* this solution is used to Search a 2D Matrix II
* method: divde the matrix into square matrix step by step
* */
class Solution1 {
    private int[][] matrix = null;
    private int target;

    Solution1(int[][] Matrix, int Target) {
        matrix = Matrix;
        target = Target;
    }

    public boolean searchMatrix() {
        return divideMatrix(matrix, target);
    }

    public boolean divideMatrix(int[][] matrix, int target) {
        if (matrix.length == 0) return false;
        //(startx,starty)(endx,endy)
        int startx = 0, starty = 0;
        int endx = matrix.length - 1;
        int endy = matrix[0].length - 1;
        while (startx <= endx && starty <= endy) {
            int xlength = endx - startx + 1, ylength = endy - starty + 1;
            if (xlength == ylength || xlength == 1 || ylength == 1) { //need not divided and it is the end of the while
                if (searchSubMatrix(matrix, target, startx, endx, starty, endy)) return true;
                else return false;
            } else if (xlength < ylength) {
                if (searchSubMatrix(matrix, target, startx, endx, starty, starty + xlength - 1)) return true;
                starty = starty + xlength;
            } else { //xlength >ylength
                if (searchSubMatrix(matrix, target, startx, startx + ylength - 1, starty, endy)) return true;
                startx = startx + ylength;
            }
        }
        return false;
    }

    //(x1,y1)<=(x2,y2),subMatrix is a column, row or a square Matrix
    public boolean searchSubMatrix(int[][] subMatrix, int target, int x1, int x2, int y1, int y2) {
        if (x1 == x2)
            for (; y1 <= y2; y1++)
                if (subMatrix[x1][y1] == target) return true;
        if (y1 == y2)
            for (; x1 <= x2; x1++)
                if (subMatrix[x1][y1] == target) return true;
        int temp_x = x1, temp_y = y1;
        while (temp_x <= x2 && temp_y <= y2 && subMatrix[temp_x][temp_y] < target) {
            temp_x++;
            temp_y++;
        }
        if (temp_x > x2 || temp_y > y2) return false;
        if (subMatrix[temp_x][temp_y] == target) return true;
        else {
            for (int i = temp_x; i <= x2; i++) {
                for (int j = y1; j <= y2; j++)
                    if (subMatrix[i][j] == target) return true;
            }
            for (int i = x1; i <= temp_x; i++)
                for (int j = temp_y; j <= y2; j++)
                    if (subMatrix[i][j] == target) return true;
        }
        return false;
    }
}