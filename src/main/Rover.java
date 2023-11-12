package main;

import java.util.Dictionary;
import java.util.Hashtable;

import java.util.ArrayList;




// to-do
// handle exceptions in isObstacle
//handle exceptions in move


class Rover {
	
	int cx;
	int cy;
	
	char direction;
	
	final int max_x;
	final int max_y;
	
	ArrayList<int[]> obstacles = new ArrayList<>();
	
	public Rover(int cx,int cy,char direction, int max_x,int max_y){
		this.cx = cx;
		this.cy = cy;
		this.direction = direction;
		this.max_x = max_x;
		this.max_y = max_y;
	}
	
	boolean isObstacle(int x,int y) {
		for(int i=0;i<this.obstacles.size();i++) {
			if(x == obstacles.get(i)[0] && y == obstacles.get(i)[1]) {
				return true;
			}
		}
		return false;
	}
	
	char turn(char command) {
		
		Dictionary<Character, char[]> dict = new Hashtable<>();
		dict.put('N', new char[]{'W', 'E'});
        dict.put('W', new char[]{'S', 'N'});
        dict.put('S', new char[]{'E', 'W'});
        dict.put('E', new char[]{'N', 'S'});
        
        
        if(command == 'L') {
        	return dict.get(direction)[0];
        }
        else {
        	return dict.get(direction)[1];
        }
		
		
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
			direction = this.turn(command);
		}
	}
	

	

}
