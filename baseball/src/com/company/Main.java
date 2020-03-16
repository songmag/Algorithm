package com.company;


// 해답....

public class Main{
    public static void main(String[]args)  {
        Solution solution = new Solution();
        System.out.println(solution.solution(new int[][]{{123,1,1},{356,1,0},{327,2,0},{489,0,1}}));

    }
}
class Solution {

    public int solution(int[][] baseball) {
        int answer = 0;
        int str[] = new int[baseball.length];
        int ball[] = new int[baseball.length];
        int number[][] = new int[baseball.length][3];
        /**
         * setting 나누기
         */
        for(int i = 0 ; i < baseball.length;i++)
        {
            for(int j = 0 ; j < 3;j++)
            {
                int pow = (int) Math.pow(10,3-j);
                int remain = baseball[i][0]%pow;
                number[i][j] = remain / (pow/10);
            }
            str[i] = baseball[i][1];
            ball[i] = baseball[i][2];
        }
        /**
         * All Number Setting
         */
        int Allnumber[] = new int[3];
        for(int i = 123 ; i <= 987 ; i++)
        {
            for(int j = 0 ; j < 3;j++)
            {
                int pow = (int) Math.pow(10,3-j);
                int remain = i%pow;
                Allnumber[j] = remain / (pow/10);
            }
            if(Allnumber[0] == 0 || Allnumber[1] == 0 || Allnumber[2] == 0 ||
                    Allnumber[0] == Allnumber[1] || Allnumber[1] == Allnumber[2] ||
                    Allnumber[0] == Allnumber[2]
            )
            {
                continue;
            }
            for(int j = 0 ; j < baseball.length; j++)
            {
                int strike=0;
                int bl=0;
                if(Allnumber[0]  == number[j][0]) strike++;
                if(Allnumber[1] == number[j][1]) strike++;
                if(Allnumber[1] == number[j][2]) strike++;
                if(strike != str[j]) break;
                if(Allnumber[0]  == number[j][2] ||
                        Allnumber[0]  == number[j][1]) bl++;
                if(Allnumber[1] == number[j][2]
                    || Allnumber[1] == number[j][0]) bl++;
                if(Allnumber[2] == number[j][0] ||
                Allnumber[2] == number[j][1]
                ) bl++;
                if(ball[j] != bl) break;
                if(j == baseball.length - 1) answer++;
            }
        }
        return answer;
    }
}


















/*
public class Main {
    public static void main(String[] args) {
	    int[][] object = new int[][]{{123,1,1},{356,1,0},{327,2,0},{489,0,1}};
        Solution solv = new Solution();
        solv.solution(object);
    }
}
class Solution {
    int[][] baseball;
    static int answer;
    Queue<Answer> queue;

    public int solution(int[][] baseball) {
        int answer = 0;
        this.baseball = baseball;
        runGame();
        return answer;
    }
    public void runGame()
    {
        queue = new LinkedList();
        int[] number = new int[3];
        int j = 0 ;
        Answer[] answers = null;
        while(answers == null && j < baseball.length) {
            for (int i = 0; i < 3; i++) {
                int remain;
                int pow = (int) Math.pow(10, 3 - i);
                remain = baseball[0][j] % pow;
                number[i] = remain /( pow / 10);// 100 나눈것 , 10으로 나눈거 , 1로 나눈거
            }
            answers = Answer.init(baseball[j][1], baseball[j][2], number);
            j=j+1;
        }
        for(Answer answer : answers)
        {
            queue.offer(answer);
        }
        int i=1;
        while(!queue.isEmpty()) {
            run(queue.poll(),i++);
        }
    }
    private Answer run(Answer poll, int index) {
        if(index > baseball.length)
        {
            return null;
        }
        int[] example = baseball[index];
        int st,bl,number[]=new int[3];
        st = example[1];
        bl = example[2];
        for(int i = 0 ; i < 3;i++)
        {
            int remain;
            int pow = (int) Math.pow(10,3-i);
            remain = baseball[index][0] % pow;
            number[i] = remain / (pow / 10);// 100 나눈것 , 10으로 나눈거 , 1로 나눈거
        }
        Answer[] temp = Answer.checkStBl(poll,st,bl,number);
        if(temp != null)
        for(Answer answer : temp)
        {
            if(answer != null){
                queue.offer(answer);
            }
        }
        return null;
    }
}
class Answer{
    int[] answer = new int[3];
    int[] wrong = new int[9];
    public Answer()
    {
        for(int i = 0 ; i < 3 ; i++) answer[i]= 0;
        for(int i = 1 ; i < 10; i++) wrong[i-1]=0;
    }
    public Answer(Answer clone)
    {
        this.answer = clone.answer;
        this.wrong = clone.wrong;
    }
    public Answer setWrong(int value)
    {
        this.wrong[value] = -1;
        return this;
    }
    public Answer setAnswer(int index, int value)
    {
        this.answer[index] = value;
        return this;
    }
    public static Answer[] init(int st, int bl, int [] now)
    {
        List<Answer> answers = new ArrayList<Answer>();
        if(st == 0)
        {
            if(bl == 0){
                return null;
            }
            else if(bl == 1)
            {
                answers.add(new Answer().setWrong(now[1]).setWrong(now[2]).setAnswer(2,now[0]));
                answers.add(new Answer().setWrong(now[0]).setWrong(now[2]).setAnswer(2,now[1]));

                answers.add(new Answer().setWrong(now[0]).setWrong(now[1]).setAnswer(1,now[2]));
                answers.add(new Answer().setWrong(now[2]).setWrong(now[1]).setAnswer(1,now[0]));

                answers.add(new Answer().setWrong(now[2]).setWrong(now[0]).setAnswer(0,now[1]));
                answers.add(new Answer().setWrong(now[1]).setWrong(now[0]).setAnswer(0,now[2]));
            }
            else if(bl == 2)
            {
                answers.add(new Answer().setWrong(now[0]).setAnswer(0,now[1]).setAnswer(1,now[2]));
                answers.add(new Answer().setWrong(now[0]).setAnswer(0,now[2]).setAnswer(2,now[1]));

                answers.add(new Answer().setWrong(now[1]).setAnswer(0,now[2]).setAnswer(1,now[0]));
                answers.add(new Answer().setWrong(now[1]).setAnswer(1,now[2]).setAnswer(2,now[0]));

                answers.add(new Answer().setWrong(now[2]).setAnswer(1,now[0]).setAnswer(0,now[1]));
                answers.add(new Answer().setWrong(now[2]).setAnswer(1,now[0]).setAnswer(2,now[1]));
            }
            else if(bl == 3)
            {
                answers.add(new Answer().setAnswer(0,now[2]).setAnswer(1,now[0]).setAnswer(2,now[1]));
                answers.add(new Answer().setAnswer(0,now[1]).setAnswer(1,now[2]).setAnswer(2,now[0]));
            }
        }
        else if(st == 1)
        {
            if(bl == 0)
            {
                answers.add(new Answer().setAnswer(0,now[0]).setWrong(now[1]).setWrong(now[2]));
                answers.add(new Answer().setAnswer(1,now[1]).setWrong(now[0]).setWrong(now[2]));
                answers.add(new Answer().setAnswer(2,now[2]).setWrong(now[0]).setWrong(now[1]));
            }
            else if(bl == 1)
            {
                answers.add(new Answer().setAnswer(0,now[0]).setWrong(now[1]).setAnswer(1,now[2]));
                answers.add(new Answer().setAnswer(0,now[0]).setWrong(now[2]).setAnswer(2,now[1]));

                answers.add(new Answer().setAnswer(1,now[1]).setWrong(now[2]).setAnswer(2,now[0]));
                answers.add(new Answer().setAnswer(1,now[1]).setWrong(now[0]).setAnswer(0,now[2]));

                answers.add(new Answer().setAnswer(2,now[2]).setWrong(now[0]).setAnswer(0,now[1]));
                answers.add(new Answer().setAnswer(2,now[2]).setWrong(now[1]).setAnswer(1,now[0]));
            }
            else if(bl == 2)
            {
                answers.add(new Answer().setAnswer(0,now[0]).setAnswer(2,now[1]).setAnswer(1,now[2]));
                answers.add(new Answer().setAnswer(1,now[1]).setAnswer(0,now[2]).setAnswer(2,now[0]));
                answers.add(new Answer().setAnswer(2,now[2]).setAnswer(1,now[0]).setAnswer(2,now[1]));
            }
        }
        else if(st == 2)
        {
            if(bl == 0)
            {
                answers.add(new Answer().setAnswer(0,now[0]).setAnswer(1,now[1]).setWrong(now[2]));
                answers.add(new Answer().setAnswer(0,now[0]).setAnswer(2,now[2]).setWrong(now[1]));
                answers.add(new Answer().setAnswer(1,now[1]).setAnswer(2,now[2]).setWrong(now[0]));
            }
        }
        return (Answer[])answers.toArray(new Answer[0]);
    }
    public static Answer[] checkStBl(Answer root,int st, int bl,int[] now) {
        if (st != 0) {
            int count = 0;
            for (int i = 0; i < 3; i++) {
                if(root.wrong[now[i]] == -1)
                {
                    now[i] = -1;
                }
                if (root.answer[i] == now[i]) {
                    count++;
                }
            }
            if (count < st) {
                return null;
            }
        }
        return null;
    }
    public static Answer[] makeBall(Answer root, int bl, int[] now)
    {
        List<Answer> answers;
        if(bl == 0)
        {
            root.setWrong(now[0]).setWrong(now[1]).setWrong(now[2]);
            return new Answer[]{root};
        }
        else if(bl == 1)
        {
            answers = new ArrayList<Answer>();
            for(int i = 0 ; i < 3 ; i++) {
                if (now[i] != -1) {
                    Answer answer = new Answer(root);
                    answer.setWrong(now[i]);

                }
            }
        }
        else if(bl == 2)
        {

        }
        return null;
    }
}
*/