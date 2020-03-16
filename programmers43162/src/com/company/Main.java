package com.company;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    public static void main(String[] args) {
	    Solution solution = new Solution();
//	    System.out.println(solution.solution(4,new int[][]{{1,1,0,0},{1,1,0,1},{0,0,1,1},{0,1,1,1}}));
//        System.out.println(solution.solution(3,new int[][]{{1,1,0},{1,1,0},{0,0,1}}));
//        System.out.println(solution.solution(3,new int[][]{{1,0,0},{0,1,0},{0,0,1}}));
//        System.out.println(solution.solution(3,new int[][]{{1,1,0},{1,1,1},{0,1,1}}));
//
    }
}
class Solution {
    byte[] vertex;
    public int solution(int n, int[][] computers) {
        int answer = 1;
        vertex = new byte[n];
        Arrays.fill(vertex,(byte)0);
        Queue<Integer> queue = new LinkedList<Integer>();
        int temp=answer;
        for(int i = 0 ; i< n;i++)
        {
            if(vertex[i] == (byte)0){
                answer = temp;
                queue.offer(i);
                vertex[i] = (byte)answer;
                temp=answer+1;
            }
            while(!queue.isEmpty()){
                int k = queue.poll();
                vertex[k] = (byte)answer;
                for(int j=0;j<n;j++) {
                    if(computers[k][j] == 1 && k != j)
                    {
                        if(vertex[j] == 0)
                            queue.offer(j);
                    }
                }
            }
        }
        return answer;
    }
}