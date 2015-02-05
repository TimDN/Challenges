import java.awt.Point;

public class FloodFill {
	private final char[][] image;
	private char replacementChar;
	private Point startPoint;
	private final int imageWidth;
	private final int imageHeight;
	
	public FloodFill(char[][] image,char replacementChar){
		this.image = image;
		this.replacementChar = replacementChar;
		imageWidth =  image.length;
		imageHeight = image[0].length;
	}
	public FloodFill(char[][] image,char replacementChar,Point startPoint){
		this.image = image;
		this.replacementChar = replacementChar;
		this.startPoint = startPoint;
		imageWidth =  image.length;
		imageHeight = image[0].length;
	}
	public void setStartPoint(Point start){
		this.startPoint = start;
	}
	public char[][] getImage()
	{
		return image;
		
	}
	public void startFlood(boolean wrap){
		char startChar = image[startPoint.x][startPoint.y];
		if(wrap)
			floodFillWrap(startPoint.x,startPoint.y,startChar);
		else
			floodFill(startPoint.x,startPoint.y,startChar);
	}
	private void floodFillWrap(int x,int y,char floodChar){
		//When it wraps it will start working from the new point 
		//Even if this happens when there are points left at the non wrapped area
		//The recursive nature of the functions ensures that all of the point are filled
		
		System.out.println("x:"+ x +" y:"+y);
		image[x][y] = replacementChar;
		//Up
		if((y - 1 >= 0) && (image[x][y-1] == floodChar)){
				floodFillWrap(x,y-1,floodChar);
		}
		else if(y == 0 && image[x][imageHeight-1] == floodChar){//Wrap around
			floodFillWrap(x,imageHeight-1,floodChar);
		}
		if((y + 1 < imageHeight) && (image[x][y+1] == floodChar)){
				floodFillWrap(x,y+1,floodChar);
		}
		else if(y == imageHeight-1 && image[x][0] == floodChar){
			floodFillWrap(x,0,floodChar);
		}
		if((x - 1 >= 0) && (image[x-1][y] == floodChar)){
				floodFillWrap(x-1,y,floodChar);
		}
		else if(x == 0 && image[imageWidth-1][y] == floodChar){
			floodFillWrap(imageWidth-1,y,floodChar);
		}
		if((x + 1 < imageWidth) && (image[x+1][y] == floodChar)){
				floodFillWrap(x+1,y,floodChar);
		}
		else if(x == imageWidth-1 && image[0][y] == floodChar){
				floodFillWrap(0,y,floodChar);
		}
	}
	private void floodFill(int x,int y,char floodChar){
		image[x][y] = replacementChar;
		if((y - 1 >= 0) && (image[x][y-1] == floodChar)){
			floodFill(x,y-1,floodChar);
		}
		if((y + 1 < imageHeight) && (image[x][y+1] == floodChar)){
			floodFill(x,y+1,floodChar);
		}
		if((x - 1 >= 0) && (image[x-1][y] == floodChar)){
			floodFill(x-1,y,floodChar);
		}
		if((x + 1 < imageWidth) && (image[x+1][y] == floodChar)){
			floodFill(x+1,y,floodChar);
	}
	}
}