package rover;

public class Obstacle implements Gridcomponent {
	private Pair p;
	private MyGrid grid;


	
	
	public Obstacle(Pair p, MyGrid grid) {
		super();
		this.p = p;
		this.grid = grid;
	}
	
	public Obstacle(MyGrid grid) {
		this.grid = grid;
	}


	public Pair getP() {
		return p;
	}


	public void isValid(int x,int y) {
        try {
            //This is to check if that particular move is valid and if it isn't it will go to catch block
        	int access = grid.getGrid()[x][y];
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new ArrayIndexOutOfBoundsException("Starting coordinates outside defined environment");
        }
    }
	
	public boolean validObstacle(int count) {
		int dim[] = grid.getDim();
		return dim[0]*dim[1] <= count;
	}
	
	
}
