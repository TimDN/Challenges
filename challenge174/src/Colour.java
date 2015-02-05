import java.awt.Color;

public class Colour{
	private char turnDirection;
	private Color colour;
	private int colourPos;

	public Colour(char turnDirection,Color colour,int colourPos){
		this.turnDirection = turnDirection;
		this.colour = colour;
		this.colourPos = colourPos;
	}
	public char getTurnDirection() {
		return turnDirection;
	}
	public Color getColour(){
		return this.colour;
	}
	public int getColourPos() {
		return colourPos;
	}
	public void setColourPos(int colourPos) {
		this.colourPos = colourPos;
	}
}
