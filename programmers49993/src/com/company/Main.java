package com.company;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Solution solution = new Solution();
//        , "BACDE",
        System.out.println(solution.solution("CBD",new String[]{ "CBADF","AECB", "BDA"}));
    }
}
//정규표현식 풀이
class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        ArrayList<String> skillTrees = new ArrayList<String>(Arrays.asList(skill_trees));
        //ArrayList<String> skillTrees = new ArrayList<String>();
        Iterator<String> it = skillTrees.iterator();

        while (it.hasNext()) {
            String object =it.next().replaceAll("[^"+skill+"]","");
            if (skill.indexOf(it.next().replaceAll("[^" + skill + "]", "")) != 0) {
                it.remove();
            }
        }
        answer = skillTrees.size();
        return answer;
    }
}
/*
class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        List<Character> queue = new ArrayList<Character>(skill.length());

        for(char c : skill.toCharArray())
        {
            queue.add(c);
        }
        for(String s : skill_trees)
        {
            char[] learn = s.toCharArray();
            int i = 0;
            int k=0;
            while(queue.size() != k && learn.length > i)
            {
                if(learn[i] == queue.get(k))
                {
                    k++;
                }
                boolean flag=false;
                for(int j = k ; j < queue.size();j++)
                {
                    if(learn[i] == queue.get(j)){
                        flag = true;
                        break;
                    }
                }
                if(flag) break;
                i+=1;
            }
            if(i == learn.length || k == queue.size())
            {
                answer++;
            }
        }
        return answer;
    }
}
*/