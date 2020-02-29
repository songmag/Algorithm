import com.sun.deploy.security.SelectableSecurityManager;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        char[] temp = new char[3];
        try {
            String p= reader.readLine();
            temp[0] = p.charAt(0);
            temp[1] = p.charAt(2);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Game game = new Game(temp[0],temp[1]);
        Game.reader = reader;
        game.setData();
        game.printAll();
    }
}
class Move{
    static final char LEFT=1;
    static final char RIGHT=2;
    static final char TOP=4;
    static final char BOTTOM=8;
    public static boolean getSame(char value,char value2)
    {
        if((value&value2) == 0)
        {
            return false;//다르면 false
        }
        return true;//같으면 true;
    }
}
class Game{
    public static char map[][];
    public static int vertical, horitional;
    public static BufferedReader reader;
    public Game(char vertical,char horitional)
    {
        Game.vertical = (int)(vertical-48);
        Game.horitional = (int)(horitional-48);
        map = new char[Game.vertical][Game.horitional];
    }
    public void setData()
    {
       for(char i = 0 ; i < Game.vertical ; i++)
       {
           try {
               String p = reader.readLine();
               System.out.println(p);
               for(char j =0 ; j < Game.horitional ;j++)
               {
                   map[i][j]=p.charAt(j);
               }
            } catch (IOException e) {
               e.printStackTrace();
           }
       }
        try {
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void printAll()
    {
        System.out.println(vertical);
        System.out.println(horitional);
        for(int i = 0 ; i < vertical ; i++)
        {
            for(int j = 0 ; j <horitional; j++) {
                System.out.print(map[i][j]);
            }
            System.out.println();
        }
    }
}