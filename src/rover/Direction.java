package rover;

import java.io.IOException;

public enum Direction {
    N,
    S, 
    W,
    E,
    ERROR;
	
	public void wrongDirection() throws IOException{
		throw new IOException("Specified Direction not permitted. (N, S, E, W only permitted)");
	}

    public Direction turnRight(Direction currentDirection) throws Exception{
        Direction newDirection = null;
        switch (currentDirection) {
            case N:
                newDirection = E;
                break;
            
            case S:
                newDirection = W;
                break;

            case W:
                newDirection = N;
                break;

            case E:
                newDirection = S;
                break;
        
            default:
                this.wrongDirection();
        }
        return newDirection;
    }

    public Direction turnLeft(Direction currentDirection) throws Exception{
        Direction newDirection = null;
        switch (currentDirection) {
            case N:
                newDirection = W;
                break;
            
            case S:
                newDirection = E;
                break;

            case W:
                newDirection = S;
                break;

            case E:
                newDirection = N;
                break;
        
            default:
                throw new Exception("Specified Direction not permitted. (N, S, E, W only permitted)");
        }
        return newDirection;
    }


    
}
