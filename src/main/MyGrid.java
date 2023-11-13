package main;

import java.util.Arrays;
import java.util.List;

public class MyGrid implements Grid{

    //x -> row
    //y -> column
    private int[][] grid;

    MyGrid(int height, int width){
        this.grid = new int[height][width];
    }

    @Override
    public void printGrid(){
        for (int i = 0; i < grid.length; i++) {
            System.out.println(Arrays.toString(grid[i]));
        }
        System.out.println();
    }

    @Override
    public int[] move(int x, int y, Direction direction) {
        int newX = x;
        int newY = y;
        int access = -1;

        switch (direction) {
            case N:
                newX = x - 1;
                break;
            
            case S:
                newX = x + 1;
                break;

            case E:
                newY = y + 1;
                break;
            
            case W:
                newY = y - 1;
                break;
        
            default:
                break;
        }

        try {
            //This is to check if that particular move is valid and if it isn't it will go to catch block
            access = grid[newX][newY];
        } catch (ArrayIndexOutOfBoundsException e) {
            // System.out.println("Triggered IndexOutOfBounds" + direction + ", " + x + ", " + y);
            return new int[]{x, y, access};
        }
        //Format of array generated - {rowCord, colCord, value at current index}
        // System.out.println("Current Coordinates - (" + newX + ", " + newY + ", " + direction + ")");
        return access == 1 ? new int[]{x, y, access} : new int[]{newX, newY, access};
    }


    @Override
    public void isValid(int x, int y) {
        try {
            //This is to check if that particular move is valid and if it isn't it will go to catch block
            int access = grid[x][y];
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new ArrayIndexOutOfBoundsException("Starting coordinates outside defined environment");
        }
    }

    @Override
    public void fillObstacles(List<Pair> obstacles){
        for (Pair pair : obstacles) {
            grid[pair.getRow()][pair.getCol()] = 1;
        }
    }
    
}
