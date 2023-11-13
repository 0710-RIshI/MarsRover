package main;

public enum Direction {
    N,
    S, 
    W,
    E;

    Direction turnRight(Direction currentDirection){
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
                break;
        }
        return newDirection;
    }

    Direction turnLeft(Direction currentDirection){
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
                break;
        }
        return newDirection;
    }


    
}
