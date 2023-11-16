package main;

public class Move implements Instructions {
	
	private Rover r;
	private MyGrid grid;
	
	
	public Move(Rover r,MyGrid grid) {
		this.r = r;
		this.grid = grid;
		
	}
	
	public Direction execute() {
		
		int[] move = grid.move(r.getX(), r.getY(), r.getDirection());
        r.setX((move[0] != r.getX()) ? move[0] : r.getX());
        r.setY((move[1] != r.getY()) ? move[1] : r.getY());
        r.setObstacleCount((move[2] == 1) ? r.getObstacleCount() + 1 : r.getObstacleCount());
        return r.getDirection();
		
	}
	

}
