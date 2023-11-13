package main;

public class Pair {
    private int row;
    private int col;
    
    Pair(int row, int col){
        this.row = row;
        this.col = col;
    }

    int getRow(){
        return this.row;
    }

    int getCol(){
        return this.col;
    }
    
}
