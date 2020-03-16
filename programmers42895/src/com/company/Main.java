package com.company;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

    }
}

class Solution {
    boolean complete;
    public int solution(int N, int number) {
        int answer = 1;
        if(N == number) return 1;
        while(!complete)
        {
            answer += 1;
            complete = operationRunning(N,number,answer);
        }
        return answer;
    }
    private boolean operationRunning(int N,int number, int count)
    {

        return true;
    }
}