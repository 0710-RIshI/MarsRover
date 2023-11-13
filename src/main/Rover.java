package main;

import java.util.List;

public class Rover {
    //Defining the position
    private int x;
    private int y;
    private int obstacleCount;
    private Direction direction;

    Rover(int x, int y, Direction direction, MyGrid grid){
        this.x = x;
        this.y = y;
        this.obstacleCount = 0;
        this.direction = direction;

        System.out.println("Starting Position: (" + x + ", " + y + ", " + direction + ")");

        //Check if entered coordinates are valid
        grid.isValid(x, y);

    }

    public void getStatusReport(){
        String obstaclePrint = (obstacleCount == 0) ? "No" : Integer.toString(obstacleCount);
        System.out.println("Rover is at (" + x + ", " + y + ") facing " + direction + ". " + obstaclePrint + " Obstacles detected.");
    }

    //

    public void executeRover(Command cmd, MyGrid grid){
        List<Character> commands = cmd.getCommands();
        // System.out.println("Starting Direction - " + direction);
        for (Character command : commands) {
            switch (command) {
                case 'M':
                    int[] move = grid.move(x, y, direction);
                    x = (move[0] != x) ? move[0] : x;
                    y = (move[1] != y) ? move[1] : y;
                    obstacleCount = (move[2] == 1) ? obstacleCount + 1 : obstacleCount;
                    break;
                
                //Only update current direction for Left and Right
                case 'L':
                    this.direction = direction.turnLeft(this.direction);
                    break;
                
                case 'R':
                    this.direction = direction.turnRight(this.direction);
                    
                    break;

                default:
                    break;
            }
            // System.out.println("Current Direction - " + this.direction);
        }
        System.out.println("Final Position: (" + x + ", " + y + ", " + this.direction + ")");

    }
    
}
