package hundredDoors;

public class Door {

	// Each door has a number, between 1 and 100
	private int number;
	// Each door is either open or closed
	private boolean open;
	
	// A door is create closed, with its own number
	public Door(int number){
		this.number = number;
		this.open = false;
	}
	
	public int getNumber() {
		return this.number;
	}
	
	public boolean isOpen() {
		return this.open;
	}
	
	// "If the door is closed,  open it;   if it is open,  close it"
	public void toggle() {
		if (this.open == true) {
			this.open = false;
		} else {
			this.open = true;
		}
	}
	
	public String toString() {
		return "Door n° " + this.number + " is " + (this.open == true ? "open" : "closed");
	}
	
	
}
