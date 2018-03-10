/*
problem:
Given an array of size n, find the majority element. The majority element is the element that appears more than floor(n/2) times.
You may assume that the array is non-empty and the majority element always exist in the array.
*/

#include<.h>
void mergeSort(int* a,int left,int right);
void merge(int* a,int left,int mid,int right);

int majorityElementmajorityElement(int* nums, int numsSize) {
    mergeSort(nums,0,numsSize-1);
    int winner=nums[0],times;
    int current=nums[0],ctimes=1;
    int i=1;
    for(;i!=numsSize;i++){
        if(nums[i]==current) ctimes++;
        else break;
    }
    times=ctimes;
    for(;i!=numsSize;i++){
        if(current!=nums[i]){
            if(ctimes>times) {times=ctimes;winner=current;}
            current=nums[i];
            ctimes=1;
        }
        else ctimes++;
    }
    if(ctimes>times) {times=ctimes;winner=current;}	//last refresh of the winner
    return winner;
}
//[left,right]


void insertionSort(int* A,int left,int right){
    for(int i=left+1;i<=right;i++){
        int key=A[i];
        int j;
        for(j=i-1;j>=0;j--)
            if(key<A[j]) A[j+1]=A[j];
            else   { A[j+1]=key;break;}
        if(j<0) A[0]=key;
    }
}

//no insertionSort 32ms
// insertionSort <=19 20ms
//insertionSort <=60 16ms

//insertionSort <=80 12ms
//insertionSort <=81 16ms
//insertionSort <=85 16ms
//insertionSort <=90 20ms
//insertionSort <=100 16ms
//<=200 72

void mergeSort(int* a,int left,int right){
    if(right-left<=80) 
    {
        insertionSort(a,left,right);
        return;
    }
    if(left==right) return;
    mergeSort(a,left,(left+right)/2);
    mergeSort(a,(left+right)/2+1,right);
    merge(a,left,(left+right)/2,right);
}


//[left,mid],[mid+1,right]
void merge(int* num,int left,int mid,int right){
    int* a=(int*) malloc(sizeof(int)*(mid-left+2));
    int* b=(int*) malloc(sizeof(int)*(right-mid+1));
    for(int i=left;i<=mid;i++)
        a[i-left]=num[i];
    a[mid-left+1]=0x7fffffff;
    for(int i=mid+1;i<=right;i++)
        b[i-mid-1]=num[i];
    b[right-mid]=0x7fffffff;
    for(int i=0,j=0;left<=right;left++){
        if(a[i]<=b[j]) num[left]=a[i++];	//a,b array mistake
        else num[left]=b[j++];
    }
    free(a);
    free(b);
}
