package main;


// to-do
// handle exceptions in isObstacle
//handle exceptions in move
// finish turn function


class Rover {
	
	int cx;
	int cy;
	
	char direction;
	
	final int max_x;
	final int max_y;
	
	Vector<Pair<Integer, String>> obstacles = new Vector<>();
	
	
	public Rover(int cx,int cy,char direction, int max_x,int max_y){
		this.cx = cx;
		this.cy = cy;
		this.direction = direction;
		this.max_x = max_x;
		this.max_y = max_y;
	}
	
	boolean isObstacle(int x,int y) {
		for(int i=0;i<this.obstacles.size();i++) {
			if(x == obstacles[i].getLeft() && y == obstacles[i].getRight()) {
				return true;
			}
		}
		return false;
	}
	
	void turn(char command) {
		
		// create a dictionary with key as directions and values as its corresponding left and right
	}
	
	public void move(char command) {
		
		
		if(command == 'M') {
		
			switch(direction) {
			
			case 'E':
				if(!this.isObstacle(cx+1,cy)) {
					cx+=1;
				}
				break;
			
			case 'W':
				if(!this.isObstacle(cx-1, cy)) {
					cy -= 1;
				}
				break;
			
			case 'N':
				if(!this.isObstacle(cx, cy+1)) {
					cy += 1;
				}
				break;
			case 'S':
				if(!this.isObstacle(cx, cy-1)) {
					cy = cy-1;
				}
				break;
			default:
				 System.out.println("Invalid direction");
			}
		}
		
		else {
			this.turn(command);
		}
	}
	

	

}
