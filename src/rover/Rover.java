package rover;

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
    
    

    public int getX() {
		return x;
	}



	public void setX(int x) {
		this.x = x;
	}



	public int getY() {
		return y;
	}



	public void setY(int y) {
		this.y = y;
	}



	public int getObstacleCount() {
		return obstacleCount;
	}



	public void setObstacleCount(int obstacleCount) {
		this.obstacleCount = obstacleCount;
	}



	public Direction getDirection() {
		return direction;
	}



	public void setDirection(Direction direction) {
		this.direction = direction;
	}



	public void getStatusReport(){
        String obstaclePrint = (obstacleCount == 0) ? "No" : Integer.toString(obstacleCount);
        System.out.println("Rover is at (" + x + ", " + y + ") facing " + direction + ". " + obstaclePrint + " Obstacles detected.");
    }

    //

    public void executeRover(Command cmd, MyGrid grid) throws Exception{
        List<Character> commands = cmd.getCommands();
        // System.out.println("Starting Direction - " + direction);
        for (Character command : commands) {
            switch (command) {
                case 'M':
                    this.direction = new Move(this,grid).execute();
                    break;
                
                //Only update current direction for Left and Right
                case 'L':
                    this.direction = new Left(this.direction).execute();
                    break;
                
                case 'R':
                    this.direction =  new Right(this.direction).execute();
                    
                    break;

                default:
                    break;
            }
            // System.out.println("Current Direction - " + this.direction);
        }
        System.out.println("Final Position: (" + x + ", " + y + ", " + this.direction + ")");

    }
    
}
