package rover;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);
        int height;
        int width;
        //Defining Rover Environment variables
        System.out.println("--------------- Entering Environment Values (Grid Height and Width) ---------------");
        System.out.print("Height - ");
        height = input.nextInt();
        System.out.print("Width - ");
        width = input.nextInt();
        MyGrid grid = new MyGrid(height, width);

        // System.out.println("Height - " + height + "\nWidth - " + width);
        
        
        grid.printGrid();

        //Inserting Obstacles
        System.out.println("--------------- Entering Environment Values (No. of Obstacles and their cordinates) ---------------");
        List<Obstacle> obstacles = new ArrayList<>();
        
        int numberOfObstacles;
        
        //User validation for entering no of obstacles
        do {
        	System.out.print("Number of Obstacles (should not exceed maximum possible obstacles: " + (grid.getDim()[0] * grid.getDim()[1]) + ") - ");
        	numberOfObstacles = input.nextInt();
        } while((new Obstacle(grid).validObstacle(numberOfObstacles)));
        
        
        for (int i = 0; i < numberOfObstacles; i++) {
            int row;
            System.out.print("Row - ");
            row = input.nextInt();
            int col;
            System.out.print("Column - ");
            col = input.nextInt();
            Obstacle t = new Obstacle(new Pair(height-1-col,row), grid);
            try{
            	t.isValid(t.getP().getRow(), t.getP().getCol());
            	obstacles.add(t);
            }catch(ArrayIndexOutOfBoundsException e){
            	System.out.println("Please Enter valid Obstacle location");
            	i--;
            }          
        }

        grid.fillObstacles(obstacles);
        
//

        System.out.println("--------------- After adding Obstacles ---------------");
        grid.printGrid();
        
        boolean isValid = true; //flag for handling user validation
        
        // Declaring Rover Parameters
        Direction direction = null;
        int x = 0,y = 0;
        do{
        	
        	isValid = true;
        	try {
        		
		        //Defining Rover
		        System.out.println("--------------- Entering Starting Coordinates (N - North, S - South, E - East and W - West) ---------------");
		        System.out.print("Enter starting row - (0 <= row < " + height + "): ");
		        x = input.nextInt();
		        System.out.print("Enter starting column - (0 <= column < " + width + "): ");
		        y = input.nextInt();
		        grid.isValid(x, y);
		        char dir;
		        System.out.print("Enter starting direction - ");
		        dir = input.next().toUpperCase().charAt(0);
		        
		
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
		            	System.out.println("Error");
		            	direction = Direction.ERROR;
		            	direction.wrongDirection();
		                break;
		        }
        
        	}
	        catch(ArrayIndexOutOfBoundsException | IOException e) {
	        	System.out.println("Mismatch input, Try again!!");
	        	isValid = false;
	         
	        }
        }
        while(!isValid);
        
//        
    
        
        	
        //Defining movements
        System.out.println("--------------- Entering Navigation Commands (R - Right, L - Left, M - Move in same direction) ---------------");
        List<Character> commands = new ArrayList<>();

        System.out.print("Number of Commands - ");
        int numberOfCommands;
        numberOfCommands = input.nextInt();

        for (int i = 0; i < numberOfCommands; i++) {
            char command;
            System.out.print("Command - ");
            
            command = input.next().toUpperCase().charAt(0);
            if(command != 'M' && command !='L' && command != 'R') {
            	System.out.println("Enter valid commands");
            	i--;
            	continue;
            }
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