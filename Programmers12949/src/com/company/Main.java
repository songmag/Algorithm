package com.company;

public class Main {

    public static void main(String[] args) {
        int arr1[][], arr2[][];
        Solution solution= new Solution();
        arr1 = new int[][]{{2, 3, 2}, {4, 2, 4}, {3, 1, 4}};
        arr2 = new int[][]{{5, 4, 3}, {2, 4, 1}, {3, 1, 1}};

        solution.solution(arr1,arr2);
    }
}
class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        Mul mul= new Mul(arr1,arr2);
        return mul.answer();
    }
}
class Mul{
    public int result[][];
    public Mul(int[][] argu,int[][] argu2) {
        int[][] arr1,arr2;
        arr1 = argu;
        arr2 = argu2;

        int temp[][] = new int[arr2[0].length][arr2.length];
        for(int i = 0 ; i < temp.length ;i++)
        {
            for(int j = 0 ; j < temp[0].length;j++)
            {
                temp[i][j] = arr2[j][i];
            }
        }
        result = new int[arr1.length][arr2[0].length];
        for(int i = 0 ; i < result.length ; i++)
        {
            for(int j = 0 ; j  < result[0].length ;j++)
            {
                result[i][j] = mul(arr1[i],temp[j]);
            }
        }
    }
    private int mul(int[] ints, int[] ints1) {
        int rs=0;
        for(int i = 0 ; i  < ints.length ; i++)
        {
            rs += ints[i]*ints1[i];
        }
        return rs;
    }
    public int[][] answer(){
        return result;
    }
}
/** 주먹구구식 풀이 방식 이였음 **/
/** 해답 **/
/*
{
    int answer[arr1.length][arr2[0].length];
    for(int i = 0 ; i < answer.length ;i++)
    {
        for(int j = 0 ; j < answer[0].length;j++)
        {
            for(int k = 0 ; k < arr1[0].length ; k++)
            {
                answer[i][j] += arr1[i][k]* arr2[k][j];
            }
        }
    }
}

 */
/** 확실한건 다른 작업이 들어가는 순간 느려진다. **/
