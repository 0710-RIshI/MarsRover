package main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    //Turn Left and Turn Right - Polymorphism - Implementing a turn interface
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int height;
        int width;
        System.out.println("--------------- Entering Environment Values (Grid Height and Width) ---------------");
        System.out.print("Height - ");
        height = input.nextInt();
        System.out.print("Width - ");
        width = input.nextInt();
        
        MyGrid grid = new MyGrid(height, width);
        // int[][] grid = gridObj.defineGrid(height, width);

        // System.out.println("Height - " + height + "\nWidth - " + width);
        
        grid.printGrid();

        //Inserting Obstacles
        System.out.println("--------------- Entering Environment Values (No. of Obstacles and their cordinates) ---------------");
        List<Pair> obstacles = new ArrayList<>();
        
        System.out.print("Number of Obstacles - ");
        int numberOfObstacles;
        numberOfObstacles = input.nextInt();
        
        for (int i = 0; i < numberOfObstacles; i++) {
            int row;
            System.out.print("Row - ");
            row = input.nextInt();
            int col;
            System.out.print("Column - ");
            col = input.nextInt();
            obstacles.add(new Pair(row, col));
        }

        grid.fillObstacles(obstacles);

        System.out.println("--------------- After adding Obstacles ---------------");
        grid.printGrid();


        //Defining Rover
        System.out.println("--------------- Entering Starting Coordinates (N - North, S - South, E - East and W - West) ---------------");
        int x;
        System.out.print("Enter starting row - (0 <= row < " + height + "): ");
        x = input.nextInt();
        int y;
        System.out.print("Enter starting column - (0 <= column < " + width + "): ");
        y = input.nextInt();
        char dir;
        System.out.print("Enter starting direction - ");
        dir = input.next().charAt(0);
        Direction direction = null;

        switch (dir) {
            case 'N':
                direction = Direction.N;
                break;
            case 'S':
                direction = Direction.S;
                break;
            case 'W':
                direction = Direction.W;
                break;
            case 'E':
                direction = Direction.E;
                break;
            default:
                break;
        }

        //Defining movements
        System.out.println("--------------- Entering Navigation Commands (R - Right, L - Left, M - Move in same direction) ---------------");
        List<Character> commands = new ArrayList<>();

        System.out.print("Number of Commands - ");
        int numberOfCommands;
        numberOfCommands = input.nextInt();

        for (int i = 0; i < numberOfCommands; i++) {
            char command;
            System.out.print("Command - ");
            command = input.next().charAt(0);
            commands.add(command);
        }

        Command cmd = new Command(commands);
        // System.out.println("X - " + x + ", " + "Y - " + y);

        Rover myRover = new Rover(x, y, direction, grid);

        myRover.executeRover(cmd, grid);

        myRover.getStatusReport();

        input.close();
    }
    
}
