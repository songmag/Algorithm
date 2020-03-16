package com.company;

public class Main {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(new int[]{1, 1, 1, 1, 1},3));
    }
}
class Solution {
    int size;
    int[] numbers;
    public int solution(int[] numbers, int target) {
        int answer = 0;
        size = numbers.length;
        this.numbers = numbers;
        answer += dfsSolution(0,0,true,target);
        answer += dfsSolution(0,0,false,target);
        return answer;
    }

    /**
     *
     * @param num
     * @param index
     * @param flag = true(+),flase(-)
     * @return
     */
    private int dfsSolution(int num,int index,boolean flag,int target)
    {
        int count=0;
        int rs=0;
        if(index >= size) return 0;
        rs = (flag)? num+numbers[index] : num-numbers[index];
        if(rs == target && index == size-1) return 1;
        count += dfsSolution(rs,index+1,true,target);
        count += dfsSolution(rs,index+1,false,target);
        return count;
    }
}
