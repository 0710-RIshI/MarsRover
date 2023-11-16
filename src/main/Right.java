package main;

public class Right implements Instructions {
	private Direction d;

	public Right(Direction d) {
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
		this.setD(this.getD().turnRight(this.getD()));
		return d;
	}
}
