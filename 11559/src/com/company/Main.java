package com.company;

import java.util.*;

public class Main{
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] lines = new String[12];
        for(int i = 0 ; i < 12; i++) {
            lines[i]=scan.nextLine();
        }
        GameMap game = new GameMap(lines);
        game.start();
    }
}
class GameMap{
    private byte[][] gameMap;
    private Map<Index,Byte> vertices;
    private int count=0;
    private Queue<Index> indices;

    public GameMap(String[] lines)
    {
        gameMap = new byte[12][6];
        vertices = new HashMap<Index,Byte>();
        for(int i = 0 ; i < lines.length ; i++)
        {
            for(int j = 0 ; j < lines[i].length();j++)
            {
                if(lines[i].charAt(j) != '.') {
                    gameMap[i][j] = (byte) (lines[i].charAt(j) - 'A');
                    vertices.put(new Index(j,i),gameMap[i][j]);
                }
            }
        }
    }
    public void start()
    {
        indices = new LinkedList<Index>();
        for(Index key : vertices.keySet())
        {
            byte color = gameMap[key.y][key.x];
            indices.offer(key);
            for(int i = 0 ; i < 9;i++)
            {
                getRange(i,key,color);
            }
            if(indices.size() == 4)
            {
                System.out.println(((char)(color+'A'))+"색깔");
                reProductGameMap();
            }
            Iterator<Index> iterator = indices.iterator();
            while(iterator.hasNext())
            {
                indices.poll();
            }
        }
    }
    public void reProductGameMap(){

    }
    public void getRange(int direction, Index vertex, byte color)
    {
        Index temp;
        switch(direction)
        {
            case 0:
                temp = getLeft(vertex);
                break;
            case 1:
                temp = getRight(vertex);
                break;
                case 2:
            case 3:
                temp = getUp(vertex);
                break;
            case 4:
                temp = getDown(vertex);
                break;
            case 5:
                temp = getCrossRightDown(vertex);
                break;
            case 6:
                temp = getCrossLeftDown(vertex);
                break;
            case 7:
                temp = getCrossLeftUp(vertex);
                break;
            case 8:
                temp = getCrossRightUp(vertex);
                break;
            default:
                temp = null;
        }
        Set<Index> keyset = vertices.keySet();
        for(Index index : keyset)
        {
            if( index.equals(temp) && gameMap[temp.y][temp.x] == color)
            {
                indices.add(temp);
            }
        }
    }
    public Index getLeft(Index value)
    {
        return new Index(value.x-1,value.y);
    }
    public Index getRight(Index value)
    {
        return new Index(value.x+1,value.y);
    }
    public Index getUp(Index value)
    {
        return new Index(value.x,value.y-1);
    }
    public Index getDown(Index value)
    {
        return new Index(value.x,value.y+1);
    }
    public Index getCrossLeftDown(Index value)
    {
        return new Index(value.x-1,value.y+1);
    }
    public Index getCrossRightDown(Index value)
    {
        return new Index(value.x+1,value.y+1);
    }
    public Index getCrossLeftUp(Index value)
    {
        return new Index(value.x-1,value.y-1);
    }
    public Index getCrossRightUp(Index value)
    {
        return new Index(value.x+1,value.y-1);
    }
}
class Index{
    int x;
    int y;
    public Index(int x,int y)
    {
        this.x = x;
        this.y = y;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Index)) return false;
        Index index = (Index) o;
        return x == index.x &&
                y == index.y;
    }
    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}