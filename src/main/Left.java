package main;

public class Left implements Instructions {
	
	private Direction d;

	public Left(Direction d) {
		super();
		this.d = d;
	}
	
	public Direction getD() {
		return d;
	}
	
	public void setD(Direction d) {
		this.d = d;
	}

	public Direction execute() throws Exception {
		this.setD(this.getD().turnLeft(this.getD()));
		return d;
	}
	
	

}
