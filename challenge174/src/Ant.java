
public class Ant {
	private char heading = 'N';
	private int posX;
	private int posY;
	
	public Ant(int posX,int posY){
		this.posX = posX;
		this.posY = posY;
	}	
	public int getPosX() {
		return posX;
	}
	public void setPosX(int posX) {
		this.posX = posX;
	}
	public int getPosY() {
		return posY;
	}
	public void setPosY(int posY) {
		this.posY = posY;
	}
	public char getHeading() {
		return heading;
	}
	public void setHeading(char heading) {
		this.heading = heading;
	}
	public void moveAnt(){
		switch(this.heading){
		case 'N':
			this.posY = posY - 1;
			break;
		case 'W':
			this.posX = posX - 1;
			break;
		case 'S':
			this.posY = posY + 1;
			break;
		case 'E':
			this.posX = posX + 1;
			break;
		}
	}
}
