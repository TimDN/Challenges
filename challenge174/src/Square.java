
public class Square {
	private Colour currentColour;
	
	public Square(Colour newColour)
	{
		this.setCurrentColour(newColour);
	}
	public Colour getCurrentColour() {
		return currentColour;
	}
	public void setCurrentColour(Colour currentColour) {
		this.currentColour = currentColour;
	}
}
