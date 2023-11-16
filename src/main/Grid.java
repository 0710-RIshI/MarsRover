package main;

import java.util.List;

public interface Grid {

    int[] move(int x, int y, Direction direction);

    void fillObstacles(List<Obstacle> obstacles);

    void printGrid();
    
}
