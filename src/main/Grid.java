package main;

import java.util.List;

public interface Grid {

    void isValid(int x, int y);

    int[] move(int x, int y, Direction direction);

    void fillObstacles(List<Pair> obstacles);

    void printGrid();
    
}
