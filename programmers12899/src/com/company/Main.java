package com.company;

import java.util.*;

class Solution{
    Stack<Integer> stack = new Stack<Integer>();
    public String solution(int number)
    {
        String answer= "";
        int[] arr = {4,1,2};
        int index = number%3 ,startNum=0;
        int remain = (number%3==0)? 3: number%3;
        startNum = (int) (remain+((Math.pow(3,2)-3)/2));
        for (int i = 1;number >= startNum ; i++)
        {
            startNum = (int)(remain+(((Math.pow(3,i+1)-3)/2)));
            if(number <= startNum) {
                startNum=(int)(remain+(((Math.pow(3,i)-3)/2)));
                break;
            }
            stack.push(1);
        }
        for(int j = startNum ; j< number ;j+=3) {
            carry();
        }
        StringBuilder builder = new StringBuilder();
        Stack<Integer> str = new Stack<Integer>();
        while(!stack.isEmpty())
        {
            str.push(arr[stack.pop()]);
        }
        while(!str.isEmpty())
            builder.append(str.pop());
        builder.append(arr[index]);
        return builder.toString();
    }
    private void carry()
    {
        if(stack.isEmpty()) {
            stack.push(1);
            return;
        }
        if(stack.peek() == 0)
        {
            int index = stack.pop();
            carry();
            index = (index+1)%3;
            stack.push(index);
            return;
        }
        int index = stack.pop();
        index = (index+1)%3;
        stack.push(index);
    }
}
public class Main{
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(7));
    }
}