package com.company;////package com.company;
////
////import java.io.BufferedReader;
////import java.io.InputStreamReader;
////import java.util.*;
////
////class Main {
////    public static void main(String[] args) throws Exception {
////        GameConstructor game = new GameConstructor(new BufferedReader(new InputStreamReader(System.in)));
////        game.getStartIndexInit();
////        game.setHashMap();
////        System.out.println(game.getMax(0,game.getNumbers().get(0)));
////        game.printMap();
////    }
////}
////class GameConstructor{
////    private Map<String,Integer> map;//괄호
////    private List<Integer> numbers;
////    private List<Character> opers;
////    private BufferedReader bufferedReader;
////    private int max;
////
////    public List<Integer> getNumbers() {
////        return numbers;
////    }
////
////    GameConstructor(BufferedReader reader) {
////        bufferedReader = reader;
////    }
////    public void getStartIndexInit() throws Exception
////    {
////        String value;
////        value = bufferedReader.readLine();
////        map = new HashMap<String,Integer>(Integer.parseInt(value)/2);
////        opers= new ArrayList<Character>(Integer.parseInt(value)/2);
////        numbers = new ArrayList<Integer>(Integer.parseInt(value)/2+1);
////    }
////    public int bigger(int a,int b)
////    {
////        return a>b ? a:b;
////    }
////    public void setHashMap() throws Exception
////    {
////        String value;
////        value = bufferedReader.readLine();
////        StringBuffer buff = new StringBuffer();
////        int size = value.length();
////        for(int i = 0 ; i < size ; i++)
////        {
////            if(i %2 == 1 ) opers.add(value.charAt(i));
////            else numbers.add(value.charAt(i)-'0');
////        }
////        for(int i = 0 ; i <size-1; i=i+2)
////        {
////            buff.append(value.charAt(i));
////            buff.append(value.charAt(i+1));
////            buff.append(value.charAt(i+2));
////            map.put(buff.toString(),calc(buff.charAt(0)-'0',buff.charAt(2)-'0',buff.charAt(1)));
////            buff.setLength(0);
////        }
////    }
////    public int calc(int n1,int n2,char oper)
////    {
////        int temp;
////        if(oper == '+') temp= n1+n2;
////        else if(oper == '-') temp=n1-n2;
////        else temp=n1*n2;
////        return temp;
////    }
////
////    public void printMap()
////    {
////        for(String key : map.keySet()) {
////            System.out.print("Key ::" + key);
////            System.out.println("Value ::" + map.get(key));
////        }
////    }
////
////    public int getMax(int idx, int result)
////    {
////        if(idx >= opers.size())
////        {
////            max= bigger(max,result);
////            return max;
////        }
////
////        int current_result = calc(result,numbers.get(idx+1),opers.get(idx));
////        getMax(idx+1,current_result);
////        if(idx+1 < opers.size())
////        {
////            int after_result = calc(numbers.get(idx+1),numbers.get(idx+2),opers.get(idx+1));
////            int curr_result = calc(result,after_result,opers.get(idx));
////            getMax(idx+2,curr_result);
////        }
////        return max;
////    }
////}
//
//package com.company;
//
//import java.io.BufferedReader;
//import java.io.InputStreamReader;
//import java.util.*;
//
//public class Main {
//    public static void main(String[] args) throws Exception {
//        GameConstructor game = new GameConstructor(new BufferedReader(new InputStreamReader(System.in)));
//        game.getStartIndexInit();
//        game.solve();
//    }
//}
//class GameConstructor{
//    private List<Integer> numbers;
//    private List<Character> opers;
//    private BufferedReader bufferedReader;
//    private int max=Integer.MIN_VALUE;
//
//    public int getMaxNumber(){
//        return max;
//    }
//
//    public List<Integer> getNumbers() {
//        return numbers;
//    }
//
//    GameConstructor(BufferedReader reader) {
//        bufferedReader = reader;
//    }
//    public void getStartIndexInit() throws Exception
//    {
//        String value;
//        value = bufferedReader.readLine();
//        opers= new ArrayList<Character>(Integer.parseInt(value)/2);
//        numbers = new ArrayList<Integer>(Integer.parseInt(value)/2+1);
//    }
//    public int bigger(int a,int b)
//    {
//        return a>b ? a:b;
//    }
//    public void solve() throws Exception
//    {
//        String value;
//        value = bufferedReader.readLine();
//        int size = value.length();
//        if(size == 1)
//        {
//            max = Integer.parseInt(value);
//            System.out.println(max);
//            return;
//        }
//        else if(size == 3)
//        {
//            max = calc(value.charAt(0),value.charAt(2),value.charAt(1));
//            System.out.println(max);
//            return;
//        }
//        for(int i = 0 ; i < size ; i++)
//        {
//            if(i %2 == 1 ) opers.add(value.charAt(i));
//            else numbers.add(value.charAt(i)-'0');
//        }
//        getMax(0,numbers.get(0));
//        System.out.println(max);
//    }
//    public int calc(int n1,int n2,char oper)
//    {
//        int temp;
//        if(oper == '+') temp= n1+n2;
//        else if(oper == '-') temp=n1-n2;
//        else temp=n1*n2;
//        return temp;
//    }
//
//
//    public void getMax(int idx, int result)
//    {
//        int current_result,after_result,curr_result;
//        if(idx >= opers.size())
//        {
//            max= bigger(max,result);
//            return;
//        }
//        current_result = calc(result,numbers.get(idx+1),opers.get(idx));
//        getMax(idx+1,current_result);
//        if(idx+1 < opers.size())
//        {
//            after_result = calc(numbers.get(idx+1),numbers.get(idx+2),opers.get(idx+1));
//            curr_result = calc(result,after_result,opers.get(idx));
//            getMax(idx+2,curr_result);
//        }
//    }
//}

//
//public class Main{
//    public static void main(String[] args) {
//        int p = 8;
//        int number = 0;
//        while( (p&1) == 0)
//        {
//            number++;
//            p >>= 1;
//        }
//        System.out.println(number);
//    }
//}

import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String t = sc.next();

        int[] arrN = new int[n/2+1];
        int[] buho = new int[n/2];
        int idx1 = 0;
        int idx2 = 0;
        // 숫자와 부호 나눠서 받기
        for(int i=0;i<t.length();i++){
            if(i%2==0) arrN[idx1++] = t.charAt(i)-'0';
            else buho[idx2++] = t.charAt(i);
        }
        // 앞에서 부터 연산이니 Queue를 이용해보자
        makePowerSet(n/2,arrN,buho);
        System.out.println(result);
    }

    static int result = Integer.MIN_VALUE;
    private static void solve(boolean[] preCul,int[] arrN,int[] arrBuho){
        Queue<Integer> queue = new LinkedList<>();
        // 첫 숫자 담기
        queue.add(arrN[0]);
        // 우선 연산해주기
        for(int i=0;i<preCul.length;i++){
            // 우선 연산이라면 앞의 숫자를 빼서 연산해주기
            if(preCul[i]){
                int tN = ((LinkedList<Integer>) queue).pollLast();
                switch (arrBuho[i]){
                    case '+':
                        queue.add(tN+arrN[i+1]);
                        break;
                    case '-':
                        queue.add(tN-arrN[i+1]);
                        break;
                    case '*':
                        queue.add(tN*arrN[i+1]);
                        break;
                }
                if(i<preCul.length-1) preCul[i+1] = false;
            }else {
                queue.add(arrBuho[i]);
                queue.add(arrN[i+1]);
            }
        }
        // 남은 연산해주기
        int tResult = queue.poll();
        while(!queue.isEmpty()){
            int buho = queue.poll();
            int tN = queue.poll();
            switch (buho){
                case '+':
                    tResult += tN;
                    break;
                case '-':
                    tResult -= tN;
                    break;
                case '*':
                    tResult *= tN;
                    break;
            }
        }
        result = Math.max(result,tResult);
    }
    private static void makePowerSet(long n,int[] arrN,int[] arrBuho){
        boolean[] preCul = new boolean[(int)n];

        for(long i=0;i<(1<<n);i++){
            // 조합 만들기
            for(long j=0;j<n;j++){
                if(((1<<j)&i)>0){
                    preCul[(int)j] = true;
                }
            }
            // 만든 조합으로 연산하기
            solve(preCul,arrN,arrBuho);
            for(int j=0;j<n;j++)
                preCul[j] = false;
        }
    }
}